package it.polimi.ingsw.ps09.model.ExcommunicationTileEffects;

import it.polimi.ingsw.ps09.model.Player;

public class NoConqueredTerritoriesBonus implements ExcommunicationTileEffect{
    private boolean mConqueredTerritoriesBonus = false;

    @Override
    public String toString(){
        return ("You will no longer get the Conquered territories bonus");
    }

    @Override
    public void applyEffect(Player player) {

    }
}
