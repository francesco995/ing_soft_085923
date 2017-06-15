package it.polimi.ingsw.ps09.model.DevelopmentCardEffects;

import it.polimi.ingsw.ps09.model.Player;
import it.polimi.ingsw.ps09.model.UserPoints;

/**
 * Created by francesco995 on 23/05/2017.
 * Gain UserPoints
 */
public class GainPointsEffect implements DevelopmentCardEffect{

    //Gains when activated
    private UserPoints mPointsGains;

    public GainPointsEffect(UserPoints pointsGains) {
        mPointsGains = pointsGains;
    }

    /**
     * Apply effect to a Player
     * @param player Player to apply effect to
     */
    @Override
    public void applyEffect(Player player) {

        player.add(mPointsGains);

    }


    /**
     * Describe object as a string to CLI Clients
     */
    @Override
    public String toString(){
        return ("Gain Points -> " + mPointsGains);
    }
}
