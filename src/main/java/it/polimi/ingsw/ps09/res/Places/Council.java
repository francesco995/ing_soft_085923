package it.polimi.ingsw.ps09.res.Places;

import it.polimi.ingsw.ps09.res.FamilyMember.FamilyMember;
import it.polimi.ingsw.ps09.res.Places.Place;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ale on 09/05/2017.
 */
public class Council extends Place {

    //ArrayList of FamilyMember to know the order player for the next game
    private List<FamilyMember> mCouncilOrderList = new ArrayList<FamilyMember>();

    public Council() {
    }

    //Add a FamilyMember into Council queue
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
