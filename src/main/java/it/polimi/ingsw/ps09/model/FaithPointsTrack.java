package it.polimi.ingsw.ps09.model;

import it.polimi.ingsw.ps09.model.Points.FaithPoints;
import it.polimi.ingsw.ps09.model.Points.VictoryPoints;

import java.util.ArrayList;
import java.util.List;

public class FaithPointsTrack {

    private List<VictoryPoints> mVictoryPointsBonus = new ArrayList<VictoryPoints>();
    //carica solo punti vittoria o tutti i bonus ??
    //decisione da prendere
    //caricamento da file json da fare

    /**
     * Returns the Victory Points bonus linked to the ammount of points offered
     * @param offer FaithPoints variable passed by Game
     * @return the ammount of Victory Points that you get by offering to the church 
     */
    public VictoryPoints convertToBonus(FaithPoints offer){

        int ammount = offer.getValue();

        return mVictoryPointsBonus.get(ammount);

    }
}
