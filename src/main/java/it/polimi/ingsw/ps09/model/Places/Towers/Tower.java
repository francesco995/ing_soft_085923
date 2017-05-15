package it.polimi.ingsw.ps09.model.Places.Towers;

import it.polimi.ingsw.ps09.model.Places.Towers.Floor.Floor;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by ale on 10/05/2017.
 */

public class Tower {

    private List<Floor> mFloors = new ArrayList<>();
    private int cont = 0;
    private String mColor;

    public Tower(String color) {
        mColor = color;
    }

    public void setFloors(List<Floor> floors) {
        mFloors = floors;
    }

    //Return FloorList
    public List<Floor> getFloors() {
        return mFloors;
    }

    //Return tower's color
    public String getColor() {
        return mColor;
    }

    //Check if a Pawn is on the tower
    public boolean hasPawn(){

        while (mFloors.get(cont) !=null){

            if(mFloors.get(cont).getPawn() != null)
                return true;
                cont++;
        }

        return false;
    }

    //Check if tower's floor is free
    public boolean isFree(int floor){

        if(mFloors.get(floor).getPawn() == null)
            return true;

        else
            return false;

    }

    //TODO: Ale waiting FraL for FamilyMembers ID for comparison for


}