package it.polimi.ingsw.ps09.model.ExcommunicationTileEffects;

import it.polimi.ingsw.ps09.model.Player;

/**
 * This effect just says you have no access to market and this will be checked before the action
 */
public class NoMarketAccess implements ExcommunicationTileEffect{

    private boolean mMarketAccess = false;

    @Override
    public String toString(){
        return ("You will no longer get access to market");
    }

    @Override
    public void applyEffect(Player player) {

    }

}
