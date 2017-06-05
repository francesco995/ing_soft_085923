package it.polimi.ingsw.ps09.model;

import it.polimi.ingsw.ps09.model.ExcommunicationTileEffect.ExcommunicationTileEffect;

import java.util.LinkedList;
import java.util.List;

public class  ExcommunicationTile {

    //Variables

    //Tile general info

    private String mTileName;
    private int mPeriod;

    //Effects

    private List<ExcommunicationTileEffect> mExcommunicationTileEffects;

    //Methods

    //CONSTRUCTOR

    public ExcommunicationTile(String tileName, int period, List<ExcommunicationTileEffect> excommunicationTileEffects) {

        mTileName = tileName;
        mPeriod = period;
        mExcommunicationTileEffects = excommunicationTileEffects;

    }


    //GETTER
    //NO SETTER BECAUSE ALL TILES ARE CREATED FROM EXTERNAL FILE


    public String getTileName() {
        return mTileName;
    }

    public int getPeriod() {
        return mPeriod;
    }

    public List<ExcommunicationTileEffect> getExcommunicationTileEffects() {

        return mExcommunicationTileEffects;

    }
}
