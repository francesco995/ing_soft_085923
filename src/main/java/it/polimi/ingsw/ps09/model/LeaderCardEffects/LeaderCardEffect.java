package it.polimi.ingsw.ps09.model.LeaderCardEffects;

import it.polimi.ingsw.ps09.model.Board;
import it.polimi.ingsw.ps09.model.FamilyMembers.FamilyMember;
import it.polimi.ingsw.ps09.model.Player;

public interface LeaderCardEffect {

    @Override
    String toString();

    boolean isValid (Player player);
    void doAction(Board board, Player player, FamilyMember familyMember, int index) throws UnsupportedOperationException;

}
