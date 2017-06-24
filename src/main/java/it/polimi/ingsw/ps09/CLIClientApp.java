package it.polimi.ingsw.ps09;


import it.polimi.ingsw.ps09.controller.Network.Client.ServerConnections.ServerConnection;
import it.polimi.ingsw.ps09.view.CLIClientGame;
import it.polimi.ingsw.ps09.controller.Network.Client.ServerConnections.ServerConnectionSocket;


import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Logger;

import static java.util.logging.Level.WARNING;

/**
 * Created by franc on 09/05/2017.
 */
public class CLIClientApp {

    public static void main(String[] args) throws IOException {

        final Logger mLogger = Logger.getAnonymousLogger();


        Scanner scanner = new Scanner(System.in);

        CLIClientGame mClientGame;

        String userName;

        String serverAddress;

        //SETUP
        System.out.println("\n\n---Hello and Welcome to Lorenzo il Magnifico---\n\n");

        System.out.print("\nPlease enter your UserName -> ");

        userName = scanner.nextLine();

        System.out.print("Please enter server address -> ");

        serverAddress = scanner.nextLine();

        ServerConnection serverConnectionSocket = new ServerConnectionSocket(serverAddress, userName);

        System.out.print("\nConnecting to server.");
        serverConnectionSocket.start();

        do{
            try {
                System.out.print(".");
                Thread.sleep(500);
            } catch (InterruptedException e) {
                mLogger.log(WARNING, "Interrupted!", e);
                // clean up state...
                Thread.currentThread().interrupt();
            }

        }while(!serverConnectionSocket.isConnected());

        //TODO: move into serverconnection

        System.out.println("\nConnected to server " + serverConnectionSocket.getAddress() + " on port: " + serverConnectionSocket.getPort() + "\n");

            mClientGame = new CLIClientGame(serverConnectionSocket, userName);
            mClientGame.run();



    }


}
