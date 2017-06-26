package it.polimi.ingsw.ps09.model.Actions.PlayerActions;


import it.polimi.ingsw.ps09.model.Player;
import it.polimi.ingsw.ps09.model.UserPoints;
import it.polimi.ingsw.ps09.model.UserResources;
import it.polimi.ingsw.ps09.view.Prompter;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * Created by franc on 22/06/2017.
 */
public class UseCouncilPrivilege implements PlayerAction{
    //static data
    static final int MAX_NUMBER = 5;
    //List<String> mStringList = new ArrayList<String>();
    int mPrivilegesCount;

    public UseCouncilPrivilege(int privilegesCount) {
        mPrivilegesCount = privilegesCount;
    }


    /**
     *
     * @param player The player whom perform the action
     * @param choice List of all the choices done by the player through prompter
     */
    public void doAction(Player player, List<Integer> choice) {

       /* //add all the different effects to a StringList passed to prompter for it to display
        mStringList.add("Get 1 wood and 1 stone");
        mStringList.add("Get 2 servants");
        mStringList.add("Get 2 coins");
        mStringList.add("Get 2 military points");
        mStringList.add("Get 1 faith point");*/

        //delegates the task of choosing to player through Prompter
       /* List<Integer> choice = new ArrayList<>();
        choice = Prompter.PromptForMultipleDifferentChoices
                ("Choose " + privilegesCount +" different council privilege", mStringList , privilegesCount, MAX_NUMBER);
*/

        //goes through the choice list to actually do the action
        for(int i=0; i<choice.size(); i++){

            switch(choice.get(i)){
                //1 wood and 1 stone
                case 1:
                    player.add(new UserResources(0,0,1,1));
                    break;
                //2 servants
                case 2:
                    player.add(new UserResources(0,2,0,0));
                    break;
                //2 coins
                case 3:
                    player.add(new UserResources(2,0,0,0));
                    break;
                //2 military points
                case 4:
                    player.add(new UserPoints(0,2,0));
                    break;
                //1 faith point
                case 5:
                    player.add(new UserPoints(1,0,0));
                    break;
                default:
                // somehow passed wrong int, no action done on player to avoid cheating
                    break;

            }
        }


    }

    /**
     *
     * @return A string of the action to perform
     */
    @Override
    public String toString(){

        StringJoiner mStringCouncilPrivilege = new StringJoiner("", "", "");

        mStringCouncilPrivilege.add("");
        mStringCouncilPrivilege.add("Use one privilege council, converting it in: | 1 wood and 1 stone | 2 servants " +
                "| 2 coins | 2 military points | 1 faith point |");

        return mStringCouncilPrivilege.toString();
    }
}
