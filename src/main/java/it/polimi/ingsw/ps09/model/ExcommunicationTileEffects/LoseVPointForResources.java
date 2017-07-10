package it.polimi.ingsw.ps09.model.ExcommunicationTileEffects;

import it.polimi.ingsw.ps09.model.Player;
import it.polimi.ingsw.ps09.model.UserResources;

public class LoseVPointForResources implements ExcommunicationTileEffect{

    //how many resources you must have to lose one Victory point
    private UserResources mResources;

    @Override
    public String toString(){
        return ("Lose 1 Victory Points for every -> " + mResources + " you have");
    }

    @Override
    public void applyEffect(Player player) {
        if(mResources.getCoins().getValue()==1) {
            player.getBonusFlags().putMalus("loseForResources");
        }
        else{
            player.getBonusFlags().putMalus("loseForResources2");
        }
    }
}
