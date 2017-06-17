package it.polimi.ingsw.ps09;


import it.polimi.ingsw.ps09.controller.Client.ServerConnections.ServerConnectionSocket;


import java.io.IOException;
import java.util.Scanner;

/**
 * Created by franc on 09/05/2017.
 */
public class CLIClientApp {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        String userName;

        String serverAddress;

        //SETUP
        System.out.println("\n\n---Hello and Welcome to Lorenzo il Magnifico---\n\n");

        System.out.print("\nPlease enter your UserName -> ");

        userName = scanner.nextLine();

        System.out.print("Please enter server address -> ");

        serverAddress = scanner.nextLine();

        ServerConnectionSocket serverConnectionSocket = new ServerConnectionSocket(serverAddress, userName);

        System.out.print("\nConnecting to server.");
        serverConnectionSocket.start();

        do{
            try {
                System.out.print(".");
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }while(!serverConnectionSocket.isConnected());

        System.out.println("\nConnected to server " + serverConnectionSocket.getAddress() + " on port: " + serverConnectionSocket.getPort() + "\n");

        System.out.println("Waiting for server to start Game... Hang on...");



    }


}
