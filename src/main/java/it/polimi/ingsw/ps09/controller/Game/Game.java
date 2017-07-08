package it.polimi.ingsw.ps09.controller.Game;

import it.polimi.ingsw.ps09.Constants;
import it.polimi.ingsw.ps09.controller.PlayersOrder;
import it.polimi.ingsw.ps09.controller.Network.Server.PlayerConnections.PlayerConnection;
import it.polimi.ingsw.ps09.model.Board;
import it.polimi.ingsw.ps09.model.Decks.DevelopmentCardsDeck;
import it.polimi.ingsw.ps09.model.Decks.ExcommunicationTilesDeck;
import it.polimi.ingsw.ps09.model.Decks.LeaderCardsDeck;
import it.polimi.ingsw.ps09.model.Decks.PersonalBonusTilesDeck;
import it.polimi.ingsw.ps09.model.Dices.BlackDice;
import it.polimi.ingsw.ps09.model.Dices.OrangeDice;
import it.polimi.ingsw.ps09.model.Dices.WhiteDice;
import it.polimi.ingsw.ps09.model.FaithPointsTrack;
import it.polimi.ingsw.ps09.model.FamilyMembers.FamilyMember;
import it.polimi.ingsw.ps09.model.PersonalBoardBonus;
import it.polimi.ingsw.ps09.model.Places.Towers.Tower;
import it.polimi.ingsw.ps09.model.Player;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
    protected ArrayList<Integer> mUserIds;
    protected List<String> mUserNames;
    protected ArrayList<String> mUserColors;

    //Number of players
    public static int PLAYERS_NUMBER;

    //Map of Players by ID
    protected HashMap<Integer, Player> mPlayers;

    //Map of Players connection by ID
    protected HashMap<Integer, PlayerConnection> mConnections;

    //The Players Order manager
    protected PlayersOrder mPlayersOrder;

    //The Game Board
    protected Board mGameBoard;

    //The Period
    protected int mPeriod = 0;

    //The Tracks
    protected FaithPointsTrack mFaithPointsTrack;

    //Personal Board Bonus

    protected PersonalBoardBonus mPersonalBoardBonus;

    //The Card Decks
    protected DevelopmentCardsDeck mDevelopmentCardsDeck;
    protected ExcommunicationTilesDeck mExcommunicationTilesDeck;
    protected LeaderCardsDeck mLeaderCardsDeck;

    //The Dices
    protected BlackDice mBlackDice;
    protected OrangeDice mOrangeDice;
    protected WhiteDice mWhiteDice;

    //All personalBoardBonusTiles
    protected PersonalBonusTilesDeck mPersonalBonusTilesDeck;


    //LOGGER
    protected static final Logger mLogger = Logger.getAnonymousLogger();


    /**
     * The Game constructor creates the basic game structure without initializing anything
     *
     * @param userIds    Queue of UserIDs
     * @param userNames  Queue of UserNames
     * @param userColors Queue of UserColors
     * @param gameId     Unique GameID
     */
    public Game(ArrayList<Integer> userIds,
                List<String> userNames,
                ArrayList<String> userColors,
                int gameId,
                HashMap<Integer, PlayerConnection> connections) {

        GAME_ID = gameId;
        PLAYERS_NUMBER = userNames.size();

        mUserIds = userIds;
        mUserNames = userNames;
        mUserColors = userColors;

        mConnections = connections;

        mLogger.log(INFO, "Created a new Game with ID: " + GAME_ID);

    }

    /**
     * Starts the Game Thread
     * then setup and start the game, handling exceptions
     */
    @Override
    public void run() {

        mLogger.log(INFO, "Game: " + GAME_ID + " is setting up!");
        try {
            GameSetup.setupGame(this);
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
     *
     * @throws FileNotFoundException
     */
    private void startGame() throws FileNotFoundException {

        LeaderCardsExchange.startExchange(this);
        DrawBonusTile.startSelection(this);

        mPeriod = 1;
        Round.startRound(this, 1);
        Round.startRound(this, 2);
        vaticanReport();

        mPeriod = 2;
        Round.startRound(this, 3);
        Round.startRound(this, 4);
        vaticanReport();

        mPeriod = 3;
        Round.startRound(this, 5);
        Round.startRound(this, 6);
        vaticanReport();


        //End Game

    }



    /**
     * It calls the vatican report only when a mPeriod end (once every two round) (PHASE C)
     */
    private void vaticanReport() {

        mLogger.log(INFO, "Game: " + GAME_ID + " entering Vatican Report phase after period: " + mPeriod);

        mPlayersOrder.getPlayersOrder().stream().forEach(id -> {

            mLogger.log(INFO, "Game: " + GAME_ID + " checking Vatican Report for player: " + id);

            if(mPlayers.get(id).has(Constants.VATICAN_FAITH_POINTS.get(mPeriod))){

                //Ask if player wants to donate FaithPoints to vatican
                mConnections.get(id).waitVaticanReportChoiceReady();

                boolean choice = false; //Get choice from connection

                if(mConnections.get(id).getVaticanReportChoice() == 0) {
                    choice = true;
                }

                if(choice){

                    mPlayers.get(id).add(
                            mFaithPointsTrack.convertToBonus(
                                    mPlayers.get(id).clearFaithPoints()));

                }else{
                    //Player don't want to support vatican
                    mPlayers.get(id).add(mGameBoard.getExcommunicationTilesList().get(mPeriod-1));

                    mGameBoard.getExcommunicationTilesList().get(mPeriod-1).getExcommunicationTileEffects().stream().
                            forEach(effect -> effect.applyEffect(mPlayers.get(id)));
                }

                //If player has enough Faith Points to do vatican report


            }else{

                //If player don't have enough Faith Points

                mPlayers.get(id).add(mGameBoard.getExcommunicationTilesList().get(mPeriod-1));

                mGameBoard.getExcommunicationTilesList().get(mPeriod-1).getExcommunicationTileEffects().stream().
                        forEach(effect -> effect.applyEffect(mPlayers.get(id)));

            }


        });

    }

    /**
     * It must be called  at the end  of every round, it clears the board and reorders the player order (PHASE D1)
     */
    private void endRound() {


        //inserire funzione gianni reorder
        mGameBoard.clearAll();


    }

    /**
     *It must be called at the end of every mPeriod, does the same things that endRound does plus it adds the vaticanReport phase (PHASE D2)
     */
    private void endPeriod() {

        //reorder dei pedoni
        mGameBoard.clearAll();
        vaticanReport();
        mPeriod++;


    }


    /**
     *
     * @return ArrayList of booelan value, true if tower is free otherwise false
     */
    private ArrayList TowerDisposability(){

        ArrayList<Boolean> TowerDispos = new ArrayList<Boolean>();

        if(mGameBoard.isTerritoriesTowerAvailable())
            TowerDispos.add(true);
        else
            TowerDispos.add(false);

        if(mGameBoard.isCharacterTowerAvailable())
            TowerDispos.add(true);
        else
            TowerDispos.add(false);

        if(mGameBoard.isBuildingsTowerAvailable())
            TowerDispos.add(true);
        else
            TowerDispos.add(false);

        if(mGameBoard.isVenturesTowerAvailable())
            TowerDispos.add(true);
        else
            TowerDispos.add(false);

        return TowerDispos;
    }

    /**
     *
     * @param tower The specific tower you like to check
     * @return ArrayList of boolean value for each floor. True if a floor is free, otherwise false
     */
    private ArrayList AvailableFloor(Tower tower){

        ArrayList<Boolean> FloorDispos = new ArrayList<Boolean>();

        for(int cont=0; cont<tower.getFloors().size(); cont++){
            if(tower.getFloors().get(cont).isAvailable())
                FloorDispos.add(true);
            else
                FloorDispos.add(false);
        }

        return FloorDispos;
    }

    /**
     *
     * @return ArrayList of boolean value for each marketspace. True if available, false if not
     */
    private ArrayList AvailableMarketSpaces(){

        ArrayList<Boolean> MarketSpacesDispos = new ArrayList<Boolean>();

        for(int cont = 0; cont<mGameBoard.getMarketList().size(); cont++){
            if(mGameBoard.isMarketSpaceAvailable(cont))
                MarketSpacesDispos.add(true);
            else
                MarketSpacesDispos.add(false);
        }

        return MarketSpacesDispos;
    }

    private void setFamilyMemberOnFloor(FamilyMember familyMember, Tower tower, int floor){
        tower.getFloors().get(floor).setFamilyMember(familyMember);
    }



}