package it.polimi.ingsw.ps09.model.Actions;

import it.polimi.ingsw.ps09.model.Board;
import it.polimi.ingsw.ps09.model.DevelopmentCards.Building;
import it.polimi.ingsw.ps09.model.FamilyMembers.FamilyMember;
import it.polimi.ingsw.ps09.model.Player;
import it.polimi.ingsw.ps09.model.Resources.Coins;

/**
 * Created by francesco995 on 11/06/2017.
 */
public class PlaceFamilyMemberInYellowFloor extends PlaceFamilyMemberInFloor {

    private static final int EXTRA_TOWER_COST = 3;

    public PlaceFamilyMemberInYellowFloor(Board board, int floorIndex, Player player, FamilyMember familyMember){

        super(board, floorIndex, player, familyMember);

    }


    public static boolean isValid(Board board, int floorIndex, Player player, FamilyMember familyMember){

        //check if family member is usable
        if (!familyMember.isUsable() == true)
            return false;
        else
        //Check if floor is free
        if (!board.getBuildingsTower().getFloors().get(floorIndex).isAvailable()) {
            return false;
        } else
            //check if Family Member has enough power
            if (
                    familyMember.getPower()
                            + player.getFamilyMemberPlacementBonus("BUILDING")
                            <
                            board.getBuildingsTower().getFloors().get(floorIndex).getDiceValue()) {
                return false;
            }


        //card variable to check for resources
        Building card = (Building) board.getBuildingsTowerCard(floorIndex);

        //check if enough resources

        if(!player.has(card.getResourcesCosts().get(0)))
            return false;
            //check if enough points

        else if (!player.has(card.getPointsCosts().get(0)))
            return false;
        else
            //player has enough resources and/or points, check if tower already filled
            if(board.getBuildingsTower().hasFamilyMember())
            {
                if(player.getCoins().getValue()
                        >
                        (card.getResourcesCosts().get(0).getCoins().getValue() + EXTRA_TOWER_COST ))
                    //passed extra coins check
                    return true;
                else
                    return false;


            }
            else
                //if tower not filled returns true
                return true;
    }

    public void doAction(Board board, int floorIndex, Player player, FamilyMember familyMember){

        //add instant r&p gains from board
        player.add(board.getBuildingsTower().getFloors().get(floorIndex).getBoardBonus().getResourcesBonus());
        player.add(board.getBuildingsTower().getFloors().get(floorIndex).getBoardBonus().getPointsBonus());

        //pay for card
        player.remove( board.getBuildingsTowerCard(floorIndex).getResourcesCosts().get(0) );

        //pay if floor already occupied
        if(board.getBuildingsTower().hasFamilyMember())
            player.remove(new Coins(EXTRA_TOWER_COST));
        //get card
        player.addBuildingCard((Building) board.getBuildingsTower().getFloors().get(floorIndex).getCard());

        //TODO: ASK FRAG if immediate effect must be activated here or where

    }
}
