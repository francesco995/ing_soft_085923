package it.polimi.ingsw.ps09.controller.Server;

import it.polimi.ingsw.ps09.controller.Server.PlayerConnections.PlayerConnection;
import it.polimi.ingsw.ps09.controller.Server.PlayerConnections.PlayerConnectionSocket;
import it.polimi.ingsw.ps09.controller.Server.WelcomeServers.WelcomeSocketServer;
import it.polimi.ingsw.ps09.model.Player;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Logger;

/**
 * Created by francesco995 on 16/06/2017.
 */
public class Server extends Thread{

    private static final Logger mLogger = Logger.getLogger(Player.class.getName());

    private Queue<PlayerConnection> mQueuedPlayers = new LinkedList<>();

    WelcomeSocketServer mWelcomeSocketServer;



    public void startWelcomeServer() throws IOException {

        mWelcomeSocketServer = new WelcomeSocketServer();
        mWelcomeSocketServer.start();


    }


    public void run(){


        while(true){

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if(mWelcomeSocketServer.hasReadyPorts()) {
                try {
                    mQueuedPlayers.add(new PlayerConnectionSocket(mWelcomeSocketServer.getReadyPort()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }



    }




}
