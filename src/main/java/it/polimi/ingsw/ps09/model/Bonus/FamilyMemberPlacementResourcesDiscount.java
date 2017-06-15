package it.polimi.ingsw.ps09.model.Bonus;

import it.polimi.ingsw.ps09.model.Resources.Resource;
import it.polimi.ingsw.ps09.model.UserResources;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by francesco995 on 04/06/2017.
 * Whenever a Player performs an action to take a DevelopmentCard card (through
 * a Family Member or as an effect of another card), the cost of
 * the card you take is reduced by 1 coin.
 * This bonus is card-specific and it depends on the type of card
 * (ex: you can have a bonus of "-2 Gold" for Building cards but not for the other cards)
 *
 * Each Player is supposed to have one instance of this object
 * Placement actions and other bonus actions are supposed to do checks on this object
 * to verify that a specific player can do a specific action
 */
public class FamilyMemberPlacementResourcesDiscount {

    /**
     * Map of Discount Bonus value (UserResources) to card Type (String)
     */
    private Map<String, UserResources> mBonus = new HashMap<String, UserResources>(){{
        put("BUILDING", new UserResources());
        put("CHARACTER", new UserResources());
        put("TERRITORY", new UserResources());
        put("VENTURE", new UserResources());
    }};


    /**
     * Get Discount value from card type
     * @param cardType Card type
     * @return Bonus Value as UserResources
     */
    public UserResources getBonus(String cardType){
        return mBonus.get(cardType.toUpperCase());
    }


    /**
     * Add Discount Bonus value as UserResources
     * @param cardType Card Type
     * @param addBonus Bonus value as UserResources
     */
    public void addBonus(String cardType, UserResources addBonus){

        UserResources tempBonus = mBonus.get(cardType.toUpperCase());
        tempBonus.add(addBonus);

        mBonus.put(
                cardType.toUpperCase(), tempBonus );
    }

    //TODO: test

    //TODO: toString




}
