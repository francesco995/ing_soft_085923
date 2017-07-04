package it.polimi.ingsw.ps09.controller.Game;

import it.polimi.ingsw.ps09.model.DevelopmentCards.Building;
import it.polimi.ingsw.ps09.model.DevelopmentCards.Character;
import it.polimi.ingsw.ps09.model.DevelopmentCards.Territory;
import it.polimi.ingsw.ps09.model.DevelopmentCards.Venture;
import it.polimi.ingsw.ps09.model.Dices.Dice;

import java.util.List;

/**
 * Created by francesco995 on 14/06/2017.
 */
public abstract class RoundSetup {

    private RoundSetup(){
        //NO INSTANCE
    }


    /**
     * Prepare the board for a new Round
     * @param game Game instance
     */
    protected static void setupRound(Game game) {

        //First clear the Game Board
        game.mGameBoard.clearAll();

        fillTowers(game);
        rollDices(game);
        setPlayersFamilyMembers(game);

        

    }


    /**
     * void method that fill the tower with randomly drawn cards from the deck
     * @param game Game instance
     */
    private static void fillTowers(Game game) {

        for (int i = 0; i < 4; i++) {

            game.mGameBoard.setTerritoriesTowerCard(i,
                    (Territory) game.mDevelopmentCardsDeck.drawCard("TERRITORY"));

            game.mGameBoard.setCharacterTowerCard(i,
                    (Character) game.mDevelopmentCardsDeck.drawCard("CHARACTER"));

            game.mGameBoard.setBuildingsTowerCard(i,
                    (Building) game.mDevelopmentCardsDeck.drawCard("BUILDING"));

            game.mGameBoard.setVenturesTowerCard(i,
                    (Venture) game.mDevelopmentCardsDeck.drawCard("VENTURE"));

        }

    }


    /**
     * Simple method that roll all the dices
     * @param game Game instance
     */
    private static void rollDices(Game game) {

        game.mBlackDice.roll();
        game.mWhiteDice.roll();
        game.mOrangeDice.roll();

        //Copy dice value into Board per la view
        game.mGameBoard.setBlackDice(game.mBlackDice.getValue());
        game.mGameBoard.setOrangeDice(game.mOrangeDice.getValue());
        game.mGameBoard.setWhiteDice(game.mWhiteDice.getValue());

    }


    /**
     * Set Family Members as usable and then sets their value to corresponsing dice
     * @param game Game instance
     */
    private static void setPlayersFamilyMembers(Game game){

        game.mPlayersOrder.getPlayersOrder().stream().forEach(iD -> {

            //set as usable again all familyMembers
            game.mPlayers.get(iD).getFamilyMember("NEUTRAL").setUsable();
            game.mPlayers.get(iD).getFamilyMember("BLACK").setUsable();
            game.mPlayers.get(iD).getFamilyMember("WHITE").setUsable();
            game.mPlayers.get(iD).getFamilyMember("ORANGE").setUsable();

            game.mPlayers.get(iD).setFamilyMemberPower("BLACK", game.mBlackDice);
            game.mPlayers.get(iD).setFamilyMemberPower("WHITE", game.mWhiteDice);
            game.mPlayers.get(iD).setFamilyMemberPower("ORANGE", game.mOrangeDice);
            game.mPlayers.get(iD).setFamilyMembersToUsable();
                });

    }

}
