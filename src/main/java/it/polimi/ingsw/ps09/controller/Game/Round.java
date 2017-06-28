package it.polimi.ingsw.ps09.controller.Game;

import it.polimi.ingsw.ps09.model.Actions.AllFamilyMemberActions;
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
        ArrayList<FamilyMemberAction> familyMemberActionsList = AllFamilyMemberActions.getValidActionsForPlayer(game.mGameBoard, game.mPlayers.get(playerID));
        ArrayList<PlayerAction> playerActionsList = new ArrayList<>(); //TODO: as previous

        game.mConnections.get(playerID).sendPlacementActionsList(placementActionsList);
        game.mConnections.get(playerID).sendFamilyMemberActionsList(familyMemberActionsList);

        game.mConnections.get(playerID).waitActionReady();

        int choice = Integer.valueOf(game.mConnections.get(playerID).getActionChoice());
        choice--;

        switch(game.mConnections.get(playerID).getActionType()){

            case "PLACEMENT": {

                mLogger.log(INFO, "Game: " + Game.GAME_ID + " player " + playerID + " chosen action # " + choice + ": " + placementActionsList.get(choice - 1).toString());

                placementActionsList.get(choice).doAction(
                        game.mGameBoard,
                        game.mPlayers.get(playerID),
                        placementActionsList.get(choice).getFamilyMember(),
                        placementActionsList.get(choice).getIndex()
                );

                break;
            }

            case "FAMILY_MEMBER": {

                mLogger.log(INFO, "Game: " + Game.GAME_ID + " player " + playerID + " chosen action # " + choice + ": " + familyMemberActionsList.get(choice - 1).toString());

                familyMemberActionsList.get(choice).doAction(
                        game.mGameBoard,
                        game.mPlayers.get(playerID),
                        familyMemberActionsList.get(choice).getFamilyMember(),
                        familyMemberActionsList.get(choice).getIndex()
                );

                break;
            }

            case "PLAYER": {

                break;
            }


        }





        //TODO: pass a second list of action (moved by 1000) that are not ENDING
    }


}
