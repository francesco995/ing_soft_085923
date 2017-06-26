package it.polimi.ingsw.ps09.model.Actions.FamilyMemberActions;

import it.polimi.ingsw.ps09.model.Board;
import it.polimi.ingsw.ps09.model.FamilyMembers.FamilyMember;
import it.polimi.ingsw.ps09.model.Player;
import it.polimi.ingsw.ps09.model.Resources.Servant;

import java.util.StringJoiner;

/**
 * Created by franc on 15/06/2017.
 */
public class IncreaseFamilyMemberValue implements FamilyMemberAction {

    FamilyMember mFamilyMember;
    int mIndex;

    public IncreaseFamilyMemberValue(FamilyMember familyMember,int index) {
        mFamilyMember = familyMember;
        mIndex = index;
    }

    /**
     *
     * @param player The player whom perform the check
     * @param familyMember The family member that the player want to check
     * @param index Number of servants to perform the action
     * @return Boolean value; false if the family member is not available or he doesn't have enough power, otherwise true
     */
    //check if player has enough servant to give
    public static boolean isValid(Player player,FamilyMember familyMember, int index) {


        //check if family member is usable
        if (!familyMember.isUsable())
            return false;
        if (!player.has(new Servant(index)))
            return false;

        //if reaches here it passed all controls
        return true;
    }

    /**
     *
     * @param board Main board used to manage the game
     * @param player The player whom perform the action
     * @param familyMember The family member that do the action
     * @param index The quantity of power to add
     * @throws UnsupportedOperationException
     */
    public void doAction(Board board, Player player, FamilyMember familyMember, int index)
            throws UnsupportedOperationException {

        //check if action is valid
        if (!isValid(player, familyMember, index))
            throw new UnsupportedOperationException("Operation not supported");

        //remove the servant to pay for action
        player.remove(new Servant (index));

        //Do action
        familyMember.morePower(index);

    }

    @Override
    public FamilyMember getFamilyMember() {
        return null;
    }

    @Override
    public int getIndex() {
        return mIndex;
    }

    /**
     *
     * @return A string of the action to perform
     */
    @Override
    public String toString(){

        StringJoiner mStringIncreaseValue = new StringJoiner("", "", "");

        mStringIncreaseValue.add("");
        mStringIncreaseValue.add("Increase the "+ mFamilyMember.getColor().toLowerCase()+" family member value by"+ mIndex);

        return mStringIncreaseValue.toString();
    }


}
