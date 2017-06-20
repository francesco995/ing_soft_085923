package it.polimi.ingsw.ps09.model.Bonus;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by francesco995 on 04/06/2017.
 * Whenever a Player performs an action to take a DevelopmentCard (through
 * a Family Member or as an effect of another card), increase the value
 * of the action by X.
 * This bonus is card-specific and it depends on the type of card
 * (ex: you can have a bonus of "2" for Building cards but not for the other cards)
 *
 * Each Player is supposed to have one instance of this object
 * Placement actions and other bonus actions are supposed to do checks on this object
 * to verify that a specific player can do a specific action
 */
public class FamilyMemberPlacementBonus {

    /**
     * Map of Bonus value (Integer) to card Type (String)
     */
    private Map<String, Integer> mBonus = new HashMap<String, Integer>(){{
        put("BUILDING", 0);
        put("CHARACTER", 0);
        put("TERRITORY", 0);
        put("VENTURE", 0);
    }};

    /**
     * Get Family Member Placement Bonus for card type
     * @param cardType Card type
     * @return Placement Bonus value
     */
    public int getBonus(String cardType){
        return mBonus.get(cardType.toUpperCase());
    }

    /**
     * Set Family Member Placement Bonus for card type
     * @param cardType Card type
     * @param bonusValue New Bonus value
     */
    public void setBonus(String cardType, int bonusValue){
        mBonus.put(cardType.toUpperCase(), bonusValue);
    }

    /**
     * Add Family Member Placement Bonus for card type
     * @param cardType Card type
     * @param bonusValue Bonus value to add
     */
    public void addBonus(String cardType, int bonusValue){
        mBonus.put(
                cardType.toUpperCase(),
                bonusValue + mBonus.get(cardType.toUpperCase()));
    }

    public void addMalus(String cardType, int bonusValue){
        mBonus.put(
                cardType.toUpperCase(),
                - bonusValue + mBonus.get(cardType.toUpperCase()));
    }
    //TODO: test

    //TODO: toString


}
