package it.polimi.ingsw.ps09.model.LeaderCardEffects;

import it.polimi.ingsw.ps09.model.Player;
import it.polimi.ingsw.ps09.model.UserPoints;
import it.polimi.ingsw.ps09.model.UserResources;

/**
 * Created by walle on 19/06/17.
 */
public class EarnFiveVictoryPointsFromChurch extends LeaderCardEffect {

    private UserResources mUserResourcesRequirements;

    /**
     *
     * @param player Object representing the player
     * @return Boolean value, true if the player can apply the effect, otherwise false
     */
    public boolean isValid(Player player){

        //Sisto IV
        if(player.has(mUserResourcesRequirements))
            return true;

        return false;

    }

    @Override
    public String toString(){

        String toString = "";

        toString += "Gain 5 victory points each time you show support for the church during Vatican Report round.";

        return toString;

    }
}
