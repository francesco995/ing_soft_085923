package it.polimi.ingsw.ps09;

import it.polimi.ingsw.ps09.controller.Server.Server;
import it.polimi.ingsw.ps09.controller.Server.WelcomeServers.WelcomeSocketServer;
import it.polimi.ingsw.ps09.model.Player;

import java.io.IOException;
import java.util.SplittableRandom;
import java.util.logging.Logger;

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

        System.out.println("server started");

    }
}
