package it.polimi.ingsw.ps09.res;

import java.util.LinkedList;

public class LeaderCard {
    //CARD INFO

    private String mTileName;
    private int mPeriod;

    //this Boolean says if the card effect is permanent (value set to true) or OncePerTurn (value set to false)

    private boolean mPermanent;

    //EFFECT

    private LinkedList<String> mEffects = new LinkedList<>();

    //CONSTRUCTOR


    public LeaderCard(String tileName, int period, boolean permanent, LinkedList<String> effects) {
        mTileName = tileName;
        mPeriod = period;
        mPermanent = permanent;
        mEffects = effects;
    }

    //GETTER

    public String getTileName() {
        return mTileName;
    }

    public int getPeriod() {
        return mPeriod;
    }

    public boolean isPermanent() {
        return mPermanent;
    }

    public LinkedList<String> getEffects() {
        return mEffects;
    }

    //SETTER

    public void setTileName(String tileName) {
        mTileName = tileName;
    }

    public void setPeriod(int period) {
        mPeriod = period;
    }

    public void setPermanent(boolean permanent) {
        mPermanent = permanent;
    }

    public void setEffects(LinkedList<String> effects) {
        mEffects = effects;
    }
}
