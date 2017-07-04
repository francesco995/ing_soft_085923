package it.polimi.ingsw.ps09.model.LeaderCardEffects;

import it.polimi.ingsw.ps09.model.Board;
import it.polimi.ingsw.ps09.model.FamilyMembers.FamilyMember;
import it.polimi.ingsw.ps09.model.Player;

/**
 * Created by walle on 19/06/17.
 */
public class OccupyTowerForFree implements LeaderCardEffect {

    private int mBuildingCardsRequired;

    /**
     *
     * @param player Object representing the player
     * @return Boolean value, true if the player can apply the effect, otherwise false
     */
    public boolean isValid(Player player){

        //Filippo Brunelleschi
        if(player.getBuildingsCount() >= mBuildingCardsRequired)
            return true;

        return false;

    }

    /**
     *
     * @return Effect's description
     */
    @Override
    public String toString(){

        String toString = "";

        toString += "You don't have to spend 3 coins to enter into occupied tower.";

        return toString;

    }

    @Override
    public void doAction(Board board, Player player, FamilyMember familyMember, int index) throws UnsupportedOperationException {

    }

}
