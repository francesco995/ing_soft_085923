package it.polimi.ingsw.ps09;

import it.polimi.ingsw.ps09.controller.Server.WelcomeServers.WelcomeSocketServer;
import it.polimi.ingsw.ps09.model.Player;

import java.io.IOException;
import java.util.logging.Logger;

/**
 * Created by franc on 09/05/2017.
 */
public class ServerApp {

    private static final Logger mLogger = Logger.getLogger(Player.class.getName());



    public static void main(String[] args) throws IOException {

        WelcomeSocketServer welcomeSocketServer = new WelcomeSocketServer();

        welcomeSocketServer.start();


    }
}
