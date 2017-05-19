package it.polimi.ingsw.ps09.model.Decks;

import it.polimi.ingsw.ps09.model.DevelopmentCards.*;
import it.polimi.ingsw.ps09.model.DevelopmentCards.Character;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Type;
import java.util.*;


/**
 * Created by franc on 10/05/2017.
 * DevelopmentCardsDeck is a Collections that contains all the Development cards
 * Provides a method for drawing cards
 *
 * HashMap of CARD TYPE to a Map of GAME PERIODS (Tiers) to a LinkedList of Cards
 *
 * BUILDING
 *      TIER 1
 *          LinkedList of Buildings
 *      TIER 2
 *          LinkedList of Buildings
 *      ...
 * CHARACTER
 *      TIER 1
 *          LinkedList of Characters
 *      TIER 2
 *          LinkedList of Characters
 *      ...
 * ...
 */
public class DevelopmentCardsDeck {

    private final static int MAX_PERIODS = 3;
    private final static String DECK_FORMAT = ".json";

    //THE DECK
    private HashMap<String, Map<Integer, List>> mDeck = new HashMap();

    //OTHER VARIABLES
    Random mRandom = new Random();

    //ALL BUILDINGS
    @Deprecated
    private List<Building> mBuildingTierOne;
    @Deprecated
    private List<Building> mBuildingTierTwo;
    @Deprecated
    private List<Building> mBuildingTierThree;

    //ALL CHARACTERS
    @Deprecated
    private List<Character> mCharacterTierOne;
    @Deprecated
    private List<Character> mCharacterTierTwo;
    @Deprecated
    private List<Character> mCharacterTierThree;

    //ALL TERRITORY
    @Deprecated
    private List<Territory> mTerritoryTierOne;
    @Deprecated
    private List<Territory> mTerritoryTierTwo;
    @Deprecated
    private List<Territory> mTerritoryTierThree;

    //ALL VENTURES
    @Deprecated
    private List<Venture> mVentureTierOne;
    @Deprecated
    private List<Venture> mVentureTierTwo;
    @Deprecated
    private List<Venture> mVentureTierThree;


    /**
     * Loads the deck from file sources
     * @throws FileNotFoundException
     */
    public DevelopmentCardsDeck() throws FileNotFoundException {

        //Create the directory path
        File mDirectory = new File("./");
        String mFilePath = mDirectory.getAbsolutePath().replace(".",
                "src\\main\\res\\DevelopmentCardDecks\\");

        //Initialize 4 maps for the 4 types of cards
        mDeck.put("BUILDING", new HashMap<>());
        mDeck.put("CHARACTER", new HashMap<>());
        mDeck.put("TERRITORY", new HashMap<>());
        mDeck.put("VENTURE", new HashMap<>());

        //For each period and for each type of card, fill the corresponding Map and LinkedList
        for(int i = 1; i <= MAX_PERIODS; i++){
            mDeck.get("BUILDING").put(i, loadDeck(  mFilePath + "BuildingDeck" +  i + DECK_FORMAT,
                    new TypeToken<LinkedList<Building>>(){}.getType() ));
            mDeck.get("CHARACTER").put(i, loadDeck( mFilePath + "CharacterDeck" +  i + DECK_FORMAT,
                    new TypeToken<LinkedList<Character>>(){}.getType() ));
            mDeck.get("TERRITORY").put(i, loadDeck( mFilePath + "TerritoryDeck" + i + DECK_FORMAT,
                    new TypeToken<LinkedList<Territory>>(){}.getType()));
            mDeck.get("VENTURE").put(i, loadDeck(   mFilePath + "VentureDeck" + i + DECK_FORMAT,
                    new TypeToken<LinkedList<Venture>>(){}.getType()));
        }

    }

    /**
     * Loads a text-based file to a string
     * @param fileName name of the file to load
     * @return returns the file as a string
     * @throws FileNotFoundException
     */
    private String loadStringDeck(String fileName) throws FileNotFoundException {

        String mStringDeck;

        Scanner mScanner = new Scanner( new File(fileName) );
        mStringDeck = mScanner.useDelimiter("\\A").next();

        mScanner.close();

        return mStringDeck;
    }

    @Deprecated
    private List<Building> loadBuildingDeck(String fileName) throws FileNotFoundException {
        //TODO: FraG comment and LOG

        String stringDeck = loadStringDeck(fileName);

        Type mListType = new TypeToken<LinkedList<Building>>(){}.getType();

        return new Gson().fromJson(stringDeck, mListType);
    }

    @Deprecated
    private List<Character> loadCharacterDeck(String fileName) throws FileNotFoundException {
        //TODO: FraG comment and LOG

        String stringDeck = loadStringDeck(fileName);

        Type mListType = new TypeToken<LinkedList<Character>>(){}.getType();

        return new Gson().fromJson(stringDeck, mListType);
    }

    @Deprecated
    private List<Territory> loadTerritoryDeck(String fileName) throws FileNotFoundException {
        //TODO: FraG comment and LOG

        String stringDeck = loadStringDeck(fileName);

        Type mListType = new TypeToken<LinkedList<Territory>>(){}.getType();

        return new Gson().fromJson(stringDeck, mListType);
    }

    @Deprecated
    private List<Venture> loadVentureDeck(String fileName) throws FileNotFoundException {
        //TODO: FraG comment and LOG

        String stringDeck = loadStringDeck(fileName);

        Type mListType = new TypeToken<LinkedList<Venture>>(){}.getType();

        return new Gson().fromJson(stringDeck, mListType);
    }

    /**
     * Import an object from the given file in json format
     * @param fileName complete path of the file to load (from the project index)
     * @param objectType Type of the Object to import
     * @return
     * @throws FileNotFoundException
     */
    private List loadDeck(String fileName, Type objectType) throws FileNotFoundException {

        String stringDeck = loadStringDeck(fileName);

        return new Gson().fromJson(stringDeck, objectType);
    }


    private int getRandomNumber(int max){
        return mRandom.nextInt(max);
    }

    public Object drawCard(String cardType){

        for(int i = 1; i <= MAX_PERIODS; i++){
            if(!mDeck.get(cardType.toUpperCase()).get(i).isEmpty()){
                return mDeck.get(cardType).get(i).remove(getRandomNumber(mDeck.get(cardType).get(i).size()));
            }
        }
        return null;

    }

    @Deprecated
    public Building drawBuildingCard(){

        Building mTempCard;
        int mRandomNumber;

        if(!mBuildingTierOne.isEmpty()){
            mRandomNumber = getRandomNumber(mBuildingTierOne.size());
            mTempCard = mBuildingTierOne.get(mRandomNumber);
            mBuildingTierOne.remove(mRandomNumber);
        }else
            if(!mBuildingTierTwo.isEmpty()){
                mRandomNumber = getRandomNumber(mBuildingTierOne.size());
                mTempCard = mBuildingTierTwo.get(mRandomNumber);
                mBuildingTierTwo.remove(mRandomNumber);
            }else
                if(!mBuildingTierThree.isEmpty()){
                    mRandomNumber = getRandomNumber(mBuildingTierOne.size());
                    mTempCard = mBuildingTierThree.get(mRandomNumber);
                    mBuildingTierThree.remove(mRandomNumber);
                }else
                    return null;
        return mTempCard;
    }

    @Deprecated
    public Character drawCharacterCard(){

        Character mTempCard;
        int mRandomNumber;

        if(!mCharacterTierOne.isEmpty()){
            mRandomNumber = getRandomNumber(mCharacterTierOne.size());
            mTempCard = mCharacterTierOne.get(mRandomNumber);
            mCharacterTierOne.remove(mRandomNumber);
        }else
        if(!mCharacterTierTwo.isEmpty()){
            mRandomNumber = getRandomNumber(mCharacterTierOne.size());
            mTempCard = mCharacterTierTwo.get(mRandomNumber);
            mCharacterTierTwo.remove(mRandomNumber);
        }else
        if(!mCharacterTierThree.isEmpty()){
            mRandomNumber = getRandomNumber(mCharacterTierOne.size());
            mTempCard = mCharacterTierThree.get(mRandomNumber);
            mCharacterTierThree.remove(mRandomNumber);
        }else
            return null;
        return mTempCard;
    }

    @Deprecated
    public Territory drawTerritoryCard(){

        Territory mTempCard;
        int mRandomNumber;

        if(!mTerritoryTierOne.isEmpty()){
            mRandomNumber = getRandomNumber(mTerritoryTierOne.size());
            mTempCard = mTerritoryTierOne.get(mRandomNumber);
            mTerritoryTierOne.remove(mRandomNumber);
        }else
        if(!mTerritoryTierTwo.isEmpty()){
            mRandomNumber = getRandomNumber(mTerritoryTierOne.size());
            mTempCard = mTerritoryTierTwo.get(mRandomNumber);
            mTerritoryTierTwo.remove(mRandomNumber);
        }else
        if(!mTerritoryTierThree.isEmpty()){
            mRandomNumber = getRandomNumber(mTerritoryTierOne.size());
            mTempCard = mTerritoryTierThree.get(mRandomNumber);
            mTerritoryTierThree.remove(mRandomNumber);
        }else
            return null;
        return mTempCard;
    }

    @Deprecated
    public Venture drawVentureCard(){

        Venture mTempCard;
        int mRandomNumber;

        if(!mVentureTierOne.isEmpty()){
            mRandomNumber = getRandomNumber(mVentureTierOne.size());
            mTempCard = mVentureTierOne.get(mRandomNumber);
            mVentureTierOne.remove(mRandomNumber);
        }else
        if(!mVentureTierTwo.isEmpty()){
            mRandomNumber = getRandomNumber(mVentureTierOne.size());
            mTempCard = mVentureTierTwo.get(mRandomNumber);
            mVentureTierTwo.remove(mRandomNumber);
        }else
        if(!mVentureTierThree.isEmpty()){
            mRandomNumber = getRandomNumber(mVentureTierOne.size());
            mTempCard = mVentureTierThree.get(mRandomNumber);
            mVentureTierThree.remove(mRandomNumber);
        }else
            return null;
        return mTempCard;
    }

}
