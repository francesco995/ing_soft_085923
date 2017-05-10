package it.polimi.ingsw.ps09.res;

import it.polimi.ingsw.ps09.res.Points.FaithPoints;
import it.polimi.ingsw.ps09.res.Points.MilitaryPoints;
import it.polimi.ingsw.ps09.res.Points.VictoryPoints;

/**
 * Created by franc on 10/05/2017.
 */
public class Player {

    //VARIABLES

    private String mUserName;
    private UserColors mUserColor;
    private PersonalBoard mPersonalBoard;
    private UserPoints mUserPoints;

    //CONSTRUCTOR

    public Player(String userName, UserColors userColor){
        new Player(userName, userColor, new PersonalBoard(), new UserPoints());
    }

    public Player(String userName, UserColors userColor, PersonalBoard personalBoard, UserPoints userPoints){
        mUserName = userName;
        mUserColor = userColor;
        mPersonalBoard = personalBoard;
        mUserPoints = userPoints;
    }

    //GETTERS

    //User Data

    public String getUserName() {
        return mUserName;
    }

    public UserColors getUserColor() {
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
    }

    public void setMilitaryPoints(MilitaryPoints militaryPoints){
        mUserPoints.setMilitaryPoints(militaryPoints);
    }

    public void setVictoryPoints(VictoryPoints victoryPoints){
        mUserPoints.setVictoryPoints(victoryPoints);
    }


    //Set User Points from int

    public void setFaithPoints(int faithPoints){
        mUserPoints.mFaithPoints.setPoints(faithPoints);
    }

    public void setMilitaryPoints(int militaryPoints){
        mUserPoints.mMilitaryPoints.setPoints(militaryPoints);
    }

    public void setVictoryPoints(int victoryPoints){
        mUserPoints.mVictoryPoints.setPoints(victoryPoints);
    }


    //Add User Points from Point objects

    public void addFaithPoints(FaithPoints faithPoints){
        mUserPoints.addFaithPoints(faithPoints);
    }

    public void addMilitaryPoints(MilitaryPoints militaryPoints){
        mUserPoints.addMilitaryPoints(militaryPoints);
    }

    public void addVictoryPoints(VictoryPoints victoryPoints){
        mUserPoints.addVictoryPoints(victoryPoints);
    }


    //Add User Points from int

    public void addFaithPoints(int faithPoints){
        mUserPoints.addFaithPoints(faithPoints);
    }

    public void addMilitaryPoints(int militaryPoints){
        mUserPoints.addMilitaryPoints(militaryPoints);
    }

    public void addVictoryPoints(int victoryPoints){
        mUserPoints.addVictoryPoints(victoryPoints);
    }


}
