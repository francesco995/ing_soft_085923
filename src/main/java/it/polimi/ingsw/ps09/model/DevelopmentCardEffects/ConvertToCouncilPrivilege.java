package it.polimi.ingsw.ps09.model.DevelopmentCardEffects;

import it.polimi.ingsw.ps09.model.Player;
import it.polimi.ingsw.ps09.model.UserPoints;
import it.polimi.ingsw.ps09.model.UserResources;

import java.util.List;

/**
 * Created by francesco995 on 04/06/2017.
 * Convert UserResources and/or UserPoints to Council Privilege(s)
 *
 * If more than one choice has to be given to the player, lists will have more than 1 item
 * (ex: mResourcesCosts[0] -> mPrivilegesCount[0] OR mPointsCosts[1] -> mPrivilegesCount[1])
 *
 * empty resources still have to be inserted with "0" values, but will not be printed if empty
 */
public class ConvertToCouncilPrivilege implements DevelopmentCardEffect{

    //Resources or Points cost to activate conversion
    private List<UserResources> mResourcesCosts;
    private List<UserPoints> mPointsCosts;

    private List<Integer> mPrivilegesCount;

    //TODO: controllare se la scelta dell'attivazione va fatta qui o in GameLogic


    public ConvertToCouncilPrivilege(List<UserResources> resourcesCosts,
                         List<UserPoints> pointsCosts,
                         List<Integer> privilegesCount) {

        mResourcesCosts = resourcesCosts;
        mPointsCosts = pointsCosts;
        mPrivilegesCount = privilegesCount;

    }

    /**
     * Apply effect to a Player
     * @param player Player to apply effect to
     */
    @Override
    public void applyEffect(Player player) {

        //TODO: Prompt User for cost/gain 0 or 1

        //cost payments
        player.remove(mResourcesCosts.get(0));
        player.remove(mPointsCosts.get(0));

        //gains for conversion
        player.addCouncilPrivilege(mPrivilegesCount.get(0));

    }


    /**
     * Describe object as a string to CLI Clients
     */
    @Override
    public String toString(){

        String mConvert = "Convert -> ";
        //TODO: FraG fix for list

        for(int i = 0; i < Integer.max(mResourcesCosts.size(), mPointsCosts.size()); i++){
            mConvert +=( "\n        " + Integer.toString(i + 1) + ") " + mResourcesCosts.get(i) + " " + mPointsCosts.get(i) +
                    " To => " + Integer.toString(mPrivilegesCount.get(i)) + " Council Privilege(s)");
        }


        return mConvert;
    }



}
