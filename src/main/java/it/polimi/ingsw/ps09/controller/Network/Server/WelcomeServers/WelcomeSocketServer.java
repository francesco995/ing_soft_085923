package it.polimi.ingsw.ps09.controller.Network.Server.WelcomeServers;

import it.polimi.ingsw.ps09.controller.Network.Server.SocketPortsManager;

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

    private SocketPortsManager mSocketPortsManager;

    private Queue<Integer> mReadyPorts;

    private BufferedReader mIncomingMessages;
    private BufferedWriter mOutgoingMessages;

    private String mMessage;

    public WelcomeSocketServer() throws IOException {

        //Start ServerSocket on port 100
        mLocalSocket = new ServerSocket(100);
        mLogger.log(INFO, "Created ServerSocket on port 100");

        //Start SocketPortsManager to get a new free port every time a client connects
        mSocketPortsManager = new SocketPortsManager(10001, 20000);
        mReadyPorts = new LinkedList<>();

    }


    public int getReadyPort(){
        mLogger.log(INFO, "Server requested new ready port, sending port " + mReadyPorts.peek());
        return mReadyPorts.poll();
    }

    public boolean hasReadyPorts(){
        if(!mReadyPorts.isEmpty())
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

                mLogger.log(INFO, "New Client request, message is: " + mMessage);

                //Setup the message sender
                mOutgoingMessages = new BufferedWriter(new OutputStreamWriter(mRemoteSocket.getOutputStream()));


                //Answer the client with a new free port
                port = mSocketPortsManager.getAvailablePort();

                mOutgoingMessages.write(String.valueOf(port));
                mOutgoingMessages.write("\n");
                mOutgoingMessages.flush();

                mLogger.log(INFO, "Sent new port available, port: " + port);

                mReadyPorts.add(port);

                mLogger.log(INFO, "Port " + port + " added to mReadyPorts");




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
