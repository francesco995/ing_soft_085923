package it.polimi.ingsw.ps09.model.LeaderCardEffects;

import it.polimi.ingsw.ps09.model.Player;

/**
 * Created by walle on 19/06/17.
 */
public class DoProductionAction {

    private int mBuldingCardsRequired;
    private int mTerritoryCardsRequired;

    public boolean isValid(Player player){

        //Leonardo Da Vinci
        if((player.getBuildingsCount()>=mBuldingCardsRequired)
                &&(player.getTerritoriesCount()>=mTerritoryCardsRequired))
            return true;

        return false;

    }

    @Override
    public String toString(){

        String toString = "";

        toString += "Do a production action of value 0. You can increase it with servants or by character card effect.";

        return toString;

    }

}
