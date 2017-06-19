package it.polimi.ingsw.ps09.model.LeaderCardEffects;

import it.polimi.ingsw.ps09.model.Player;
import it.polimi.ingsw.ps09.model.UserPoints;
import it.polimi.ingsw.ps09.model.UserResources;

/**
 * Created by walle on 19/06/17.
 */
public class UnlimitedTerritoryCards {

    private UserResources mUserResourcesRequirements;
    private UserPoints mUserPointsRequirements;
    private int mBuldingCardsRequired;

    public boolean isValid(Player player){

        //Cesare Borgia
        if((player.has(mUserResourcesRequirements))
                &&(player.has(mUserPointsRequirements))
                &&(player.getBuildingsCount()>=mBuldingCardsRequired))
            return true;

        return false;

    }

}
