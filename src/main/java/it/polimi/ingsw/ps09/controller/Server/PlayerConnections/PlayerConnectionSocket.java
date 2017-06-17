package it.polimi.ingsw.ps09.controller.Server.PlayerConnections;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.logging.Logger;

import static java.util.logging.Level.INFO;


/**
 * Created by francesco995 on 15/06/2017.
 */
public class PlayerConnectionSocket extends PlayerConnection {

    //A ServerSocket listening and a Socket to answer
    private ServerSocket mLocalSocket;
    private Socket mRemoteSocket;

    private BufferedReader mMessageReader;
    private BufferedWriter mMessageSender;

    private String mMessage;

    private Queue<String> mIncomingMessages;

    private String mUserName;

    //LOGGER
    private static final Logger mLogger = Logger.getAnonymousLogger();


    public PlayerConnectionSocket(int port) throws IOException {

        //Start ServerSocket on port 100
        mLocalSocket = new ServerSocket(port);

        mIncomingMessages = new LinkedList<>();

        this.start();

    }

    public String getMessage(){
        return mIncomingMessages.poll();
    }


    public List<String> getAllMessages(){
        List<String> messages = new LinkedList<>();

        while (!mIncomingMessages.isEmpty()){
            messages.add(mIncomingMessages.poll());
        }

        return messages;
    }


    public boolean hasIncomingMessages(){

        if(!mIncomingMessages.isEmpty())
            return true;

        return false;
    }

    public void sendMessage(String message){
        //TODO: maybe switch to boolean return

        try {
            mMessageSender.write(message);
            mMessageSender.write("\n");
            mMessageSender.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }




    public void run() {

        mLogger.log(INFO, "Starting new Connection on port " + mLocalSocket.getLocalPort());

        try {

            //Start listening to the socket
            mRemoteSocket = mLocalSocket.accept();

            //Read the incoming message
            mMessageReader = new BufferedReader(new InputStreamReader(mRemoteSocket.getInputStream()));

            //Setup the message sender
            mMessageSender = new BufferedWriter(new OutputStreamWriter(mRemoteSocket.getOutputStream()));

            mUserName = mMessageReader.readLine();

            mLogger.log(INFO, "User " + mUserName + " connected on port " + mLocalSocket.getLocalPort());

            do {

                //Read message from Player
                mMessage = mMessageReader.readLine();

                mIncomingMessages.add(mMessage);

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
