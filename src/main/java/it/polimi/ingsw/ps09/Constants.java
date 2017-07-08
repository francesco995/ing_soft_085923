package it.polimi.ingsw.ps09;

import it.polimi.ingsw.ps09.model.Points.FaithPoints;

import java.util.ArrayList;
import java.util.Arrays;

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
     * Vatican report Faith Points requirements
     */
    public static final ArrayList<FaithPoints> VATICAN_FAITH_POINTS = new ArrayList<>(
            Arrays.asList(
                    //First is empty because periods start from 1
                    new FaithPoints(0),
                    new FaithPoints(3),
                    new FaithPoints(4),
                    new FaithPoints(5)
            ));



    /**
     * Timeout to start game with 2-3 players
     */
    public static final int GAME_START_TIMEOUT = 25;

    /**
     * File with the Timeout to start game with 2-3 players
     */
    public static final String GAME_START_TIMEOUT_FILE = "gameTimeout.txt";

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
    /**
     * End game constants
     */
    public static final int FIRST_MILITARY = 5;
    public static final int SECOND_MILITARY  = 2;
    /**
     * Military requirement for green cards
     */
    public static final int THREE_GREEN= 3;
    public static final int FOUR_GREEN = 7;
    public static final int FIVE_GREEN = 12;
    public static final int SIX_GREEN = 18;
    //####################################################
    //####################################################
    //############### Game view constants ################


    /**
     * Timeout for placement action
     */
    public static final int PLACEMENT_ACTION_TIMEOUT = 30;


    /**
     * Main CLI menu
     */
    public static final ArrayList<String> CLI_MAIN_MENU = new ArrayList<>(
            Arrays.asList(
                    "Display Players",
                    "Display Board",
                    "Display Players order",
                    "Do Placement Action",
                    "Do Family Member Action",
                    "Do Player Action",
                    "Refresh main menu"
            ));


    /**
     * Board CLI menu
     */
    public static final ArrayList<String> CLI_BOARD_MENU = new ArrayList<>(
            Arrays.asList(
                "Display the whole Board",
                    "Display Towers",
                    "Display Markets",
                    "Display Harvest & Production",
                    "Display Dices values",
                    "Display Excommunication tiles",
                    "Go back to main menu"
            ));


    /**
     * Player CLI menu
     */
    public static final ArrayList<String> CLI_PLAYER_MENU = new ArrayList<>(
            Arrays.asList(
                    "Show Player info",
                    "Show Player available FamilyMembers",
                    "Show Player Resources and Points",
                    "Show Player Green cards",
                    "Show Player Yellow cards",
                    "Show Player Blue cards",
                    "Show Player Purple cards",
                    "Show Player last PlacementActions",
                    "Go back to main menu"
            ));


    /**
     * Towers CLI menu
     */
    public static final ArrayList<String> CLI_TOWERS_MENU = new ArrayList<>(
            Arrays.asList(
                "Green Tower",
                    "Yellow Tower",
                    "Blue Tower",
                    "Purple Tower",
                    "Go back to main menu"
            ));


    /**
     * Council CLI menu
     */
    public static final ArrayList<String> CLI_COUNCIL_MENU = new ArrayList<>(
            Arrays.asList(
                "Get 1 wood and 1 stone",
                    "Get 2 servants",
                    "Get 2 coins",
                    "Get 2 military points",
                    "Get 1 faith point"
            ));

    /**
     * Yes / No choice
     */
    public static final ArrayList<String> YES_NO_CHOICE = new ArrayList<>(
            Arrays.asList(
                    "Yes",
                    "No"
            ));

}
