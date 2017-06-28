package it.polimi.ingsw.ps09.model.Actions.PlacementActions;

import it.polimi.ingsw.ps09.model.Board;
import it.polimi.ingsw.ps09.model.FamilyMembers.FamilyMember;
import it.polimi.ingsw.ps09.model.Player;

/**
 * Created by franc on 28/06/2017.
 */
public class NoAction implements PlacementAction {

    public void doAction(Board board, Player player, FamilyMember familyMember, int index) throws UnsupportedOperationException {

    }

    @Override
    public FamilyMember getFamilyMember() {
        return null;
    }

    @Override
    public int getIndex() {
        return 0;
    }
}
