package it.polimi.ingsw.ps09.model.ExcommunicationTileEffects;

public class NoConqueredTerritoriesBonus extends ExcommunicationTileEffect{
    private boolean mConqueredTerritoriesBonus = false;

    @Override
    public String toString(){
        return ("You will no longer get the Conquered territories bonus");
    }
}
