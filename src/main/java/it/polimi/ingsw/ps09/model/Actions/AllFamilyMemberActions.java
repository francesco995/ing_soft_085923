package it.polimi.ingsw.ps09.model.Actions;

import it.polimi.ingsw.ps09.model.Actions.FamilyMemberActions.FamilyMemberAction;
import it.polimi.ingsw.ps09.model.Actions.FamilyMemberActions.IncreaseFamilyMemberValue;
import it.polimi.ingsw.ps09.model.Board;
import it.polimi.ingsw.ps09.model.Player;

import java.util.ArrayList;

/**
 * Created by franc on 26/06/2017.
 * It creates the list of all the possibility to increase the family member value
 */
public class AllFamilyMemberActions {
    public static ArrayList<FamilyMemberAction> getValidActionsForPlayer(Board board, Player player) {

        ArrayList<FamilyMemberAction> mActionsList = new ArrayList<>();

        //// CHECK FOR POSSIBLE FAMILY MEMBER ACTION  ///
        /////////////////////////////////////////////////
        /////////////////////////////////////////////////
        /////////////////////////////////////////////////


        //Check and add the possibility to increase the family member value

        int maxNumber = player.getServant().getValue();

        for(int i=1; i<maxNumber; i++) {

            if (IncreaseFamilyMemberValue.isValid(player, player.getFamilyMember("NEUTRAL"), i))
                mActionsList.add
                        (new IncreaseFamilyMemberValue(player.getFamilyMember("NEUTRAL"),i));


            if (IncreaseFamilyMemberValue.isValid(player, player.getFamilyMember("BLACK"), i))
                mActionsList.add
                        (new IncreaseFamilyMemberValue(player.getFamilyMember("BLACK"),i));


            if (IncreaseFamilyMemberValue.isValid(player, player.getFamilyMember("ORANGE"), i))
                mActionsList.add
                        (new IncreaseFamilyMemberValue(player.getFamilyMember("ORANGE"),i));

            if (IncreaseFamilyMemberValue.isValid(player, player.getFamilyMember("WHITE"), i))
                mActionsList.add
                        (new IncreaseFamilyMemberValue(player.getFamilyMember("WHITE"),i));

        }

        return mActionsList;
    }

}
