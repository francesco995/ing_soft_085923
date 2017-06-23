package it.polimi.ingsw.ps09.model.Actions;

import it.polimi.ingsw.ps09.model.Board;
import it.polimi.ingsw.ps09.model.DevelopmentCards.Venture;
import it.polimi.ingsw.ps09.model.FamilyMembers.FamilyMember;
import it.polimi.ingsw.ps09.model.Player;
import it.polimi.ingsw.ps09.model.Resources.Coins;

/**
 * Created by francesco995 on 11/06/2017.
 */
public class PlaceFamilyMemberInPurpleFloor extends PlaceFamilyMemberInFloor {

    private static final int EXTRA_TOWER_COST = 3;

    public PlaceFamilyMemberInPurpleFloor(FamilyMember familyMember, int index) {

        super(familyMember, index);

    }


    public static boolean isValid(Board board, Player player, FamilyMember familyMember, int index) {

        //FAMILY MEMBER CONTROLS
        //check if family member is usable
        if (!familyMember.isUsable())
            return false;

        //Check if floor is free
        if (!board.getVenturesTower().getFloors().get(index).isAvailable())
            return false;

        //check if Family Member has enough power
        if (
                familyMember.getPower()
                        + player.getFamilyMemberPlacementBonus("VENTURE")
                        <
                        board.getVenturesTower().getFloors().get(index).getDiceValue())
            return false;


        //PLAYERS CONTROLS
        //card variable to check for resources
        Venture card = (Venture) board.getVenturesTowerCard(index);

        //check if enough resources
        if (!player.has(card.getResourcesCosts().get(0)))
            return false;

        //check if enough points
        if (!player.has(card.getPointsCosts().get(0)))
            return false;

        //player has enough resources and/or points, check if tower already filled
        if (board.getVenturesTower().hasFamilyMember()) {
            if (player.getCoins().getValue()
                    <
                    (card.getResourcesCosts().get(0).getCoins().getValue() + EXTRA_TOWER_COST))
                return false;
        }

        //if reaches here it passed all controls
        return true;
    }

    public void doAction(Board board, Player player, FamilyMember familyMember, int index) {

        //add instant r&p gains from board
        player.add(board.getVenturesTower().getFloors().get(index).getBoardBonus().getResourcesBonus());
        player.add(board.getVenturesTower().getFloors().get(index).getBoardBonus().getPointsBonus());

        //pay for card
        player.remove(board.getVenturesTowerCard(index).getResourcesCosts().get(0));

        //pay if floor already occupied
        if (board.getVenturesTower().hasFamilyMember())
            player.remove(new Coins(EXTRA_TOWER_COST));
        //get card
        player.addVentureCard((Venture) board.getVenturesTower().getFloors().get(index).getCard());

        //TODO: ASK FRAG if immediate effect must be activated here or where

    }
}
