package it.polimi.ingsw.ps09.model.DevelopmentCardEffects;

import it.polimi.ingsw.ps09.model.Player;
import it.polimi.ingsw.ps09.model.UserResources;

/**
 * Created by francesco995 on 05/06/2017.
 */
public class GainFamilyMemberPlacementResourcesDiscount extends DevelopmentCardEffect {


    private UserResources mResourcesDiscount;
    private String mCardType;



    public GainFamilyMemberPlacementResourcesDiscount(UserResources resourcesDiscount, String cardType) {
        mResourcesDiscount = resourcesDiscount;
        mCardType = cardType;
    }



    @Override
    public void applyEffect(Player player) {
        //TODO: implement
    }

    //TODO: toString
}
