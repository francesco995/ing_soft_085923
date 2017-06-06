package it.polimi.ingsw.ps09.model.DevelopmentCardEffects;

import it.polimi.ingsw.ps09.model.Player;

/**
 * Created by franc on 30/05/2017.
 */
public class NoFloorBonusEffect extends DevelopmentCardEffect {

    @Override
    public void applyEffect(Player player) {

        player.noHighFloorBonus();

    }


    @Override
    public String toString(){

        String toString = "";

        toString += "If you place a Family Member on floors 3 or 4, you no longer take the bonus effect";

        return toString;

    }
}
