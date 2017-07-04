package it.polimi.ingsw.ps09.model.Actions.LeaderCardActions;

import it.polimi.ingsw.ps09.model.Board;
import it.polimi.ingsw.ps09.model.LeaderCard;
import it.polimi.ingsw.ps09.model.Player;

/**
 * Created by franc on 30/06/2017.
 */
public class OncePerTurnEffects implements LeaderCardAction{

    private int mCardIndex;

    public OncePerTurnEffects(int cardIndex) {

        mCardIndex = cardIndex;

    }

    public static boolean isValid(Player player, LeaderCard leaderCard){

        //if reaches here passed all tests
        return true;

    }

    @Override
    public void doAction(Board board, Player player, LeaderCard leaderCard) throws UnsupportedOperationException {

        //todo still needs to implement check
    }
}
