package it.polimi.ingsw.ps09.model.Actions;

import it.polimi.ingsw.ps09.model.Board;
import it.polimi.ingsw.ps09.model.FamilyMembers.FamilyMember;
import it.polimi.ingsw.ps09.model.Player;

/**
 * Created by francesco995 on 13/06/2017.
 */
public class PlaceFamilyMemberInFloor extends Action {

    private Board mBoard;
    private int mFloorIndex;
    private Player mPlayer;
    private FamilyMember mFamilyMember;

    public PlaceFamilyMemberInFloor(Board board, int floorIndex, Player player, FamilyMember familyMember){

        mBoard = board;
        mFloorIndex = floorIndex;
        mPlayer = player;
        mFamilyMember = familyMember;

    }

}
