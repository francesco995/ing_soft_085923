package it.polimi.ingsw.ps09.controller.Client.ServerConnections;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by francesco995 on 15/06/2017.
 */
public class ServerConnectionSocket extends Thread implements ServerConnection {

    private Socket mSocket;

    private InetAddress mSERVER_ADDRESS;
    private int mSERVER_PORT = 100;

    BufferedReader mIncomingMessages;
    BufferedWriter mOutgoingMessages;

    public ServerConnectionSocket() throws IOException {

        mSERVER_ADDRESS = InetAddress.getByName("localhost");

    }

    public void run() {

        try {

            //Connects to Server
            mSocket = new Socket(mSERVER_ADDRESS, mSERVER_PORT);

            //Incoming and Outgoing Messages
            mOutgoingMessages = new BufferedWriter(new OutputStreamWriter(mSocket.getOutputStream()));
            mIncomingMessages = new BufferedReader(new InputStreamReader(mSocket.getInputStream()));

            //Request connection to server
            mOutgoingMessages.write("connect\n");
            mOutgoingMessages.flush();

            //Wait for Server response with a new free port
            mSERVER_PORT = Integer.parseInt(mIncomingMessages.readLine());

            //Close old connection
            mSocket.close();




        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
