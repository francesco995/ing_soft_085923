package it.polimi.ingsw.ps09.res;

import java.util.LinkedList;

public class LeaderCard {
    //CARD INFO

    private String mCardName;

    //this Boolean says if the card effect is permanent (value set to true) or OncePerTurn (value set to false)

    private boolean mPermanent;
    private String mEffect;

    //CONSTRUCTOR


    public LeaderCard(String cardName, boolean permanent, String effects) {
        mCardName = cardName;
        mPermanent = permanent;
        mEffect = effects;
    }

    //GETTER

    public String getCardName() {
        return mCardName;
    }

    public boolean isPermanent() {
        return mPermanent;
    }

    public String getEffects() {
        return mEffect;
    }

    //SETTER

    public void setCardName(String cardName) {
        mCardName = cardName;
    }

    public void setPermanent(boolean permanent) {
        mPermanent = permanent;
    }

    public void setEffects(String effects) {
        mEffect = effects;
    }
}
