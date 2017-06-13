package it.polimi.ingsw.ps09.controller.Game;

import it.polimi.ingsw.ps09.model.DevelopmentCards.Building;
import it.polimi.ingsw.ps09.model.DevelopmentCards.Character;
import it.polimi.ingsw.ps09.model.DevelopmentCards.Territory;
import it.polimi.ingsw.ps09.model.DevelopmentCards.Venture;

/**
 * Created by francesco995 on 14/06/2017.
 */
public class RoundSetup {

    private RoundSetup(){
        //NO INSTANCE
    }


    /**
     * Prepare the board for a new Round
     */
    protected static void setupRound(Game game) {

        //First clear the Game Board
        game.mGameBoard.clearAll();

        fillTowers(game);
        rollDices(game);

    }


    /**
     * void method that fill the tower with randomly drawn cards from the deck
     */
    private static void fillTowers(Game game) {


        for (int i = 0; i < game.mGameBoard.getTerritoriesTowerFloors().size(); i++) {

            //it fills all the floor no matter how many are there
            game.mGameBoard.setTerritoriesTowerCard(i,
                    (Territory) game.mDevelopmentCardsDeck.drawCard("TERRITORY"));

        }

        for (int i = 0; i < game.mGameBoard.getCharacterTowerFloors().size(); i++) {

            //it fills all the floor no matter how many are there
            game.mGameBoard.setCharacterTowerCard(i,
                    (Character) game.mDevelopmentCardsDeck.drawCard("CHARACTER"));

        }

        for (int i = 0; i < game.mGameBoard.getBuildingsTowerFloors().size(); i++) {

            //it fills all the floor no matter how many are there
            game.mGameBoard.setBuildingsTowerCard(i,
                    (Building) game.mDevelopmentCardsDeck.drawCard("BUILDING"));

        }

        for (int i = 0; i < game.mGameBoard.getVenturesTowerFloors().size(); i++) {
            //it fills all the floor no matter how many are there
            game.mGameBoard.setVenturesTowerCard(i,
                    (Venture) game.mDevelopmentCardsDeck.drawCard("VENTURE"));

        }
    }


    /**
     * Simple method that roll all the dices
     */
    private static void rollDices(Game game) {

        game.mBlackDice.roll();
        game.mWhiteDice.roll();
        game.mOrangeDice.roll();

    }

}
