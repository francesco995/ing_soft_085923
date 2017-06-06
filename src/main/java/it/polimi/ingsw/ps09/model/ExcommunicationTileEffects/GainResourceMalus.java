package it.polimi.ingsw.ps09.model.ExcommunicationTileEffects;

import it.polimi.ingsw.ps09.model.UserResources;

/**
 * It applies a malus to the user Resources gains of the desired value marked in the tile file
 */
public class GainResourceMalus extends ExcommunicationTileEffect{

        //everytime you gain a resource of the kind indicated in Excommunication you will receive corrisponding malus
        private UserResources mResourcesMalus;

    public UserResources getResourcesMalus() {
        return mResourcesMalus;
    }
}

