package it.polimi.ingsw.ps09.model;

import java.util.LinkedList;

public class  ExcommunicationTile {

    //CARD INFO

    private String mTileName;
    private int mPeriod;
    private String mEffect;



    //CONSTRUCTOR

    public ExcommunicationTile(String tileName, int period, String effect) {
        mTileName = tileName;
        mPeriod = period;
        mEffect = effect;
    }

    //GETTER
    //NO SETTER BECAUSE ALL TILES ARE CREATED FROM EXTERNAL FILE

    public String getEffect() {
        return mEffect;
    }

    public String getTileName() {
        return mTileName;
    }

    public int getPeriod() {
        return mPeriod;
    }
    
}
