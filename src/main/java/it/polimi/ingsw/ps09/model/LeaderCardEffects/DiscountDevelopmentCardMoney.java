package it.polimi.ingsw.ps09.model.LeaderCardEffects;

import it.polimi.ingsw.ps09.model.Board;
import it.polimi.ingsw.ps09.model.FamilyMembers.FamilyMember;
import it.polimi.ingsw.ps09.model.Player;

/**
 * Created by walle on 19/06/17.
 */
public class DiscountDevelopmentCardMoney implements LeaderCardEffect {

    private int mVentureCardsRequired;
    private int mBuildingCardsRequired;

    /**
     *
     * @param player Object representing the player
     * @return Boolean value, true if the player can apply the effect, otherwise false
     */
    public boolean isValid(Player player){

        //Pico della Mirandola
        if((player.getVenturesCount()>=mVentureCardsRequired)
            &&(player.getBuildingsCount()>=mBuildingCardsRequired))
            return true;

        return false;

    }

    @Override
    public String toString(){

        String toString = "";

        toString += "Have a discount of 3 coins when purchasing a development card (if required)." +
                "This discount is not applied to enter in the tower.";

        return toString;

    }

    @Override
    public void doAction(Board board, Player player, FamilyMember familyMember, int index) throws UnsupportedOperationException {
        player.getFamilyMemberPlacementBonus().addBonus("TERRITORY", 3);
        player.getFamilyMemberPlacementBonus().addBonus("BUILDING", 3);
        player.getFamilyMemberPlacementBonus().addBonus("CHARACTER", 3);
        player.getFamilyMemberPlacementBonus().addBonus("VENTURE", 3);

        //TODO: Remove this Leader Card. How?
    }
}
