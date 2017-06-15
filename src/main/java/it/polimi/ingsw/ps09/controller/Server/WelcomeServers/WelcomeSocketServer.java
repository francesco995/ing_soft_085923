package it.polimi.ingsw.ps09.controller.Server.WelcomeServers;

import it.polimi.ingsw.ps09.controller.Server.SocketPortsManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by francesco995 on 15/06/2017.
 */
public class WelcomeSocketServer extends Thread implements WelcomeServer{

    ServerSocket mLocalSocket;
    Socket mRemoteSocket;

    SocketPortsManager mSocketPortsManager;

    BufferedReader mIncomingMessages;
    PrintWriter mOutgoingMessages;

    public WelcomeSocketServer() throws IOException {

        mLocalSocket = new ServerSocket(100);

        mSocketPortsManager = new SocketPortsManager(5000, 10000);


    }

    public void run(){





        while(true){

            try {

                mRemoteSocket = mLocalSocket.accept();

                mIncomingMessages = new BufferedReader(new InputStreamReader(mRemoteSocket.getInputStream()));
                mOutgoingMessages = new PrintWriter(mRemoteSocket.getOutputStream(), true);


                String message = mIncomingMessages.readLine();

                if(message.equalsIgnoreCase("connect")){
                    mOutgoingMessages.print(mSocketPortsManager.getAvailablePort());
                }


            } catch (IOException e) {
                e.printStackTrace();
            }

        }



    }

}
