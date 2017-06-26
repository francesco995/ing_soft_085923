package it.polimi.ingsw.ps09.model.Actions;

import it.polimi.ingsw.ps09.model.Actions.FamilyMemberActions.FamilyMemberAction;
import it.polimi.ingsw.ps09.model.Actions.FamilyMemberActions.IncreaseFamilyMemberValue;
import it.polimi.ingsw.ps09.model.Board;
import it.polimi.ingsw.ps09.model.Player;

import java.util.ArrayList;

/**
 * Created by franc on 26/06/2017.
 */
public class AllFamilyMemberActions {
    public static ArrayList<FamilyMemberAction> getValidActionsForPlayer(Board board, Player player /*or maybe here the index*/) {

        ArrayList<FamilyMemberAction> mActionsList = new ArrayList<>();

        //// CHECK FOR POSSIBLE FAMILY MEMBER ACTION  ///
        /////////////////////////////////////////////////
        /////////////////////////////////////////////////
        /////////////////////////////////////////////////


        //Check and add the possibility to increase the family member value

        //we need to call the prompter and ask for the number of servant he wants to donate
        int index = 0;
        //here we do the index = call

        if (IncreaseFamilyMemberValue.isValid(player, player.getFamilyMember("NEUTRAL"),index))
            mActionsList.add
                    (new IncreaseFamilyMemberValue(player.getFamilyMember("NEUTRAL")));


        if (IncreaseFamilyMemberValue.isValid(player, player.getFamilyMember("BLACK"),index))
            mActionsList.add
                    (new IncreaseFamilyMemberValue(player.getFamilyMember("BLACK")));


        if (IncreaseFamilyMemberValue.isValid(player, player.getFamilyMember("ORANGE"),index))
            mActionsList.add
                    (new IncreaseFamilyMemberValue(player.getFamilyMember("ORANGE")));

        if (IncreaseFamilyMemberValue.isValid(player, player.getFamilyMember("WHITE"),index))
            mActionsList.add
                    (new IncreaseFamilyMemberValue(player.getFamilyMember("WHITE")));


        return mActionsList;
    }

}
