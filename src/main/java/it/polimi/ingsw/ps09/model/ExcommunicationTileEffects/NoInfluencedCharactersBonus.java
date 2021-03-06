package it.polimi.ingsw.ps09.model.ExcommunicationTileEffects;

import it.polimi.ingsw.ps09.model.Player;

public class NoInfluencedCharactersBonus implements ExcommunicationTileEffect{


    @Override
    public String toString(){
        return ("You will no longer get the Conquered character bonus");
    }

    @Override
    public void applyEffect(Player player) {
        player.getBonusFlags().putMalus("noCharacter");
    }
}
