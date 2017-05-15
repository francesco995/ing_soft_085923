package it.polimi.ingsw.ps09.model.Places.Towers;

import it.polimi.ingsw.ps09.model.Places.Towers.Floor.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by ale on 12/05/2017.
 */


//This module initialize all towers and floors

public class CreateTower {

    private static final Logger LOGGER = Logger.getLogger(CreateTower.class.getName());
    private List<Tower> mTowerList = new ArrayList<>();

    public List<Tower> CreateTower () {

        //Create all towers
        mTowerList.add(new TerritoriesTower());
        mTowerList.add(new CharactersTower());
        mTowerList.add(new BuildingsTower());
        mTowerList.add(new VenturesTower());

        //Create a List of Floor fore each tower
        mTowerList.get(0).setFloors(CreateFloors());
        mTowerList.get(1).setFloors(CreateFloors());
        mTowerList.get(2).setFloors(CreateFloors());
        mTowerList.get(3).setFloors(CreateFloors());

        return mTowerList;

    }


    private List<Floor> CreateFloors(){

        //Create a List of 4 floors
        List<Floor> FloorList = new ArrayList<>();

        FloorList.add(0, new FloorOne());
        FloorList.add(1, new FloorTwo());
        FloorList.add(2, new FloorThree());
        FloorList.add(3, new FloorFour());

        return FloorList;

    }

    public List<Tower> getTowerList(){
        return mTowerList;
    }

}