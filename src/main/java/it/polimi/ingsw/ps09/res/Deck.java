package it.polimi.ingsw.ps09.res;

import it.polimi.ingsw.ps09.res.Cards.Card;

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
    List<Card> mBuildingTierOne = new ArrayList<Card>();
    List<Card> muildingTierTwo = new ArrayList<Card>();
    List<Card> mbuildingTierThree = new ArrayList<Card>();
    //ALL CHARACTERS
    List<Card> mcharacterTierOne = new ArrayList<Card>();
    List<Card> mcharacterTierTwo = new ArrayList<Card>();
    List<Card> mcharacterTierThree = new ArrayList<Card>();
    //ALL TERRITORY
    List<Card> mterritoryTierOne = new ArrayList<Card>();
    List<Card> mterritoryTieTwo = new ArrayList<Card>();
    List<Card> mterritoryTieThree = new ArrayList<Card>();
    //ALL VENTURES
    List<Card> mventureTierOne = new ArrayList<Card>();
    List<Card> mventureTierTwo = new ArrayList<Card>();
    List<Card> mventureTierThree = new ArrayList<Card>();




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
                        addBuilding(new Card(args[1], parseInt(args[2])));
                        break;
                    case "character":
                        addCharacter(new Card(args[1], parseInt(args[2])));
                        break;
                    case "territory":
                        addTerritory(new Card(args[1], parseInt(args[2])));
                        break;
                    case "venture":
                        addVenture(new Card(args[1], parseInt(args[2])));
                        break;
                }

            }
        } catch (IOException ioe) {
            System.out.printf("Problems loading %s %n", fileName);
            ioe.printStackTrace();
        }
    }

    public void addBuilding(Card card){

    }
    public void addCharacter(Card card){

    }
    public void addTerritory(Card card){

    }
    public void addVenture(Card card){

    }
}
