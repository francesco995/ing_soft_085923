package it.polimi.ingsw.ps09.controller;

import it.polimi.ingsw.ps09.model.Player;

import java.util.HashMap;
import java.util.Queue;

import java.util.logging.Logger;
import static java.util.logging.Level.INFO;


public class Game {

    //Game components
    public static int mGameId;

    //LOGGER
    private static final Logger mLogger = Logger.getLogger( Player.class.getName() );

    private HashMap<Integer, Player> mPlayers = new HashMap<>();


    public Game(Queue<Integer> userIds, Queue<String> userNames, Queue<String> userColors, int gameId){

        mGameId = gameId;
        mLogger.log(INFO, "Creating a new Game with ID: " + mGameId);

        while(!userIds.isEmpty() && !userNames.isEmpty()){
            mPlayers.put(
                    userIds.peek(),
                    new Player(userNames.peek(), userColors.peek(), userIds.peek(), mPlayers.size() + 5 ) );

            mLogger.log(INFO, "Added a player to game# " + gameId +
                                    " with userName: " + userNames.peek() +
                                    ", userColor: " + userColors.peek() +
                                    ", userId: " + userIds.peek());

            userIds.remove();
            userNames.remove();
            userColors.remove();
        }




    }








}
