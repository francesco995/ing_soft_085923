package it.polimi.ingsw.ps09.model.Bonus;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by francesco995 on 04/06/2017.
 */
public class HarvestAndProductionBonus {

    private Map<String, Integer> mBonus = new HashMap<String, Integer>(){{
        put("HARVEST", 0);
        put("PRODUCTION", 0);
    }};


    public int getBonus(String bonusType){
        return mBonus.get(bonusType.toUpperCase());
    }

    public void setBonus(String bonusType, int bonusValue){
        mBonus.put(bonusType.toUpperCase(), bonusValue);
    }

    public void addBonus(String bonusType, int bonusValue){
        mBonus.put(
                bonusType.toUpperCase(),
                bonusValue + mBonus.get(bonusType.toUpperCase()));
    }

    //TODO: test


    //TODO: toString
}
