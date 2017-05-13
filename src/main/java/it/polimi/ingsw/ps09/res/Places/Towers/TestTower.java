package it.polimi.ingsw.ps09.res.Places.Towers;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static java.util.logging.Level.INFO;


/**
 * Created by ale on 11/05/2017.
 */
public class TestTower {


    private static final Logger LOGGER = Logger.getLogger(TestTower.class.getName());


    public static void main(String[] args) {

        List<Tower> TowerList = new ArrayList<>();

        TowerList = new CreateTower().CreateTower();

        int info = TowerList.get(3).getFloors().get(2).getDiceValue();


        LOGGER.log(INFO, info + "");
    }
}
