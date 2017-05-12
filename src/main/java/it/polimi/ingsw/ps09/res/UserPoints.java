package it.polimi.ingsw.ps09.res;

import it.polimi.ingsw.ps09.res.Points.FaithPoints;
import it.polimi.ingsw.ps09.res.Points.MilitaryPoints;
import it.polimi.ingsw.ps09.res.Points.VictoryPoints;

/**
 * Created by francGianni on 10/05/2017.
 */
public class UserPoints {

    //VARIABLES
    FaithPoints mFaithPoints;
    MilitaryPoints mMilitaryPoints;
    VictoryPoints mVictoryPoints;

    //CONSTRUCTORS

    //Create empty UserPoints
    public UserPoints(){
        this(0, 0, 0);
    }

    //Create UserPoints from Points items
    public UserPoints(FaithPoints faithPoints, MilitaryPoints militaryPoints, VictoryPoints victoryPoints){
        mFaithPoints = faithPoints;
        mMilitaryPoints = militaryPoints;
        mVictoryPoints = victoryPoints;
    }

    //Create UserPoints from int Values
    public UserPoints(int initialFaithPoints, int initialMilitaryPoints, int initialVictoryPoints){
        this(new FaithPoints(initialFaithPoints), new MilitaryPoints(initialMilitaryPoints), new VictoryPoints(initialVictoryPoints));
    }


    //GETTERS

    public FaithPoints getFaithPoints() {
        return mFaithPoints;
    }

    public MilitaryPoints getMilitaryPoints() {
        return mMilitaryPoints;
    }

    public VictoryPoints getVictoryPoints() {
        return mVictoryPoints;
    }

    //SETTERS

    public void setFaithPoints(FaithPoints faithPoints) {
        mFaithPoints = faithPoints;
    }

    public void setMilitaryPoints(MilitaryPoints militaryPoints) {
        mMilitaryPoints = militaryPoints;
    }

    public void setVictoryPoints(VictoryPoints victoryPoints) {
        mVictoryPoints = victoryPoints;
    }

    //Add Points from points values

    public void addFaithPoints(FaithPoints faithPoints) {
        mFaithPoints.addPoints(faithPoints.getPoints());
    }

    public void addMilitaryPoints(MilitaryPoints militaryPoints) {
        mMilitaryPoints.addPoints(militaryPoints.getPoints());
    }

    public void addVictoryPoints(VictoryPoints victoryPoints) {
        mVictoryPoints.addPoints(victoryPoints.getPoints());
    }

    //Add points from int values

    public void addFaithPoints(int faithPoints) {
        mFaithPoints.addPoints(faithPoints);
    }

    public void addMilitaryPoints(int militaryPoints) {
        mMilitaryPoints.addPoints(militaryPoints);
    }

    public void addVictoryPoints(int victoryPoints) {
        mVictoryPoints.addPoints(victoryPoints);
    }


}
