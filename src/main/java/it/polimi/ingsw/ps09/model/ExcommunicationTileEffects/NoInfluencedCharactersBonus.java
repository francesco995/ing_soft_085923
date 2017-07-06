package it.polimi.ingsw.ps09.model.ExcommunicationTileEffects;

import it.polimi.ingsw.ps09.model.Player;

public class NoInfluencedCharactersBonus implements ExcommunicationTileEffect{
    private boolean mInfluencedCharactersBonus = false;

    @Override
    public String toString(){
        return ("You will no longer get the Conquered territories bonus");
    }

    @Override
    public void applyEffect(Player player) {

    }
}
