package it.polimi.ingsw.ps09.model;

import it.polimi.ingsw.ps09.model.ExcommunicationTileEffects.ExcommunicationTileEffect;

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

    //TO STRING
    @Override
    public String toString(){
        String mTile = "\n";
        mTile += "mPeriod: " +mPeriod + "\neffect: ";
        for(int i= 0; i<mExcommunicationTileEffects.size(); i++)
        {
            mTile += mExcommunicationTileEffects.get(i).toString();
            mTile += "\n";
        }

        return mTile;
    }
}
