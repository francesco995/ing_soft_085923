package it.polimi.ingsw.ps09.controller.Server.WelcomeServers;

import it.polimi.ingsw.ps09.ServerApp;
import it.polimi.ingsw.ps09.controller.Server.SocketPortsManager;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by francesco995 on 15/06/2017.
 */
public class WelcomeSocketServer extends Thread implements WelcomeServer {

    //A ServerSocket listening and a Socket to answer
    ServerSocket mLocalSocket;
    Socket mRemoteSocket;

    SocketPortsManager mSocketPortsManager;

    BufferedReader mIncomingMessages;
    BufferedWriter mOutgoingMessages;

    String mMessage;

    public WelcomeSocketServer() throws IOException {

        //Start ServerSocket on port 100
        mLocalSocket = new ServerSocket(100);

        //Start SocketPortsManager to get a new free port every time a client connects
        mSocketPortsManager = new SocketPortsManager(10000, 20000);

    }


    public void run() {

        do {

            try {

                //Start listening to the socket
                mRemoteSocket = mLocalSocket.accept();

                //Read the incoming message
                mIncomingMessages = new BufferedReader(new InputStreamReader(mRemoteSocket.getInputStream()));
                mMessage = mIncomingMessages.readLine();

                //Setup the message sender
                mOutgoingMessages = new BufferedWriter(new OutputStreamWriter(mRemoteSocket.getOutputStream()));


                if(mMessage.equalsIgnoreCase("connect")){

                    //Answer the client with a new free port
                    mOutgoingMessages.write(String.valueOf(mSocketPortsManager.getAvailablePort()));
                    mOutgoingMessages.write("\n");
                    mOutgoingMessages.flush();

                }

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
