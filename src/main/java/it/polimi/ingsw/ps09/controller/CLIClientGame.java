package it.polimi.ingsw.ps09.controller;

import it.polimi.ingsw.ps09.controller.Network.Client.ServerConnections.ServerConnectionSocket;
import it.polimi.ingsw.ps09.model.Actions.Action;
import it.polimi.ingsw.ps09.model.Board;
import it.polimi.ingsw.ps09.model.Player;
import it.polimi.ingsw.ps09.view.Prompter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by francesco995 on 18/06/2017.
 * Client-side game instance for CLI clients
 */
public class CLIClientGame extends Thread{

    private int mPlayerID;

    private Board mBoard;

    private HashMap<Integer, Player> mPlayers;
    private PlayersOrder mPlayersOrder;
    private ArrayList<Action> mPlayerActionsList;

    private boolean mHasAction;

    //TODO: change to generic ServerConnection
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

        mHasAction = false;

        //TODO: change add method
        mMainMenu = new ArrayList<>();
        mMainMenu.add("Force view refresh");
        mMainMenu.add("Display Board");

        mBoardMenu = new ArrayList<>();
        mBoardMenu.add("Display the whole Board");
        mBoardMenu.add("Display Towers");
        mBoardMenu.add("Display Markets");
        mBoardMenu.add("Display Harvest & Production");

        mTowersMenu = new ArrayList<>();
        mTowersMenu.add("Green Tower");
        mTowersMenu.add("Yellow Tower");
        mTowersMenu.add("Blue Tower");
        mTowersMenu.add("Purple Tower");

    }

    private void doAction(){
        mPrompter.promptForIntChoice("Choose your action", mPlayerActionsList.stream().map(Action::toString).collect(Collectors.toList()));
    }

    /**
     * Sends a request to the connection to update game data
     */
    private void updateData(){

        mPlayers = mServerConnection.getPlayers();
        mBoard = mServerConnection.getBoard();
        mPlayersOrder = mServerConnection.getPlayersOrder();

        mHasAction = mServerConnection.hasAction();
        if(mHasAction)
            mPlayerActionsList = mServerConnection.getPlayerActionsList();


    }


    /**
     * Starts game session when 2+ players are ready
     */
    public void run(){

        boolean run = true;

        while(run){

            updateData();

            if(mHasAction && !mMainMenu.contains("Do Action"))
                mMainMenu.add("Do Action");
            else
                mMainMenu.remove("Do Action");

            switch(mPrompter.promptForIntChoice("Main menu:", mMainMenu)){

                case 1:{
                    mServerConnection.updateView();
                    break;
                }

                case 2:{
                    displayBoard();
                    break;
                }
                case 3:{
                    if(mHasAction)
                        doAction();
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
