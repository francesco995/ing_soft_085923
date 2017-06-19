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
}
