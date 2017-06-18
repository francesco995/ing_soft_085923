package it.polimi.ingsw.ps09.controller.Network.Server;

import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Logger;

import static java.util.logging.Level.INFO;

/**
 * Created by francesco995 on 15/06/2017.
 */
public class SocketPortsManager{

    Queue<Integer> mAvailablePorts;

    //LOGGER
    private static final Logger mLogger = Logger.getLogger(SocketPortsManager.class.getName());


    public SocketPortsManager(int startPort, int endPort){

        mAvailablePorts = new LinkedList<>();

        for( int i = startPort; i <= endPort; i++){
            mAvailablePorts.add(i);
        }

        mLogger.log(INFO, "Created port library, first port is " + mAvailablePorts.peek());

    }


    public int getAvailablePort(){

        return mAvailablePorts.poll();

    }


}
