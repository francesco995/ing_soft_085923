package it.polimi.ingsw.ps09.model.Actions;


import it.polimi.ingsw.ps09.model.Board;
import it.polimi.ingsw.ps09.model.FamilyMembers.FamilyMember;
import it.polimi.ingsw.ps09.model.Player;

import java.io.InvalidObjectException;

/**
 * Created by francesco995 on 11/06/2017.
 */
public class Production extends Action {

    Board mBoard;
    Player mPlayer;
    FamilyMember mFamilyMember;

    public Production(Board board, Player player, FamilyMember familyMember) {
        mBoard = board;
        mPlayer = player;
        mFamilyMember = familyMember;
    }

    public static boolean isValid(Board board, Player player, FamilyMember familyMember){

        //check if family member is usable
        if (!familyMember.isUsable() == true)
            return false;
        else
        //Check if the family Member has enough power to do basic action
        if(
                familyMember.getPower() + player.getProductionBonus() > board.getProductionSlotDiceValue()
                )
            return true;
        else
            return false;
    }

    public void doAction(Board board, Player player, FamilyMember familyMember)
            throws InvalidObjectException {

        //check if action is valid
        if(!isValid(board, player, familyMember))
            throw new InvalidObjectException("Operation not supported");


        //Do action
        board.getProduction().addMember(familyMember);
        //check all player cards
        player.getPersonalBoard().getBoardBuildings()
                .stream()
                .filter(card -> card.getProductionCost()>familyMember.getPower()+ player.getProductionBonus())
                .forEach(card ->
                        card.getProductionEffects().stream()
                                .forEach(effect -> effect.applyEffect(player))
                );


    }
}
