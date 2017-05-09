package it.polimi.ingsw.ps09.res.Points;

/**
 * Created by ale on 09/05/2017.
 */
public class MilitaryPoints {

    private int mMilitaryPoints;

    public void setMilitaryPoints(int militaryPoints) {
        mMilitaryPoints = militaryPoints;
    }

    public int getMilitaryPoints() {
        return mMilitaryPoints;
    }

    public void addMilitaryPoints(int militaryPoints){
        mMilitaryPoints = militaryPoints + mMilitaryPoints;
    }

    public void subMilitaryPoints(int militaryPoints){
        if(mMilitaryPoints<= Math.abs(militaryPoints))
            mMilitaryPoints = 0;
        else
            mMilitaryPoints = mMilitaryPoints - militaryPoints;
    }
}


