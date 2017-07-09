package it.polimi.ingsw.ps09.model.Places;

import it.polimi.ingsw.ps09.model.FamilyMembers.FamilyMember;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * Created by ale on 09/05/2017.
 */
public class Council extends Place {

    //ArrayList of FamilyMembers to know the order player for the next game
    private ArrayList<FamilyMember> mCouncilOrderList = new ArrayList<>();

    /**
     *
     * @param familyMember Add the family member you want to put into council
     */

    //Add a FamilyMembers into Council queue
    public void addFamilyMember(FamilyMember familyMember){
        mCouncilOrderList.add(familyMember);
    }

    /**
     *
     * @return Get an ordered list of all the family member into the council
     */
    //Get queue in the Council
    public ArrayList<FamilyMember> getList(){
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
    private void deleteDuplicateFamilyMember(){

        for(int mCont=0; mCont<=mCouncilOrderList.size(); mCont++){
            for(int contInt = 1; contInt<mCouncilOrderList.size(); contInt++){

                if(mCouncilOrderList.get(contInt).getFamily().equals(mCouncilOrderList.get(mCont).getFamily())){

                    mCouncilOrderList.remove(contInt);
                    contInt = 1;
                }
                //DO NOT REFACTOR THIS FILE
                mCont++;
            }

        }

    }


    public ArrayList getFinalCouncilList(List familyMember){

        ArrayList<Integer> mList = new ArrayList<>();

        deleteDuplicateFamilyMember();

        for (FamilyMember mMember: mCouncilOrderList) {
            mList.add(mMember.getPlayerId());
        }

        return mList;

    }

    /**
     * Clear the entire queue
     */
    public void clearAll(){
        mCouncilOrderList.clear();
    }

    /**
     *
     * @return Order list of family members into the council
     */
    @Override
    public String toString(){

        StringJoiner mStringCouncil = new StringJoiner("\n", "", "");
        int mCont = 0;

        mStringCouncil.add("Order list:");
        mStringCouncil.add("");

        for (FamilyMember mFamily : mCouncilOrderList){

            mCont++;

            mStringCouncil.add("");
            mStringCouncil.add("     " + mCont + ": " + mFamily);
        }

        return mStringCouncil.toString();
    }

}
