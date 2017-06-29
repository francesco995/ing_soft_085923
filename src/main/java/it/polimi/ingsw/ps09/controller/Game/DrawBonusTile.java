package it.polimi.ingsw.ps09.controller.Game;

import it.polimi.ingsw.ps09.controller.PlayersOrder;
import it.polimi.ingsw.ps09.model.Decks.PersonalBonusTilesDeck;
import java.util.*;
import java.util.stream.IntStream;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by franc on 29/06/2017.
 */
public class DrawBonusTile {

    public static void startSelection(Game game){


        PlayersOrder mOrder = game.mPlayersOrder;
        List<Integer> mReverseOrder = new ArrayList<>();

        //TODO ASK GIANNI IF PLAYERS ORDER JUST USER ID LIST (integer)
        mOrder.getPlayersOrder().stream().forEach(id -> mReverseOrder.add(id));

        //order actually get reversed
        Collections.reverse(mReverseOrder);

        mReverseOrder.stream().forEach(id -> chooseBonusTile(game));


    }


    private static void chooseBonusTile(Game game){

        int choice = 0;

        //Retrieve choice

       // game.mConnections.get();
       // choice = Integer.valueOf(game.mConnections.get(LeaderCardsOrderList.get(cont).getPlayerID()).getMessage());

        //Add chosen BonusTile to player's BonusTile object
       // game.mPlayers.get(LeaderCardsOrderList.get(cont).getPlayerID()).add(LeaderCardsOrderList.get(cont).getLeaderCardList().get(choice - 1));

        //Remove chosen BonusTile from BonusTile list
         game.mPersonalBonusTilesDeck.getDeck().remove(choice);


    }
}
