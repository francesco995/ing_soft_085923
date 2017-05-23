package it.polimi.ingsw.ps09.controller;

import it.polimi.ingsw.ps09.model.Board;
import it.polimi.ingsw.ps09.model.Decks.DevelopmentCardsDeck;
import it.polimi.ingsw.ps09.model.Decks.ExcommunicationTilesDeck;
import it.polimi.ingsw.ps09.model.Decks.LeaderCardsDeck;
import it.polimi.ingsw.ps09.model.DevelopmentCards.*;
import it.polimi.ingsw.ps09.model.DevelopmentCards.Character;
import it.polimi.ingsw.ps09.model.Dices.BlackDice;
import it.polimi.ingsw.ps09.model.Dices.OrangeDice;
import it.polimi.ingsw.ps09.model.Dices.WhiteDice;
import it.polimi.ingsw.ps09.model.FaithPointsTrack;
import it.polimi.ingsw.ps09.model.Player;
import it.polimi.ingsw.ps09.model.Points.VictoryPoints;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Queue;

import java.util.logging.Logger;
import static java.util.logging.Level.INFO;


/**
 *
 */
public class Game extends Thread {

    //####################################################
    //####################################################
    //############### Game Components ####################

    //Unique GameID
    public static int GAME_ID;

    //Players IDs, Names and Colors
    private Queue<Integer> mUserIds;
    private Queue<String> mUserNames;
    private Queue<String> mUserColors;

    //Number of players
    public static int PLAYERS_NUMBER;

    //Map of Players by ID
    private HashMap<Integer, Player> mPlayers;

    //The Players Order manager
    private PlayersOrder mPlayersOrder;

    //The Game Board
    private Board mGameBoard;

    //The Period
    int period = 1;

    //The Tracks
    private FaithPointsTrack mFaithPointsTrack;

    //The Card Decks
    private DevelopmentCardsDeck mDevelopmentCardsDeck;
    private ExcommunicationTilesDeck mExcommunicationTilesDeck;
    private LeaderCardsDeck mLeaderCardsDeck;

    //The Dices
    private BlackDice mBlackDice;
    private OrangeDice mOrangeDice;
    private WhiteDice mWhiteDice;

    //LOGGER
    private static final Logger mLogger = Logger.getLogger( Player.class.getName() );


    /**
     * The Game constructor creates the basic game structure without initializing anything
     * @param userIds Queue of UserIDs
     * @param userNames Queue of UserNames
     * @param userColors Queue of UserColors
     * @param gameId Unique GameID
     */
    public Game(Queue<Integer> userIds, Queue<String> userNames, Queue<String> userColors, int gameId){

        GAME_ID = gameId;
        PLAYERS_NUMBER = userIds.size();

        mUserIds = userIds;
        mUserNames = userNames;
        mUserColors = userColors;

        mLogger.log(INFO, "Created a new Game with ID: " + GAME_ID);

    }

    /**
     * Starts the Game Thread
     * then setup and start the game, handling exceptions
     */
    @Override
    public void run(){

        mLogger.log(INFO, "Game: " + GAME_ID + " is setting up!");
        try {
            setupGame();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        mLogger.log(INFO, "Game: " + GAME_ID + " is starting!");
        try {
            startGame();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }


    /**
     * Start the game
     * @throws FileNotFoundException
     */
    private void startGame() throws FileNotFoundException {

    }


    /**
     * Setup the game
     * @throws FileNotFoundException
     */
    private void setupGame() throws FileNotFoundException {

        //Create 3 dices
        setupDices();

        //Setup the Player objects
        setupPlayers();

        //Setup and loads the Deck objects
        setupDecks();

        //Set the Board
        mGameBoard = new Board( mExcommunicationTilesDeck.drawCard(1),
                                mExcommunicationTilesDeck.drawCard(2),
                                mExcommunicationTilesDeck.drawCard(3));

        fillTower();

    }

    /**
     * Creates a new HashMap of Players to userIDs, each player contains his own PersonalBoard
     */
    private void setupPlayers(){

        mPlayers = new HashMap<>();
        mPlayersOrder = new PlayersOrder(mUserIds);

        while(!mUserIds.isEmpty() && !mUserNames.isEmpty()){
            mPlayers.put(
                    mUserIds.peek(),
                    new Player( mUserNames.peek(),
                                mUserColors.peek(),
                                mUserIds.peek(),
                                mPlayers.size() + 5 ) );

            mLogger.log(INFO,
                    "Added a player to game# " + GAME_ID +
                    " with userName: " + mUserNames.peek() +
                    ", userColor: " + mUserColors.peek() +
                    ", userId: " + mUserIds.peek());

            mUserIds.remove();
            mUserNames.remove();
            mUserColors.remove();
        }

    }

    /**
     * Loads the 3 card decks
     */
    private void setupDecks() throws FileNotFoundException {

        mDevelopmentCardsDeck = new DevelopmentCardsDeck();
        mExcommunicationTilesDeck = new ExcommunicationTilesDeck();
        mLeaderCardsDeck = new LeaderCardsDeck();

    }

    /**
     * Setup the Dices
     */
    private void setupDices(){

        mWhiteDice = new WhiteDice();
        mBlackDice = new BlackDice();
        mOrangeDice = new OrangeDice();

    }


    /**
     * void method that fill the tower to the top with randomly drawn cards from the deck
     */
    private void fillTower() {

        //problem it need to add as code every new kind of tower if a new tower is added to game

        for (int i = 0; i < mGameBoard.getTerritoriesTowerFloors().size(); i++) {

            //it fills all the floor no matter how many are there
            mGameBoard.setTerritoriesTowerCard(i,
                    (Territory) mDevelopmentCardsDeck.drawCard("TERRITORY"));

        }

        for (int i = 0; i < mGameBoard.getCharacterTowerFloors().size(); i++) {

            //it fills all the floor no matter how many are there
            mGameBoard.setCharacterTowerCard(i,
                    (Character) mDevelopmentCardsDeck.drawCard("CHARACTER"));

        }

        for (int i = 0; i < mGameBoard.getBuildingsTowerFloors().size(); i++) {

            //it fills all the floor no matter how many are there
            mGameBoard.setBuildingsTowerCard(i,
                    (Building) mDevelopmentCardsDeck.drawCard("BUILDING"));

        }

        for (int i = 0; i < mGameBoard.getVenturesTowerFloors().size(); i++) {
            //it fills all the floor no matter how many are there
            mGameBoard.setVenturesTowerCard(i,
                    (Venture) mDevelopmentCardsDeck.drawCard("VENTURE"));

        }
    }
        /**
         * Simple method that roll all the dices
         */
        private void rollDices(){

            mBlackDice.roll();
            mWhiteDice.roll();
            mOrangeDice.roll();

        }

        /**
         * Prepare the board for a new Round
         */
        private void roundSetup(){

            fillTower();
            rollDices();

        }

        /**
         * This method represents phase C of The Game, it must be called only when a period its at his end
         */
        private void vaticanReport(){


            int numberOfPlayer = mPlayers.size();

            if(mPlayers.get(0).getFaithPoints().getPoints() < period ){
                //mPlayers.get(0).add();
            }else {
                //if(mDonate == false){
                //mPlayers.get(0).add(tilescomunica);
                //}else{
                // FaithPoints mOffer = mPlayers.get(0).clearFaithPoints();
                //VictoryPoints mReward = mFaithPointsTrack.convertToBonus(mOffer);
                //mPlayers.get(0).add(mReward);
            }

        }
        private void endRound(){


            //inserire funzione gianni reorder
            mGameBoard.clearAll();


        }

        /**
         *
         */
        private void endPeriod(){

            //reorder dei pedoni
            mGameBoard.clearAll();
            vaticanReport();
            period++;

        }
        private void endGame(){

            //cicla tutti i giocatori (in base a come mettiamo id)

            //Collected resources bonus//
            /////////////////////////////
            int total =
                    mPlayers.get(0).getWood().getValue()+
                    mPlayers.get(0).getStone().getValue()+
                    mPlayers.get(0).getCoins().getValue()+
                    mPlayers.get(0).getServant().getValue();

            VictoryPoints collectedResources = new VictoryPoints(total/5);
            mPlayers.get(0).add(collectedResources);

            //Conquered territories Bonus//
            ///////////////////////////////
            total = mPlayers.get(0).getTerritoriesCount();
            //decidiamo come caricare i bonus del tabellone personale

            //Influenced Characters//
            /////////////////////////
            total = mPlayers.get(0).getCharactersCount();

            //Encouraged Ventures//
            ///////////////////////
            total = mPlayers.get(0).getVenturesCount();

            //Military Strength//
            /////////////////////
            mPlayers.get(0).getMilitaryPoints().getPoints();
        }
    }