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

    public List<Slot> getSlotList() {
        return mSlotList;
    }

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

        int mCont;

        if(mSlotList.isEmpty())
            return true;

        for(mCont = 0; mCont<mSlotList.size(); mCont++){
            if(mSlotList.get(mCont).getFamilyMember() == familyMember)
                return false;
        }

        return true;
    }


    /**
     * Clear the list containing all family member in the area
     */

    //Clear SlotList
    public void clearAll(){
        mSlotList.clear();
    }

    @Override
    public String toString(){

        StringJoiner mStringSlot = new StringJoiner("\n", "", "");

        for(int cont=0; cont<mSlotList.size(); cont++){

            mStringSlot.add("");
            mStringSlot.add("Area " + (cont+1) + ":");
            mStringSlot.add(mSlotList.get(cont).toString());
            mStringSlot.add("");

        }

        return mStringSlot.toString();
    }

}
