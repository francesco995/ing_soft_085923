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

    public FamilyMember getFamilyMember(int pos){
        return mCouncilOrderList.get(pos);
    }

    public void deleteDuplicateFamilyMember(){
        for(int cont=0; cont<mCouncilOrderList.size(); cont++){
            for(int contInt=cont+1; contInt<mCouncilOrderList.size(); contInt++){
                if(mCouncilOrderList.get(contInt).getFamily().equals(mCouncilOrderList.get(cont))){
                    mCouncilOrderList.remove(contInt);
                }
            }
        }

    }

    //Delete all the queue
    public void clearAll(){
        mCouncilOrderList.clear();
    }

}
