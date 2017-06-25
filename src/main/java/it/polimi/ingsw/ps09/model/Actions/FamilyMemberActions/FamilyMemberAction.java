package it.polimi.ingsw.ps09.model.Actions.FamilyMemberActions;

import it.polimi.ingsw.ps09.model.Board;
import it.polimi.ingsw.ps09.model.FamilyMembers.FamilyMember;
import it.polimi.ingsw.ps09.model.Player;

/**
 * Created by francesco995 on 25/06/2017.
 */
public interface FamilyMemberAction {


    @Override
    String toString();

    void doAction(Board board, Player player, FamilyMember familyMember, int index) throws UnsupportedOperationException;

    FamilyMember getFamilyMember();

    public int getIndex();


}
