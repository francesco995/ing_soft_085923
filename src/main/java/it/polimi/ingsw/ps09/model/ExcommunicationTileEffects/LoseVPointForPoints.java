package it.polimi.ingsw.ps09.model.ExcommunicationTileEffects;

import it.polimi.ingsw.ps09.model.Player;
import it.polimi.ingsw.ps09.model.UserPoints;

public class LoseVPointForPoints implements ExcommunicationTileEffect{

    //how many point you must have to lose one Victory point
    private UserPoints mPoints;


    @Override
    public String toString(){
        return ("Lose 1 Victory Points for every -> " + mPoints + "you have");
    }

    @Override
    public void applyEffect(Player player) {
        if(mPoints.getMilitaryPoints().getValue()!=0) {
            player.getBonusFlags().putMalus("loseForVictoryPoints");
        }
        if(mPoints.getFaithPoints().getValue()!=0) {
            player.getBonusFlags().putMalus("loseForVictoryPoints2");
        }
    }

}
