package it.polimi.ingsw.ps09.model.LeaderCardEffects;

import it.polimi.ingsw.ps09.model.Board;
import it.polimi.ingsw.ps09.model.FamilyMembers.FamilyMember;
import it.polimi.ingsw.ps09.model.Player;
import it.polimi.ingsw.ps09.model.UserResources;

/**
 * Created by walle on 19/06/17.
 */
public class GetCouncilPrivilege implements LeaderCardEffect {

    private UserResources mUserResourcesRequirements = new UserResources();

    /**
     *
     * @param player Object representing the player
     * @return Boolean value, true if the player can apply the effect, otherwise false
     */
    public boolean isValid(Player player){

        //Ludovico III Gonzaga
        if(player.has(mUserResourcesRequirements))
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

        toString += "Receive 1 Council Privilege.";

        return toString;

    }

    @Override
    public void doAction(Board board, Player player, FamilyMember familyMember, int index) throws UnsupportedOperationException {
        player.addCouncilPrivilege(1);

    }

}
