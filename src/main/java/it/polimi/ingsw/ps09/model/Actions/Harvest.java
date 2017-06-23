package it.polimi.ingsw.ps09.model.Actions;

import it.polimi.ingsw.ps09.model.Board;
import it.polimi.ingsw.ps09.model.FamilyMembers.FamilyMember;
import it.polimi.ingsw.ps09.model.Player;

import java.io.InvalidObjectException;

/**
 * Created by francesco995 on 11/06/2017.
 */
public class Harvest implements Action {

    Player mPlayer;
    FamilyMember mFamilyMember;

    public Harvest(FamilyMember familyMember) {

        mFamilyMember = familyMember;
    }

    public static boolean isValid(Board board, Player player, FamilyMember familyMember){

        //check if family member is usable
        if (!familyMember.isUsable())
            return false;

        //Check if the family Member has enough power to do basic action
        if(familyMember.getPower() + player.getHarvestBonus() < board.getHarvestSlotDiceValue())
            return false;

        return true;
    }

    public void doAction(Board board, Player player, FamilyMember familyMember, int index)
            throws UnsupportedOperationException{

            //check if action is valid
            if(!isValid(board, player, familyMember))
                throw new UnsupportedOperationException("Operation not supported");


            //Do action
            board.getHarvest().addMember(familyMember);
            //check all player cards
             player.getPersonalBoard().getBoardTerritories()
                     .stream()
                     .filter(card -> card.getProductionCost()>familyMember.getPower()+ player.getHarvestBonus())
                     .forEach(card ->
                         card.getHarvestEffects().stream()
                                 .forEach(effect -> effect.applyEffect(player))
                     );


    }


    public String toString(){

        //TODO: Implement
        return "";
    }

    public FamilyMember getFamilyMember(){
        return mFamilyMember;
    }

    public int getIndex(){
        //TODO: check if good
        return 0;
    }

}
