package it.polimi.ingsw.ps09.model.Actions.LeaderCardActions;

import it.polimi.ingsw.ps09.model.Board;
import it.polimi.ingsw.ps09.model.FamilyMembers.FamilyMember;
import it.polimi.ingsw.ps09.model.LeaderCard;
import it.polimi.ingsw.ps09.model.Player;

/**
 * Created by franc on 30/06/2017.
 */
public interface LeaderCardAction {


    @Override
    String toString();

    void doAction(Board board, Player player, LeaderCard leaderCard) throws UnsupportedOperationException;
}
