package it.polimi.ingsw.ps09.model.LeaderCardEffects;

import it.polimi.ingsw.ps09.model.Player;
import it.polimi.ingsw.ps09.model.UserPoints;
import it.polimi.ingsw.ps09.model.UserResources;

/**
 * Created by walle on 19/06/17.
 */
public class UnlimitedTerritoryCards extends LeaderCardEffect {

    private UserResources mUserResourcesRequirements;
    private UserPoints mUserPointsRequirements;
    private int mBuildingCardsRequired;

    /**
     *
     * @param player Object representing the player
     * @return Boolean value, true if the player can apply the effect, otherwise false
     */
    public boolean isValid(Player player){

        //Cesare Borgia
        if((player.has(mUserResourcesRequirements))
                &&(player.has(mUserPointsRequirements))
                &&(player.getBuildingsCount()>=mBuildingCardsRequired))
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

        toString += "You don't have to satisfy military points requirements when taking a territory card.";

        return toString;

    }

}
