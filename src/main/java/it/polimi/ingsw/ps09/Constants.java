package it.polimi.ingsw.ps09;

/**
 * Created by francesco995 on 30/06/2017.
 * Application constants
 */
public final class Constants {


    //####################################################
    //####################################################
    //############## Networking constants ################


    /**
     * Port for Socket connections
     */
    public static final int SOCKET_PORT = 1024;

    //####################################################
    //####################################################
    //############### Testing constants ##################

    /**
     * True if you want to run server with more output for diagnostics
     */
    public static final boolean ADVANCED_TESTING_SERVER = false;

    /**
     * True if you want to run clients with more output for diagnostics
     */
    public static final boolean ADVANCED_TESTING_CLIENT = false;



    //####################################################
    //####################################################
    //############## Game logic constants ################


    /**
     * Max players number for each game
     */
    public static final int MAX_PLAYERS = 4;
    /**
     * Static number for PersonalBoardBonusDeck
     */
    public static final int TILE_TOTAL = 4;
    /**
     * Static numbers for LeaderCardDeck
     */
    public static final int CARD_TOTAL = 20;
    public static final int HAND_SIZE = 4;
    /**
     * Static number for ExcommunicationTilesDeck
     */
    /**
     * Static number for DevelopmentCardsDeck
     */
    public final static int MAX_PERIODS = 3;
    public static final int CARD_PER_PERIOD = 7;
    /**
     * Static number for Actions
     */
    public static final int EXTRA_TOWER_COST = 3;
    public static final int SERVANT_TO_ADD_POWER = 1;
    public static final int MAX_NUMBER_PRIVILEGE = 5;
    public static final int TOWER_HEIGHT = 4;
    /**
     * Max dice number
     */
    public static final int MAX_DICE_VALUE = 6;
    /**
     * User resources constant for new player
     */
    public static final int INITIAL_SERVANT = 3;
    public static final int INITIAL_STONE = 2;
    public static final int INITIAL_WOOD = 2;
    //####################################################
    //####################################################
    //############### Game view constants ################


    /**
     * Timeout for placement action
     */
    public static final int PLACEMENT_ACTION_TIMEOUT = 30;



}
