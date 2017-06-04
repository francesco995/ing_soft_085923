package it.polimi.ingsw.ps09.model.DevelopmentCardEffects;

import it.polimi.ingsw.ps09.model.Player;
import it.polimi.ingsw.ps09.model.UserPoints;
import it.polimi.ingsw.ps09.model.UserResources;

import java.util.List;

/**
 * Created by francesco995 on 04/06/2017.
 */
public class ConvertToCouncilPrivilege extends DevelopmentCardEffect{

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


    @Override
    public void applyEffect(Player player) {

        //TODO: Prompt User for cost/gain 0 or 1

        //cost payments
        player.remove(mResourcesCosts.get(0));
        player.remove(mPointsCosts.get(0));

        //gains for conversion
        //TODO: gain council privilege

    }



}
