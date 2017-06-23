package it.polimi.ingsw.ps09.model.LeaderCardEffects;

import it.polimi.ingsw.ps09.model.Player;
import it.polimi.ingsw.ps09.model.UserPoints;

/**
 * Created by walle on 19/06/17.
 */
public class AddThreeNeutralFamilyMemberValue extends LeaderCardEffect {

    private UserPoints mUserPointsRequirements = new UserPoints();


    /**
     *
     * @param player Object representing the player
     * @return Boolean value, true if the player can apply the effect, otherwise false
     */
    public boolean isValid(Player player){

        //Sigismondo Malatesta
        if(player.has(mUserPointsRequirements))
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

        toString += "Increase neutral family member +3 as value. You can increase it with servants or other Leader card";

        return toString;

    }

}
