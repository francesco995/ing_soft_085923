package it.polimi.ingsw.ps09.model;

import it.polimi.ingsw.ps09.controller.Game;
import it.polimi.ingsw.ps09.model.Points.FaithPoints;
import it.polimi.ingsw.ps09.model.Points.MilitaryPoints;
import it.polimi.ingsw.ps09.model.Points.VictoryPoints;
import it.polimi.ingsw.ps09.model.Resources.*;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

import static java.util.logging.Level.INFO;

/**
 * Created by francGianni on 10/05/2017.
 */
public class Player {

    //CONSTANTS
    public static int PLAYER_ID;

    //VARIABLES
    private String mUserName;
    private String mUserColor;

    //GAME OBJECTS
    private PersonalBoard mPersonalBoard;
    private UserPoints mUserPoints;
    private List<LeaderCard> mLeaderCards;

    //LOGGER
    private static final Logger mLogger = Logger.getLogger( Player.class.getName() );


    //CONSTRUCTOR

    /**
     * Create a new player with default resources and no cards
     * @param userName The name of the Player that is being created
     * @param userColor The color of the Player that is being created
     * @param userId The UserId for the Player that is being created
     */
    public Player(String userName, String userColor, int userId, int initialCoins){
        this(userName, userColor, new PersonalBoard(initialCoins),
                new UserPoints(), userId);
    }

    /**
     * Create a new player with given resources and cards
     * @param userName The name of the Player that is being created
     * @param userColor The color of the Player that is being created
     * @param personalBoard The player can receive an already-created PersonalBoard
     * @param userPoints The player can receive and already-created UserPoints
     * @param userId The UserId for the Player that is being created
     */
    private Player(String userName, String userColor, PersonalBoard personalBoard,
                  UserPoints userPoints, int userId){
        mUserName = userName;
        mUserColor = userColor;
        mPersonalBoard = personalBoard;
        mUserPoints = userPoints;
        PLAYER_ID = userId;

        mLeaderCards = new LinkedList<>();

        //log created player
        mLogger.log(INFO, "Game: " + Game.GAME_ID +
                                " created player: " + mUserName +
                                " with Id: " + PLAYER_ID +
                                " with color: " + mUserColor +
                                " with: " + mPersonalBoard.getCoins().getValue() + " initial Coins");
    }

    //Get User info

    public String getUserName() {
        return mUserName;
    }

    public String getUserColor() {
        return mUserColor;
    }

    public List<LeaderCard> getLeaderCards() {
        return mLeaderCards;
    }

//User points as point objects

    public FaithPoints getFaithPoints() {
        return mUserPoints.getFaithPoints();
    }

    public MilitaryPoints getMilitaryPoints() {
        return mUserPoints.getMilitaryPoints();
    }

    public VictoryPoints getVictoryPoints() {
        return mUserPoints.getVictoryPoints();
    }


    //####################################################
    //####################################################
    //################ Add a Leader Card #################

    /**
     * Add a Leader Card to Player
     * @param leaderCard Leader Card to add
     */
    public void add(LeaderCard leaderCard){
        mLeaderCards.add(leaderCard);

        //LOG
        mLogger.log(INFO, "Game: " + Game.GAME_ID +
                " add Leader Card " + leaderCard.getCardName() +
                " to player: " + mUserName +
                " now has: " + mLeaderCards.size() + " Leader Cards");

    }

    //####################################################
    //####################################################
    //################# Clear FaithPoints ################

    /**
     * Clears all the Player FaithPoints, and returns the value
     * @return Old Player FaithPoints value (as object)
     */
    public FaithPoints clearFaithPoints(){

        //LOG
        mLogger.log(INFO, "Game: " + Game.GAME_ID +
                " clearing FaithPoints for player: " + mUserName +
                " had: " + mUserPoints.getFaithPoints() + " FaithPoints, now has 0");

        return mUserPoints.clearFaithPoints();
    }

    //####################################################
    //####################################################
    //#################### Add Points ####################

    /**
     * Add UserPoints to Player
     * @param addPoints UserPoints containing multiple Points objects
     */
    public void add(UserPoints addPoints){
        add(addPoints.getFaithPoints());
        add(addPoints.getMilitaryPoints());
        add(addPoints.getVictoryPoints());
    }

    /**
     * Add FaithPoints to Player
     * @param faithPoints FaithPoints (object) to add
     */
    public void add(FaithPoints faithPoints){
        mUserPoints.add(faithPoints);

        //LOG
        mLogger.log(INFO, "Game: " + Game.GAME_ID +
                                " add " + faithPoints.toString() +
                                " FaithPoints to player: " + mUserName +
                                " now has: " + mUserPoints.getFaithPoints().toString() + " FaithPoints");

    }

    /**
     * Add MilitaryPoints to Player
     * @param militaryPoints MilitaryPoints (object) to add
     */
    public void add(MilitaryPoints militaryPoints){
        mUserPoints.add(militaryPoints);

        //LOG
      mLogger.log(INFO,"Game: " + Game.GAME_ID +
                            " add " + militaryPoints.toString() +
                            " MilitaryPoints to player: " + mUserName +
                            " now has: " + mUserPoints.getFaithPoints().toString() + " MilitaryPoints");

    }

    /**
     * Add VictoryPoints to Player
     * @param victoryPoints VictoryPoints (object) to add
     */
    public void add(VictoryPoints victoryPoints){
        mUserPoints.add(victoryPoints);

        //LOG
        mLogger.log(INFO, "Game: " + Game.GAME_ID +
                                " add " + victoryPoints.toString() +
                                " VictoryPoints to player: " + mUserName +
                                " now has: " + this.getFaithPoints().toString() + " VictoryPoints");

    }

    //####################################################
    //####################################################
    //################## Get Resources ###################

    public Coins getCoins() {
        return mPersonalBoard.getCoins();
    }

    public Servant getServant() {
        return mPersonalBoard.getServant();
    }

    public Stone getStone() {
        return mPersonalBoard.getStone();
    }

    public Wood getWood() {
        return mPersonalBoard.getWood();
    }

    //Get user cards count as int

    /**
     *
     * @return number of territories card owned by player
     */
    public int getTerritoriesCount(){

        return mPersonalBoard.getBoardTerritories().size();

    }

    public int getCharactersCount(){

        return mPersonalBoard.getBoardCharacters().size();

    }

    public int getBuildingsCount(){

        return mPersonalBoard.getBoardBuildings().size();

    }

    public int getVenturesCount(){

        return mPersonalBoard.getBoardTerritories().size();

    }
    //####################################################
    //####################################################
    //################## Add Resources ###################

    /**
     * Add UserResources to Player
     * @param addResources a UserResources containing multiple resource objects
     */
    public void add(UserResources addResources){
        add(addResources.getCoins());
        add(addResources.getServant());
        add(addResources.getStone());
        add(addResources.getWood());
    }

    /**
     * Add Coins to Player
     * @param addCoins Coins (object) to add
     */
    public void add(Coins addCoins){
        mPersonalBoard.addCoins(addCoins);

        //LOG
        mLogger.log(INFO, "Game: " + Game.GAME_ID +
                " add " + addCoins.toString() +
                " Coins to player: " + mUserName +
                " now has: " + this.getCoins().toString() + " Coins");

    }

    /**
     * Add Servants to Player
     * @param addServant Servant (object) to add
     */
    public void add(Servant addServant){
        mPersonalBoard.addServant(addServant);

        //LOG
        mLogger.log(INFO, "Game: " + Game.GAME_ID +
                " add " + addServant.toString() +
                " Servant to player: " + mUserName +
                " now has: " + this.getServant().toString() + " Servant");

    }

    /**
     * Add Stone to Player
     * @param addStone Stone (object) to add
     */
    public void add(Stone addStone){
        mPersonalBoard.addStone(addStone);

        //LOG
        mLogger.log(INFO, "Game: " + Game.GAME_ID +
                " add " + addStone.toString() +
                " Stone to player: " + mUserName +
                " now has: " + this.getStone().toString() + " Stone");

    }

    /**
     * Add Wood to Player
     * @param addWood Wood (object) to add
     */
    public void add(Wood addWood){
        mPersonalBoard.addWood(addWood);

        //LOG
        mLogger.log(INFO, "Game: " + Game.GAME_ID +
                " add " + addWood.toString() +
                " Wood to player: " + mUserName +
                " now has: " + this.getWood().toString() + " Wood");

    }


    //####################################################
    //####################################################
    //######### Check if Player has Resources ############

    /**
     * Check if Player has a given Resource / Points
     * @param hasCoins the Resource / Points to check if Player has
     * @return returns true if the Player has the given Resource / Points
     */
    public boolean has(Coins hasCoins){
        return mPersonalBoard.getCoins().isGreaterOrEqual(hasCoins);
    }

    /**
     * Check if Player has a given Resource / Points
     * @param hasServant the Resource / Points to check if Player has
     * @return returns true if the Player has the given Resource / Points
     */
    public boolean has(Servant hasServant){
        return mPersonalBoard.getServant().isGreaterOrEqual(hasServant);
    }

    /**
     * Check if Player has a given Resource / Points
     * @param hasStone the Resource / Points to check if Player has
     * @return returns true if the Player has the given Resource / Points
     */
    public boolean has(Stone hasStone){
        return mPersonalBoard.getStone().isGreaterOrEqual(hasStone);
    }

    /**
     * Check if Player has a given Resource / Points
     * @param hasWood the Resource / Points to check if Player has
     * @return returns true if the Player has the given Resource / Points
     */
    public boolean has(Wood hasWood){
        return mPersonalBoard.getWood().isGreaterOrEqual(hasWood);
    }

    /**
     * Check if Player has a given Resource / Points
     * @param hasUserResources the Resource / Points to check if Player has
     * @return returns true if the Player has the given Resource / Points
     */
    public boolean has(UserResources hasUserResources){
        return (
                    has(hasUserResources.getCoins()) &&
                    has(hasUserResources.getServant()) &&
                    has(hasUserResources.getStone()) &&
                    has(hasUserResources.getWood())
                );
    }

    //####################################################
    //####################################################
    //########## Check if Player has Points ##############

    /**
     * Check if Player has a given Resource / Points
     * @param hasUserPoints the Resource / Points to check if Player has
     * @return returns true if the Player has the given Resource / Points
     */
    public boolean has(UserPoints hasUserPoints){
        return (
                    has(hasUserPoints.getFaithPoints()) &&
                    has(hasUserPoints.getMilitaryPoints()) &&
                    has(hasUserPoints.getVictoryPoints())
                );
    }

    /**
     * Check if Player has a given Resource / Points
     * @param hasFaithPoints the Resource / Points to check if Player has
     * @return returns true if the Player has the given Resource / Points
     */
    public boolean has(FaithPoints hasFaithPoints){
        return mUserPoints.getFaithPoints().isGreaterOrEqual(hasFaithPoints);
    }

    /**
     * Check if Player has a given Resource / Points
     * @param hasMilitaryPoints the Resource / Points to check if Player has
     * @return returns true if the Player has the given Resource / Points
     */
    public boolean has(MilitaryPoints hasMilitaryPoints){
        return mUserPoints.getMilitaryPoints().isGreaterOrEqual(hasMilitaryPoints);
    }

    /**
     * Check if Player has a given Resource / Points
     * @param hasVictoryPoints the Resource / Points to check if Player has
     * @return returns true if the Player has the given Resource / Points
     */
    public boolean has(VictoryPoints hasVictoryPoints){
        return mUserPoints.getVictoryPoints().isGreaterOrEqual(hasVictoryPoints);
    }


    //####################################################
    //####################################################
    //########## Remove Points from Player ###############
    //TODO: FraG

    public void remove(FaithPoints removeFaithPoints){
        if(has(removeFaithPoints)){

        }

    }


}
