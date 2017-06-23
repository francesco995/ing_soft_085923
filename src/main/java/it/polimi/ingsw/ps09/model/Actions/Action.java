package it.polimi.ingsw.ps09.model.Actions;

import it.polimi.ingsw.ps09.model.Board;
import it.polimi.ingsw.ps09.model.FamilyMembers.FamilyMember;
import it.polimi.ingsw.ps09.model.Player;

import java.io.InvalidObjectException;

/**
 * Created by francesco995 on 08/06/2017.
 */
public interface Action {

    @Override
    String toString();

    void doAction(Board board, Player player, FamilyMember familyMember, int index) throws UnsupportedOperationException;

    FamilyMember getFamilyMember();

    public int getIndex();
}
