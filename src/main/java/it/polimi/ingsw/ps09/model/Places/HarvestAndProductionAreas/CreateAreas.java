package it.polimi.ingsw.ps09.model.Places.HarvestAndProductionAreas;

import it.polimi.ingsw.ps09.model.FamilyMembers.FamilyMember;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ale on 13/05/2017.
 */
public class CreateAreas {

    private List<Slot> mSlotList = new ArrayList<>();

    public List<Slot> getSlotList() {
        return mSlotList;
    }

    //Try to put FamilyMembers in Area
    public void addMember(FamilyMember FamilyMember){

        if(isAvailable(FamilyMember)){
            if(mSlotList.isEmpty())

                //Add into first slot
                mSlotList.add(new Slot(1, FamilyMember));

            else
                //Add into other slot
                mSlotList.add(new Slot(3,FamilyMember));
        }

    }

    //Return List
    public List getList(){
        return mSlotList;
    }

    //Check if a slot is available
    public boolean isAvailable(FamilyMember FamilyMember){

        int mCont;

        if(mSlotList.isEmpty())
            return true;

        for(mCont = 0; mCont<mSlotList.size(); mCont++){
            if(mSlotList.get(mCont).getPawn() == FamilyMember)
                return false;
        }

        return true;
    }

    //Clear SlotList
    public void clearAll(){
        mSlotList.clear();
    }

}
