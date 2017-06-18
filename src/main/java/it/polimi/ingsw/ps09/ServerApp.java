package it.polimi.ingsw.ps09;

import it.polimi.ingsw.ps09.controller.Server;

import java.io.IOException;
import java.util.logging.Logger;

import static java.util.logging.Level.INFO;

/**
 * Created by franc on 09/05/2017.
 */
public class ServerApp {

    private static final Logger mLogger = Logger.getAnonymousLogger();

    private static Server mServer;



    public static void main(String[] args) throws IOException {

        System.setProperty("java.util.logging.SimpleFormatter.format", "%1$tF %1$tT %5$s%6$s%n");

        mServer = new Server();

        mServer.startWelcomeServer();

        mServer.start();

        mLogger.log(INFO, "ServerApp Started");

    }
}
