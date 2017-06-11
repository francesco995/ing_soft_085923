package it.polimi.ingsw.ps09.model.Actions;

import it.polimi.ingsw.ps09.model.Board;
import it.polimi.ingsw.ps09.model.FamilyMembers.FamilyMember;
import it.polimi.ingsw.ps09.model.Player;
import it.polimi.ingsw.ps09.model.Resources.Servant;
import it.polimi.ingsw.ps09.model.UserResources;

import java.io.InvalidObjectException;

/**
 * Created by francesco995 on 11/06/2017.
 */
public class PlaceFamilyMemberInMarket1 implements Action {

    public static boolean isValid(Board board, Player player, FamilyMember familyMember){

        //Check if market is empty
        if(!board.getMarket().get(0).isAvailable())
            return false;


        //Check if Family Member has power
        if(
                familyMember.getPower() < 1 &&
                !player.has(new Servant(1)))
            return false;

        return true;
    }

    public static void doAction(Board board, Player player, FamilyMember familyMember) throws InvalidObjectException {

        //Do check
        if(!isValid(board, player, familyMember))
            throw new InvalidObjectException("Operation not supported");

        if(familyMember.getPower() < 1)
            player.remove(new Servant(1));

        //Do action
        board.getMarket().get(0).setFamilyMember(familyMember);
        player.add(board.getMarket().get(0).getBoardBonus().getPointsBonus());
        player.add(board.getMarket().get(0).getBoardBonus().getResourcesBonus());

    }


}
