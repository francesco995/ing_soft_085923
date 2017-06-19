package it.polimi.ingsw.ps09.model.LeaderCardEffects;

import it.polimi.ingsw.ps09.model.Player;
import it.polimi.ingsw.ps09.model.UserPoints;
import it.polimi.ingsw.ps09.model.UserResources;

/**
 * Created by walle on 19/06/17.
 */
public class EarnFiveVictoryPointsFromChurch {

    private UserResources mUserResourcesRequirements;

    public boolean isValid(Player player){

        //Sisto IV
        if(player.has(mUserResourcesRequirements))
            return true;

        return false;

    }
}
