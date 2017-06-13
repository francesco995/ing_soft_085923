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

import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

import static java.util.logging.Level.INFO;

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

        long seed = System.nanoTime();
        Collections.shuffle(game.mUserNames, new Random(seed));

        game.mPlayers = new HashMap<>();
        game.mPlayersOrder = new PlayersOrder(game.mUserIds);

        while (!game.mUserNames.isEmpty()) {
            game.mPlayers.put(
                    game.mUserIds.get(0),
                    new Player(game.mUserNames.get(0),
                            game.mUserColors.get(0),
                            game.mUserIds.get(0),
                            game.mPlayers.size() + 5));

            game.mLogger.log(INFO,
                    "Added a player to game# " + game.GAME_ID +
                            " with userName: " + game.mUserNames.get(0) +
                            ", userColor: " + game.mUserColors.get(0) +
                            ", userId: " + game.mUserIds.get(0));

            game.mUserIds.remove(0);
            game.mUserNames.remove(0);
            game.mUserColors.remove(0);
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
        game.mFaithPointsTrack.loadFromFile();

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
