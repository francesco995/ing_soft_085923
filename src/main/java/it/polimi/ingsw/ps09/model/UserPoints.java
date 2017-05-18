package it.polimi.ingsw.ps09.model;

import it.polimi.ingsw.ps09.model.Points.FaithPoints;
import it.polimi.ingsw.ps09.model.Points.MilitaryPoints;
import it.polimi.ingsw.ps09.model.Points.VictoryPoints;

/**
 * Created by francesco995 on 10/05/2017.
 */
public class UserPoints {

    //VARIABLES
    private FaithPoints mFaithPoints;
    private MilitaryPoints mMilitaryPoints;
    private VictoryPoints mVictoryPoints;

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
        this(   new FaithPoints(initialFaithPoints),
                new MilitaryPoints(initialMilitaryPoints),
                new VictoryPoints(initialVictoryPoints));
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

    //Add Points from points values

    public void add(FaithPoints faithPoints) {
        mFaithPoints.add(faithPoints);
    }

    public void add(MilitaryPoints militaryPoints) {
        mMilitaryPoints.add(militaryPoints);
    }

    public void add(VictoryPoints victoryPoints) {
        mVictoryPoints.add(victoryPoints);
    }

    public void add(UserPoints userPoints){
        add(userPoints.getFaithPoints());
        add(userPoints.getMilitaryPoints());
        add(userPoints.getVictoryPoints());
    }

    public FaithPoints clearFaithPoints(){
        FaithPoints oldFaithPoints = mFaithPoints;
        mFaithPoints = new FaithPoints(0);
        return oldFaithPoints;
    }


}
