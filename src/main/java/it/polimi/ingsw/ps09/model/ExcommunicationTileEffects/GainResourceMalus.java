package it.polimi.ingsw.ps09.model.ExcommunicationTileEffects;

import it.polimi.ingsw.ps09.model.Player;
import it.polimi.ingsw.ps09.model.UserResources;

/**
 * It applies a malus to the user Resources gains of the desired value marked in the tile file
 */
public class GainResourceMalus implements ExcommunicationTileEffect{

    //everytime you gain a resource of the kind indicated in Excommunication you will receive corresponding malus
    private UserResources mResourcesMalus;

    public UserResources getResourcesMalus() {
        return mResourcesMalus;
    }


    @Override
    public String toString(){
        return ("Resource malus -> " + mResourcesMalus);
    }

    @Override
    public void applyEffect(Player player) {

    }
}

