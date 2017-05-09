package it.polimi.ingsw.ps09.res.Points;

/**
 * Created by ale on 09/05/2017.
 */
public class FaithPoints {

    private int mFaithPoints;

    public void setFaithPoints(int faithPoints) {
        mFaithPoints = faithPoints;
    }

    public int getFaithPoints() {
        return mFaithPoints;
    }

    public void addFaithPoints(int faithPoints){
        mFaithPoints = mFaithPoints + faithPoints;
    }

    public void subFaithPoints(int faithPoints){
        if(mFaithPoints<= Math.abs(faithPoints))
            mFaithPoints = 0;
        else
            mFaithPoints = mFaithPoints - faithPoints;
    }
}
