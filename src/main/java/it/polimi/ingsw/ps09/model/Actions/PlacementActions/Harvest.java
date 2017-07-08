package it.polimi.ingsw.ps09.model.Actions.PlacementActions;

import it.polimi.ingsw.ps09.controller.Game.Game;
import it.polimi.ingsw.ps09.model.Board;
import it.polimi.ingsw.ps09.model.FamilyMembers.FamilyMember;
import it.polimi.ingsw.ps09.model.Player;

import java.util.StringJoiner;

/**
 * Created by francesco995 on 11/06/2017.
 */
public class Harvest implements PlacementAction {

    Player mPlayer;
    FamilyMember mFamilyMember;

    public Harvest(FamilyMember familyMember) {

        mFamilyMember = familyMember;
    }

    /**
     *
     * @param board Main board used to manage the game
     * @param player The player whom perform the check
     * @param familyMember The family member that the player want to check
     * @return Boolean value; false if the family member is not usable or he doesn't have enough power, otherwise true
     */
    public static boolean isValid(Board board, Player player, FamilyMember familyMember){


        //check if family member is usable
        if (!familyMember.isUsable())
            return false;

        //controls number of player to know how many slot to open
        if(Game.PLAYERS_NUMBER == 2 && board.getHarvest().hasOneFamilyMember())
            return false;
        //controls if family member of same family not already used and not the neutral one
        /*if(currentTower.hasSameFamilyMember(familyMember) && !familyMember.getColor().equalsIgnoreCase("neutral")){
            return false;
        }*/

        //Check if the family Member has enough power to do basic action
        if(familyMember.getPower() + player.getHarvestBonus() < board.getHarvestSlotDiceValue())
            return false;

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
            throws UnsupportedOperationException{

            //check if action is valid
            if(!isValid(board, player, familyMember))
                throw new UnsupportedOperationException("Operation not supported");


            //Do action
            board.getHarvest().addMember(familyMember);
            familyMember.used();
            //apply effect for  all player cards
             player.getPersonalBoard().getBoardTerritories()
                     .stream()
                     .filter(card -> card.getProductionCost()>familyMember.getPower()+ player.getHarvestBonus())
                     .forEach(card ->
                         card.getHarvestEffects().stream()
                                 .forEach(effect -> effect.applyEffect(player))
                     );
            //apply effect for the personal board
            player.getPersonalBoard().getPersonalBonusTile().getHarvestBonus()
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
        //TODO: check if good
        return 0;
    }

    /**
     *
     * @return A string of the action to perform
     */
    @Override
    public String toString(){

        StringJoiner mStringHarvest = new StringJoiner("", "", "");

        mStringHarvest.add("");
        mStringHarvest.add("Place your " + mFamilyMember.getColor() + " family member into the Harvest area");

        return mStringHarvest.toString();
    }

}
