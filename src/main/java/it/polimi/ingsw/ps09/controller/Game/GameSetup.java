package it.polimi.ingsw.ps09.controller.Game;

import it.polimi.ingsw.ps09.controller.PlayersOrder;
import it.polimi.ingsw.ps09.model.Board;
import it.polimi.ingsw.ps09.model.Decks.DevelopmentCardsDeck;
import it.polimi.ingsw.ps09.model.Decks.ExcommunicationTilesDeck;
import it.polimi.ingsw.ps09.model.Decks.LeaderCardsDeck;
import it.polimi.ingsw.ps09.model.Dices.BlackDice;
import it.polimi.ingsw.ps09.model.Dices.OrangeDice;
import it.polimi.ingsw.ps09.model.Dices.WhiteDice;
import it.polimi.ingsw.ps09.model.FaithPointsTrack;
import it.polimi.ingsw.ps09.model.PersonalBoardBonus;
import it.polimi.ingsw.ps09.model.Player;
import it.polimi.ingsw.ps09.model.Resources.Coins;

import java.io.FileNotFoundException;
import java.util.HashMap;

/**
 * Created by francesco995 on 13/06/2017.
 * Delegate Class to setup the Game Objects for the first time
 */
public class GameSetup {


    private GameSetup(){
    //NO INSTANCE
    }

    /**
     * Setup the game
     *
     * @throws FileNotFoundException
     */
    protected static void setupGame(Game game) throws FileNotFoundException {

        //Create 3 dices
        setupDices(game);

        //Setup the Player objects
        setupPlayers(game);

        //Setup and loads the Deck objects
        setupDecks(game);

        //Setup and loads the bonus
        setupFaithTracksBonus(game);
        setupPersonalBoardBonus(game);

        //Set the Board
        setupBoard(game);

        //Create reference for Game and Players in connections
        updateConnections(game);

        //Alert the players Game is starting
        alertPlayers(game);

    }

    private static void updateConnections(Game game) {

        game.mPlayersOrder.getPlayersOrder().stream().forEach(id -> {
            game.mConnections.get(id).setUserID(id);
            game.mConnections.get(id).setGameData(game.mGameBoard, game.mPlayers, game.mPlayersOrder);
        });


    }

    private static void alertPlayers(Game game) {

        game.mPlayersOrder.getPlayersOrder().stream().forEach(id -> {
            game.mConnections.get(id).sendUpdatedData();
            game.mConnections.get(id).sendMessage(String.valueOf(id));
        });



    }


    /**
     * Setup the Dices
     */
    private static void setupDices(Game game) {

        game.mWhiteDice = new WhiteDice();
        game.mBlackDice = new BlackDice();
        game.mOrangeDice = new OrangeDice();

    }

    /**
     * Creates a new HashMap of Players to userIDs, each player contains his own PersonalBoard
     */
    private static void setupPlayers(Game game) {


        game.mPlayers = new HashMap<>();
        game.mPlayersOrder = new PlayersOrder(game.mUserIds);

        while (!game.mUserNames.isEmpty()) {
            game.mPlayers.put(
                    game.mUserIds.get(0),
                    new Player(game.mUserNames.get(0),
                            game.mUserColors.get(0),
                            game.mUserIds.get(0),
                            5));

            game.mUserIds.remove(0);
            game.mUserNames.remove(0);
            game.mUserColors.remove(0);
        }

        game.mPlayersOrder.shufflePlayers();

        for(int i = 0; i < game.mPlayersOrder.getPlayersOrder().size(); i++){
            game.mPlayers.get(
                    game.mPlayersOrder.getUserIdByIndex(i))
                    .add(new Coins(i));
        }

    }

    /**
     * Loads the 3 card decks
     */
    private static void setupDecks(Game game) throws FileNotFoundException {

        game.mDevelopmentCardsDeck = new DevelopmentCardsDeck();
        game.mExcommunicationTilesDeck = new ExcommunicationTilesDeck();
        game.mLeaderCardsDeck = new LeaderCardsDeck();

    }

    /**
     * Setup for the FaithTracksBonus
     * @throws FileNotFoundException
     */
    private static void setupFaithTracksBonus(Game game) throws FileNotFoundException{

        game.mFaithPointsTrack = new FaithPointsTrack();

    }

    /**
     * Setup for the PersonaBoardBonus
     * @throws FileNotFoundException
     */
    private static void setupPersonalBoardBonus(Game game) throws FileNotFoundException{

        game.mPersonalBoardBonus = new PersonalBoardBonus();

    }

    private static void setupBoard(Game game){
        game.mGameBoard = new Board(
                game.mExcommunicationTilesDeck.drawCard(1),
                game.mExcommunicationTilesDeck.drawCard(2),
                game.mExcommunicationTilesDeck.drawCard(3));
    }


}
