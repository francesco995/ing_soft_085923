package it.polimi.ingsw.ps09.controller.Server.PlayerConnections;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

import static java.util.logging.Level.INFO;


/**
 * Created by francesco995 on 15/06/2017.
 */
public class PlayerConnectionSocket extends PlayerConnection {

    //A ServerSocket listening and a Socket to answer
    ServerSocket mLocalSocket;
    Socket mRemoteSocket;

    BufferedReader mMessageReader;
    BufferedWriter mMessageSender;

    String mMessage;

    //LOGGER
    private static final Logger mLogger = Logger.getAnonymousLogger();


    public PlayerConnectionSocket(int port) throws IOException {

        //Start ServerSocket on port 100
        mLocalSocket = new ServerSocket(port);

        this.start();

    }


    public void run() {

        mLogger.log(INFO, "Starting new Connection on port " + mLocalSocket.getLocalPort());

        try {

            do {

                //Start listening to the socket
                mRemoteSocket = mLocalSocket.accept();

                mLogger.log(INFO, "Socket connected");

                //Read the incoming message
                mMessageReader = new BufferedReader(new InputStreamReader(mRemoteSocket.getInputStream()));
                mMessage = mMessageReader.readLine();

                //Setup the message sender
                mMessageSender = new BufferedWriter(new OutputStreamWriter(mRemoteSocket.getOutputStream()));

            }while(!mMessage.equalsIgnoreCase("close"));

        } catch (IOException e) {
            e.printStackTrace();
        }


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
