package it.polimi.ingsw.ps09.model.Actions;

import it.polimi.ingsw.ps09.model.Board;
import it.polimi.ingsw.ps09.model.DevelopmentCards.Building;
import it.polimi.ingsw.ps09.model.FamilyMembers.FamilyMember;
import it.polimi.ingsw.ps09.model.Places.Towers.Floor.Floor;
import it.polimi.ingsw.ps09.model.Player;

/**
 * Created by francesco995 on 08/06/2017.
 */
public class PlaceFamilyMemberInGreenFloor extends Action {

    public static boolean isValid(Floor floor, Player player, FamilyMember familyMember){

        //TODO: IMPLEMENT
        //Check if floor is free and contains card
        if(!floor.isAvailable()){
            return false;
        }

        //Building card = (Building) floor.getCard();

        int playerPower = 0;
        playerPower += familyMember.getPower();
        playerPower += player.getFamilyMemberPlacementBonus("BUILDING");
        playerPower += player.getServant().getValue();

        if(playerPower < floor.getDiceValue())
            return false;

        //TODO: check if there are other familyMembers in tower



        return true;
    }

    public static void doAction(Floor floor, Player player, FamilyMember familyMember){

        player.add(floor.getBoardBonus().getResourcesBonus());
        player.add(floor.getBoardBonus().getPointsBonus());

        player.addBuildingCard( (Building) floor.getCard() );

    }


}
