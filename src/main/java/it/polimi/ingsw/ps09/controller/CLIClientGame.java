package it.polimi.ingsw.ps09.controller;

import it.polimi.ingsw.ps09.controller.Network.Client.ServerConnections.ServerConnectionSocket;
import it.polimi.ingsw.ps09.model.Board;
import it.polimi.ingsw.ps09.model.Player;
import it.polimi.ingsw.ps09.view.Prompter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by francesco995 on 18/06/2017.
 * Client-side game instance for CLI clients
 */
public class CLIClientGame extends Thread{

    private int mPlayerID;

    private Board mBoard;

    private HashMap<Integer, Player> mPlayers;
    private PlayersOrder mPlayersOrder;

    private ServerConnectionSocket mServerConnection;

    private Prompter mPrompter;
    private ArrayList<String> mMainMenu;
    private ArrayList<String> mBoardMenu;
    private ArrayList<String> mTowersMenu;

    private String mUserName;

    public CLIClientGame(int playerID, ServerConnectionSocket serverConnection, String userName){

        mPlayerID = playerID;
        mServerConnection = serverConnection;
        mUserName = userName;
        mPrompter = new Prompter();

        mMainMenu = new ArrayList<String>(){{
            add("Force view refresh");
            add("Display Board");
        }};

        mBoardMenu = new ArrayList<String>(){{
            add("Display the whole Board");
            add("Display Towers");
            add("Display Markets");
            add("Display Harvest & Production");
        }};

        mTowersMenu = new ArrayList<String>(){{
            add("Green Tower");
            add("Yellow Tower");
            add("Blue Tower");
            add("Purple Tower");
        }};

    }

    /**
     * Sends a request to the connection to update game data
     */
    private void updateData(){

        mServerConnection.updateView();

        mBoard = mServerConnection.getBoard();
        mPlayersOrder = mServerConnection.getPlayersOrder();
        mPlayers = mServerConnection.getPlayers();

    }


    /**
     * Starts game session when 2+ players are ready
     */
    public void run(){

        boolean run = true;

        while(run){

            updateData();

            switch(mPrompter.promptForIntChoice("Main menu:", mMainMenu)){

                case 1:{
                    break;
                }

                case 2:{
                    displayBoard();
                    break;
                }

            }

        }

    }

    /**
     * Display board components to the CLI
     */
    private void displayBoard(){

        switch(mPrompter.promptForIntChoice("Please choose what to display", mBoardMenu)){

            case 1:{
                System.out.println(mBoard.toString());
                break;
            }

            case 2:{
                displayTowers();
                break;
            }

            case 3:{
                System.out.println(mBoard.getMarket().toString());
                break;
            }

            case 4:{
                System.out.println(mBoard.getHarvest().toString());
                System.out.println(mBoard.getProduction().toString());
                break;
            }
        }

    }


    /**
     * Display towers to the CLI
     */
    private void displayTowers(){

        switch (mPrompter.promptForIntChoice("Please choose a Tower", mTowersMenu)){

            case 1:{
                System.out.println(mBoard.getTerritoriesTower().toString());
                break;
            }

            case 2:{
                System.out.println(mBoard.getBuildingsTower().toString());
                break;
            }

            case 3:{
                System.out.println(mBoard.getCharactersTower().toString());
                break;
            }
            case 4:{
                System.out.println(mBoard.getVenturesTower().toString());
                break;
            }

        }
    }



}
