package it.polimi.ingsw.ps09.view;

import it.polimi.ingsw.ps09.Constants;
import it.polimi.ingsw.ps09.controller.Network.Client.ServerConnections.ServerConnection;
import it.polimi.ingsw.ps09.controller.PlayersOrder;
import it.polimi.ingsw.ps09.model.*;
import it.polimi.ingsw.ps09.model.Actions.FamilyMemberActions.FamilyMemberAction;
import it.polimi.ingsw.ps09.model.Actions.PlacementActions.PlacementAction;

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

    private boolean mHasPlacementAction;
    private boolean mHasFamilyMemberAction;
    private boolean mHasPlayerAction;
    private boolean mCanSupportVatican;

    private ServerConnection mServerConnection;

    private String mMainMenuMessage;

    private ArrayList<String> mMainMenu;
    private ArrayList<String> mPlayersMenu;

    private String mUserName;


    public CLIClientGame(ServerConnection serverConnection, String userName){

        mServerConnection = serverConnection;
        mUserName = userName;

        mHasPlacementAction = false;
        mCanSupportVatican = false;

        mMainMenuMessage = "\n###################################################";
        mMainMenuMessage += "\n######### Lorenzo il Magnifico Main Menu ##########";
        mMainMenuMessage += "\n###################################################\n";

        mMainMenu = Constants.CLI_MAIN_MENU;

        mPlayersMenu = new ArrayList<>();

    }


    public static void alertActions(){

        System.out.println("\n##It's your turn to play, actions available in main menu, please refresh!!!##");
        System.out.println("##It's your turn to play, actions available in main menu, please refresh!!!##");
        System.out.println("##It's your turn to play, actions available in main menu, please refresh!!!##");
        System.out.println("\nYour choice? -> ");

    }


    public static void alertCouncilAction(){

        System.out.println("\n##You have Council Choice, please refresh!!!##");
        System.out.println("##You have Council Choice, please refresh!!!##");
        System.out.println("##You have Council Choice, please refresh!!!##");
        System.out.println("\nYour choice? -> ");

    }


    public static void alertVaticanReport(){

        System.out.println("\n##You have a vatican action to do, please refresh!!!##");
        System.out.println("##You have a vatican action to do, please refresh!!!##");
        System.out.println("##You have a vatican action to do, please refresh!!!##");
        System.out.println("\nYour choice? -> ");


    }


    private void doPlacementAction(){

        ArrayList<PlacementAction> playerActionsList;

        playerActionsList = mServerConnection.getPlacementActionsList();

        int choice = Prompter.promptForIntChoiceZero("Choose your action, or press 0 to go back",
                playerActionsList.stream().map(PlacementAction::toString).collect(Collectors.toList()));

       if(choice > 0){

           mServerConnection.doPlacementAction(choice);
           mServerConnection.setHasPlacementAction(false);
       }

    }

    private void doFamilyMemberAction(){

        ArrayList<FamilyMemberAction> familyMemberActionsList;

        familyMemberActionsList = mServerConnection.getFamilyMemberActionsList();

        int choice = Prompter.promptForIntChoiceZero("Choose what Family Member give power to, or press 0 to go back",
                familyMemberActionsList.stream().map(FamilyMemberAction::toString).collect(Collectors.toList()));

        if(choice > 0){

            mServerConnection.doFamilyMemberAction(choice);
        }


    }

    private void useCouncilPrivilege(){

        int privilegesCount = mServerConnection.getCouncilChoices();

        ArrayList<Integer> choices = Prompter.promptMultipleDifferentChoices
                ("Choose " + privilegesCount +" different council privilege", Constants.CLI_COUNCIL_MENU , privilegesCount, Constants.MAX_COUNCIL);

        mServerConnection.sendCouncilChoices(choices);

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

        mHasPlacementAction = mServerConnection.hasPlacementAction();
        mHasFamilyMemberAction = mServerConnection.hasFamilyMemberAction();
        mHasPlayerAction = mServerConnection.hasPlayerActions();

        mCanSupportVatican = mServerConnection.canSupportVatican();

        //Add Placement Action to menu
        if(mHasPlacementAction)
            mMainMenu.set(3, "Do Placement Action");

        //Add Family Member Action to menu
        if(mHasFamilyMemberAction)
            mMainMenu.set(4, "Do Family Member Action");

        //Add Player Action to menu
        if(mHasPlayerAction)
            mMainMenu.set(5, "Do Player Action");

        //Remove Placement Action from menu
        if(!mHasPlacementAction)
            mMainMenu.set(3, "Placement Action - Not your turn to play");

        //Remove Family Member Action from menu
        if(!mHasFamilyMemberAction)
            mMainMenu.set(4, "No Family Member Action available");

        //Remove Placement Action from menu
        if(!mHasPlayerAction)
            mMainMenu.set(5, "Not your turn to play, or you don't have an action");

    }

    private void chooseLeaderCard(){
        mServerConnection.waitLeaderCardsChoiceList();
        ArrayList<LeaderCard> mCards = mServerConnection.getLeaderCardsChoiceList();

        int choice = Prompter.promptForIntChoice(
                "Choose a Leader card to keep, the others will be passed to the next player\n\n",
                mCards.stream().map(LeaderCard::toString).collect(Collectors.toList())
        );

        mServerConnection.chooseLeaderCard(choice);

    }

    private void choosePersonalBoardBonusTile(){
        mServerConnection.waitPersonalBoardBonusTileChoiceList();
        ArrayList<PersonalBonusTile> mTiles = mServerConnection.getPersonalBonusTilesList();

        int choice = Prompter.promptForIntChoice(
                "Choose a Personal Board Bonus Tile to keep, the others will be passed to the previous player",
                mTiles.stream().map(PersonalBonusTile::toString).collect(Collectors.toList())
        );

        mServerConnection.choosePersonalBoardBonusTile(choice);
    }


    private void vaticanReport(){

        int choice = Prompter.promptForIntChoice(
                "Do you want to support the vatican?",
                Constants.YES_NO_CHOICE
        );
        choice--;
        mServerConnection.vaticanReportChoice(choice);
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

        System.out.println("\n## Before the Game start, Players need to choose their 4 leader cards ##");

        for(int i = 0; i < Constants.HAND_SIZE; i++){

            chooseLeaderCard();

        }

        System.out.println("\n## Before the Game start, Players need to choose their Personal Board Bonus Tile ##");

        choosePersonalBoardBonusTile();





        boolean run = true;

        while(run){

            updateData();

            if(mCanSupportVatican){
                vaticanReport();
                mCanSupportVatican = false;
            }

            if(mServerConnection.hasCouncilAction()){
                useCouncilPrivilege();
            }

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
                    //Do PlacementAction
                    updateData();
                    if(mHasPlacementAction)
                        doPlacementAction();
                    break;
                }
                case 5:{
                    //Do Family Member Action
                    updateData();
                    if(mHasFamilyMemberAction)
                        doFamilyMemberAction();
                    break;
                }
                case 6:{
                    //Do Player Action
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

        switch (Prompter.promptForIntChoice("Please choose what to display of Player: " + player.getUserName(), Constants.CLI_PLAYER_MENU)){

            case 1:{
                //Show Player info
                System.out.println(player.toString());
                break;
            }

            case 2:{
                System.out.println(player.getUserName() + "family members are: \n");
                //Show Player available FamilyMembers
                System.out.println(player.getFamilyMember("BLACK").toString());
                System.out.println(player.getFamilyMember("ORANGE").toString());
                System.out.println(player.getFamilyMember("WHITE").toString());
                System.out.println(player.getFamilyMember("NEUTRAL").toString());
                break;
            }

            case 3:{
                //Show Player Resources and Points
                System.out.println(player.getUserName() + " Resources are: " + player.getPersonalBoard().getUserResources().toString());
                System.out.println(player.getUserName() + "\n Points are: " + player.getUserPoints().toString());
                break;
            }

            case 4:{
                //Show Player Green cards
                System.out.println(player.getUserName() + "Territory cards:");
                System.out.println(player.getPersonalBoard().territoryToString());
                break;
            }

            case 5:{
                //Show Player Yellow cards
                System.out.println(player.getUserName() + "Building cards:");
                System.out.println(player.getPersonalBoard().buildingToString());
                break;
            }

            case 6:{
                //Show Player Blue cards
                System.out.println(player.getUserName() + "Character cards:");
                System.out.println(player.getPersonalBoard().characterToString());
                break;
            }

            case 7:{
                //Show Player Purple cards
                System.out.println(player.getUserName() + "Venture cards:");
                System.out.println(player.getPersonalBoard().ventureToString());
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

        String mString = new String();

        switch(Prompter.promptForIntChoice("Please choose what to display", Constants.CLI_BOARD_MENU)){

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

            case 5:{

                System.out.println(mBoard.getBlackDice().toString());
                System.out.println(mBoard.getWhiteDice().toString());
                System.out.println(mBoard.getOrangeDice().toString());
                break;
            }

            case 6:{

                mString = mBoard.getExcommunicationTilesList().toString();

                mString = mString.replace("[", "");
                mString = mString.replace("]", "");
                mString = mString.replace(",", "");

                System.out.println(mString);

            }
        }

    }


    /**
     * Display towers to the CLI
     */
    private void displayTowers(){

        switch (Prompter.promptForIntChoice("Please choose a Tower", Constants.CLI_TOWERS_MENU)){

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