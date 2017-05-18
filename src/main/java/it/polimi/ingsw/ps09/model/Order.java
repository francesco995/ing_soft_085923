package it.polimi.ingsw.ps09.model;

import it.polimi.ingsw.ps09.model.FamilyMembers.FamilyMember;
import it.polimi.ingsw.ps09.model.Places.Council;

import java.util.*;

/**
 * Created by ale on 14/05/2017.
 */
public class Order {

    private List<FamilyMember> mOrderList = new ArrayList<FamilyMember>();

    private void addTop(FamilyMember Pawn){
        mOrderList.add(0,Pawn);
    }

    //Get the list of player's order
    public List<FamilyMember> getPlayerList(){
        return mOrderList;
    }

    public List<FamilyMember> getFinalOrderList(Council councilList){

        councilList.deleteDuplicateFamilyMember();

        for(int cont=0; cont<councilList.getList().size(); cont++){
            mOrderList.add(0,councilList.getFamilyMember(cont));
        }

        return mOrderList;
    }
}
