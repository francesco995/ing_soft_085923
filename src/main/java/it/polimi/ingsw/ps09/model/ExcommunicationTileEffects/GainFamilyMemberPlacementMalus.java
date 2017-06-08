package it.polimi.ingsw.ps09.model.ExcommunicationTileEffects;

import it.polimi.ingsw.ps09.model.Player;

public class GainFamilyMemberPlacementMalus extends  ExcommunicationTileEffect{
    private String mCardType;
    private int mMalusValue;


    public void applyEffect(Player player) {
        //TODO: implement
    }

    //TODO: toString
    @Override
    public String toString(){

        String toString = "";

        toString += "Gain malus when placing " + mCardType.toLowerCase();

        toString += " cards: your family member has => -" + mMalusValue;

        toString += " power";

        return toString;

    }
}
