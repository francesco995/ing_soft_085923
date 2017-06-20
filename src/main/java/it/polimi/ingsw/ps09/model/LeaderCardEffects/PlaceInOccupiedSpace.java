package it.polimi.ingsw.ps09.model.LeaderCardEffects;

import it.polimi.ingsw.ps09.model.Player;

/**
 * Created by walle on 19/06/17.
 */
public class PlaceInOccupiedSpace {

    private int mCharacterCardsRequired;


    public boolean isValid(Player player){

        //Ludovico Ariosto
        if(player.getCharactersCount() >= mCharacterCardsRequired)
            return true;

        return false;

    }

    @Override
    public String toString(){

        String toString = "";

        toString += "You can place your family members into occupied action spaces. ";

        return toString;

    }

}
