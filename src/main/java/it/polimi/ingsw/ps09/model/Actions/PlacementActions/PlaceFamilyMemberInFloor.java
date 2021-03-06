package it.polimi.ingsw.ps09.model.Actions.PlacementActions;

import it.polimi.ingsw.ps09.model.FamilyMembers.FamilyMember;

import java.util.StringJoiner;

/**
 * Created by francesco995 on 13/06/2017.
 */
public abstract class PlaceFamilyMemberInFloor implements PlacementAction {

    private int mFloorIndex;
    private FamilyMember mFamilyMember;

    /**
     *
     * @param familyMember Family memeber the player want to place
     * @param index floor's number
     */
    public PlaceFamilyMemberInFloor(FamilyMember familyMember, int index){

        mFloorIndex = index;
        mFamilyMember = familyMember;

    }

    /**
     *
     * @return The family member
     */
    public FamilyMember getFamilyMember(){
        return mFamilyMember;
    }

    /**
     *
     * @return Floor's number
     */
    public int getIndex(){
        return mFloorIndex;
    }

    /**
     *
     * @return A string of the action to perform
     */
    @Override
    public String toString(){

        StringJoiner mStringPlace = new StringJoiner("", "", "");

        mStringPlace.add("");
        mStringPlace.add("Place  " + mFamilyMember.getColor() + " family member into " + mFloorIndex + ".");

        return mStringPlace.toString();

    }


}
