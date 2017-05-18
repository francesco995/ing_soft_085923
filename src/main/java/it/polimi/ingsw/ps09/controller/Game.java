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

    //Map of Players by ID
    private HashMap<Integer, Player> mPlayers;

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


    public void startGame() throws FileNotFoundException {

    }


    private void setupGame() throws FileNotFoundException {
        setupPlayers();
        setupDecks();
    }

    /**
     * Creates a new HashMap of Players to userIDs, each player contains his own PersonalBoard
     */
    private void setupPlayers(){

        mPlayers = new HashMap<>();

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
     *
     */
    private void setupDecks() throws FileNotFoundException {

        mDevelopmentCardsDeck = new DevelopmentCardsDeck();

        mExcommunicationTilesDeck = new ExcommunicationTilesDeck();

        mLeaderCardsDeck = new LeaderCardsDeck();

    }







}
