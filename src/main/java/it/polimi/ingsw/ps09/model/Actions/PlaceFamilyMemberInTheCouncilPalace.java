package it.polimi.ingsw.ps09.model.Actions;

import it.polimi.ingsw.ps09.model.Board;
import it.polimi.ingsw.ps09.model.FamilyMembers.FamilyMember;
import it.polimi.ingsw.ps09.model.Player;
import it.polimi.ingsw.ps09.model.Resources.Coins;

import java.io.InvalidObjectException;

/**
 * Created by francesco995 on 11/06/2017.
 */
public class PlaceFamilyMemberInTheCouncilPalace implements Action {

    FamilyMember mFamilyMember;

    public PlaceFamilyMemberInTheCouncilPalace(FamilyMember familyMember, int index) {

        mFamilyMember = familyMember;
    }

    public static boolean isValid(FamilyMember familyMember) {

        //check if family member is usable
        if (!familyMember.isUsable() == true)
            return false;
        //check if has the minimum power for CouncilPalace
        if (familyMember.getPower() < 1)
            return false;

        //if reaches here it passed all controls
        return true;
    }

    public void doAction
            (Board board, Player player, FamilyMember familyMember, int index)
            throws UnsupportedOperationException, IndexOutOfBoundsException {

        // Check if action is actually valid
        if (!isValid(familyMember))
            throw new UnsupportedOperationException("Operation not supported");


        //Do action
        player.add(new Coins(1));
        //

    }

}
