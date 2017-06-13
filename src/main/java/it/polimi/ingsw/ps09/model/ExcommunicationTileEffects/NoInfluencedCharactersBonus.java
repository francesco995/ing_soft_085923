package it.polimi.ingsw.ps09.model.ExcommunicationTileEffects;

public class NoInfluencedCharactersBonus extends ExcommunicationTileEffect{
    private boolean mInfluencedCharactersBonus = false;

    @Override
    public String toString(){
        return ("You will no longer get the Conquered territories bonus");
    }
}
