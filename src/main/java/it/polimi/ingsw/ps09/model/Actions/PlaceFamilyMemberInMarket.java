package it.polimi.ingsw.ps09.model.Actions;

import it.polimi.ingsw.ps09.controller.Game.Game;
import it.polimi.ingsw.ps09.model.Board;
import it.polimi.ingsw.ps09.model.FamilyMembers.FamilyMember;
import it.polimi.ingsw.ps09.model.Player;
import it.polimi.ingsw.ps09.model.Resources.Servant;

import java.io.InvalidObjectException;

/**
 * Created by francesco995 on 11/06/2017.
 */
public class PlaceFamilyMemberInMarket extends Action {

    Board mBoard;
    Player mPlayer;
    FamilyMember mFamilyMember;
    int mMarketIndex;

    public PlaceFamilyMemberInMarket(Board board, Player player, FamilyMember familyMember, int marketIndex) {
        mBoard = board;
        mPlayer = player;
        mFamilyMember = familyMember;
        mMarketIndex = marketIndex;
    }

    public static boolean isValid(Board board, Player player, FamilyMember familyMember, int marketIndex){

        //check if family member is usable
        if (!familyMember.getUsable() == true)
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

        return true;
    }

    public void doAction
            (Board board, Player player, FamilyMember familyMember, int marketIndex)
            throws InvalidObjectException, IndexOutOfBoundsException {

        // Check if action is actually valid
        if(!isValid(board, player, familyMember, marketIndex))
            throw new InvalidObjectException("Operation not supported");

        if(familyMember.getPower() < 1)
            player.remove(new Servant(1));

        //Do action
        board.getMarketList().get(marketIndex).setFamilyMember(familyMember);
        player.add(board.getMarketList().get(marketIndex).getBoardBonus().getPointsBonus());
        player.add(board.getMarketList().get(marketIndex).getBoardBonus().getResourcesBonus());

    }


}
