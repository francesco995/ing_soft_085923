package it.polimi.ingsw.ps09.model.LeaderCardEffects;

import it.polimi.ingsw.ps09.model.Board;
import it.polimi.ingsw.ps09.model.FamilyMembers.FamilyMember;
import it.polimi.ingsw.ps09.model.Player;

/**
 * Created by walle on 19/06/17.
 */
public class DoProductionAction implements LeaderCardEffect {

    private int mCharacterCardsRequired;
    private int mTerritoryCardsRequired;

    /**
     *
     * @param player Object representing the player
     * @return Boolean value, true if the player can apply the effect, otherwise false
     */
    public boolean isValid(Player player){

        //Leonardo Da Vinci
        if((player.getCharactersCount()>=mCharacterCardsRequired)
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

    @Override
    public void doAction(Board board, Player player, FamilyMember familyMember, int index) throws UnsupportedOperationException {
        player.getHarvestAndProductionBonus().addBonus("PRODUCTION", 0);

        //TODO: Da chiedere a fraG

    }

}
