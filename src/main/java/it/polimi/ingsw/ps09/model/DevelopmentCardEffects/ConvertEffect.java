package it.polimi.ingsw.ps09.model.DevelopmentCardEffects;

import it.polimi.ingsw.ps09.controller.Game.Game;
import it.polimi.ingsw.ps09.model.Player;
import it.polimi.ingsw.ps09.model.UserPoints;
import it.polimi.ingsw.ps09.model.UserResources;

import java.util.List;
import java.util.StringJoiner;


/**
 * Created by francesco995 on 04/06/2017.
 * Convert UserResources and UserPoints
 *
 * If more than one choice has to be given to the player, lists will have more than 1 item
 * (ex: mResourcesCosts[0] -> mPointsGains[0] OR mPointsCosts[1] -> mResourcesGains[1])
 *
 * empty resources still have to be inserted with "0" values, but will not be printed if empty
 */
public class ConvertEffect implements DevelopmentCardEffect{

    //Resources or Points cost to activate conversion
    private List<UserResources> mResourcesCosts;
    private List<UserPoints> mPointsCosts;

    //Resources or Point gained in conversion

    private List<UserResources> mResourcesGains;
    private List<UserPoints> mPointsGains;

    //TODO: controllare se la scelta dell'attivazione va fatta qui o in GameLogic


    public ConvertEffect(List<UserResources> resourcesCosts,
                         List<UserPoints> pointsCosts,
                         List<UserResources> resourcesGains,
                         List<UserPoints> pointsGains) {

        mResourcesCosts = resourcesCosts;
        mPointsCosts = pointsCosts;
        mResourcesGains = resourcesGains;
        mPointsGains = pointsGains;

    }


    /**
     * Apply effect to a Player
     * @param player Player to apply effect to
     */
    @Override
    public void applyEffect(Player player) {

        //TODO: Prompt User for cost/gain 0 or 1

        if(player.has(mResourcesCosts.get(0)) && player.has(mPointsCosts.get(0))){
            //cost payments
            player.remove(mResourcesCosts.get(0));
            player.remove(mPointsCosts.get(0));

            //gains for conversion
            player.add(mResourcesGains.get(0));
            player.add(mPointsGains.get(0));
        }


    }


    /**
     * Describe object as a string to CLI Clients
     */
    @Override
    public String toString(){

        String mConvert = "Convert -> ";
        //TODO: FraG fix for list

        for(int i = 0; i < Integer.max(mResourcesCosts.size(), mPointsCosts.size()); i++){
            mConvert +=( "\n        " + Integer.toString(i + 1) + ") ");

            if(mResourcesCosts.get(i).isGreaterOrEqual(
                    new UserResources(1, 1, 1, 1))){
                mConvert += mResourcesCosts.get(i);
            }

            if(mPointsCosts.get(i).isGreaterOrEqual(
                    new UserPoints(1, 1, 1))){
                mConvert += mPointsCosts.get(i);
            }


            mConvert += " To => ";

            if(mResourcesGains.get(i).isGreaterOrEqual(
                    new UserResources(1, 1, 1, 1))){
                mConvert += mResourcesGains.get(i);
            }

            if(mPointsGains.get(i).isGreaterOrEqual(
                    new UserPoints(1, 1, 1))){
                mConvert += mPointsGains.get(i);
            }

        }


        return mConvert;
    }
}
