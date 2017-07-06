package it.polimi.ingsw.ps09.model.ExcommunicationTileEffects;

import it.polimi.ingsw.ps09.model.Player;

public class GainHarverstAndProductionMalus implements ExcommunicationTileEffect {

    /**
     * HARVEST or PRODUCTION
     */
    private String mMalusType;

    /**
     * Bonus Value
     */
    private int mMalusValue;



    public void applyEffect( Player player ){
        player.getHarvestAndProductionBonus().addMalus(mMalusType,mMalusValue);
    }

    @Override
    public String toString(){

        String toString = "";

        toString += "Gain " + mMalusType.toLowerCase();

        toString += " malus => +" + mMalusValue;

        return toString;

    }
}
