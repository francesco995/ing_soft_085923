package it.polimi.ingsw.ps09.model.LeaderCardEffects;

import it.polimi.ingsw.ps09.model.Player;
import it.polimi.ingsw.ps09.model.UserPoints;

/**
 * Created by walle on 19/06/17.
 */
public class CopyLeaderEffect {

    private UserPoints mUserPointsRequirements;

    public boolean isValid(Player player){

        //Lorenzo de' Medici
        if(player.has(mUserPointsRequirements))
            return true;

        return false;

    }

    @Override
    public String toString(){

        String toString = "";

        toString += "Copy a leader's ability. Once chosen, you can't undo it.";

        return toString;

    }
}
