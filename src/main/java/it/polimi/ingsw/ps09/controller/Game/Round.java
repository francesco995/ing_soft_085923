package it.polimi.ingsw.ps09.controller.Game;

import it.polimi.ingsw.ps09.model.Actions.Action;
import it.polimi.ingsw.ps09.model.Actions.AllActions;

import java.util.List;

/**
 * Created by francesco995 on 14/06/2017.
 */
public class Round {

    private Round(){
        //NO INSTANCE
    }

    protected static void startRound(Game game, int roundN){

        RoundSetup.setupRound(game);

        game.mPlayersOrder.getPlayersOrder().stream().forEach(id -> {
            playerAction(game, id);
        });



    }

    private static void playerAction(Game game, int playerID){

        List<Action> playerActionsList =  AllActions.getValidActionsForPlayer(game.mGameBoard, game.mPlayers.get(playerID));

        System.out.println("dadada");
    }


}
