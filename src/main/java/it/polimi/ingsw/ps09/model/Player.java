package it.polimi.ingsw.ps09.model;

import it.polimi.ingsw.ps09.controller.Game;
import it.polimi.ingsw.ps09.model.DevelopmentCardEffects.DevelopmentCardEffect;
import it.polimi.ingsw.ps09.model.DevelopmentCards.Building;
import it.polimi.ingsw.ps09.model.DevelopmentCards.DevelopmentCard;
import it.polimi.ingsw.ps09.model.Points.FaithPoints;
import it.polimi.ingsw.ps09.model.Points.MilitaryPoints;
import it.polimi.ingsw.ps09.model.Points.VictoryPoints;
import it.polimi.ingsw.ps09.model.Resources.*;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

import static java.util.logging.Level.INFO;

/**
 * Created by francesco995 on 10/05/2017.
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


    //####################################################
    //####################################################
    //################## Add Resources ###################

    /**
     * Add UserResources to Player
     * @param addResources a UserResources object containing multiple resource objects
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
        mPersonalBoard.add(addCoins);

        //LOG
        mLogger.log(INFO, "Game: " + Game.GAME_ID +
                " add " + addCoins.toString() +
                " Coins to player: " + mUserName +
                " now has: " + getCoins().toString() + " Coins");

    }

    /**
     * Add Servants to Player
     * @param addServant Servant (object) to add
     */
    public void add(Servant addServant){
        mPersonalBoard.add(addServant);

        //LOG
        mLogger.log(INFO, "Game: " + Game.GAME_ID +
                " add " + addServant.toString() +
                " Servant to player: " + mUserName +
                " now has: " + getServant().toString() + " Servant");

    }

    /**
     * Add Stone to Player
     * @param addStone Stone (object) to add
     */
    public void add(Stone addStone){
        mPersonalBoard.add(addStone);

        //LOG
        mLogger.log(INFO, "Game: " + Game.GAME_ID +
                " add " + addStone.toString() +
                " Stone to player: " + mUserName +
                " now has: " + getStone().toString() + " Stone");

    }

    /**
     * Add Wood to Player
     * @param addWood Wood (object) to add
     */
    public void add(Wood addWood){
        mPersonalBoard.add(addWood);

        //LOG
        mLogger.log(INFO, "Game: " + Game.GAME_ID +
                " add " + addWood.toString() +
                " Wood to player: " + mUserName +
                " now has: " + getWood().toString() + " Wood");

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
    //################ Remove Resources ##################

    /**
     * Remove UserResources from Player
     * @param removeResources a UserResources containing multiple resource objects
     */
    public void remove(UserResources removeResources){
        remove(removeResources.getCoins());
        remove(removeResources.getServant());
        remove(removeResources.getStone());
        remove(removeResources.getWood());
    }

    /**
     * Remove Coins from Player
     * @param removeCoins Coins (object) to remove
     */
    public void remove(Coins removeCoins){
        mPersonalBoard.remove(removeCoins);

        //LOG
        mLogger.log(INFO, "Game: " + Game.GAME_ID +
                " remove " + removeCoins.toString() +
                " Coins from player: " + mUserName +
                " now has: " + getCoins().toString() + " Coins");

    }

    /**
     * Remove Servants from Player
     * @param removeServant Servant (object) to remove
     */
    public void remove(Servant removeServant){
        mPersonalBoard.remove(removeServant);

        //LOG
        mLogger.log(INFO, "Game: " + Game.GAME_ID +
                " add " + removeServant.toString() +
                " Servant to player: " + mUserName +
                " now has: " + getServant().toString() + " Servant");

    }

    /**
     * Remove Stone from Player
     * @param removeStone Stone (object) to remove
     */
    public void remove(Stone removeStone){
        mPersonalBoard.remove(removeStone);

        //LOG
        mLogger.log(INFO, "Game: " + Game.GAME_ID +
                " remove " + removeStone.toString() +
                " Stone to player: " + mUserName +
                " now has: " + getStone().toString() + " Stone");

    }

    /**
     * Remove Wood from Player
     * @param removeWood Wood (object) to remove
     */
    public void remove(Wood removeWood){
        mPersonalBoard.remove(removeWood);

        //LOG
        mLogger.log(INFO, "Game: " + Game.GAME_ID +
                " remove " + removeWood.toString() +
                " Wood to player: " + mUserName +
                " now has: " + getWood().toString() + " Wood");

    }






    //####################################################
    //####################################################
    //################ Get User Points ###################

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
     * @param addFaithPoints FaithPoints (object) to add
     */
    public void add(FaithPoints addFaithPoints){
        mUserPoints.add(addFaithPoints);

        //LOG
        mLogger.log(INFO, "Game: " + Game.GAME_ID +
                " add " + addFaithPoints.toString() +
                " FaithPoints to player: " + mUserName +
                " now has: " + getFaithPoints().toString() + " FaithPoints");

    }

    /**
     * Add MilitaryPoints to Player
     * @param addMilitaryPoints MilitaryPoints (object) to add
     */
    public void add(MilitaryPoints addMilitaryPoints){
        mUserPoints.add(addMilitaryPoints);

        //LOG
        mLogger.log(INFO,"Game: " + Game.GAME_ID +
                " add " + addMilitaryPoints.toString() +
                " MilitaryPoints to player: " + mUserName +
                " now has: " + getMilitaryPoints().toString() + " MilitaryPoints");

    }

    /**
     * Add VictoryPoints to Player
     * @param addVictoryPoints VictoryPoints (object) to add
     */
    public void add(VictoryPoints addVictoryPoints){
        mUserPoints.add(addVictoryPoints);

        //LOG
        mLogger.log(INFO, "Game: " + Game.GAME_ID +
                " add " + addVictoryPoints.toString() +
                " VictoryPoints to player: " + mUserName +
                " now has: " + getVictoryPoints().toString() + " VictoryPoints");

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
        return getFaithPoints().isGreaterOrEqual(hasFaithPoints);
    }

    /**
     * Check if Player has a given Resource / Points
     * @param hasMilitaryPoints the Resource / Points to check if Player has
     * @return returns true if the Player has the given Resource / Points
     */
    public boolean has(MilitaryPoints hasMilitaryPoints){
        return getMilitaryPoints().isGreaterOrEqual(hasMilitaryPoints);
    }

    /**
     * Check if Player has a given Resource / Points
     * @param hasVictoryPoints the Resource / Points to check if Player has
     * @return returns true if the Player has the given Resource / Points
     */
    public boolean has(VictoryPoints hasVictoryPoints){
        return getVictoryPoints().isGreaterOrEqual(hasVictoryPoints);
    }


    //####################################################
    //####################################################
    //########## Remove Points from Player ###############

    /**
     * Remove Points from Player
     * @param removeUserPoints UserPoints (object) to remove
     */
    public void remove(UserPoints removeUserPoints){
        remove(removeUserPoints.getFaithPoints());
        remove(removeUserPoints.getMilitaryPoints());
        remove(removeUserPoints.getVictoryPoints());
    }

    /**
     * Remove FaithPoints from Player
     * @param removeFaithPoints FaithPoints (object) to remove
     */
    public void remove(FaithPoints removeFaithPoints){
        mUserPoints.remove(removeFaithPoints);

        //LOG
        mLogger.log(INFO, "Game: " + Game.GAME_ID +
                " remove " + removeFaithPoints.toString() +
                " FaithPoints from player: " + mUserName +
                " now has: " + getFaithPoints().toString() + " FaithPoints");

    }

    /**
     * Remove MilitaryPoints from Player
     * @param removeMilitaryPoints MilitaryPoints (object) to remove
     */
    public void remove(MilitaryPoints removeMilitaryPoints){
        mUserPoints.remove(removeMilitaryPoints);

        //LOG
        mLogger.log(INFO, "Game: " + Game.GAME_ID +
                " remove " + removeMilitaryPoints.toString() +
                " MilitaryPoints from player: " + mUserName +
                " now has: " + getMilitaryPoints().toString() + " MilitaryPoints");

    }

    /**
     * Remove VictoryPoints from Player
     * @param removeVictoryPoints VictoryPoints (object) to remove
     */
    public void remove(VictoryPoints removeVictoryPoints){
        mUserPoints.remove(removeVictoryPoints);

        //LOG
        mLogger.log(INFO, "Game: " + Game.GAME_ID +
                " remove " + removeVictoryPoints.toString() +
                " VictoryPoints from player: " + mUserName +
                " now has: " + getVictoryPoints().toString() + " VictoryPoints");

    }


    //####################################################
    //####################################################
    //######### Check if Player can Pick Card ############

//TODO: FraG Fix
 /*   public boolean canPickCard(DevelopmentCard card, BoardBonus bonus){
        return
                        has(new Coins(card.getResourcesCosts().getCoins().getValue()
                                - bonus.getResourcesBonus().getCoins().getValue()))
                &&
                        has(new Servant(card.getResourcesCosts().getServant().getValue()
                                - bonus.getResourcesBonus().getServant().getValue()))
                &&
                        has(new Stone(card.getResourcesCosts().getStone().getValue()
                                - bonus.getResourcesBonus().getStone().getValue()))
                &&
                        has(new Wood(card.getResourcesCosts().getWood().getValue()
                                - bonus.getResourcesBonus().getWood().getValue()))
                &&
                        has(new FaithPoints(card.getPointsCosts().getFaithPoints().getPoints()
                                - bonus.getPointsBonus().getFaithPoints().getPoints()))
                &&
                        has(new MilitaryPoints(card.getPointsCosts().getMilitaryPoints().getPoints()
                                - bonus.getPointsBonus().getMilitaryPoints().getPoints()))
                &&
                        has(new VictoryPoints(card.getPointsCosts().getVictoryPoints().getPoints()
                                - bonus.getPointsBonus().getVictoryPoints().getPoints()));
    }
*/

}
