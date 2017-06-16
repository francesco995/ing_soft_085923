package it.polimi.ingsw.ps09.controller.Client.ServerConnections;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by francesco995 on 15/06/2017.
 */
public class ServerConnectionSocket extends Thread implements ServerConnection {

    private Socket mSocket;

    private InetAddress mSERVER_ADDRESS;
    private int mSERVER_PORT = 100;

    private String mMessage;

    BufferedReader mMessageReader;
    BufferedWriter mMessageSender;

    Queue<String> mIncomingMessage;

    public ServerConnectionSocket() throws IOException {

        mSERVER_ADDRESS = InetAddress.getByName("localhost");
        mIncomingMessage = new LinkedList<>();

    }

    public void run() {

        try {

            //Connects to Server
            mSocket = new Socket(mSERVER_ADDRESS, mSERVER_PORT);

            //Incoming and Outgoing Messages
            mMessageSender = new BufferedWriter(new OutputStreamWriter(mSocket.getOutputStream()));
            mMessageReader = new BufferedReader(new InputStreamReader(mSocket.getInputStream()));

            //Request connection to server
            mMessageSender.write("connect\n");
            mMessageSender.flush();

            //Wait for Server response with a new free port
            mSERVER_PORT = Integer.parseInt(mMessageReader.readLine());

            //Close old connection
            mSocket.close();

            //Sleep 5 seconds to let the server create new socket
            Thread.sleep(5000);

            //Start connection to new Port
            mSocket = new Socket(mSERVER_ADDRESS, mSERVER_PORT);

            //Incoming and Outgoing Messages
            mMessageSender = new BufferedWriter(new OutputStreamWriter(mSocket.getOutputStream()));
            mMessageReader = new BufferedReader(new InputStreamReader(mSocket.getInputStream()));

            //Request connection to server
            mMessageSender.write("connect\n");
            mMessageSender.flush();


            do {

                mMessage = mMessageReader.readLine();
                mIncomingMessage.add(mMessage);

            }while(!mMessage.equalsIgnoreCase("close"));

            mSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
