package it.polimi.ingsw.ps09.model;

import it.polimi.ingsw.ps09.model.Points.FaithPoints;
import it.polimi.ingsw.ps09.model.Points.MilitaryPoints;
import it.polimi.ingsw.ps09.model.Points.Points;
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

    //####################################################
    //####################################################
    //#################### Add Points ####################

    public void add(FaithPoints addFaithPoints){
        mFaithPoints.add(addFaithPoints);
    }

    public void add(MilitaryPoints addMilitaryPoints){
        mMilitaryPoints.add(addMilitaryPoints);
    }

    public void add(VictoryPoints addVictoryPoints){
        mVictoryPoints.add(addVictoryPoints);
    }

    public void add(UserPoints addUserPoints){
        add(addUserPoints.getFaithPoints());
        add(addUserPoints.getMilitaryPoints());
        add(addUserPoints.getVictoryPoints());
    }

    //####################################################
    //####################################################
    //################## Remove Points ###################

    public void remove(FaithPoints removeFaithPoints){
        mFaithPoints.remove(removeFaithPoints);
    }

    public void remove(MilitaryPoints removeMilitaryPoints){
        mMilitaryPoints.remove(removeMilitaryPoints);
    }

    public void remove(VictoryPoints removeVictoryPoints){
        mVictoryPoints.remove(removeVictoryPoints);
    }

    public void remove(UserPoints removeUserPoints){
        remove(removeUserPoints.getFaithPoints());
        remove(removeUserPoints.getMilitaryPoints());
        remove(removeUserPoints.getVictoryPoints());
    }


    //####################################################
    //####################################################
    //################# Clear FaithPoints ################

    public FaithPoints clearFaithPoints(){
        FaithPoints oldFaithPoints = mFaithPoints;
        mFaithPoints = new FaithPoints(0);
        return oldFaithPoints;
    }




}
