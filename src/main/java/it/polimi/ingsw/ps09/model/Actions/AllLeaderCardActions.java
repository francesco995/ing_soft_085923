package it.polimi.ingsw.ps09.model.Actions;

import it.polimi.ingsw.ps09.model.Actions.FamilyMemberActions.FamilyMemberAction;
import it.polimi.ingsw.ps09.model.Actions.FamilyMemberActions.IncreaseFamilyMemberValue;
import it.polimi.ingsw.ps09.model.Actions.LeaderCardActions.DiscardLeaderCard;
import it.polimi.ingsw.ps09.model.Actions.LeaderCardActions.LeaderCardAction;
import it.polimi.ingsw.ps09.model.Actions.LeaderCardActions.OncePerTurnEffects;
import it.polimi.ingsw.ps09.model.Actions.LeaderCardActions.PlayLeaderCard;
import it.polimi.ingsw.ps09.model.Board;
import it.polimi.ingsw.ps09.model.Player;

import java.util.ArrayList;

/**
 * Created by franc on 30/06/2017.
 * It Creates a List of all the leader card actions that a player can do
 */
public class AllLeaderCardActions {
    public static ArrayList<LeaderCardAction> getValidActionsForPlayer(Board board, Player player) {


        ArrayList<LeaderCardAction> mActionsList = new ArrayList<>();


        // CHECK FOR POSSIBILITY OF PLAYING LEADER CARDS FROM HAND
        for( int i=0; i < player.getLeaderCards().size(); i++){
            if (PlayLeaderCard.isValid(player, player.getLeaderCards().get(i)))
                mActionsList.add(new PlayLeaderCard(i)); //see if more things needed
        }


        // CHECK FOR POSSIBILITY OF USING ONCE PER TURN EFFECT OF LEADER CARDS
        for (int i=0; i < player.getLeaderCards().size(); i++){
            if(OncePerTurnEffects.isValid(player, player.getLeaderCards().get(i)))
                mActionsList.add(new OncePerTurnEffects(i));
        }


        // CHECK FOR POSSIBILITY OF DISCARDING LEADER CARD
        for (int i=0; i < player.getLeaderCards().size(); i++){
            if(DiscardLeaderCard.isValid(player, player.getLeaderCards().get(i)))
                mActionsList.add(new DiscardLeaderCard(i));
        }

        //returns list of all valid actions
        return mActionsList;
    }

}
