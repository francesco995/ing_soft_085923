package it.polimi.ingsw.ps09.model.ExcommunicationTileEffects;

import it.polimi.ingsw.ps09.model.Player;
import it.polimi.ingsw.ps09.model.UserPoints;

public class LoseVPointForPoints implements ExcommunicationTileEffect{
    //how many Victory point you must have to lose one Victory point
    private UserPoints mPoints;


    @Override
    public String toString(){
        return ("Lose 1 Victory Points for every -> " + mPoints + "you have");
    }

    @Override
    public void applyEffect(Player player) {

    }

}
