package it.polimi.ingsw.ps09.model.ExcommunicationTileEffects;

import it.polimi.ingsw.ps09.model.Player;

public interface ExcommunicationTileEffect {

    String toString();
    void applyEffect( Player player );
    
}
