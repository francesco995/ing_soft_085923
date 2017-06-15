package it.polimi.ingsw.ps09.controller.Client.ServerConnections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by francesco995 on 15/06/2017.
 */
public class ServerConnectionSocket extends Thread implements ServerConnection{

    ServerSocket mLocalSocket;
    Socket mRemoteSocket;


    BufferedReader mIncomingMessages;
    PrintWriter mOutgoingMessages;

    public ServerConnectionSocket() throws IOException {

        mLocalSocket = new ServerSocket(101);

    }

    public void run(){





        while(true){

            try {

                mRemoteSocket = mLocalSocket.accept();

                mOutgoingMessages = new PrintWriter(mRemoteSocket.getOutputStream(), true);
                mIncomingMessages = new BufferedReader(new InputStreamReader(mRemoteSocket.getInputStream()));

                mOutgoingMessages.println("connect");


                System.out.println(mIncomingMessages.readLine());



            } catch (IOException e) {
                e.printStackTrace();
            }

        }



    }

}
