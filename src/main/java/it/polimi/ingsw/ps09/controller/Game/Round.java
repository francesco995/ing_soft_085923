package it.polimi.ingsw.ps09.controller.Game;

import it.polimi.ingsw.ps09.model.Actions.Action;
import it.polimi.ingsw.ps09.model.Actions.AllActions;

import java.util.ArrayList;
import java.util.logging.Logger;

import static java.util.logging.Level.INFO;

/**
 * Created by francesco995 on 14/06/2017.
 */
public class Round {

    //LOGGER
    private static final Logger mLogger = Logger.getAnonymousLogger();


    private Round(){
        //NO INSTANCE
    }

    private static void sleep(int mS){

        try {
            Thread.sleep(mS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    protected static void startRound(Game game, int roundN){

        RoundSetup.setupRound(game);

        sleep(5000);

        game.mPlayersOrder.getPlayersOrder().stream().forEach(id -> {

            forceClientsReloadData(game);

            sleep(1000);
            forceClientsReloadData(game);

            sleep(5000);
            forceClientsReloadData(game);

            sleep(5000);
            forceClientsReloadData(game);

            sleep(5000);
            forceClientsReloadData(game);

            sleep(5000);
            forceClientsReloadData(game);

            sleep(5000);
            forceClientsReloadData(game);

            sleep(0500);


            //playerDoAction(game, id);


        });



    }

    private static void playerDoAction(Game game, int playerID){

        mLogger.log(INFO, "Game: " + Game.GAME_ID + " player " + playerID + " turn to do Action!");

        ArrayList<Action> playerActionsList =  AllActions.getValidActionsForPlayer(game.mGameBoard, game.mPlayers.get(playerID));

        game.mConnections.get(playerID).setActions(playerActionsList);

        int choice = Integer.valueOf(game.mConnections.get(playerID).getMessage());


    }

    private static void forceClientsReloadData(Game game){

        game.mPlayersOrder.getPlayersOrder().stream().forEach(id -> {
            game.mConnections.get(id).sendMessage("update");
        });

    }


}
