package it.polimi.ingsw.ps09.model.LeaderCardEffects;

import it.polimi.ingsw.ps09.model.Player;

/**
 * Created by walle on 19/06/17.
 */
public class AddTwoToFamilyMemberValue {

    private int mCharacterCardsRequired;
    private int mBuldingCardsRequired;
    private int mVentureCardsRequired;
    private int mTerritoryCardsRequired;

    public boolean isValid(Player player) {

        //Lucrezia Borgia
        if ((player.getBuildingsCount() >= mBuldingCardsRequired)
                || (player.getTerritoriesCount() >= mTerritoryCardsRequired)
                || (player.getCharactersCount() >= mCharacterCardsRequired)
                || (player.getVenturesCount() >= mVentureCardsRequired))
            return true;

        return false;

    }

    @Override
    public String toString(){

        String toString = "";

        toString += "Increase colored family members +2 as value. You can increase it with servants or other character card";

        return toString;

    }
}
