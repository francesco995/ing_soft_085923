package it.polimi.ingsw.ps09.model.Actions.PlacementActions;

import it.polimi.ingsw.ps09.model.Board;
import it.polimi.ingsw.ps09.model.FamilyMembers.FamilyMember;
import it.polimi.ingsw.ps09.model.Player;

/**
 * Created by francesco995 on 08/06/2017.
 */
public interface PlacementAction {

    @Override
    String toString();

    void doAction(Board board, Player player, FamilyMember familyMember, int index) throws UnsupportedOperationException;

    FamilyMember getFamilyMember();

    int getIndex();
}
