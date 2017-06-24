package it.polimi.ingsw.ps09.model.Actions;

import it.polimi.ingsw.ps09.model.Board;
import it.polimi.ingsw.ps09.model.FamilyMembers.FamilyMember;
import it.polimi.ingsw.ps09.model.Player;
import it.polimi.ingsw.ps09.model.Resources.Coins;

import java.io.InvalidObjectException;
import java.util.StringJoiner;

/**
 * Created by francesco995 on 11/06/2017.
 */
public class PlaceFamilyMemberInTheCouncilPalace implements Action {

    FamilyMember mFamilyMember;

    public PlaceFamilyMemberInTheCouncilPalace(FamilyMember familyMember, int index) {

        mFamilyMember = familyMember;
    }

    /**
     *
     * @param familyMember The family member that the player want to check
     * @return Boolean value; false if the family member doesn't have enough power, of if he isn't available; otherwise true
     */
    public static boolean isValid(FamilyMember familyMember) {

        //check if family member is usable
        if (!familyMember.isUsable() == true)
            return false;
        //check if has the minimum power for CouncilPalace
        if (familyMember.getPower() < 1)
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
     * @throws IndexOutOfBoundsException
     */
    public void doAction
            (Board board, Player player, FamilyMember familyMember, int index)
            throws UnsupportedOperationException, IndexOutOfBoundsException {

        // Check if action is actually valid
        if (!isValid(familyMember))
            throw new UnsupportedOperationException("Operation not supported");


        //Do action
        player.add(new Coins(1));
        //

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

        StringJoiner mStringCouncil = new StringJoiner("", "", "");

        mStringCouncil.add("");
        mStringCouncil.add("Place " + mFamilyMember.getColor() + " family member into the Council Palace");

        return mStringCouncil.toString();
    }

}
