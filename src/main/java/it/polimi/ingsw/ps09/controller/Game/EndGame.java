package it.polimi.ingsw.ps09.controller.Game;

import it.polimi.ingsw.ps09.Constants;
import it.polimi.ingsw.ps09.model.Player;
import it.polimi.ingsw.ps09.model.Points.VictoryPoints;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by franc on 05/07/2017.
 */
public class EndGame {


    /**
     * This is the method called for calculating all the final scores and giving last bonus (LAST PHASE)
     */
    private void endGame(Game game) {

        //runs all players
        for (int i = 0; i < game.mPlayers.size(); i++) {

            int total;
            int myRank;
            Player currentPlayer = game.mPlayers.get(i);

            //Conquered territories Bonus//
            ///////////////////////////////

            total = currentPlayer.getTerritoriesCount();
            currentPlayer.add(game.mPersonalBoardBonus.EndTerritoriesBonus(total));

            //Influenced Characters Bonus//
            /////////////////////////

            total = currentPlayer.getCharactersCount();
            currentPlayer.add(game.mPersonalBoardBonus.EndCharactersBonus(total));

            //Encouraged Ventures Bonus//
            ///////////////////////

            //check all player ventures card
            currentPlayer.getPersonalBoard().getBoardVentures()
                    .stream()
                    .forEach(card ->
                            card.getEndGameEffects().stream()
                                    .forEach(effect -> effect.applyEffect(currentPlayer))
                    );

            //Military Strength//
            /////////////////////
            myRank = militaryRank(game, currentPlayer);
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

            VictoryPoints collectedResources = new VictoryPoints(total / 5);
            currentPlayer.add(collectedResources);
        }


    }

    /**
     * This methods receives a player and it returns the rank of his militaryPoints
     *
     * @param game   this param is used to make possible to check for all Players points
     * @param player this param is used as a control for ensuring right values
     * @return
     */
    public int militaryRank(Game game, Player player) {

        int playerRank = 0;
        int playerPoints = player.getMilitaryPoints().getValue();
        List<Integer> rankList = new ArrayList<Integer>();

        //insert all players military points value  into arrayList
        for (int i = 0; i < game.mPlayers.size(); i++)
            rankList.add(player.getMilitaryPoints().getValue());

        Collections.sort(rankList);

        for (int i = 0; i < rankList.size(); i++) {
            if (rankList.get(i) == playerPoints)
                playerRank = Constants.MAX_PLAYERS - i;
        }

        return playerRank;
    }

    //TODO: still need some fixing
    public int victoryRank(Game game, Player player) {

        int playerRank = 0;
        int playerPoints = player.getVictoryPoints().getValue();
        List<Integer> rankList = new ArrayList<Integer>();

        //insert all players military points value  into arrayList
        for (int i = 0; i < game.mPlayers.size(); i++)
            rankList.add(player.getVictoryPoints().getValue());

        Collections.sort(rankList);

        for (int i = 0; i < rankList.size(); i++) {
            if (rankList.get(i) == playerPoints)
                playerRank = Constants.MAX_PLAYERS - i;
        }

        return playerRank;
    }
}
