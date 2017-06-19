package it.polimi.ingsw.ps09.model.LeaderCardEffects;

import it.polimi.ingsw.ps09.model.Player;
import it.polimi.ingsw.ps09.model.UserPoints;
import it.polimi.ingsw.ps09.model.UserResources;

/**
 * Created by francesco995 on 19/06/2017.
 */
public class GainPointsAndResources extends LeaderCardEffect {

    private UserResources mUserResourcesRequirements;
    private UserPoints mUserPointsRequirements;

    private UserResources mUserResourcesGains;
    private UserPoints mUserPointsGains;



    public boolean isValid(Player player){

        if(player.has(mUserPointsRequirements) && player.has(mUserResourcesRequirements))
            return true;

        return false;

    }


}
