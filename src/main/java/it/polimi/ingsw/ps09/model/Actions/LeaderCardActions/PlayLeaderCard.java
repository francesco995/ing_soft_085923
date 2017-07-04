package it.polimi.ingsw.ps09.model.Actions.LeaderCardActions;

import it.polimi.ingsw.ps09.model.Board;
import it.polimi.ingsw.ps09.model.LeaderCard;
import it.polimi.ingsw.ps09.model.Player;

/**
 * Created by franc on 30/06/2017.
 * This actions uses the isValid method and the doAction method of the leaderCard Effect
 */
public class PlayLeaderCard implements LeaderCardAction {

    private int mCardindex;

    public PlayLeaderCard(int cardIndex) {

        mCardindex = cardIndex;

    }

    public static boolean isValid(Player player, LeaderCard leaderCard){

        if (!leaderCard.getLeaderCardEffect().get(0).isValid(player))
            return false ;
        //if reaches here passed all tests
        return true;

    }



    @Override
    public void doAction(Board board, Player player, LeaderCard leaderCard) throws UnsupportedOperationException {

        //here just play the leader card but the action is implemented inside leader card
        //leaderCard.getLeaderCardEffect().get(0).doAction(board, player); //TODO ASK ALE TO IMPLEMENT, ALSO WHY CONSTRUCTOR USES ALL THIS THINGS AND IF NECESSARY
    }
}
