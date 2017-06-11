package it.polimi.ingsw.ps09.model.DevelopmentCardEffects;

import it.polimi.ingsw.ps09.model.Player;
import it.polimi.ingsw.ps09.model.UserResources;

/**
 * Created by francesco995 on 05/06/2017.
 * Gain permanent resources discount for when taking cards of a specific color
 */
public class GainFamilyMemberPlacementResourcesDiscount implements DevelopmentCardEffect {


    private UserResources mResourcesDiscount;
    private String mCardType;



    public GainFamilyMemberPlacementResourcesDiscount(UserResources resourcesDiscount, String cardType) {
        mResourcesDiscount = resourcesDiscount;
        mCardType = cardType;
    }



    @Override
    public void applyEffect(Player player) {
        player.addFamilyMemberPlacementResourcesDiscount(mCardType, mResourcesDiscount);
    }


    @Override
    public String toString(){

        String toString = "";

        toString += "Gain discount for picking " + mCardType.toLowerCase();

        toString += " cards: you pay less => " + mResourcesDiscount;

        return toString;

    }
}
