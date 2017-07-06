package it.polimi.ingsw.ps09.model.LeaderCardEffects;

import it.polimi.ingsw.ps09.model.*;
import it.polimi.ingsw.ps09.model.FamilyMembers.FamilyMember;

/**
 * Created by francesco995 on 19/06/2017.
 */
public class GainPointsAndResources implements LeaderCardEffect {

    private UserResources mUserResourcesRequirements = new UserResources();
    private UserPoints mUserPointsRequirements = new UserPoints();
    private int mCharacterCardsRequired;
    private int mBuildingCardsRequired;
    private int mVentureCardsRequired;
    private int mTerritoryCardsRequired;

    private UserResources mUserResourcesGains = new UserResources();
    private UserPoints mUserPointsGains = new UserPoints();


    /**
     *
     * @param player Object representing the player
     * @return Boolean value, true if the player can apply the effect, otherwise false
     */
    public boolean isValid(Player player){

        //Buonarroti, Botticelli, delle Bande Nere, Savonarola
        if(player.has(mUserPointsRequirements) && player.has(mUserResourcesRequirements))
            return true;

        //Bartolomeo Colleoni
        else if((player.getVenturesCount() == mVentureCardsRequired) && (player.getTerritoriesCount()==mTerritoryCardsRequired))
            return true;

        //Cosimo de' Medici
        else if ((player.getCharactersCount() == mCharacterCardsRequired) && (player.getBuildingsCount()==mBuildingCardsRequired))
            return true;


        return false;

    }

    /**
     *
     * @return Effect's description
     */
    @Override
    public String toString(){

        String toString = "";

        toString += "Gain " + mUserPointsGains.toString() + " and " + mUserResourcesGains.toString();

        return toString;

    }

    @Override
    public void doAction(Board board, Player player, FamilyMember familyMember, int index) throws UnsupportedOperationException {

        player.add(mUserPointsGains);
        player.add(mUserResourcesGains);


    }


}
