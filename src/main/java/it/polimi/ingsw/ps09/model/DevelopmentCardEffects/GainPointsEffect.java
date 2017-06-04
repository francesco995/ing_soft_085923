package it.polimi.ingsw.ps09.model.DevelopmentCardEffects;

import it.polimi.ingsw.ps09.model.Player;
import it.polimi.ingsw.ps09.model.UserPoints;

public class GainPointsEffect extends  DevelopmentCardEffect{

    //Gains when activated
    private UserPoints mPointsGains;

    public GainPointsEffect(UserPoints pointsGains) {
        mPointsGains = pointsGains;
    }

    @Override
    public String toString(){
        return ("Gain Points -> " + mPointsGains);
    }

    @Override
    public void applyEffect(Player player) {

        player.add(mPointsGains);

    }
}
