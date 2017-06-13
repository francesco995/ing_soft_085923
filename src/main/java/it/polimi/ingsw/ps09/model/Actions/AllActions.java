package it.polimi.ingsw.ps09.model.Actions;


import it.polimi.ingsw.ps09.model.Board;
import it.polimi.ingsw.ps09.model.FamilyMembers.FamilyMember;
import it.polimi.ingsw.ps09.model.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by francesco995 on 13/06/2017.
 */
public class AllActions {

    public static List<Action> getValidActionsForPlayer(Board board, Player player){

        List<Action> mActionsList = new ArrayList<>();


        //Check and add placement actions for Territory Tower
        for(int i = 0; i <=4; i++){

            if(PlaceFamilyMemberInGreenFloor.isValid
                    (board, i, player, player.getFamilyMember("NEUTRAL")))

                mActionsList.add
                        (new PlaceFamilyMemberInGreenFloor(board, i, player, player.getFamilyMember("NEUTRAL")));


            if(PlaceFamilyMemberInGreenFloor.isValid
                    (board, i, player, player.getFamilyMember("BLACK")))

                mActionsList.add
                        (new PlaceFamilyMemberInGreenFloor(board, i, player, player.getFamilyMember("BLACK")));


            if(PlaceFamilyMemberInGreenFloor.isValid
                    (board, i, player, player.getFamilyMember("ORANGE")))

                mActionsList.add
                        (new PlaceFamilyMemberInGreenFloor(board, i, player, player.getFamilyMember("ORANGE")));


            if(PlaceFamilyMemberInGreenFloor.isValid
                    (board, i, player, player.getFamilyMember("WHITE")))

                mActionsList.add
                        (new PlaceFamilyMemberInGreenFloor(board, i, player, player.getFamilyMember("WHITE")));

        }


        return mActionsList;

    }





}
