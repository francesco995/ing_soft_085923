package it.polimi.ingsw.ps09.model.Actions;

import it.polimi.ingsw.ps09.model.Board;
import it.polimi.ingsw.ps09.model.FamilyMembers.FamilyMember;
import it.polimi.ingsw.ps09.model.Player;
import it.polimi.ingsw.ps09.model.Resources.Servant;

import java.io.InvalidObjectException;

/**
 * Created by franc on 15/06/2017.
 */
public class IncreaseFamilyMemberValue extends Action {

    //check if player has enough servant to give
    public static boolean isValid(Player player, Servant offer) {

        if (player.has(offer))
            return true;
        else
            return false;
    }

    public void doAction(Board board, Player player, String color, Servant offer)
            throws InvalidObjectException {

        //check if action is valid
        if (!isValid(player, offer))
            throw new InvalidObjectException("Operation not supported");


        //Do action
        player.getFamilyMember(color).morePower(offer.getValue());

    }
}
