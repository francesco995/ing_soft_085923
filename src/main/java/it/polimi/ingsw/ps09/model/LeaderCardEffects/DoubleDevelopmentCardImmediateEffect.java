package it.polimi.ingsw.ps09.model.LeaderCardEffects;

import it.polimi.ingsw.ps09.model.Player;
import it.polimi.ingsw.ps09.model.UserPoints;

/**
 * Created by walle on 19/06/17.
 */
public class DoubleDevelopmentCardImmediateEffect {

    private UserPoints mUserPointsRequirements;

    public boolean isValid(Player player){

        //Santa Rita
        if(player.has(mUserPointsRequirements))
            return true;

        return false;

    }

    @Override
    public String toString(){

        String toString = "";

        toString += "Every time you receive a wood, stone, coin or servant as development card immediate effect," +
                " double the amount.";

        return toString;

    }
}
