package it.polimi.ingsw.ps09.model;

import it.polimi.ingsw.ps09.controller.Game;
import it.polimi.ingsw.ps09.model.Points.FaithPoints;
import it.polimi.ingsw.ps09.model.Points.MilitaryPoints;
import it.polimi.ingsw.ps09.model.Points.VictoryPoints;
import it.polimi.ingsw.ps09.model.Resources.Coins;
import it.polimi.ingsw.ps09.model.Resources.Servant;
import it.polimi.ingsw.ps09.model.Resources.Stone;
import it.polimi.ingsw.ps09.model.Resources.Wood;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

import static java.util.logging.Level.INFO;

/**
 * Created by francGianni on 10/05/2017.
 */
public class Player {

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

    private PersonalBoard getPersonalBoard() {
        return mPersonalBoard;
    }

    private UserPoints getUserPoints() {
        return mUserPoints;
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


    //Add a Leader Card

    public void add(LeaderCard leaderCard){
        mLeaderCards.add(leaderCard);

        //LOG
        mLogger.log(INFO, "Game: " + Game.GAME_ID +
                " add Leader Card " + leaderCard.getCardName() +
                " to player: " + mUserName +
                " now has: " + mLeaderCards.size() + " Leader Cards");

    }

    //Add User Points from Point objects

    public FaithPoints clearFaithPoints(){
        return mUserPoints.clearFaithPoints();
    }

    public void add(FaithPoints faithPoints){
        mUserPoints.add(faithPoints);

        //LOG
        mLogger.log(INFO, "Game: " + Game.GAME_ID +
                                " add " + faithPoints.toString() +
                                " FaithPoints to player: " + mUserName +
                                " now has: " + mUserPoints.getFaithPoints().toString() + " FaithPoints");

    }

    public void add(MilitaryPoints militaryPoints){
        mUserPoints.add(militaryPoints);

        //LOG
      mLogger.log(INFO,"Game: " + Game.GAME_ID +
                            " add " + militaryPoints.toString() +
                            " MilitaryPoints to player: " + mUserName +
                            " now has: " + mUserPoints.getFaithPoints().toString() + " MilitaryPoints");

    }

    public void add(VictoryPoints victoryPoints){
        mUserPoints.add(victoryPoints);

        //LOG
        mLogger.log(INFO, "Game: " + Game.GAME_ID +
                                " add " + victoryPoints.toString() +
                                " VictoryPoints to player: " + mUserName +
                                " now has: " + this.getFaithPoints().toString() + " VictoryPoints");

    }

    //Get User Resources as Resource object
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

    /**
     *
     * @param addCoins
     */
    public void add(Coins addCoins){
        mPersonalBoard.addCoins(addCoins);

        //LOG
        mLogger.log(INFO, "Game: " + Game.GAME_ID +
                " add " + addCoins.toString() +
                " Coins to player: " + mUserName +
                " now has: " + this.getCoins().toString() + " Coins");

    }

    public void add(Servant addServant){
        mPersonalBoard.addServant(addServant);

        //LOG
        mLogger.log(INFO, "Game: " + Game.GAME_ID +
                " add " + addServant.toString() +
                " Servant to player: " + mUserName +
                " now has: " + this.getServant().toString() + " Servant");

    }

    public void add(Stone addStone){
        mPersonalBoard.addStone(addStone);

        //LOG
        mLogger.log(INFO, "Game: " + Game.GAME_ID +
                " add " + addStone.toString() +
                " Stone to player: " + mUserName +
                " now has: " + this.getStone().toString() + " Stone");

    }

    public void add(Wood addWood){
        mPersonalBoard.addWood(addWood);

        //LOG
        mLogger.log(INFO, "Game: " + Game.GAME_ID +
                " add " + addWood.toString() +
                " Wood to player: " + mUserName +
                " now has: " + this.getWood().toString() + " Wood");

    }

}
