package it.polimi.ingsw.ps09.model.Places.HarvestAndProductionAreas;

import it.polimi.ingsw.ps09.model.FamilyMembers.FamilyMember;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * Created by ale on 13/05/2017.
 */
public class CreateAreas {

    private List<Slot> mSlotList = new ArrayList<>();

    /**
     *
     * @param familyMember Add the specified family member in the area
     */

    //Try to put FamilyMembers in Area
    public void addMember(FamilyMember familyMember){

        if(isAvailable(familyMember)){
            if(mSlotList.isEmpty())

                //Add into first slot
                mSlotList.add(new Slot(1, familyMember));

            else
                //Add into other slot
                mSlotList.add(new Slot(3,familyMember));
        }

    }

    /**
     *
     * @return Entire list of slot
     */

    //Return List
    public List getList(){
        return mSlotList;
    }

    /**
     *
     * @param familyMember Check the ability to add a specific family member into the are
     * @return Boolean true if available, false if not
     */

    //Check if a slot is available
    public boolean isAvailable(FamilyMember familyMember){

        if(mSlotList.isEmpty())
            return true;

        for(Slot mSlot : mSlotList){

            if(mSlot.getFamilyMember().getFamily().equals(familyMember.getFamily())){

                if((mSlot.getFamilyMember().getColor().equals("Neutral")) || (familyMember.getColor().equals("Neutral"))){
                    return true;
                }

                else
                    return false;

            }


        }

        return true;
    }


    public boolean hasOneFamilyMember(){
        if(mSlotList.size()==1){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Clear the list containing all family member in the area
     */

    //Clear SlotList
    public void clearAll(){
        mSlotList.clear();
    }

    /**
     *
     * @return All areas information
     */
    @Override
    public String toString(){

        StringJoiner mStringSlot = new StringJoiner("\n", "", "");
        int mCont = 0;

        if(mSlotList.size()==0){

            mStringSlot.add("");
            mStringSlot.add(getClass().getSimpleName() + " area is empty");
        }

        else {
            for (Slot mSlot : mSlotList) {

                mCont++;

                mStringSlot.add("");
                mStringSlot.add("Area " + mCont + ":");
                mStringSlot.add(mSlot.toString());
                mStringSlot.add("");

            }
        }

        return mStringSlot.toString();
    }

}
