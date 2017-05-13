package it.polimi.ingsw.ps09.res.Towers;

import it.polimi.ingsw.ps09.res.Towers.Floor.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by ale on 12/05/2017.
 */


//This module initialize all towers and floors

public class CreateTower {

    private static final Logger LOGGER = Logger.getLogger(CreateTower.class.getName());


    public List<Tower> CreateTower(){

        List<Tower> TowerList = new ArrayList<>();

        //Create all towers
        TowerList.add(new TerritoriesTower());
        TowerList.add(new CharactersTower());
        TowerList.add(new BuildingsTower());
        TowerList.add(new VenturesTower());

        //Create a List of Floor fore each tower
        TowerList.get(0).setFloors(CreateFloors());
        TowerList.get(1).setFloors(CreateFloors());
        TowerList.get(2).setFloors(CreateFloors());
        TowerList.get(3).setFloors(CreateFloors());

        return TowerList;

    }

    private List<Floor> CreateFloors(){

        //Create a List of 4 floors
        List<Floor> FloorList = new ArrayList<Floor>();

        FloorList.add(0, new FloorOne());
        FloorList.add(1, new FloorTwo());
        FloorList.add(2, new FloorThree());
        FloorList.add(3, new FloorFour());

        return FloorList;

    }

}