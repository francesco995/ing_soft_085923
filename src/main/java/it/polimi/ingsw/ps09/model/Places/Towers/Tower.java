package it.polimi.ingsw.ps09.model.Places.Towers;

import it.polimi.ingsw.ps09.model.FamilyMembers.FamilyMember;
import it.polimi.ingsw.ps09.model.Places.Towers.Floor.*;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by ale on 10/05/2017.
 */

public class Tower {

    private List<Floor> mFloors = new ArrayList<>();
    private String mColor;

    /**
     *
     * @param color Set tower's color
     */
    public Tower(String color) {
        mColor = color;

        mFloors.add(0, new FloorOne());
        mFloors.add(1, new FloorTwo());
        mFloors.add(2, new FloorThree());
        mFloors.add(3, new FloorFour());
    }

    /**
     *
     * @param floors Set floor list
     */
    public void setFloors(List<Floor> floors) {
        mFloors = floors;
    }

    /**
     *
     * @return Get tower floor list
     */
    //Return FloorList
    public List<Floor> getFloors() {
        return mFloors;
    }

    /**
     *
     * @return Get tower's color
     */
    //Return tower's color
    public String getColor() {
        return mColor;
    }

    /**
     *
     * @return Get boolean value: true if there's a family member in th tower, otherwise false
     */
    //Check if a Pawn is on the tower
    public boolean hasPawn(){
        int cont = 0;

        while (mFloors.get(cont)!=null){

            if(mFloors.get(cont).getPawn()!=null) {
                return true;
            }
            else
                cont++;
        }

        return false;
    }

    /**
     *
     * @param floor Floor number you want to check
     * @return Boolean value: true if the specified floor is available, otherwise false
     */
    //Check if tower's floor is free
    public boolean isFree(int floor){

        if(mFloors.get(floor).getPawn() == null)
            return true;

        else
            return false;

    }

    /**
     *
     * @param Pawn Family member object to compare whth
     * @return Boolean value: true if a member of that family is already in the tower, otherwise flase
     */
    public boolean hasSameFamilyMember(FamilyMember Pawn){

        int cont = 0;

        while (mFloors.get(cont).getPawn()!=Pawn || (cont<=mFloors.size())){

            cont++;

            if(cont>mFloors.size())
                return true;
        }

        return false;

    }

    public void clearAll(){
        mFloors.clear();
    }


}