package it.polimi.ingsw.ps09.model.Actions;

import it.polimi.ingsw.ps09.model.Board;
import it.polimi.ingsw.ps09.model.FamilyMembers.FamilyMember;
import it.polimi.ingsw.ps09.model.Player;

import java.io.InvalidObjectException;

/**
 * Created by francesco995 on 11/06/2017.
 */
public class Harvest extends Action {

    public static boolean isValid(Board board, Player player, FamilyMember familyMember){

        //Check if the family Member has enough power to do basic action
        if(
                familyMember.getPower() + player.getHarvestBonus() > board.getHarvestSlotDiceValue()
                )
        return true;
        else
            return false;
    }

    public void doAction(Board board, Player player, FamilyMember familyMember)
            throws InvalidObjectException{

            //check if action is valid
            if(!isValid(board, player, familyMember))
                throw new InvalidObjectException("Operation not supported");

            //TODO: check if players want to give more power


            //Do action
            board.getHarvest().addMember(familyMember);
            //check all player cards
      /*  for (player.getPersonalBoard().getBoardTerritories()
             ) {
            
        }
*/
    }
}
