package it.polimi.ingsw.ps09.model.Bonus;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by francesco995 on 04/06/2017.
 */
public class FamilyMemberPlacementBonus {

    private Map<String, Integer> mBonus = new HashMap<String, Integer>(){{
        put("BUILDING", 0);
        put("CHARACTER", 0);
        put("TERRITORY", 0);
        put("VENTURE", 0);
    }};


    public int getBonus(String cardType){
        return mBonus.get(cardType.toUpperCase());
    }

    public void setBonus(String cardType, int bonusValue){
        mBonus.put(cardType.toUpperCase(), bonusValue);
    }

    public void addBonus(String cardType, int bonusValue){
        mBonus.put(
                cardType.toUpperCase(),
                bonusValue + mBonus.get(cardType.toUpperCase()));
    }

    //TODO: test

    //TODO: toString


}
