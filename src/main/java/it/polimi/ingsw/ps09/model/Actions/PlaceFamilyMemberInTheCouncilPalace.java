package it.polimi.ingsw.ps09.model.Actions;

import it.polimi.ingsw.ps09.model.Board;
import it.polimi.ingsw.ps09.model.FamilyMembers.FamilyMember;
import it.polimi.ingsw.ps09.model.Places.Towers.Floor.Floor;
import it.polimi.ingsw.ps09.model.Player;
import it.polimi.ingsw.ps09.model.Resources.Coins;
import it.polimi.ingsw.ps09.model.Resources.Servant;

import java.io.InvalidObjectException;

/**
 * Created by francesco995 on 11/06/2017.
 */
public class PlaceFamilyMemberInTheCouncilPalace extends Action {

    public static boolean isValid(FamilyMember familyMember) {

        //check if has the minimum power for CouncilPalace
        if (familyMember.getPower() < 1)
            return false;
        else
            return true;
    }

    public void doAction
            (Board board, Player player, FamilyMember familyMember)
            throws InvalidObjectException, IndexOutOfBoundsException {

        // Check if action is actually valid
        if (!isValid(familyMember))
            throw new InvalidObjectException("Operation not supported");


        //Do action
        player.add(new Coins(1));
        //

    }

}
