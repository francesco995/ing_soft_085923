package it.polimi.ingsw.ps09.controller;

import it.polimi.ingsw.ps09.model.Board;
import it.polimi.ingsw.ps09.model.Decks.DevelopmentCardsDeck;
import it.polimi.ingsw.ps09.model.Decks.ExcommunicationTilesDeck;
import it.polimi.ingsw.ps09.model.Decks.LeaderCardsDeck;
import it.polimi.ingsw.ps09.model.Dices.BlackDice;
import it.polimi.ingsw.ps09.model.Dices.OrangeDice;
import it.polimi.ingsw.ps09.model.Dices.WhiteDice;
import it.polimi.ingsw.ps09.model.Player;

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

        mGameBoard = new Board( mExcommunicationTilesDeck.drawCard(1),
                                mExcommunicationTilesDeck.drawCard(2),
                                mExcommunicationTilesDeck.drawCard(3));
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

    private void setupDices(){

        mWhiteDice = new WhiteDice();
        mBlackDice = new BlackDice();
        mOrangeDice = new OrangeDice();

    }







}
