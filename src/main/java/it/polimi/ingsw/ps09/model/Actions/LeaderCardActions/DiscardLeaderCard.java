package it.polimi.ingsw.ps09.model.Actions.LeaderCardActions;

import it.polimi.ingsw.ps09.model.Board;
import it.polimi.ingsw.ps09.model.FamilyMembers.FamilyMember;
import it.polimi.ingsw.ps09.model.LeaderCard;
import it.polimi.ingsw.ps09.model.Player;

/**
 * Created by franc on 30/06/2017.
 */
public class DiscardLeaderCard implements LeaderCardAction{

    private int mCardindex;

    public DiscardLeaderCard(int index) {
        mCardindex = index;
    }

    public static boolean isValid(Player player, LeaderCard leaderCard){

        //discarding card is always valid

        return true;

    }


    @Override
    public void doAction(Board board, Player player, LeaderCard leaderCard) throws UnsupportedOperationException {

        //removes card from player hands of cards
        player.getLeaderCards().remove(mCardindex);
        //uses council privilege acquired

    }
}
