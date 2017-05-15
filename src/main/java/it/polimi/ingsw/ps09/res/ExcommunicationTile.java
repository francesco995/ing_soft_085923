package it.polimi.ingsw.ps09.res;

import java.util.LinkedList;

public class ExcommunicationTile {

    //CARD INFO

    private String mTileName;
    private int mPeriod;

    //Effects

    private LinkedList<String> mEffects = new LinkedList<>();

    //Constructor

    public ExcommunicationTile(String tileName, int period, LinkedList<String> effects) {
        mTileName = tileName;
        mPeriod = period;
        mEffects = effects;
    }

    //Getter

    public LinkedList<String> getEffects() {
        return mEffects;
    }

    //Setter

    public void setEffects(LinkedList<String> effects) {
        mEffects = effects;
    }


}
