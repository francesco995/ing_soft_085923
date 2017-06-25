package it.polimi.ingsw.ps09.view;

import it.polimi.ingsw.ps09.controller.Network.Client.ServerConnections.ServerConnection;
import it.polimi.ingsw.ps09.controller.PlayersOrder;
import it.polimi.ingsw.ps09.model.Actions.PlacementActions.PlacementAction;
import it.polimi.ingsw.ps09.model.Board;
import it.polimi.ingsw.ps09.model.Player;

import java.util.ArrayList;
import java.util.HashMap;
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
    private ArrayList<PlacementAction> mPlayerActionsList;

    private boolean mHasAction;

    private ServerConnection mServerConnection;

    private String mMainMenuMessage;
    private ArrayList<String> mMainMenu;
    private ArrayList<String> mBoardMenu;
    private ArrayList<String> mTowersMenu;
    private ArrayList<String> mPlayersMenu;
    private ArrayList<String> mPlayerMenu;

    private String mUserName;

    public CLIClientGame(ServerConnection serverConnection, String userName){

        mServerConnection = serverConnection;
        mUserName = userName;

        mHasAction = false;

        mMainMenuMessage = "\n###################################################";
        mMainMenuMessage += "\n######### Lorenzo il Magnifico Main Menu ##########";
        mMainMenuMessage += "\n###################################################";


        mMainMenu = new ArrayList<>();
        mMainMenu.add("Display Players");
        mMainMenu.add("Display Board");
        mMainMenu.add("Display Players order");
        mMainMenu.add("Refresh main menu");


        mBoardMenu = new ArrayList<>();
        mBoardMenu.add("Display the whole Board");
        mBoardMenu.add("Display Towers");
        mBoardMenu.add("Display Markets");
        mBoardMenu.add("Display Harvest & Production");
        mBoardMenu.add("Go back to main menu");


        mTowersMenu = new ArrayList<>();
        mTowersMenu.add("Green Tower");
        mTowersMenu.add("Yellow Tower");
        mTowersMenu.add("Blue Tower");
        mTowersMenu.add("Purple Tower");
        mTowersMenu.add("Go back to main menu");


        mPlayerMenu = new ArrayList<>();
        mPlayerMenu.add("Show Player info");
        mPlayerMenu.add("Show Player available FamilyMembers");
        mPlayerMenu.add("Show Player Resources and Points");
        mPlayerMenu.add("Show Player Green cards");
        mPlayerMenu.add("Show Player Yellow cards");
        mPlayerMenu.add("Show Player Blue cards");
        mPlayerMenu.add("Show Player Purple cards");
        mPlayerMenu.add("Show Player last PlacementActions");
        mPlayerMenu.add("Go back to main menu");


        mPlayersMenu = new ArrayList<>();


    }


    public static void alertActions(){

        System.out.println("\n##It's your turn to play, actions available in main menu, please refresh!!!##");
        System.out.println("\n##It's your turn to play, actions available in main menu, please refresh!!!##");
        System.out.println("\n##It's your turn to play, actions available in main menu, please refresh!!!##");

    }


    private void doAction(){

        mPlayerActionsList = mServerConnection.getPlayerActionsList();

        int choice = Prompter.promptForIntChoice("Choose your action",
                mPlayerActionsList.stream().map(PlacementAction::toString).collect(Collectors.toList()));

        mServerConnection.sendMessage(String.valueOf(choice));

        mServerConnection.setHasAction(false);

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

        mHasAction = mServerConnection.hasAction();

        if(mHasAction && !mMainMenu.contains("Do PlacementAction"))
            mMainMenu.add("Do PlacementAction");

        if(!mServerConnection.hasAction() && mMainMenu.contains("Do PlacementAction"))
            mMainMenu.remove("Do PlacementAction");


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

            switch(Prompter.promptForIntChoice(mMainMenuMessage, mMainMenu)){

                case 1:{
                    //Display Players
                    updateData();
                    displayPlayers();
                    break;
                }

                case 2:{
                    //Display Board
                    updateData();
                    displayBoard();
                    break;
                }
                case 3:{
                    //Display Players order
                    updateData();
                    displayPlayersOrder();
                    break;
                }
                case 4:{
                    //Refresh main menu
                    break;
                }
                case 5:{
                    //Do PlacementAction
                    updateData();
                    doAction();
                    break;
                }

            }

        }

    }

    private void displayPlayersOrder() {

        for(int i=0; i < mPlayersOrder.getPlayersOrder().size(); i++){

            System.out.println(String.valueOf((i + 1)) + ". "
                    + mPlayers.get(mPlayersOrder.getUserIdByIndex(i)).getUserName()
                    + " (" + mPlayers.get(mPlayersOrder.getUserIdByIndex(i)).getUserColor() + ")");

        }

    }

    /**
     * Display a Player to the CLI
     */
    private void displayPlayer(Player player){

        switch (Prompter.promptForIntChoice("Please choose what to display of Player: " + player.getUserName(), mPlayerMenu)){

            case 1:{
                //Show Player info
                player.toString();
                break;
            }

            case 2:{
                System.out.println(player.getUserName() + "family members are: \n");
                //Show Player available FamilyMembers
                player.getFamilyMember("BLACK").toString();
                player.getFamilyMember("ORANGE").toString();
                player.getFamilyMember("WHITE").toString();
                player.getFamilyMember("NEUTRAL").toString();
                break;
            }

            case 3:{
                //Show Player Resources and Points
                System.out.println(player.getUserName() + "resources are: \n");
                player.getPersonalBoard().getUserResources().toString();
                System.out.println(player.getUserName() + "points are: \n");
                player.getUserPoints().toString();
                break;
            }

            case 4:{
                //Show Player Green cards
                System.out.println(player.getUserName() + "territory card:");
                player.getPersonalBoard().territoryToString();
                break;
            }

            case 5:{
                //Show Player Yellow cards
                System.out.println(player.getUserName() + "building card:");
                player.getPersonalBoard().builidingToString();
                break;
            }

            case 6:{
                //Show Player Blue cards
                System.out.println(player.getUserName() + "character card:");
                player.getPersonalBoard().characterToString();
                break;
            }

            case 7:{
                //Show Player Purple cards
                System.out.println(player.getUserName() + "venture card:");
                player.getPersonalBoard().ventureToString();
                break;
            }

            case 8:{
                //Show Player last PlacementActions

                break;
            }

        }

    }


    /**
     * Display Players to the CLI
     */
    private void displayPlayers(){

        switch (Prompter.promptForIntChoice("Please choose the Player to display", mPlayersMenu)){

            case 1:{
                displayPlayer(mPlayers.get(mPlayersOrder.getUserIdByIndex(0)));
                break;
            }

            case 2:{
                displayPlayer(mPlayers.get(mPlayersOrder.getUserIdByIndex(1)));
                break;
            }

            case 3:{
                if(mPlayersOrder.getPlayersOrder().size() > 2)
                    displayPlayer(mPlayers.get(mPlayersOrder.getUserIdByIndex(2)));
                break;
            }

            case 4:{
                if(mPlayersOrder.getPlayersOrder().size() > 3)
                    displayPlayer(mPlayers.get(mPlayersOrder.getUserIdByIndex(3)));
                break;
            }

        }

    }


    /**
     * Display board components to the CLI
     */
    private void displayBoard(){

        switch(Prompter.promptForIntChoice("Please choose what to display", mBoardMenu)){

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

        switch (Prompter.promptForIntChoice("Please choose a Tower", mTowersMenu)){

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
