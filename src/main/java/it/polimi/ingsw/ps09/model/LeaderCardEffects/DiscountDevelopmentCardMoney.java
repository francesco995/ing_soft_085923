package it.polimi.ingsw.ps09.model.LeaderCardEffects;

import it.polimi.ingsw.ps09.model.Player;

/**
 * Created by walle on 19/06/17.
 */
public class DiscountDevelopmentCardMoney {

    private int mVentureCardsRequired;
    private int mTerritoryCardsRequired;

    public boolean isValid(Player player){

        //Pico della Mirandola
        if((player.getVenturesCount()>=mVentureCardsRequired)
            &&(player.getTerritoriesCount()>=mTerritoryCardsRequired))
            return true;

        return false;

    }

    @Override
    public String toString(){

        String toString = "";

        toString += "Have a discount of 3 coins when purchasing a development card (if required)." +
                "This discount is not applied to enter in the tower.";

        return toString;

    }
}
