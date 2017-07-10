package it.polimi.ingsw.ps09.model.ExcommunicationTileEffects;

import it.polimi.ingsw.ps09.model.Player;

/**
 * It applies a malus to the user dice value of the desired value marked in the tile file
 * The value should be entered positive but it will be converted if negative
 */
public class DiceRollMalus implements ExcommunicationTileEffect{

    private int mDiceMalus;

    @Override
    public String toString(){
        return ("Dice Malus -> " + mDiceMalus);
    }

    @Override
    public void applyEffect(Player player) {
        player.getDiceMalus().setMalus(mDiceMalus);
    }
}
