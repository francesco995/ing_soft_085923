package it.polimi.ingsw.ps09.model.LeaderCardEffects;

import it.polimi.ingsw.ps09.model.DevelopmentCards.Venture;
import it.polimi.ingsw.ps09.model.Player;

import java.util.List;

/**
 * Created by walle on 19/06/17.
 */
public class DoHarvestAction {

    private int mVentureCardsRequired;

    public boolean isValid(Player player){

        //Francesco Sforza
        if(player.getVenturesCount()>= mVentureCardsRequired)
            return true;

        return false;

    }
}
