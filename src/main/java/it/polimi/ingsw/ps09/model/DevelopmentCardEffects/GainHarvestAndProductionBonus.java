package it.polimi.ingsw.ps09.model.DevelopmentCardEffects;

import it.polimi.ingsw.ps09.model.Player;

/**
 * Created by francesco995 on 04/06/2017.
 */
public class GainHarvestAndProductionBonus extends DevelopmentCardEffect {

    /**
     * HARVEST or PRODUCTION
     */
    private String mBonusType;

    /**
     * Bonus Value
     */
    private int mBonusValue;



    public void applyEffect( Player player ){
        //TODO: implement
    }

    @Override
    public String toString(){

        String toString = "";

        toString += "Gain " + mBonusType.toLowerCase();

        toString += " bonus => +" + mBonusValue;

        return toString;

    }


}
