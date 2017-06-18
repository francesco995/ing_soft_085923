package it.polimi.ingsw.ps09.model.Actions;

import it.polimi.ingsw.ps09.model.Board;
import it.polimi.ingsw.ps09.model.DevelopmentCards.Building;
import it.polimi.ingsw.ps09.model.DevelopmentCards.Territory;
import it.polimi.ingsw.ps09.model.FamilyMembers.FamilyMember;
import it.polimi.ingsw.ps09.model.Player;
import it.polimi.ingsw.ps09.model.Resources.Coins;

/**
 * Created by francesco995 on 08/06/2017.
 */
public class PlaceFamilyMemberInGreenFloor extends PlaceFamilyMemberInFloor {

    private static final int EXTRA_TOWER_COST = 3;

    public PlaceFamilyMemberInGreenFloor(Board board, int floorIndex, Player player, FamilyMember familyMember) {

        super(board, floorIndex, player, familyMember);

    }


    public static boolean isValid(Board board, int floorIndex, Player player, FamilyMember familyMember) {
        //check if family member is usable
        if (!familyMember.getUsable() == true)
            return false;
        else
            //Check if floor is free
            if (!board.getTerritoriesTower().getFloors().get(floorIndex).isAvailable()) {
                return false;
            } else
                //check if Family Member has enough power
                if (
                        familyMember.getPower()
                                + player.getFamilyMemberPlacementBonus("TERRITORY")
                                <
                                board.getTerritoriesTower().getFloors().get(floorIndex).getDiceValue()) {
                    return false;
                }


        //card variable to check for resources
        Territory card = (Territory) board.getTerritoriesTowerCard(floorIndex);

        //check if enough resources

        if (!player.has(card.getResourcesCosts().get(0)))
            return false;
            //check if enough points

        else if (!player.has(card.getPointsCosts().get(0)))
            return false;
        else
            //player has enough resources and/or points, check if tower already filled
            if (board.getTerritoriesTower().hasFamilyMember()) {
                if (player.getCoins().getValue()
                        >
                        (card.getResourcesCosts().get(0).getCoins().getValue() + EXTRA_TOWER_COST))
                    //passed extra coins check
                    return true;
                else
                    return false;


            } else
                //if tower not filled returns true
                return true;

        /*//enough coins
        if (player.getCoins().getValue()
                <
                card.getResourcesCosts().get(0).getCoins().getValue())
            return false;
        //enough wood
        else if (player.getWood().getValue()
                <
                card.getResourcesCosts().get(0).getWood().getValue())
            return false;
        //enough stone
        else if (player.getStone().getValue()
                <
                card.getResourcesCosts().get(0).getStone().getValue())
            return false;
        //enough servant
        else if (player.getServant().getValue()
                <
                card.getResourcesCosts().get(0).getServant().getValue())
            return false;
        //enough Military points
        else if (player.getMilitaryPoints().getValue()
                <
                card.getPointsCosts().get(0).getMilitaryPoints().getValue())
            return false;
        else //all condition passed
                return true;
*/
    }


    public void doAction(Board board, int floorIndex, Player player, FamilyMember familyMember) {

        //add instant r&p gains from board
        player.add(board.getTerritoriesTower().getFloors().get(floorIndex).getBoardBonus().getResourcesBonus());
        player.add(board.getTerritoriesTower().getFloors().get(floorIndex).getBoardBonus().getPointsBonus());

        //pay for card
        player.remove(board.getTerritoriesTowerCard(floorIndex).getResourcesCosts().get(0));

        //pay if floor already occupied
        if (board.getTerritoriesTower().hasFamilyMember())
            player.remove(new Coins(EXTRA_TOWER_COST));
        //get card
        player.addTerritoryCard((Territory) board.getTerritoriesTower().getFloors().get(floorIndex).getCard());

        //TODO: ASK FRAG if immediate effect must be activated here or where
    }


}
