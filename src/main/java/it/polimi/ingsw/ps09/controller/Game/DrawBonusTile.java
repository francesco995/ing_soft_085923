package it.polimi.ingsw.ps09.controller.Game;

import it.polimi.ingsw.ps09.controller.PlayersOrder;
import it.polimi.ingsw.ps09.model.Decks.PersonalBonusTilesDeck;
import java.util.*;
import java.util.logging.Logger;
import java.util.stream.IntStream;

import java.util.ArrayList;
import java.util.List;

import static java.util.logging.Level.INFO;

/**
 * Created by franc on 29/06/2017.
 */
public abstract class DrawBonusTile {

    //LOGGER
    protected static final Logger mLogger = Logger.getAnonymousLogger();

    public static void startSelection(Game game){


        PlayersOrder mOrder = game.mPlayersOrder;
        List<Integer> mReverseOrder = new ArrayList<>();


        mOrder.getPlayersOrder().stream().forEach(id -> mReverseOrder.add(id));

        //order actually get reversed
        Collections.reverse(mReverseOrder);

        mReverseOrder.stream().forEach(id -> chooseBonusTile(game, id));


    }


    private static void chooseBonusTile(Game game, int playerId){

        game.mConnections.get(playerId).sendPersonalBoardBonusTilesList(game.mPersonalBonusTilesDeck.getDeck());

        int choice;

        //Retrieve choice

        choice = game.mConnections.get(playerId).getPersonalBoardBonusTileChoice();

        choice--;

        mLogger.log(INFO, "Game: " + Game.GAME_ID + " player " +
                playerId + " chosen Personal Board Bonus Tile # " +
                (choice + 1) + ": " + game.mPersonalBonusTilesDeck.getDeck().get(choice).toString());

        //Add chosen BonusTile to player's BonusTile object
        game.mPlayers.get(playerId).getPersonalBoard().setPersonalBonusTile(game.mPersonalBonusTilesDeck.getDeck().get(choice));

        //Remove chosen BonusTile from BonusTile list
         game.mPersonalBonusTilesDeck.getDeck().remove(choice);


    }
}
