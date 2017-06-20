package it.polimi.ingsw.ps09.model.LeaderCardEffects;

import it.polimi.ingsw.ps09.model.Player;
import it.polimi.ingsw.ps09.model.UserResources;

/**
 * Created by walle on 19/06/17.
 */
public class GetCouncilPrivilege {

    private UserResources mUserResourcesRequirements;

    public boolean isValid(Player player){

        //Ludovico III Gonzaga
        if(player.has(mUserResourcesRequirements))
            return true;

        return false;

    }

    @Override
    public String toString(){

        String toString = "";

        toString += "Receive 1 Council Privilege.";

        return toString;

    }

}
