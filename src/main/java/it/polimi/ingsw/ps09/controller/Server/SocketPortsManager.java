package it.polimi.ingsw.ps09.controller.Server;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by francesco995 on 15/06/2017.
 */
public class SocketPortsManager{

    Queue<Integer> mAvailablePorts;


    public SocketPortsManager(int startPort, int endPort){

        mAvailablePorts = new LinkedList<>();

        for( int i = startPort; i <= endPort; i++){
            mAvailablePorts.add(i);
        }

    }


    public int getAvailablePort(){

        return mAvailablePorts.poll();

    }


}
