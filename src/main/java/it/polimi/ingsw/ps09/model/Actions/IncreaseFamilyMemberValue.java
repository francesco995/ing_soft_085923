package it.polimi.ingsw.ps09.model.Actions;

import it.polimi.ingsw.ps09.model.Board;
import it.polimi.ingsw.ps09.model.FamilyMembers.FamilyMember;
import it.polimi.ingsw.ps09.model.Player;
import it.polimi.ingsw.ps09.model.Resources.Servant;

import java.io.InvalidObjectException;

/**
 * Created by franc on 15/06/2017.
 */
public class IncreaseFamilyMemberValue {

    //check if player has enough servant to give
    public static boolean isValid(Player player,FamilyMember familyMember, int index) {


        //check if family member is usable
        if (!familyMember.isUsable())
            return false;
        if (!player.has(new Servant(index)))
            return false;

        //if reaches here it passed all controls
        return true;
    }

    public void doAction(Board board, Player player, FamilyMember familyMember, int index)
            throws UnsupportedOperationException {

        //check if action is valid
        if (!isValid(player, familyMember, index))
            throw new UnsupportedOperationException("Operation not supported");

        //TODO: remove servant from player

        //Do action
        familyMember.morePower(index);

    }

    public String toString(){

        //TODO: Implement
        return "";
    }


}
