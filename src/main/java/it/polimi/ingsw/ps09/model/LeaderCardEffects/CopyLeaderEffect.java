package it.polimi.ingsw.ps09.model.LeaderCardEffects;

import it.polimi.ingsw.ps09.model.Board;
import it.polimi.ingsw.ps09.model.FamilyMembers.FamilyMember;
import it.polimi.ingsw.ps09.model.Player;
import it.polimi.ingsw.ps09.model.UserPoints;

/**
 * Created by walle on 19/06/17.
 */
public class CopyLeaderEffect implements LeaderCardEffect {

    private UserPoints mUserPointsRequirements;

    /**
     *
     * @param player Object representing the player
     * @return Boolean value, true if the player can apply the effect, otherwise false
     */
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

    @Override
    public void doAction(Board board, Player player, FamilyMember familyMember, int index) throws UnsupportedOperationException {

    }
}
