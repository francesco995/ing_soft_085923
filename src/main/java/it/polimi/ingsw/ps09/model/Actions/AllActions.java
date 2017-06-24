package it.polimi.ingsw.ps09.model.Actions;


import it.polimi.ingsw.ps09.model.Board;
import it.polimi.ingsw.ps09.model.Player;

import java.util.ArrayList;
import java.util.StringJoiner;

/**
 * Created by francesco995 on 13/06/2017.
 */
public class  AllActions {

    public static ArrayList<Action> getValidActionsForPlayer(Board board, Player player) {

        ArrayList<Action> mActionsList = new ArrayList<>();

        ///////CHECK FOR POSSIBLE ACTION IN TOWERS///////
        /////////////////////////////////////////////////
        /////////////////////////////////////////////////
        /////////////////////////////////////////////////


        //Check and add placement actions for Territory Tower
        for (int i = 0; i < 4; i++) {

            if (PlaceFamilyMemberInGreenFloor.isValid
                    (board, player, player.getFamilyMember("NEUTRAL"), i))

                mActionsList.add
                        (new PlaceFamilyMemberInGreenFloor(player.getFamilyMember("NEUTRAL"), i));


            if (PlaceFamilyMemberInGreenFloor.isValid
                    (board, player, player.getFamilyMember("BLACK"), i))

                mActionsList.add
                        (new PlaceFamilyMemberInGreenFloor(player.getFamilyMember("BLACK"), i));


            if (PlaceFamilyMemberInGreenFloor.isValid
                    (board, player, player.getFamilyMember("ORANGE"), i))

                mActionsList.add
                        (new PlaceFamilyMemberInGreenFloor(player.getFamilyMember("ORANGE"), i));


            if (PlaceFamilyMemberInGreenFloor.isValid
                    (board, player, player.getFamilyMember("WHITE"), i))

                mActionsList.add
                        (new PlaceFamilyMemberInGreenFloor(player.getFamilyMember("WHITE"), i));

        }

        //Check and add placement actions for Character Tower
        for (int i = 0; i < 4; i++) {

            if (PlaceFamilyMemberInBlueFloor.isValid
                    (board, player, player.getFamilyMember("NEUTRAL"), i))

                mActionsList.add
                        (new PlaceFamilyMemberInBlueFloor(player.getFamilyMember("NEUTRAL"), i));


            if (PlaceFamilyMemberInBlueFloor.isValid
                    (board, player, player.getFamilyMember("BLACK"), i))

                mActionsList.add
                        (new PlaceFamilyMemberInBlueFloor(player.getFamilyMember("BLACK"), i));


            if (PlaceFamilyMemberInBlueFloor.isValid
                    (board, player, player.getFamilyMember("ORANGE"), i))

                mActionsList.add
                        (new PlaceFamilyMemberInBlueFloor(player.getFamilyMember("ORANGE"), i));


            if (PlaceFamilyMemberInBlueFloor.isValid
                    (board, player, player.getFamilyMember("WHITE"), i))

                mActionsList.add
                        (new PlaceFamilyMemberInBlueFloor(player.getFamilyMember("WHITE"), i));

        }

        //Check and add placement actions for Building Tower
        for (int i = 0; i < 4; i++) {

            if (PlaceFamilyMemberInYellowFloor.isValid
                    (board, player, player.getFamilyMember("NEUTRAL"), i))

                mActionsList.add
                        (new PlaceFamilyMemberInYellowFloor(player.getFamilyMember("NEUTRAL"), i));


            if (PlaceFamilyMemberInYellowFloor.isValid
                    (board, player, player.getFamilyMember("BLACK"), i))

                mActionsList.add
                        (new PlaceFamilyMemberInYellowFloor(player.getFamilyMember("BLACK"), i));


            if (PlaceFamilyMemberInYellowFloor.isValid
                    (board, player, player.getFamilyMember("ORANGE"), i))

                mActionsList.add
                        (new PlaceFamilyMemberInYellowFloor(player.getFamilyMember("ORANGE"), i));


            if (PlaceFamilyMemberInYellowFloor.isValid
                    (board, player, player.getFamilyMember("WHITE"), i))

                mActionsList.add
                        (new PlaceFamilyMemberInYellowFloor(player.getFamilyMember("WHITE"), i));

        }

        //Check and add placement actions for Venture Tower
        for (int i = 0; i < 4; i++) {

            if (PlaceFamilyMemberInPurpleFloor.isValid
                    (board, player, player.getFamilyMember("NEUTRAL"), i))

                mActionsList.add
                        (new PlaceFamilyMemberInPurpleFloor(player.getFamilyMember("NEUTRAL"), i));


            if (PlaceFamilyMemberInPurpleFloor.isValid
                    (board, player, player.getFamilyMember("BLACK"), i))

                mActionsList.add
                        (new PlaceFamilyMemberInPurpleFloor(player.getFamilyMember("BLACK"), i));


            if (PlaceFamilyMemberInPurpleFloor.isValid
                    (board, player, player.getFamilyMember("ORANGE"), i))

                mActionsList.add
                        (new PlaceFamilyMemberInPurpleFloor(player.getFamilyMember("ORANGE"), i));


            if (PlaceFamilyMemberInPurpleFloor.isValid
                    (board, player, player.getFamilyMember("WHITE"), i))

                mActionsList.add
                        (new PlaceFamilyMemberInPurpleFloor(player.getFamilyMember("WHITE"), i));

        }

        ///////CHECK FOR POSSIBLE ACTION IN BOARD////////
        /////////////////////////////////////////////////
        /////////////////////////////////////////////////
        /////////////////////////////////////////////////

        //Check and add placement action for Council Palace

        if(PlaceFamilyMemberInTheCouncilPalace.isValid(player.getFamilyMember("NEUTRAL")))
            mActionsList.add(new PlaceFamilyMemberInTheCouncilPalace(player.getFamilyMember("NEUTRAL"), 0));

        if(PlaceFamilyMemberInTheCouncilPalace.isValid(player.getFamilyMember("BLACK")))
            mActionsList.add(new PlaceFamilyMemberInTheCouncilPalace(player.getFamilyMember("BLACK"), 0));

        if(PlaceFamilyMemberInTheCouncilPalace.isValid(player.getFamilyMember("ORANGE")))
            mActionsList.add(new PlaceFamilyMemberInTheCouncilPalace(player.getFamilyMember("ORANGE"), 0));

        if(PlaceFamilyMemberInTheCouncilPalace.isValid(player.getFamilyMember("WHITE")))
            mActionsList.add(new PlaceFamilyMemberInTheCouncilPalace(player.getFamilyMember("WHITE"), 0));

        //Check and add placement action for Market
        for(int i=0; i<4 ; i++) {

            if (PlaceFamilyMemberInMarket.isValid(board, player, player.getFamilyMember("NEUTRAL"), i))
                mActionsList.add(new PlaceFamilyMemberInMarket(player.getFamilyMember("NEUTRAL"), i));

            if (PlaceFamilyMemberInMarket.isValid(board, player, player.getFamilyMember("BLACK"), i))
                mActionsList.add(new PlaceFamilyMemberInMarket(player.getFamilyMember("BLACK"), i));

            if (PlaceFamilyMemberInMarket.isValid(board, player, player.getFamilyMember("ORANGE"), i))
                mActionsList.add(new PlaceFamilyMemberInMarket(player.getFamilyMember("ORANGE"), i));

            if (PlaceFamilyMemberInMarket.isValid(board, player, player.getFamilyMember("WHITE"), i))
                mActionsList.add(new PlaceFamilyMemberInMarket(player.getFamilyMember("WHITE"), i));

        }

        //Check and add placement action for Harvest

        if (Harvest.isValid(board, player, player.getFamilyMember("NEUTRAL")))
            mActionsList.add(new Harvest(player.getFamilyMember("NEUTRAL")));

        if (Harvest.isValid(board, player, player.getFamilyMember("BLACK")))
            mActionsList.add(new Harvest(player.getFamilyMember("BLACK")));

        if (Harvest.isValid(board, player, player.getFamilyMember("ORANGE")))
            mActionsList.add(new Harvest(player.getFamilyMember("ORANGE")));

        if (Harvest.isValid(board, player, player.getFamilyMember("WHITE")))
            mActionsList.add(new Harvest(player.getFamilyMember("WHITE")));

        //Check and add placement action for Production

        if(Production.isValid(board, player, player.getFamilyMember("NEUTRAL")))
            mActionsList.add(new Production(player.getFamilyMember("NEUTRAL")));

        if(Production.isValid(board, player, player.getFamilyMember("BLACK")))
            mActionsList.add(new Production(player.getFamilyMember("BLACK")));

        if(Production.isValid(board, player, player.getFamilyMember("ORANGE")))
            mActionsList.add(new Production(player.getFamilyMember("ORANGE")));

        if(Production.isValid(board, player, player.getFamilyMember("WHITE")))
            mActionsList.add(new Production(player.getFamilyMember("WHITE")));
    //returns list of possible actions
    return mActionsList;
    }


}
