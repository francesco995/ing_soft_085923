package it.polimi.ingsw.ps09.model;

import it.polimi.ingsw.ps09.model.FamilyMembers.FamilyMember;
import it.polimi.ingsw.ps09.model.Places.Council;

import java.util.*;

/**
 * Created by ale on 14/05/2017.
 */
public class Order {

    private List<FamilyMember> mOrderList = new ArrayList<FamilyMember>();

    private void addTop(FamilyMember FamilyMember){
        mOrderList.add(0,FamilyMember);
    }

    //Get the list of player's order
    public List<FamilyMember> getPlayerList(){
        return mOrderList;
    }

    public ArrayList<Integer> getFinalOrderList(ArrayList<Integer> councilList, ArrayList<Integer> playersOrder){

        ArrayList<Integer> mFinalOrderList = new ArrayList<>(councilList);
        int mFlag = 0;

        //Return council list if all player are there
        if(councilList.size()==4)
            return councilList;


        //For each playerOrder check if is in the council too
        for(int orderPlayerId : playersOrder){

            for(int councilPlayerId : councilList){

                if(orderPlayerId==councilPlayerId)
                    mFlag=1;
            }

            if(mFlag==0)
                mFinalOrderList.add(orderPlayerId);

            mFlag = 0;
        }

        return mFinalOrderList;
    }
}
