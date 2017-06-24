package it.polimi.ingsw.ps09.model.Actions;

import it.polimi.ingsw.ps09.controller.Game.Game;
import it.polimi.ingsw.ps09.model.Board;
import it.polimi.ingsw.ps09.model.FamilyMembers.FamilyMember;
import it.polimi.ingsw.ps09.model.Player;
import it.polimi.ingsw.ps09.model.Resources.Servant;

import java.io.InvalidObjectException;
import java.util.StringJoiner;

/**
 * Created by francesco995 on 11/06/2017.
 */
public class PlaceFamilyMemberInMarket implements Action {

    FamilyMember mFamilyMember;
    int mMarketIndex;

    public PlaceFamilyMemberInMarket(FamilyMember familyMember, int index) {
        mFamilyMember = familyMember;
        mMarketIndex = index;
    }

    /**
     *
     * @param board Main board used to manage the game
     * @param player The player whom perform the check
     * @param familyMember The family member that the player want to check
     * @param marketIndex Index of the market space
     * @return Boolean value, false if the family member isn't available, or the market space isn't available,
     * or index out of bound or the family member doesn't have enough power; otherwise true
     */
    public static boolean isValid(Board board, Player player, FamilyMember familyMember, int marketIndex){

        //check if family member is usable
        if (!familyMember.isUsable() == true)
            return false;

        //Check if 4+ players are playing to check if the last 2 spaces are open
        if(Game.PLAYERS_NUMBER < 4 && marketIndex > 1)
            return false;

        //Check if Market index is valid
        if(marketIndex < 0 || marketIndex > 4)
            throw new IndexOutOfBoundsException("Market index out of bound");

        //Check if market is empty
        if(!board.getMarketList().get(marketIndex).isAvailable())
            return false;


        //Check if Family Member has power or Player has 1 servant
        if(
                familyMember.getPower() < 1 &&
                !player.has(new Servant(1)))
            return false;

        //if reaches here it passed all controls
        return true;
    }

    /**
     *
     * @param board Main board used to manage the game
     * @param player The player whom perform the action
     * @param familyMember The family member that do the action
     * @param index Index of the market space
     * @throws UnsupportedOperationException
     * @throws IndexOutOfBoundsException
     */
    public void doAction
            (Board board, Player player, FamilyMember familyMember, int index)
            throws UnsupportedOperationException, IndexOutOfBoundsException {

        // Check if action is actually valid
        if(!isValid(board, player, familyMember, index))
            throw new UnsupportedOperationException("Operation not supported");

        if(familyMember.getPower() < 1)
            player.remove(new Servant(1));

        //Do action
        board.getMarketList().get(index).setFamilyMember(familyMember);
        player.add(board.getMarketList().get(index).getBoardBonus().getPointsBonus());
        player.add(board.getMarketList().get(index).getBoardBonus().getResourcesBonus());

    }


    /**
     *
     * @return Family Member
     */
    public FamilyMember getFamilyMember(){
        return mFamilyMember;
    }

    /**
     *
     * @return Index ot the market space
     */
    public int getIndex(){
        return mMarketIndex;
    }

    /**
     *
     * @return A string of the action to perform
     */
    @Override
    public String toString(){

        StringJoiner mStringMarket = new StringJoiner("\n", "", "");

        mStringMarket.add("");
        mStringMarket.add("Add " + mFamilyMember.getColor() + " family member into market space "+ (mMarketIndex +1) + ".");

        return mStringMarket.toString();
    }

}
