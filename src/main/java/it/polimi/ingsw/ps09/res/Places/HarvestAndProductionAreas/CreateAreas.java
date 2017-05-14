package it.polimi.ingsw.ps09.res.Places.HarvestAndProductionAreas;

import it.polimi.ingsw.ps09.res.FamilyMember.FamilyMember;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ale on 13/05/2017.
 */
public class CreateAreas {

    protected List<Slot> mSlotList = new ArrayList<Slot>();
    private int mCont;

    public List<Slot> getSlotList() {
        return mSlotList;
    }

    //TODO: Ale waiting FraL for FamilyMember ID for comparison

    //Try to put FamilyMember in Area
    public void addMember(Object FamilyMember){

        if(isAvailable(FamilyMember)){
            if(mSlotList==null)

                //Add into first slot
                mSlotList.add(new Slot(1, FamilyMember));

            else
                //Add into other slot
                mSlotList.add(new Slot(3,FamilyMember));
        }

    }

    //Check if a slot is available
    public boolean isAvailable(Object FamilyMember){
        if(mSlotList.size()==0)
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
