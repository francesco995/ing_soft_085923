package it.polimi.ingsw.ps09.controller;

import it.polimi.ingsw.ps09.controller.Network.Client.ServerConnections.ServerConnectionSocket;
import it.polimi.ingsw.ps09.model.Board;
import it.polimi.ingsw.ps09.model.Player;

import java.util.HashMap;

/**
 * Created by francesco995 on 18/06/2017.
 */
public class CLIClientGame extends Thread{

    private int mPlayerID;

    private Board mBoard;

    private HashMap<Integer, Player> mPlayers;

    private ServerConnectionSocket mServerConnection;

    private String mUserName;

    public CLIClientGame(int playerID, ServerConnectionSocket serverConnection, String userName){

        mPlayerID = playerID;
        mServerConnection = serverConnection;
        mUserName = userName;

    }

    public void run(){

        mServerConnection.startGame();




    }




}
