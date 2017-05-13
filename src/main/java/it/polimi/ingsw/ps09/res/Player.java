package it.polimi.ingsw.ps09.res;

import it.polimi.ingsw.ps09.res.Points.FaithPoints;
import it.polimi.ingsw.ps09.res.Points.MilitaryPoints;
import it.polimi.ingsw.ps09.res.Points.VictoryPoints;
import it.polimi.ingsw.ps09.res.Resources.Coins;
import it.polimi.ingsw.ps09.res.Resources.Servant;
import it.polimi.ingsw.ps09.res.Resources.Stone;
import it.polimi.ingsw.ps09.res.Resources.Wood;

import java.util.logging.Logger;

import static java.util.logging.Level.INFO;

/**
 * Created by francGianni on 10/05/2017.
 */
public class Player {

    public static int mUserId;

    //VARIABLES

    private String mUserName;
    private String mUserColor;

    //GAME OBJECTS
    private PersonalBoard mPersonalBoard;
    private UserPoints mUserPoints;



    //LOGGER
    private static final Logger mLogger = Logger.getLogger( Player.class.getName() );


    //CONSTRUCTOR

    public Player(String userName, String userColor, int userId, int initialCoins){
        this(userName, userColor, new PersonalBoard(initialCoins),
                new UserPoints(), userId);
    }

    public Player(String userName, String userColor, PersonalBoard personalBoard,
                  UserPoints userPoints, int userId){
        mUserName = userName;
        mUserColor = userColor;
        mPersonalBoard = personalBoard;
        mUserPoints = userPoints;
        mUserId = userId;

        //log created player
        mLogger.log(INFO, "Created player -> " + mUserName +
                                " with Id: " + mUserId +
                                " with color -> " + mUserColor +
                                " with " + mPersonalBoard.getCoins().getValue() + " initial Coins");
    }

    //GETTERS

    //User Data


    public String getUserName() {
        return mUserName;
    }

    public String getUserColor() {
        return mUserColor;
    }

    public PersonalBoard getPersonalBoard() {
        return mPersonalBoard;
    }

    public UserPoints getUserPoints() {
        return mUserPoints;
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


    //User points as int

    public int getIntFaithPoints() {
        return mUserPoints.getFaithPoints().getPoints();
    }

    public int getIntMilitaryPoints() {
        return mUserPoints.getMilitaryPoints().getPoints();
    }

    public int getIntVictoryPoints() {
        return mUserPoints.getVictoryPoints().getPoints();
    }


    //SETTERS

    //Set User Points from Point objects

    public void setFaithPoints(FaithPoints faithPoints){
        mUserPoints.setFaithPoints(faithPoints);

        //LOG
        mLogger.log(INFO, "Faith Points for user -> " + mUserName +
                " set to -> " + mUserPoints.mFaithPoints.toString());
    }

    public void setMilitaryPoints(MilitaryPoints militaryPoints){
        mUserPoints.setMilitaryPoints(militaryPoints);

        //LOG
        mLogger.log(INFO, "Military Points for user -> " + mUserName +
                " set to -> " + mUserPoints.mMilitaryPoints.toString());
    }

    public void setVictoryPoints(VictoryPoints victoryPoints){
        mUserPoints.setVictoryPoints(victoryPoints);

        //LOG
        mLogger.log(INFO, "Victory Points for user -> " + mUserName +
                " set to -> " + mUserPoints.mVictoryPoints.toString());
    }


    //Set User Points from int

    public void setFaithPoints(int faithPoints){
        mUserPoints.mFaithPoints.setPoints(faithPoints);

        //LOG
        mLogger.log(INFO, "Faith Points for user -> " + mUserName +
                " set to -> " + mUserPoints.mFaithPoints.toString());
    }

    public void setMilitaryPoints(int militaryPoints){
        mUserPoints.mMilitaryPoints.setPoints(militaryPoints);

        //LOG
        mLogger.log(INFO, "Military Points for user -> " + mUserName +
                " set to -> " + mUserPoints.mMilitaryPoints.toString());
    }

    public void setVictoryPoints(int victoryPoints){
        mUserPoints.mVictoryPoints.setPoints(victoryPoints);

        //LOG
        mLogger.log(INFO, "Victory Points for user -> " + mUserName +
                " set to -> " + mUserPoints.mVictoryPoints.toString());
    }


    //Add User Points from Point objects

    public void addFaithPoints(FaithPoints faithPoints){
        mUserPoints.addFaithPoints(faithPoints);

        //LOG
        mLogger.log(INFO, "Add " + faithPoints.toString() + " Faith Points for user -> " + mUserName +
                " set to -> " + mUserPoints.mFaithPoints.toString());
    }

    public void addMilitaryPoints(MilitaryPoints militaryPoints){
        mUserPoints.addMilitaryPoints(militaryPoints);

        //LOG
        mLogger.log(INFO, "Add " + militaryPoints.toString() + " Military Points for user -> " + mUserName +
                " set to -> " + mUserPoints.mMilitaryPoints.toString());
    }

    public void addVictoryPoints(VictoryPoints victoryPoints){
        mUserPoints.addVictoryPoints(victoryPoints);

        //LOG
        mLogger.log(INFO, "Add " + victoryPoints.toString() + " Victory Points for user -> " + mUserName +
                " set to -> " + mUserPoints.mVictoryPoints.toString());
    }


    //Add User Points from int

    public void addFaithPoints(int faithPoints){
        mUserPoints.addFaithPoints(faithPoints);

        //LOG
        mLogger.log(INFO, "Add " + String.valueOf(faithPoints) + " Faith Points for user -> " + mUserName +
                " set to -> " + this.getIntFaithPoints());
    }

    public void addMilitaryPoints(int militaryPoints){
        mUserPoints.addMilitaryPoints(militaryPoints);

        //LOG
        mLogger.log(INFO, "Add " + String.valueOf(militaryPoints) + " Military Points for user -> " + mUserName +
                " set to -> " + mUserPoints.mMilitaryPoints.toString());
    }

    public void addVictoryPoints(int victoryPoints){
        mUserPoints.addVictoryPoints(victoryPoints);

        //LOG
        mLogger.log(INFO, "Add " + String.valueOf(victoryPoints) + " Victory Points for user -> " + mUserName +
                " set to -> " + mUserPoints.mVictoryPoints.toString());
    }


    //USER RESOURCES

    //GET User Resources

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

    //Get User Resources as int
    public int getIntCoins() {
        return mPersonalBoard.getCoins().getValue();
    }

    public int getIntServant() {
        return mPersonalBoard.getServant().getValue();
    }

    public int getIntStone() {
        return mPersonalBoard.getStone().getValue();
    }

    public int getIntWood() {
        return mPersonalBoard.getWood().getValue();
    }


    //ADD User Resources

    public void addCoins(Coins addCoins){
        mPersonalBoard.addCoins(addCoins);

        //LOG
        mLogger.log(INFO, "Add " + addCoins.toString() + " Coins for user -> " + mUserName +
                " set to -> " + mPersonalBoard.getCoins().toString());
    }

    public void addServant(Servant addServant){
        mPersonalBoard.addServant(addServant);

        //LOG
        mLogger.log(INFO, "Add " + addServant.toString() + " Servant for user -> " + mUserName +
                " set to -> " + mPersonalBoard.getServant().toString());
    }

    public void addStone(Stone addStone){
        mPersonalBoard.addStone(addStone);

        //LOG
        mLogger.log(INFO, "Add " + addStone.toString() + " Stone for user -> " + mUserName +
                " set to -> " + mPersonalBoard.getStone().toString());
    }

    public void addWood(Wood addWood){
        mPersonalBoard.addWood(addWood);

        //LOG
        mLogger.log(INFO, "Add " + addWood.toString() + " Wood for user -> " + mUserName +
                " set to -> " + mPersonalBoard.getWood().toString());
    }

    //ADD User Resources as int

    public void addCoins(int addCoins){
        this.addCoins(new Coins(addCoins));
    }

    public void addServant(int addServant){
        this.addServant(new Servant(addServant));
    }

    public void addStone(int addStone){
        this.addStone(new Stone(addStone));
    }

    public void addWood(int addWood){
        this.addWood(new Wood(addWood));
    }


}
