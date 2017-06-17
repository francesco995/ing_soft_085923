package it.polimi.ingsw.ps09;


import it.polimi.ingsw.ps09.controller.Client.ServerConnections.ServerConnectionSocket;


import java.io.IOException;

/**
 * Created by franc on 09/05/2017.
 */
public class CLIClientApp {
    public static void main(String[] args) throws IOException {

        ServerConnectionSocket serverConnectionSocket = new ServerConnectionSocket();

        serverConnectionSocket.start();

    }


}
