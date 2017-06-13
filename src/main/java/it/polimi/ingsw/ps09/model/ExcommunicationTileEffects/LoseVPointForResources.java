package it.polimi.ingsw.ps09.model.ExcommunicationTileEffects;

import it.polimi.ingsw.ps09.model.UserResources;

public class LoseVPointForResources extends ExcommunicationTileEffect{
    //how many resources you must have to lose one Victory point
    private UserResources mResources;

    @Override
    public String toString(){
        return ("Lose 1 Victory Points for every -> " + mResources + " you have");
    }
}
