package it.polimi.ingsw.ps09.model.Actions;

import it.polimi.ingsw.ps09.model.Board;
import it.polimi.ingsw.ps09.model.DevelopmentCards.Building;
import it.polimi.ingsw.ps09.model.FamilyMembers.FamilyMember;
import it.polimi.ingsw.ps09.model.Player;

/**
 * Created by francesco995 on 08/06/2017.
 */
public class PlaceFamilyMemberInGreenFloor extends PlaceFamilyMemberInFloor {


    public PlaceFamilyMemberInGreenFloor(Board board, int floorIndex, Player player, FamilyMember familyMember){

        super(board, floorIndex, player, familyMember);

    }


    public static boolean isValid(Board board, int floorIndex, Player player, FamilyMember familyMember){

        //TODO: IMPLEMENT
        //Check if floor is free and contains card
        if(!board.getBuildingsTower().getFloors().get(floorIndex).isAvailable()){
            return false;
        }

        //Building card = (Building) floor.getCard();

        int playerPower = 0;
        playerPower += familyMember.getPower();
        playerPower += player.getFamilyMemberPlacementBonus("BUILDING");
        playerPower += player.getServant().getValue();

        if(playerPower < board.getBuildingsTower().getFloors().get(floorIndex).getDiceValue())
            return false;

        //TODO: check if there are other familyMembers in tower


        return true;
    }


    public void doAction(Board board, int floorIndex, Player player, FamilyMember familyMember){

        player.add(board.getBuildingsTower().getFloors().get(floorIndex).getBoardBonus().getResourcesBonus());
        player.add(board.getBuildingsTower().getFloors().get(floorIndex).getBoardBonus().getPointsBonus());

        player.addBuildingCard( (Building) board.getBuildingsTower().getFloors().get(floorIndex).getCard() );

    }


}
