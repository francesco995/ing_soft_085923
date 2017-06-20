package it.polimi.ingsw.ps09.model.LeaderCardEffects;

import it.polimi.ingsw.ps09.model.Player;

/**
 * Created by walle on 19/06/17.
 */
public class OccupyTowerForFree {

    private int mBuildingCardsRequired;

    public boolean isValid(Player player){

        //Filippo Brunelleschi
        if(player.getBuildingsCount() >= mBuildingCardsRequired)
            return true;

        return false;

    }

    @Override
    public String toString(){

        String toString = "";

        toString += "You don't have to spend 3 coins to enter into occupied tower.";

        return toString;

    }

}
