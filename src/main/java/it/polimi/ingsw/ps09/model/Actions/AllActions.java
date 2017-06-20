package it.polimi.ingsw.ps09.model.Actions;


import it.polimi.ingsw.ps09.model.Board;
import it.polimi.ingsw.ps09.model.FamilyMembers.FamilyMember;
import it.polimi.ingsw.ps09.model.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by francesco995 on 13/06/2017.
 */
public class  AllActions {

    public static List<Action> getValidActionsForPlayer(Board board, Player player) {

        List<Action> mActionsList = new ArrayList<>();

        ///////CHECK FOR POSSIBLE ACTION IN TOWERS///////
        /////////////////////////////////////////////////
        /////////////////////////////////////////////////
        /////////////////////////////////////////////////


        //Check and add placement actions for Territory Tower
        for (int i = 0; i < 4; i++) {

            if (PlaceFamilyMemberInGreenFloor.isValid
                    (board, i, player, player.getFamilyMember("NEUTRAL")))

                mActionsList.add
                        (new PlaceFamilyMemberInGreenFloor(board, i, player, player.getFamilyMember("NEUTRAL")));


            if (PlaceFamilyMemberInGreenFloor.isValid
                    (board, i, player, player.getFamilyMember("BLACK")))

                mActionsList.add
                        (new PlaceFamilyMemberInGreenFloor(board, i, player, player.getFamilyMember("BLACK")));


            if (PlaceFamilyMemberInGreenFloor.isValid
                    (board, i, player, player.getFamilyMember("ORANGE")))

                mActionsList.add
                        (new PlaceFamilyMemberInGreenFloor(board, i, player, player.getFamilyMember("ORANGE")));


            if (PlaceFamilyMemberInGreenFloor.isValid
                    (board, i, player, player.getFamilyMember("WHITE")))

                mActionsList.add
                        (new PlaceFamilyMemberInGreenFloor(board, i, player, player.getFamilyMember("WHITE")));

        }

        //Check and add placement actions for Character Tower
        for (int i = 0; i < 4; i++) {

            if (PlaceFamilyMemberInBlueFloor.isValid
                    (board, i, player, player.getFamilyMember("NEUTRAL")))

                mActionsList.add
                        (new PlaceFamilyMemberInBlueFloor(board, i, player, player.getFamilyMember("NEUTRAL")));


            if (PlaceFamilyMemberInBlueFloor.isValid
                    (board, i, player, player.getFamilyMember("BLACK")))

                mActionsList.add
                        (new PlaceFamilyMemberInBlueFloor(board, i, player, player.getFamilyMember("BLACK")));


            if (PlaceFamilyMemberInBlueFloor.isValid
                    (board, i, player, player.getFamilyMember("ORANGE")))

                mActionsList.add
                        (new PlaceFamilyMemberInBlueFloor(board, i, player, player.getFamilyMember("ORANGE")));


            if (PlaceFamilyMemberInBlueFloor.isValid
                    (board, i, player, player.getFamilyMember("WHITE")))

                mActionsList.add
                        (new PlaceFamilyMemberInBlueFloor(board, i, player, player.getFamilyMember("WHITE")));

        }

        //Check and add placement actions for Building Tower
        for (int i = 0; i < 4; i++) {

            if (PlaceFamilyMemberInYellowFloor.isValid
                    (board, i, player, player.getFamilyMember("NEUTRAL")))

                mActionsList.add
                        (new PlaceFamilyMemberInYellowFloor(board, i, player, player.getFamilyMember("NEUTRAL")));


            if (PlaceFamilyMemberInYellowFloor.isValid
                    (board, i, player, player.getFamilyMember("BLACK")))

                mActionsList.add
                        (new PlaceFamilyMemberInYellowFloor(board, i, player, player.getFamilyMember("BLACK")));


            if (PlaceFamilyMemberInYellowFloor.isValid
                    (board, i, player, player.getFamilyMember("ORANGE")))

                mActionsList.add
                        (new PlaceFamilyMemberInYellowFloor(board, i, player, player.getFamilyMember("ORANGE")));


            if (PlaceFamilyMemberInYellowFloor.isValid
                    (board, i, player, player.getFamilyMember("WHITE")))

                mActionsList.add
                        (new PlaceFamilyMemberInYellowFloor(board, i, player, player.getFamilyMember("WHITE")));

        }

        //Check and add placement actions for Venture Tower
        for (int i = 0; i < 4; i++) {

            if (PlaceFamilyMemberInPurpleFloor.isValid
                    (board, i, player, player.getFamilyMember("NEUTRAL")))

                mActionsList.add
                        (new PlaceFamilyMemberInPurpleFloor(board, i, player, player.getFamilyMember("NEUTRAL")));


            if (PlaceFamilyMemberInPurpleFloor.isValid
                    (board, i, player, player.getFamilyMember("BLACK")))

                mActionsList.add
                        (new PlaceFamilyMemberInPurpleFloor(board, i, player, player.getFamilyMember("BLACK")));


            if (PlaceFamilyMemberInPurpleFloor.isValid
                    (board, i, player, player.getFamilyMember("ORANGE")))

                mActionsList.add
                        (new PlaceFamilyMemberInPurpleFloor(board, i, player, player.getFamilyMember("ORANGE")));


            if (PlaceFamilyMemberInPurpleFloor.isValid
                    (board, i, player, player.getFamilyMember("WHITE")))

                mActionsList.add
                        (new PlaceFamilyMemberInPurpleFloor(board, i, player, player.getFamilyMember("WHITE")));

        }

        ///////CHECK FOR POSSIBLE ACTION IN BOARD////////
        /////////////////////////////////////////////////
        /////////////////////////////////////////////////
        /////////////////////////////////////////////////

        //Check and add placement action for Council Palace

        if(PlaceFamilyMemberInTheCouncilPalace.isValid(player.getFamilyMember("NEUTRAL")))
            mActionsList.add(new PlaceFamilyMemberInTheCouncilPalace(board, player, player.getFamilyMember("NEUTRAL")));

        if(PlaceFamilyMemberInTheCouncilPalace.isValid(player.getFamilyMember("BLACK")))
            mActionsList.add(new PlaceFamilyMemberInTheCouncilPalace(board, player, player.getFamilyMember("BLACK")));

        if(PlaceFamilyMemberInTheCouncilPalace.isValid(player.getFamilyMember("ORANGE")))
            mActionsList.add(new PlaceFamilyMemberInTheCouncilPalace(board, player, player.getFamilyMember("ORANGE")));

        if(PlaceFamilyMemberInTheCouncilPalace.isValid(player.getFamilyMember("WHITE")))
            mActionsList.add(new PlaceFamilyMemberInTheCouncilPalace(board, player, player.getFamilyMember("WHITE")));

        //Check and add placement action for Market
        for(int i=0; i<3 ; i++) {

            if (PlaceFamilyMemberInMarket.isValid(board, player, player.getFamilyMember("NEUTRAL"), i))
                mActionsList.add(new PlaceFamilyMemberInMarket(board, player, player.getFamilyMember("NEUTRAL"), i));

            if (PlaceFamilyMemberInMarket.isValid(board, player, player.getFamilyMember("BLACK"), i))
                mActionsList.add(new PlaceFamilyMemberInMarket(board, player, player.getFamilyMember("BLACK"), i));

            if (PlaceFamilyMemberInMarket.isValid(board, player, player.getFamilyMember("ORANGE"), i))
                mActionsList.add(new PlaceFamilyMemberInMarket(board, player, player.getFamilyMember("ORANGE"), i));

            if (PlaceFamilyMemberInMarket.isValid(board, player, player.getFamilyMember("WHITE"), i))
                mActionsList.add(new PlaceFamilyMemberInMarket(board, player, player.getFamilyMember("WHITE"), i));

        }

        //Check and add placement action for Harvest

        if (Harvest.isValid(board, player, player.getFamilyMember("NEUTRAL")))
            mActionsList.add(new Harvest(board, player, player.getFamilyMember("NEUTRAL")));

        if (Harvest.isValid(board, player, player.getFamilyMember("BLACK")))
            mActionsList.add(new Harvest(board, player, player.getFamilyMember("BLACK")));

        if (Harvest.isValid(board, player, player.getFamilyMember("ORANGE")))
            mActionsList.add(new Harvest(board, player, player.getFamilyMember("ORANGE")));

        if (Harvest.isValid(board, player, player.getFamilyMember("WHITE")))
            mActionsList.add(new Harvest(board, player, player.getFamilyMember("WHITE")));

        //Check and add placement action for Production

        if(Production.isValid(board, player, player.getFamilyMember("NEUTRAL")))
            mActionsList.add(new Production(board, player, player.getFamilyMember("NEUTRAL")));

        if(Production.isValid(board, player, player.getFamilyMember("BLACK")))
            mActionsList.add(new Production(board, player, player.getFamilyMember("BLACK")));

        if(Production.isValid(board, player, player.getFamilyMember("ORANGE")))
            mActionsList.add(new Production(board, player, player.getFamilyMember("ORANGE")));

        if(Production.isValid(board, player, player.getFamilyMember("WHITE")))
            mActionsList.add(new Production(board, player, player.getFamilyMember("WHITE")));
    //returns list of possible actions
    return mActionsList;
    }
}
