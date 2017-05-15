package it.polimi.ingsw.ps09.res;

import it.polimi.ingsw.ps09.res.DevelopmentCards.*;
import it.polimi.ingsw.ps09.res.DevelopmentCards.Character;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


/**
 * Created by franc on 10/05/2017.
 */
public class DevelopmentDeck {

    //ALL BUILDINGS
    private List<Building> mBuildingTierOne;
    private List<Building> mBuildingTierTwo;
    private List<Building> mBuildingTierThree;

    //ALL CHARACTERS
    private List<Character> mCharacterTierOne;
    private List<Character> mCharacterTierTwo;
    private List<Character> mCharacterTierThree;

    //ALL TERRITORY
    private List<Territory> mTerritoryTierOne;
    private List<Territory> mTerritoryTierTwo;
    private List<Territory> mTerritoryTierThree;

    //ALL VENTURES
    private List<Venture> mVentureTierOne;
    private List<Venture> mVentureTierTwo;
    private List<Venture> mVentureTierThree;


    private String loadStringDeck(String fileName) throws FileNotFoundException {
        //TODO: FraG comment and LOG
        String mStringDeck;
        Scanner mScanner = new Scanner( new File(fileName) );

        mStringDeck = mScanner.useDelimiter("\\A").next();
        mScanner.close();

        return mStringDeck;
    }

    private List<Building> loadBuildingDeck(String fileName) throws FileNotFoundException {
        //TODO: FraG comment and LOG

        String stringDeck = loadStringDeck(fileName);

        Type mListType = new TypeToken<LinkedList<Building>>(){}.getType();

        return new Gson().fromJson(stringDeck, mListType);
    }

    private List<Character> loadCharacterDeck(String fileName) throws FileNotFoundException {
        //TODO: FraG comment and LOG

        String stringDeck = loadStringDeck(fileName);

        Type mListType = new TypeToken<LinkedList<Character>>(){}.getType();

        return new Gson().fromJson(stringDeck, mListType);
    }

    private List<Territory> loadTerritoryDeck(String fileName) throws FileNotFoundException {
        //TODO: FraG comment and LOG

        String stringDeck = loadStringDeck(fileName);

        Type mListType = new TypeToken<LinkedList<Territory>>(){}.getType();

        return new Gson().fromJson(stringDeck, mListType);
    }

    private List<Venture> loadVentureDeck(String fileName) throws FileNotFoundException {
        //TODO: FraG comment and LOG

        String stringDeck = loadStringDeck(fileName);

        Type mListType = new TypeToken<LinkedList<Venture>>(){}.getType();

        return new Gson().fromJson(stringDeck, mListType);
    }

    public void loadFromFile() throws FileNotFoundException {

        mBuildingTierOne = loadBuildingDeck("BuildingDeck1.json");
        mBuildingTierTwo = loadBuildingDeck("BuildingDeck2.json");
        mBuildingTierThree = loadBuildingDeck("BuildingDeck3.json");

        mCharacterTierOne = loadCharacterDeck("CharacterDeck1.json");
        mCharacterTierTwo = loadCharacterDeck("CharacterDeck2.json");
        mCharacterTierThree = loadCharacterDeck("CharacterDeck3.json");

        mTerritoryTierOne = loadTerritoryDeck("TerritoryDeck1.json");
        mTerritoryTierTwo = loadTerritoryDeck("TerritoryDeck2.json");
        mTerritoryTierThree = loadTerritoryDeck("TerritoryDeck3.json");

        mVentureTierOne = loadVentureDeck("VentureDeck1.json");
        mVentureTierTwo = loadVentureDeck("VentureDeck2.json");
        mVentureTierThree = loadVentureDeck("VentureDeck3.json");
    }


}
