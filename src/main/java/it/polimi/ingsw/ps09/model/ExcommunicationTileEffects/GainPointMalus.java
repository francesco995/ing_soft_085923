package it.polimi.ingsw.ps09.model.ExcommunicationTileEffects;

import it.polimi.ingsw.ps09.model.UserPoints;

/**
 * It applies a malus to the user Points gain of the desired value marked in the tile file
 */
public class GainPointMalus extends ExcommunicationTileEffect{
    //everytime you gain a resource of the kind indicated in Excommunication you will receive corrisponding malus
    private UserPoints mPointsMalus;

    public UserPoints getPointsMalus() {
        return mPointsMalus;
    }


    @Override
    public String toString(){
        return ("Points malus -> " + mPointsMalus);
    }
}
