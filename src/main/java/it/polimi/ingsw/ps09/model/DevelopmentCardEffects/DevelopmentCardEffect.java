package it.polimi.ingsw.ps09.model.DevelopmentCardEffects;

import it.polimi.ingsw.ps09.model.Player;

/**
 * Created by francesco995 on 23/05/2017.
 * Generic interface for Effects used in DevelopmentCards
 */
public interface DevelopmentCardEffect {

    void applyEffect(Player player);

    String toString();

}
