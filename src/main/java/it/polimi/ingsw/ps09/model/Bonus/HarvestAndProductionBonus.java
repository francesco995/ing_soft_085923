package it.polimi.ingsw.ps09.model.Bonus;

import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

/**
 * Created by francesco995 on 04/06/2017.
 * Whenever a Player performs a HarvestArea or a ProductionArea action (through a Family Member or
 * as an effect of another card), increase the value of the action by X.
 *
 * This Bonus is action-specific, so it can be different depending if the action
 * is ProductionArea or HarvestArea
 */
public class HarvestAndProductionBonus {

    private Map<String, Integer> mBonus = new HashMap<String, Integer>(){{
        put("HARVEST", 0);
        put("PRODUCTION", 0);
    }};


    /**
     * Get Bonus value for Harvest / Production
     * @param bonusType Harvest or Production as String
     * @return Bonus value
     */
    public int getBonus(String bonusType){
        return mBonus.get(bonusType.toUpperCase());
    }

    /**
     * Set Bonus value for Harvest / Production
     * @param bonusType Harvest or Production as String
     * @param bonusValue Bonus value
     */
    public void setBonus(String bonusType, int bonusValue){
        mBonus.put(bonusType.toUpperCase(), bonusValue);
    }

    /**
     * Add Bonus value for Harvest / Production
     * @param bonusType Harvest or Production as String
     * @param bonusValue Bonus value
     */
    public void addBonus(String bonusType, int bonusValue){
        mBonus.put(
                bonusType.toUpperCase(),
                bonusValue + mBonus.get(bonusType.toUpperCase()));
    }
    public void addMalus(String malusType, int malusValue){
        mBonus.put(
                malusType.toUpperCase(),
                - malusValue + mBonus.get(malusType.toUpperCase()));
    }
    //TODO: test


    //TODO: toString
}
