package it.polimi.ingsw.ps09.res.Points;

/**
 * Created by ale on 09/05/2017.
 */
public class VictoryPoints {

    private int mVictoryPoints;

    public void setVictoryPoints(int VictoryPoints) {
        mVictoryPoints = VictoryPoints;
    }

    public int getVictoryPoints() {
        return mVictoryPoints;
    }

    public void addVictoryPoints(int VictoryPoints) {
        mVictoryPoints = mVictoryPoints + VictoryPoints;
    }

    public void subVictoryPoints(int VictoryPoints) {

        if(mVictoryPoints<= Math.abs(VictoryPoints))
            mVictoryPoints = 0;
        else
            mVictoryPoints = mVictoryPoints - VictoryPoints;
    }

}
