package it.polimi.ingsw.ps09.controller;

import it.polimi.ingsw.ps09.controller.Network.Client.ServerConnections.ServerConnectionSocket;
import it.polimi.ingsw.ps09.model.Board;
import it.polimi.ingsw.ps09.model.Player;
import it.polimi.ingsw.ps09.view.Prompter;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by francesco995 on 18/06/2017.
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


    public void run(){

        boolean run = true;

        mServerConnection.updateView();

        mBoard = mServerConnection.getBoard();
        mPlayersOrder = mServerConnection.getPlayersOrder();
        mPlayers = mServerConnection.getPlayers();

        while(run){

            switch(mPrompter.promptForIntChoice("Main menu:", mMainMenu)){

                case 1:{
                    mServerConnection.updateView();
                    break;
                }

                case 2:{

                    displayBoard();
                    break;

                }


            }

        }


    }

    private void displayBoard(){

        switch(mPrompter.promptForIntChoice("Please choose what to display", mBoardMenu)){

            case 1:{
                displayTowers();
                break;
            }

            case 2:{
                System.out.println(mBoard.getMarket().toString());
                break;
            }

            case 3:{
                System.out.println(mBoard.getHarvest().toString());
                System.out.println(mBoard.getProduction().toString());
                break;
            }
        }

    }


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
