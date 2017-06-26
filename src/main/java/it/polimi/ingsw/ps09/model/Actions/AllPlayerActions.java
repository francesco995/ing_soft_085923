package it.polimi.ingsw.ps09.model.Actions;

import it.polimi.ingsw.ps09.model.Actions.PlayerActions.PlayerAction;
import it.polimi.ingsw.ps09.model.Actions.PlayerActions.UseCouncilPrivilege;
import it.polimi.ingsw.ps09.model.Board;
import it.polimi.ingsw.ps09.model.Player;

import java.util.ArrayList;

/**
 * Created by franc on 26/06/2017.
 */
public class AllPlayerActions {

    public static ArrayList<PlayerAction> getValidActionsForPlayer(Board board, Player player, int privilegesCount) {

        ArrayList<PlayerAction> mActionsList = new ArrayList<>();

        ///////CHECK FOR POSSIBLE PLAYER ACTIONS  ///////
        /////////////////////////////////////////////////
        /////////////////////////////////////////////////
        /////////////////////////////////////////////////


        //Check and add player actions for use council privilage

            //how to do check for validity ?


                mActionsList.add
                        (new UseCouncilPrivilege(privilegesCount));




        return mActionsList;
    }

}