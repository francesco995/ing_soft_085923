package it.polimi.ingsw.ps09.model.Actions;

import it.polimi.ingsw.ps09.model.Board;
import it.polimi.ingsw.ps09.model.FamilyMembers.FamilyMember;
import it.polimi.ingsw.ps09.model.Places.Towers.Floor.Floor;
import it.polimi.ingsw.ps09.model.Player;

/**
 * Created by francesco995 on 11/06/2017.
 */
public class PlaceFamilyMemberInBlueFloor extends PlaceFamilyMemberInFloor {


    public PlaceFamilyMemberInBlueFloor(Board board, int floorIndex, Player player, FamilyMember familyMember){

        super(board, floorIndex, player, familyMember);

    }


    public static boolean isValid(Floor floor, Player player, FamilyMember familyMember){

        //TODO: IMPLEMENT



        return true;
    }

    public void doAction(Floor floor, Player player, FamilyMember familyMember){

        //TODO: IMPLEMENT

    }

}
