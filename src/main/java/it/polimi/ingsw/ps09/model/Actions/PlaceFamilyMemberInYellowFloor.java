package it.polimi.ingsw.ps09.model.Actions;

import it.polimi.ingsw.ps09.model.Board;
import it.polimi.ingsw.ps09.model.DevelopmentCards.Building;
import it.polimi.ingsw.ps09.model.FamilyMembers.FamilyMember;
import it.polimi.ingsw.ps09.model.Player;
import it.polimi.ingsw.ps09.model.Resources.Coins;

import java.util.StringJoiner;

/**
 * Created by francesco995 on 11/06/2017.
 */
public class PlaceFamilyMemberInYellowFloor extends PlaceFamilyMemberInFloor {

    private static final int EXTRA_TOWER_COST = 3;

    public PlaceFamilyMemberInYellowFloor(FamilyMember familyMember, int index) {

        super(familyMember, index);

    }

    /**
     *
     * @param board Main board used to manage the game
     * @param player The player whom perform the check
     * @param familyMember The family member that the player want to check
     * @param index Floor's number
     * @return Boolean value; false if family member is unavailable, or the floor/tower isn't free,
     * or the family member doesn't have enough power/resources. Otherwise true
     */
    public static boolean isValid(Board board, Player player, FamilyMember familyMember, int index) {


        //FAMILY MEMBER CONTROLS
        //check if family member is usable
        if (!familyMember.isUsable())
            return false;
        //Check if floor is free
        if (!board.getBuildingsTower().getFloors().get(index).isAvailable())
            return false;

        //check if Family Member has enough power
        if (
                familyMember.getPower()
                        + player.getFamilyMemberPlacementBonus("BUILDING")
                        <
                        board.getBuildingsTower().getFloors().get(index).getDiceValue())
            return false;


        //PLAYER CONTROLS
        //card variable to check for resources
        Building card = (Building) board.getBuildingsTowerCard(index);

        //check if enough resources
        if (!player.has(card.getResourcesCosts().get(0)))
            return false;

        //check if enough points
        if (!player.has(card.getPointsCosts().get(0)))
            return false;

        //player has enough resources and/or points, check if tower already filled
        if (board.getBuildingsTower().hasFamilyMember()) {
            if (player.getCoins().getValue()
                    >
                    (card.getResourcesCosts().get(0).getCoins().getValue() + EXTRA_TOWER_COST))
                return false;
        }

        //if reaches here it passed all controls
        return true;
    }

    /**
     *
     * @param board Main board used to manage the game
     * @param player The player whom perform the action
     * @param familyMember The family member that do the action
     * @param index Floor's number
     */
    public void doAction(Board board, Player player, FamilyMember familyMember, int index) {

        //add instant r&p gains from board
        player.add(board.getBuildingsTower().getFloors().get(index).getBoardBonus().getResourcesBonus());
        player.add(board.getBuildingsTower().getFloors().get(index).getBoardBonus().getPointsBonus());

        //pay for card
        //player.remove(board.getBuildingsTowerCard(index).getResourcesCosts().get(0));

        //pay if floor already occupied
        if (board.getBuildingsTower().hasFamilyMember())
            player.remove(new Coins(EXTRA_TOWER_COST));


        Building card = (Building) board.getBuildingsTower().getFloors().get(index).getCard();
        //place family member
        board.getBuildingsTower().getFloor(index).setCard(card);
        familyMember.used();
        //get card
        player.addBuildingCard(card);

        //TODO: ASK FRAG if immediate effect must be activated here or where

    }


    /**
     *
     * @return A string of the action to perform
     */
    @Override
    public String toString(){

        StringJoiner mStringYellowFloor = new StringJoiner("", "", "");

        mStringYellowFloor.add("");
        mStringYellowFloor.add("Place your " + getFamilyMember().getColor() + " family member into Yellow tower's floor n. " + ( getIndex() + 1 ));

        return mStringYellowFloor.toString();

    }
}
