package it.polimi.ingsw.ps09.model.LeaderCardEffects;

import it.polimi.ingsw.ps09.model.Player;
import it.polimi.ingsw.ps09.model.UserPoints;
import it.polimi.ingsw.ps09.model.UserResources;

/**
 * Created by francesco995 on 19/06/2017.
 */
public class GainPointsAndResources extends LeaderCardEffect {

    private UserResources mUserResourcesRequirements;
    private UserPoints mUserPointsRequirements;
    private int mCharacterCardsRequired;
    private int mBuldingCardsRequired;
    private int mVentureCardsRequired;
    private int mTerritoryCardsRequired;

    private UserResources mUserResourcesGains;
    private UserPoints mUserPointsGains;



    public boolean isValid(Player player){

        //Buonarroti, Botticelli, delle Bande Nere, Savonarola
        if(player.has(mUserPointsRequirements) && player.has(mUserResourcesRequirements))
            return true;

        //Bartolomeo Colleoni
        else if((player.getVenturesCount() == mVentureCardsRequired) && (player.getTerritoriesCount()==mTerritoryCardsRequired))
            return true;

        //Cosimo de' Medici
        else if ((player.getCharactersCount() == mCharacterCardsRequired) && (player.getBuildingsCount()==mBuldingCardsRequired))
            return true;


        return false;

    }


}
