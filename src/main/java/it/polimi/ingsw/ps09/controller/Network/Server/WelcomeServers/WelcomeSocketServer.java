package it.polimi.ingsw.ps09.controller.Network.Server.WelcomeServers;

import it.polimi.ingsw.ps09.controller.Network.Server.PlayerConnections.PlayerConnection;
import it.polimi.ingsw.ps09.controller.Network.Server.PlayerConnections.PlayerConnectionSocket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Logger;

import static java.util.logging.Level.INFO;

/**
 * Created by francesco995 on 15/06/2017.
 */
public class WelcomeSocketServer extends Thread implements WelcomeServer {

    //LOGGER
    private static final Logger mLogger = Logger.getLogger(WelcomeSocketServer.class.getName());

    //A ServerSocket listening and a Socket to answer
    private ServerSocket mLocalSocket;
    private Socket mRemoteSocket;

    private Queue<PlayerConnection> mReadyConnections;

    private BufferedReader mIncomingMessages;
    private BufferedWriter mOutgoingMessages;

    private String mMessage;

    public WelcomeSocketServer() throws IOException {

        //Start ServerSocket on port 1024
        mLocalSocket = new ServerSocket(1024);
        mLogger.log(INFO, "Created ServerSocket on port 1024");

        mReadyConnections = new LinkedList<>();

    }


    public PlayerConnection getReadyConnection(){
        mLogger.log(INFO, "Server requested new ready connection, sending port " + mReadyConnections.peek());
        return mReadyConnections.poll();
    }

    public boolean hasReadyConnections(){
        if(!mReadyConnections.isEmpty())
            return true;
        else
            return false;
    }


    public void run() {

        mLogger.log(INFO, "Starting Welcome Socket Server Thread");

        int port;

        do {

            try {



                //Start listening to the socket
                mRemoteSocket = mLocalSocket.accept();

                //Read the incoming message
                mIncomingMessages = new BufferedReader(new InputStreamReader(mRemoteSocket.getInputStream()));
                mMessage = mIncomingMessages.readLine();

                mLogger.log(INFO, "New Client request, UserName is: " + mMessage);

                mReadyConnections.add(new PlayerConnectionSocket(mRemoteSocket, mMessage));

                mLogger.log(INFO, "Socket from " + mRemoteSocket.getInetAddress() + " added to Ready Connections");




        } catch (IOException e) {
            e.printStackTrace();
        }


        }while (!mMessage.equalsIgnoreCase("close"));

        try {
            mRemoteSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            mLocalSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
