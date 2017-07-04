package it.polimi.ingsw.ps09.model.LeaderCardEffects;

import it.polimi.ingsw.ps09.model.Board;
import it.polimi.ingsw.ps09.model.FamilyMembers.FamilyMember;
import it.polimi.ingsw.ps09.model.Player;

public class FrancescoSforza implements LeaderCardEffect {
    @Override
    public String toString() {
        return null;
    }

    @Override
    public boolean isValid(Player player) {
        return false;
    }

    @Override
    public void doAction(Board board, Player player, FamilyMember familyMember, int index) throws UnsupportedOperationException {

    }
}
