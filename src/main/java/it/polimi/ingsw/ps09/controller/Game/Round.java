package it.polimi.ingsw.ps09.controller.Game;

import it.polimi.ingsw.ps09.model.Actions.FamilyMemberActions.FamilyMemberAction;
import it.polimi.ingsw.ps09.model.Actions.PlacementActions.PlacementAction;
import it.polimi.ingsw.ps09.model.Actions.AllPlacementActions;
import it.polimi.ingsw.ps09.model.Actions.PlayerActions.PlayerAction;

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

        for(int i = 0; i<4; i++){

            //TODO: increase to maybe 30 seconds
            sleep(5000);

            game.mPlayersOrder.getPlayersOrder().stream().forEach(id -> {

                forceClientsReloadData(game);

                sleep(2000);

                playerDoAction(game, id);

            });
        }



    }

    private static void forceClientsReloadData(Game game){

        game.mPlayersOrder.getPlayersOrder().stream().forEach(id -> {
            game.mConnections.get(id).sendUpdatedData();
        });

    }

    private static void playerDoAction(Game game, int playerID){

        mLogger.log(INFO, "Game: " + Game.GAME_ID + " player " + playerID + " turn to do PlacementAction!");

        ArrayList<PlacementAction> placementActionsList =  AllPlacementActions.getValidPlacementActionsForPlayer(game.mGameBoard, game.mPlayers.get(playerID));
        ArrayList<FamilyMemberAction> familyMemberActionsList = new ArrayList<>(); //TODO: switch to getValidFamilyMembersActionsForPlayer
        ArrayList<PlayerAction> playerActionsList = new ArrayList<>(); //TODO: as previous

        game.mConnections.get(playerID).sendPlacementActionsList(placementActionsList);

        int choice = Integer.valueOf(game.mConnections.get(playerID).getMessage());

        mLogger.log(INFO, "Game: " + Game.GAME_ID + " player " + playerID + " chosen action # " + choice + ": " + placementActionsList.get(choice - 1).toString());

        choice--;

        placementActionsList.get(choice).doAction(
                game.mGameBoard,
                game.mPlayers.get(playerID),
                placementActionsList.get(choice).getFamilyMember(),
                placementActionsList.get(choice).getIndex()
                );
        //TODO: pass a second list of action (moved by 1000) that are not ENDING
    }


}
