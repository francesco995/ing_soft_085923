package it.polimi.ingsw.ps09.model.Actions.PlacementActions;


import it.polimi.ingsw.ps09.controller.Game.Game;
import it.polimi.ingsw.ps09.model.Board;
import it.polimi.ingsw.ps09.model.FamilyMembers.FamilyMember;
import it.polimi.ingsw.ps09.model.Player;

import java.util.StringJoiner;

/**
 * Created by francesco995 on 11/06/2017.
 */
public class Production implements PlacementAction {

    FamilyMember mFamilyMember;

    public Production(FamilyMember familyMember) {

        mFamilyMember = familyMember;
    }

    /**
     *
     * @param board Main board used to manage the game
     * @param player The player whom perform the check
     * @param familyMember The family member that the player want to check
     * @return Boolean value; false if the family member isn't usable or he doesn't have enough power, otherwise true
     */
    public static boolean isValid(Board board, Player player, FamilyMember familyMember){
        //todo: controllo neutrali
        //check if family member is usable
        if (!familyMember.isUsable() == true)
            return false;
        //check if family member of same color present && not the neutral one
        //if(!familyMember.getColor().equalsIgnoreCase("neutral") && board.getProduction().hasSameFamilyMember(familyMember))
        //Check if the family Member has enough power to do basic action
        if(
                familyMember.getPower() + player.getProductionBonus() < board.getProductionSlotDiceValue()
                )
            return false;
        //controls number of player to know how many slot to open
        if(Game.PLAYERS_NUMBER == 2 && board.getProduction().hasOneFamilyMember())
            return false;
        //if reaches here it passed all controls
        return true;
    }

    /**
     *
     * @param board Main board used to manage the game
     * @param player The player whom perform the action
     * @param familyMember The family member that do the action
     * @param index
     * @throws UnsupportedOperationException
     */
    public void doAction(Board board, Player player, FamilyMember familyMember, int index)
            throws UnsupportedOperationException {

        //check if action is valid
        if(!isValid(board, player, familyMember))
            throw new UnsupportedOperationException("Operation not supported");


        //Do action
        board.getProduction().addMember(familyMember);
        familyMember.used();

        //check all player cards
        player.getPersonalBoard().getBoardBuildings()
                .stream()
                .filter(card -> card.getProductionCost() <= familyMember.getPower()+ player.getProductionBonus())
                .forEach(card ->
                        card.getProductionEffects().stream()
                                .forEach(effect -> effect.applyEffect(player))
                );
        //apply effect for the personal board
        player.getPersonalBoard().getPersonalBonusTile().getProductionBonus()
                .stream()
                .forEach(developmentCardEffect -> developmentCardEffect.applyEffect(player));

    }

    /**
     *
     * @return Family member
     */
    public FamilyMember getFamilyMember(){
        return mFamilyMember;
    }

    public int getIndex(){
        return 0;
    }

    /**
     *
     * @return A string of the action to perform
     */
    @Override
    public String toString(){

        StringJoiner mStringHProduction = new StringJoiner("", "", "");

        mStringHProduction.add("");
        mStringHProduction.add("Place your " + mFamilyMember.getColor() + " family member into the Production area");

        return mStringHProduction.toString();
    }

}
