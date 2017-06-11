package it.polimi.ingsw.ps09.model.Actions;

import it.polimi.ingsw.ps09.model.Board;
import it.polimi.ingsw.ps09.model.DevelopmentCards.Building;
import it.polimi.ingsw.ps09.model.FamilyMembers.FamilyMember;
import it.polimi.ingsw.ps09.model.Places.Towers.Floor.Floor;
import it.polimi.ingsw.ps09.model.Player;

/**
 * Created by francesco995 on 08/06/2017.
 */
public class PlaceFamilyMemberInGreenFloor implements Action {

    public static boolean isValid(Floor floor, Player player, FamilyMember familyMember){

        //TODO: IMPLEMENT
        //Check if floor is free and contains card
        if(!floor.isAvailable()){
            return false;
        }

        Building card = (Building) floor.getCard();

        int playerPower = 0;
        playerPower += familyMember.getPower();
        playerPower += player.getFamilyMemberPlacementBonus().getBonus("BUILDING");




        return true;
    }

    public static void doAction(Floor floor, Player player, FamilyMember familyMember){

        //TODO: IMPLEMENT

    }


}
