package it.polimi.ingsw.ps09.controller.Server.PlayerConnections;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * Created by francesco995 on 15/06/2017.
 */
public class PlayerConnectionSocket extends Thread implements PlayerConnection {

    ServerSocket mPlayerSocket;

    public void run() {

        try {
            mPlayerSocket = new ServerSocket(1000);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
