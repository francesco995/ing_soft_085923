package it.polimi.ingsw.ps09.res;

import it.polimi.ingsw.ps09.res.DevelopmentCards.DevelopmentCard;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

/**
 * Created by franc on 10/05/2017.
 */
public class Deck {
    //ALL BUILDINGS fix camel
    List<DevelopmentCard> mBuildingTierOne = new ArrayList<DevelopmentCard>();
    List<DevelopmentCard> mBuildingTierTwo = new ArrayList<DevelopmentCard>();
    List<DevelopmentCard> mBuildingTierThree = new ArrayList<DevelopmentCard>();
    //ALL CHARACTERS
    List<DevelopmentCard> mCharacterTierOne = new ArrayList<DevelopmentCard>();
    List<DevelopmentCard> mCharacterTierTwo = new ArrayList<DevelopmentCard>();
    List<DevelopmentCard> mCharacterTierThree = new ArrayList<DevelopmentCard>();
    //ALL TERRITORY
    List<DevelopmentCard> mTerritoryTierOne = new ArrayList<DevelopmentCard>();
    List<DevelopmentCard> mTerritoryTieTwo = new ArrayList<DevelopmentCard>();
    List<DevelopmentCard> mTerritoryTieThree = new ArrayList<DevelopmentCard>();
    //ALL VENTURES
    List<DevelopmentCard> mVentureTierOne = new ArrayList<DevelopmentCard>();
    List<DevelopmentCard> mVentureTierTwo = new ArrayList<DevelopmentCard>();
    List<DevelopmentCard> mVentureTierThree = new ArrayList<DevelopmentCard>();




    public void importFrom(String fileName) {
        try (
                FileInputStream fis = new FileInputStream(fileName);
                BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] args = line.split("\\|");
                switch (args[0].toLowerCase()){
                    case "building":
                        addBuilding(new DevelopmentCard(args[1], parseInt(args[2])));
                        break;
                    case "character":
                        addCharacter(new DevelopmentCard(args[1], parseInt(args[2])));
                        break;
                    case "territory":
                        addTerritory(new DevelopmentCard(args[1], parseInt(args[2])));
                        break;
                    case "venture":
                        addVenture(new DevelopmentCard(args[1], parseInt(args[2])));
                        break;
                }

            }
        } catch (IOException ioe) {
            System.out.printf("Problems loading %s %n", fileName);
            ioe.printStackTrace();
        }
    }

    public void addBuilding(DevelopmentCard developmentCard){

    }
    public void addCharacter(DevelopmentCard developmentCard){

    }
    public void addTerritory(DevelopmentCard developmentCard){

    }
    public void addVenture(DevelopmentCard developmentCard){

    }
}
