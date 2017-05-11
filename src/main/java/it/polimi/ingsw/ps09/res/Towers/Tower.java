package it.polimi.ingsw.ps09.res.Towers;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by ale on 10/05/2017.
 */
public class Tower {

    public List<Tower> CreateTowers(){

        //Create List of 4 towers
        List<Tower> towerList = new ArrayList<Tower>();

        towerList.add(0, new TerritoriesTower());
        towerList.add(1, new CharactersTower());
        towerList.add(2, new BuildingsTower());
        towerList.add(3, new VenturesTower());

        //Call CreateFloors for each tower
        towerList.get(0).CreateFloors();
        towerList.get(1).CreateFloors();
        towerList.get(2).CreateFloors();
        towerList.get(3).CreateFloors();

        return towerList;
    }

    private List<Floor> CreateFloors(){

        //Create a List of 4 floors
        List<Floor> FloorList = new ArrayList<Floor>();

        FloorList.add(0, new Floor());
        FloorList.add(1, new Floor());
        FloorList.add(2, new Floor());
        FloorList.add(3, new Floor());

        return FloorList;

    }

}
