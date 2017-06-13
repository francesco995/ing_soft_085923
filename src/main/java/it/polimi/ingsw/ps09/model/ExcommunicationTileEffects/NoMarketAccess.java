package it.polimi.ingsw.ps09.model.ExcommunicationTileEffects;

/**
 * This effect just says you have no access to market and this will be checked before the action
 */
public class NoMarketAccess extends ExcommunicationTileEffect{

    private boolean mMarketAccess = false;

    @Override
    public String toString(){
        return ("You will no longer get access to market");
    }

}
