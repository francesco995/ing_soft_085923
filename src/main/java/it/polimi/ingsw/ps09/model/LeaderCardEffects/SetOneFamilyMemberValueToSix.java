package it.polimi.ingsw.ps09.model.LeaderCardEffects;

import it.polimi.ingsw.ps09.model.Player;
import it.polimi.ingsw.ps09.model.UserPoints;

/**
 * Created by walle on 19/06/17.
 */
public class SetOneFamilyMemberValueToSix {

    private UserPoints mUserPointsRequirements;

    public boolean isValid(Player player){

        //Federico da Montefeltro
        if(player.has(mUserPointsRequirements))
            return true;

        return false;

    }
}
