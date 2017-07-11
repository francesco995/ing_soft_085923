package it.polimi.ingsw.ps09.controller.Game;

import it.polimi.ingsw.ps09.Constants;
import it.polimi.ingsw.ps09.controller.PlayersOrder;
import it.polimi.ingsw.ps09.model.Player;
import it.polimi.ingsw.ps09.model.Points.VictoryPoints;

import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import static java.util.logging.Level.INFO;
import static javafx.scene.input.KeyCode.K;
import static javafx.scene.input.KeyCode.V;

/**
 * Created by franc on 05/07/2017.
 */
public class EndGame {


    /**
     * This method is used to add all the victory points based on:
     * -Conquered territories
     * -Influenced Characters
     * -Military Strength
     * -Collected Resources
     */
    public static void endGame(Game game) {


        //LOGGER
        Logger mLogger = Logger.getAnonymousLogger();
        mLogger.log(INFO, "Game: " + game.GAME_ID +
                " starting end game phase ");


        //updates all players
        for (int i = 0; i < game.mPlayers.size(); i++) {

            int total;
            int myRank;
            Player currentPlayer = game.mPlayers.get(game.mPlayersOrder.getPlayersOrder().get(i));
            mLogger.log(INFO, "Game: " + game.GAME_ID +
                    " player " + currentPlayer.getUserName());


            //Conquered territories Bonus//
            ///////////////////////////////
            //check for excommunication malus

            if(!currentPlayer.getBonusFlags().getMalus("noTerritories"))
            {
                mLogger.log(INFO, "Game: " + game.GAME_ID +
                        " adding conquered territories bonus");
                total = currentPlayer.getTerritoriesCount();
                currentPlayer.add(game.mPersonalBoardBonus.EndTerritoriesBonus(total));
            }
            //Influenced Characters Bonus//
            /////////////////////////
            //check for excommunication malus

            if (!currentPlayer.getBonusFlags().getMalus("noCharacter"))
            {
                mLogger.log(INFO, "Game: " + game.GAME_ID +
                        " adding influenced character bonus");
                total = currentPlayer.getCharactersCount();
                currentPlayer.add(game.mPersonalBoardBonus.EndCharactersBonus(total));
            }
            //Encouraged Ventures Bonus//
            ///////////////////////
            //check for excommunication malus

            if(!currentPlayer.getBonusFlags().getMalus("noVenture"))
            {
                mLogger.log(INFO, "Game: " + game.GAME_ID +
                        " adding encouraged ventures");
                //check all player ventures card
                currentPlayer.getPersonalBoard().getBoardVentures()
                        .stream()
                        .forEach(card ->
                                card.getEndGameEffects().stream()
                                        .forEach(effect -> effect.applyEffect(currentPlayer))
                        );
            }
            //Military Strength//
            /////////////////////
            myRank = militaryRank(game, currentPlayer);
            mLogger.log(INFO, "Game: " + game.GAME_ID +
                    " player " + currentPlayer.getUserName() + " military rank " + myRank);

            if (myRank == 1)
                currentPlayer.add(new VictoryPoints(Constants.FIRST_MILITARY));
            else if (myRank == 2)
                currentPlayer.add(new VictoryPoints(Constants.SECOND_MILITARY));

            //Collected resources bonus//
            /////////////////////////////
            total =
                    currentPlayer.getWood().getValue() +
                            currentPlayer.getStone().getValue() +
                            currentPlayer.getCoins().getValue() +
                            currentPlayer.getServant().getValue();
            mLogger.log(INFO, "Game: " + game.GAME_ID +
                    " player " + currentPlayer.getUserName() + " collected resources (/5) " + total);

            VictoryPoints collectedResources = new VictoryPoints(total / 5);
            currentPlayer.add(collectedResources);

            //Excommunication only malus//
            /////////////////////////////

            if(currentPlayer.getBonusFlags().getMalus("loseForVictoryPoints"))
            {
                mLogger.log(INFO, "Game: " + game.GAME_ID +
                        " losing one victory for every military");

                total= currentPlayer.getMilitaryPoints().getValue();
                VictoryPoints numberOfMilitaryPoints = new VictoryPoints(total);

                if(currentPlayer.has(numberOfMilitaryPoints)) {
                    currentPlayer.remove(numberOfMilitaryPoints);
                }else{
                    currentPlayer.setVictoryPointsZero();
                }
            }

            if(currentPlayer.getBonusFlags().getMalus("loseForVictoryPoints2"))
            {
                mLogger.log(INFO, "Game: " + game.GAME_ID +
                        " losing one victory for every 5 victory");

                total= currentPlayer.getFaithPoints().getValue();
                VictoryPoints numberOfFaithPoints = new VictoryPoints(total / 5);

                if(currentPlayer.has(numberOfFaithPoints)) {
                    currentPlayer.remove(numberOfFaithPoints);
                }else{
                    currentPlayer.setVictoryPointsZero();
                }
            }

            if(currentPlayer.getBonusFlags().getMalus("loseForResources")) {
                mLogger.log(INFO, "Game: " + game.GAME_ID +
                        " losing one victory for each resource");

                total =
                        currentPlayer.getWood().getValue() +
                                currentPlayer.getStone().getValue() +
                                currentPlayer.getCoins().getValue() +
                                currentPlayer.getServant().getValue();

                VictoryPoints numberOfResources = new VictoryPoints(total);

                if(currentPlayer.has(numberOfResources)) {
                    currentPlayer.remove(numberOfResources);
                }else{
                    currentPlayer.setVictoryPointsZero();
                }
            }

            if(currentPlayer.getBonusFlags().getMalus("loseForResources2")) {
                mLogger.log(INFO, "Game: " + game.GAME_ID +
                        " losing one victory for each wood and stone");

                total =
                        currentPlayer.getWood().getValue() +
                                currentPlayer.getStone().getValue();

                VictoryPoints numberOfResources = new VictoryPoints(total);

                if(currentPlayer.has(numberOfResources)) {
                    currentPlayer.remove(numberOfResources);
                }else{
                    currentPlayer.setVictoryPointsZero();
                }
            }
        }

        //after calculating all points force client to reload board
        forceClientsReloadData(game);
        game.mPlayersOrder.getPlayersOrder().stream().forEach(id -> {
            game.mConnections.get(id).endGame();
        });

        /**
         * This methods forces all the clients to refresh
         */
    }

    private static void forceClientsReloadData(Game game) {

        game.mPlayersOrder.getPlayersOrder().stream().forEach(id -> {
            game.mConnections.get(id).sendUpdatedData();
        });

    }

    /**
     * This methods receives a player and it returns the rank of his militaryPoints compared to other players
     *
     * @param game   this param is used to make possible to check for all Players points
     * @param player this param is used as a control for ensuring right values
     * @return
     */
    private static int militaryRank(Game game, Player player) {

        int playerRank = 0;
        int playerPoints = player.getMilitaryPoints().getValue();
        List<Integer> rankList = new ArrayList<Integer>();

        //insert all players military points value  into arrayList
        for (int i = 0; i < game.mPlayers.size(); i++)
            rankList.add(game.mPlayers.get(game.mPlayersOrder.getPlayersOrder().get(i)).getMilitaryPoints().getValue());

        Collections.sort(rankList);

        for (int i = 0; i < rankList.size(); i++) {
            if (rankList.get(i) == playerPoints)
                playerRank = game.mPlayers.size() - i;
        }

        return playerRank;
    }
}
