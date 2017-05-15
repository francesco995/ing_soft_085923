package it.polimi.ingsw.ps09.model.Places;

import it.polimi.ingsw.ps09.model.FamilyMembers.FamilyMember;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ale on 09/05/2017.
 */
public class Council extends Place {

    //ArrayList of FamilyMembers to know the order player for the next game
    private List<FamilyMember> mCouncilOrderList = new ArrayList<>();

    public Council() {
    }

    //Add a FamilyMembers into Council queue
    public void addFamilyMember(FamilyMember Pawn){
        mCouncilOrderList.add(Pawn);
    }

    //Get queue in the Council
    public List getList(){
        return mCouncilOrderList;
    }

    //Delete all the queue
    public void clearAll(){
        mCouncilOrderList.clear();
    }

}
