package it.polimi.ingsw.ps09.model.Actions;

import it.polimi.ingsw.ps09.model.Board;
import it.polimi.ingsw.ps09.model.FamilyMembers.FamilyMember;
import it.polimi.ingsw.ps09.model.Player;

/**
 * Created by francesco995 on 13/06/2017.
 */
public class PlaceFamilyMemberInFloor extends Action {

    private int mFloorIndex;
    private FamilyMember mFamilyMember;

    public PlaceFamilyMemberInFloor(int floorIndex, FamilyMember familyMember){

        mFloorIndex = floorIndex;
        mFamilyMember = familyMember;

    }

}
