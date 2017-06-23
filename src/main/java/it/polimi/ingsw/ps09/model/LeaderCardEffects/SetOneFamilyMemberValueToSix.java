package it.polimi.ingsw.ps09.model.LeaderCardEffects;

import it.polimi.ingsw.ps09.model.Player;
import it.polimi.ingsw.ps09.model.UserPoints;

/**
 * Created by walle on 19/06/17.
 */
public class SetOneFamilyMemberValueToSix extends LeaderCardEffect {

    private int mTerritoryCardsRequired;

    /**
     *
     * @param player Object representing the player
     * @return Boolean value, true if the player can apply the effect, otherwise false
     */
    public boolean isValid(Player player){

        //Federico da Montefeltro
        if(player.getTerritoriesCount() >= mTerritoryCardsRequired)
            return true;

        return false;

    }

    /**
     *
     * @return Effect's description
     */
    @Override
    public String toString(){

        String toString = "";

        toString += "One family memeber has value of 6 without considering dice value." +
                "You can increase its value with servants or character cards.";

        return toString;

    }
}
