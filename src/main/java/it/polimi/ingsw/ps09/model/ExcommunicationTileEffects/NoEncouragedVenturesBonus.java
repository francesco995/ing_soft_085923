package it.polimi.ingsw.ps09.model.ExcommunicationTileEffects;

import it.polimi.ingsw.ps09.model.Player;

public class NoEncouragedVenturesBonus implements ExcommunicationTileEffect{
    private boolean mEncouragedVentureBonus = false;

    @Override
    public String toString(){
        return ("You will no longer get the Encourged Ventures bonus");
    }

    @Override
    public void applyEffect(Player player) {

    }
}
