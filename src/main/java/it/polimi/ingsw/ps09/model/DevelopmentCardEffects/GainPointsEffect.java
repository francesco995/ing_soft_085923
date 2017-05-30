package it.polimi.ingsw.ps09.model.DevelopmentCardEffects;

import it.polimi.ingsw.ps09.model.Player;
import it.polimi.ingsw.ps09.model.UserPoints;

public class GainPointsEffect extends  DevelopmentCardEffect{

    //Gains when activated
    private UserPoints mPointsGains;

    @Override
    public void applyEffect(Player player) {

        player.add(mPointsGains);

    }
}
