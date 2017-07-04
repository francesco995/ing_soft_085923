package it.polimi.ingsw.ps09.model.LeaderCardEffects;

import it.polimi.ingsw.ps09.model.Board;
import it.polimi.ingsw.ps09.model.FamilyMembers.FamilyMember;
import it.polimi.ingsw.ps09.model.Player;

/**
 * Created by walle on 19/06/17.
 */
public class FamilyMemberHasValueFive implements LeaderCardEffect {

    private int mCharacterCardsRequired;
    private int mBuildingCardsRequired;
    private int mVentureCardsRequired;
    private int mTerritoryCardsRequired;

    /**
     *
     * @param player Object representing the player
     * @return Boolean value, true if the player can apply the effect, otherwise false
     */
    public boolean isValid(Player player){

        //Ludovico il Moro
        if((player.getBuildingsCount()>=mBuildingCardsRequired)
                &&(player.getTerritoriesCount()>=mTerritoryCardsRequired)
                &&(player.getCharactersCount()>=mCharacterCardsRequired)
                &&(player.getVenturesCount()>=mVentureCardsRequired))
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

        toString += "Colored family members have 5 as value, without considering dice value." +
                "You can increase it with servants or other character card.";

        return toString;

    }

    @Override
    public void doAction(Board board, Player player, FamilyMember familyMember, int index) throws UnsupportedOperationException {

    }

}
