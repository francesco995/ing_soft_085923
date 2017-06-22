package it.polimi.ingsw.ps09.controller;

import it.polimi.ingsw.ps09.controller.Network.Client.ServerConnections.ServerConnectionSocket;
import it.polimi.ingsw.ps09.model.Actions.Action;
import it.polimi.ingsw.ps09.model.Board;
import it.polimi.ingsw.ps09.model.Player;
import it.polimi.ingsw.ps09.view.Prompter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

import static java.util.logging.Level.WARNING;

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
    private ArrayList<String> mPlayersMenu;
    private ArrayList<String> mPlayerMenu;

    private String mUserName;

    public CLIClientGame(ServerConnectionSocket serverConnection, String userName){

        mServerConnection = serverConnection;
        mUserName = userName;
        mPrompter = new Prompter();

        mHasAction = false;

        //TODO: change add method
        mMainMenu = new ArrayList<>();
        mMainMenu.add("Display Players");
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

        mPlayerMenu = new ArrayList<>();
        mPlayerMenu.add("Show Player info");
        mPlayerMenu.add("Show Player available FamilyMembers");
        mPlayerMenu.add("Show Player Resources and Points");
        mPlayerMenu.add("Show Player Green cards");
        mPlayerMenu.add("Show Player Yellow cards");
        mPlayerMenu.add("Show Player Blue cards");
        mPlayerMenu.add("Show Player Purple cards");

        mServerConnection.updateData();

        mPlayersMenu = new ArrayList<>();

        //updateData();

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

        mPlayersMenu.clear();
        mPlayersOrder.getPlayersOrder().stream().forEach(id -> mPlayersMenu.add(mPlayers.get(id).getUserName()));


    }


    /**
     * Starts game session when 2+ players are ready
     */
    public void run(){

        System.out.print("\nWaiting for server to start Game... Hang on...");

        do{

            try {
                System.out.print(".");
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Interrupted!" + e);
                // clean up state...
                Thread.currentThread().interrupt();
            }

        }while (!mServerConnection.gameStarted());

        System.out.println("\nGame Starting!!!");

        boolean run = true;

        while(run){

            updateData();

            switch(mPrompter.promptForIntChoice("Main menu:", mMainMenu)){

                case 1:{
                    displayPlayers();
                    break;
                }

                case 2:{
                    displayBoard();
                    break;
                }
                case 3:{

                }

            }

        }

    }

    /**
     * Display a Player to the CLI
     */
    private void displayPlayer(String userName){

        switch (mPrompter.promptForIntChoice("Please choose what to display of Player: " + userName, mPlayerMenu)){

            case 1:{

                break;
            }

            case 2:{

                break;
            }

            case 3:{

                break;
            }

            case 4:{

                break;
            }

            case 5:{

                break;
            }

            case 6:{

                break;
            }

            case 7:{

                break;
            }

        }

    }


    /**
     * Display Players to the CLI
     */
    private void displayPlayers(){

        switch (mPrompter.promptForIntChoice("Please choose the Player to display", mPlayersMenu)){

            case 1:{
                displayPlayer(mPlayersMenu.get(0));
                break;
            }

            case 2:{
                displayPlayer(mPlayersMenu.get(1));
                break;
            }

            case 3:{
                displayPlayer(mPlayersMenu.get(2));
                break;
            }

            case 4:{
                displayPlayer(mPlayersMenu.get(3));
                break;
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
