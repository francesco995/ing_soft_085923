package it.polimi.ingsw.ps09.model.DevelopmentCardEffects;

import it.polimi.ingsw.ps09.model.Player;

/**
 * Created by franc on 30/05/2017.
 * Permanent Bonus (malus) that block player for gaining bonus when placing FamilyMembers on floors 3 and 4
 */
public class NoFloorBonusEffect implements DevelopmentCardEffect {

    @Override
    public void applyEffect(Player player) {

    }


    @Override
    public String toString(){

        String toString = "";

        toString += "If you place a Family Member on floors 3 or 4, you no longer take the bonus effect";

        return toString;

    }
}
