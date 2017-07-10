package it.polimi.ingsw.ps09.controller.Game;

import it.polimi.ingsw.ps09.model.Actions.AllFamilyMemberActions;
import it.polimi.ingsw.ps09.model.Actions.FamilyMemberActions.FamilyMemberAction;
import it.polimi.ingsw.ps09.model.Actions.PlacementActions.PlacementAction;
import it.polimi.ingsw.ps09.model.Actions.AllPlacementActions;
import it.polimi.ingsw.ps09.model.Actions.PlayerActions.PlayerAction;
import it.polimi.ingsw.ps09.model.UserPoints;
import it.polimi.ingsw.ps09.model.UserResources;

import java.util.ArrayList;
import java.util.logging.Logger;

import static java.util.logging.Level.INFO;

/**
 * Created by francesco995 on 14/06/2017.
 */
public abstract class Round {

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

        sleep(2000);

        mLogger.log(INFO, "Game: " + Game.GAME_ID + " starting round #" + roundN);


        game.mPlayersOrder.getPlayersOrder().stream().forEach(id -> {
            game.mConnections.get(id).alertNewRound(roundN);
        });

        forceClientsReloadData(game);

        for(int i = 0; i<4; i++){

            //TODO: increase to maybe 30 seconds
            sleep(3000);

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

        ArrayList<PlacementAction> placementActionsList;
        ArrayList<FamilyMemberAction> familyMemberActionsList;
        ArrayList<PlayerAction> playerActionsList; //TODO: as previous


        boolean done = false;

        while(!done){

            //Calculate all valid actions for player
            familyMemberActionsList = AllFamilyMemberActions.getValidActionsForPlayer(game.mGameBoard, game.mPlayers.get(playerID));
            placementActionsList = AllPlacementActions.getValidPlacementActionsForPlayer(game.mGameBoard, game.mPlayers.get(playerID));
            playerActionsList = new ArrayList<>();

            //Send valid actions to player
            game.mConnections.get(playerID).sendPlacementActionsList(placementActionsList);
            game.mConnections.get(playerID).sendFamilyMemberActionsList(familyMemberActionsList);
            game.mConnections.get(playerID).waitActionReady();

            //Get action choice
            int choice = Integer.valueOf(game.mConnections.get(playerID).getActionChoice());
            choice--;

            switch(game.mConnections.get(playerID).getActionType()){

                case "PLACEMENT": {

                    mLogger.log(INFO, "Game: " + Game.GAME_ID + " player " +
                            playerID + " chosen action # " +
                            (choice + 1) + ": " + placementActionsList.get(choice).toString());

                    placementActionsList.get(choice).doAction(
                            game.mGameBoard,
                            game.mPlayers.get(playerID),
                            placementActionsList.get(choice).getFamilyMember(),
                            placementActionsList.get(choice).getIndex()
                    );

                    done = true;
                    game.mConnections.get(playerID).resetActionReady();
                    break;
                }

                case "FAMILY_MEMBER": {

                    mLogger.log(INFO, "Game: " + Game.GAME_ID + " player " +
                            playerID + " chosen action # " +
                            (choice + 1) + ": " + familyMemberActionsList.get(choice).toString());

                    familyMemberActionsList.get(choice).doAction(
                            game.mGameBoard,
                            game.mPlayers.get(playerID),
                            familyMemberActionsList.get(choice).getFamilyMember(),
                            familyMemberActionsList.get(choice).getIndex()
                    );
                    game.mConnections.get(playerID).resetActionReady();
                    break;
                }

                case "PLAYER": {

                    break;
                }


            }


            if(game.mPlayers.get(playerID).getCouncilPrivilege() > 0){

                mLogger.log(INFO, "Game: " + Game.GAME_ID + " player " +
                        playerID + " has Council Privilege to choose ");

                game.mConnections.get(playerID).waitCouncilPrivilegeChoice(
                        game.mPlayers.get(playerID).getCouncilPrivilege());

                ArrayList<Integer> councilChoices = game.mConnections.get(playerID).getCouncilPrivilegeChoices();

                ArrayList<UserResources> councilResources = new ArrayList<>();
                councilResources.add(new UserResources(0, 0, 1, 1));
                councilResources.add(new UserResources(0, 2, 0, 0));
                councilResources.add(new UserResources(2, 0, 0, 0));
                councilResources.add(new UserResources(0, 0, 0, 0));
                councilResources.add(new UserResources(0, 0, 0, 0));


                ArrayList<UserPoints> councilPoints = new ArrayList<>();
                councilPoints.add(new UserPoints(0, 0, 0));
                councilPoints.add(new UserPoints(0, 0, 0));
                councilPoints.add(new UserPoints(0, 0, 0));
                councilPoints.add(new UserPoints(0, 2, 0));
                councilPoints.add(new UserPoints(1, 0, 0));

                councilChoices.stream().forEach(i -> {
                    game.mPlayers.get(playerID).add(councilResources.get(i-1));
                    game.mPlayers.get(playerID).add(councilPoints.get(i-1));
                });

                game.mPlayers.get(playerID).resetCouncilPrivilege();

            }





        }



    }


}
