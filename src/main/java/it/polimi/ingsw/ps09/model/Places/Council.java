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

    /**
     *
     * @param pawn Add the family member you want to put into council
     */

    //Add a FamilyMembers into Council queue
    public void addFamilyMember(FamilyMember pawn){
        mCouncilOrderList.add(pawn);
    }

    /**
     *
     * @return Get an ordered list of all the family member into the council
     */
    //Get queue in the Council
    public List getList(){
        return mCouncilOrderList;
    }

    /**
     *
     * @param pos To know who is in the specified position
     * @return Family member in the specified position
     */
    public FamilyMember getFamilyMember(int pos){
        return mCouncilOrderList.get(pos);
    }

    /**
     * Delete all duplicates of the same family
     */
    public void deleteDuplicateFamilyMember(){
        for(int cont=0; cont<mCouncilOrderList.size(); cont++){
            for(int contInt=cont+1; contInt<mCouncilOrderList.size(); contInt++){
                if(mCouncilOrderList.get(contInt).getFamily().equals(mCouncilOrderList.get(cont).getFamily())){
                    mCouncilOrderList.remove(contInt);
                }
            }
        }

    }

    /**
     * Clear the entire queue
     */
    public void clearAll(){
        mCouncilOrderList.clear();
    }

}
