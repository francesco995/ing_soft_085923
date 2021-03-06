package it.polimi.ingsw.ps09.model.Decks;

import com.google.gson.GsonBuilder;
import it.polimi.ingsw.ps09.Constants;
import it.polimi.ingsw.ps09.controller.Game.Game;
import it.polimi.ingsw.ps09.model.DevelopmentCardEffects.DevelopmentCardEffect;
import it.polimi.ingsw.ps09.model.DevelopmentCards.*;

import com.google.gson.Gson;
import it.polimi.ingsw.ps09.model.GsonAdapters.DevelopmentCardAdapter;
import it.polimi.ingsw.ps09.model.GsonAdapters.DevelopmentCardEffectAdapter;
import it.polimi.ingsw.ps09.model.Player;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.logging.Logger;

import static java.util.logging.Level.INFO;


/**
 * Created by francesco995 on 10/05/2017.
 * DevelopmentCardsDeck is a Collections that contains all the Development cards
 * Provides a method for drawing cards
 * HashMap of CARD TYPE to a Map of GAME PERIODS (Tiers) to a LinkedList of Cards
 * BUILDING
 * TIER 1
 * LinkedList of Buildings
 * TIER 2
 * LinkedList of Buildings
 * ...
 * CHARACTER
 * TIER 1
 * LinkedList of Characters
 * TIER 2
 * LinkedList of Characters
 * ...
 * ...
 */
public class DevelopmentCardsDeck {

    private final static int MAX_PERIODS = 3;
    private final static String DECK_FORMAT = ".json";

    //THE DECK
    private HashMap<String, Map<Integer, List>> mDeck = new HashMap();

    //OTHER VARIABLES
    Random mRandom = new Random();

    //LOGGER
    private static final Logger mLogger = Logger.getLogger(Player.class.getName());


    /**
     * Loads the deck from file sources
     *
     * @throws FileNotFoundException if decks are not present
     */
    public DevelopmentCardsDeck() throws FileNotFoundException {

        //Create the directory path
        File mDirectory = new File("./");
        String mFilePath = mDirectory.getAbsolutePath().replace(".",
                "src/main/res/DevelopmentCardDecks/");

        //Initialize 4 maps for the 4 types of cards
        mDeck.put("BUILDING", new HashMap<>());
        mDeck.put("CHARACTER", new HashMap<>());
        mDeck.put("TERRITORY", new HashMap<>());
        mDeck.put("VENTURE", new HashMap<>());

        //For each mPeriod and for each type of card, fill the corresponding Map and LinkedList
        for (int i = 1; i <= Constants.MAX_PERIODS; i++) {

            mDeck.get("BUILDING").put(i, loadDeck(mFilePath + "BuildingDeck/Tier" + i + "/"));

            mDeck.get("CHARACTER").put(i, loadDeck(  mFilePath + "CharacterDeck/Tier" +  i + "/"));

            mDeck.get("TERRITORY").put(i, loadDeck(mFilePath + "TerritoryDeck/Tier" + i + "/"));

            mDeck.get("VENTURE").put(i, loadDeck(  mFilePath + "VentureDeck/Tier" +  i + "/"));

        }

    }

    /**
     * Loads a text-based file to a string
     *
     * @param fileName name of the file to load
     * @return returns the file as a string
     * @throws FileNotFoundException
     */
    private String loadStringFromFile(String fileName) throws FileNotFoundException {

        String mStringDeck;

        Scanner mScanner = new Scanner(new File(fileName));
        mStringDeck = mScanner.useDelimiter("\\A").next();

        mScanner.close();

        return mStringDeck;
    }

    /**
     * Deserialize a card from a String using DevelopmentCardAdapter and DevelopmentCardEffectAdapter
     * @param cardString a json String
     * @return a DevelopmentCard
     */
    private DevelopmentCard loadCardFromString(String cardString) {

        //Setup Gson Builder
        Gson gsonExt = null;
        GsonBuilder builder = new GsonBuilder();

        //Register DevelopmentCard and DevelopmentCardEffect adapters
        builder.registerTypeAdapter(DevelopmentCard.class, new DevelopmentCardAdapter());
        builder.registerTypeAdapter(DevelopmentCardEffect.class, new DevelopmentCardEffectAdapter());

        //Create Gson Builder
        gsonExt = builder.create();

        return gsonExt.fromJson(cardString, DevelopmentCard.class);

    }

    /**
     * Import an object from the given file in json format
     *
     * @param fileName complete path of the file to load (from the project index)
     * @return Deck List
     * @throws FileNotFoundException
     */
    private List loadDeck(String fileName) throws FileNotFoundException {

        //Create a new Deck List
        List<DevelopmentCard> mTierDeck = new LinkedList<>();

        //Load 8 Cards
        for (int i = 1; i <= 8; i++) {
            mTierDeck.add(loadCardFromString(loadStringFromFile(fileName + i + DECK_FORMAT)));
        }

        return mTierDeck;

    }


    private int getRandomNumber(int max) {
        return mRandom.nextInt(max);
    }

    /**
     * Draw a card from of the given cardType
     *
     * It will always draw a card from the lowest tier available
     *
     * @param cardType CardType as String
     * @return DevelopmentCard of the lowest tier available
     */
    public DevelopmentCard drawCard(String cardType) {

        for (int i = 1; i <= Constants.MAX_PERIODS; i++) {

            //Check if tier is not empty
            if (!mDeck.get(cardType.toUpperCase()).get(i).isEmpty()) {

                DevelopmentCard mCard =
                        (DevelopmentCard) mDeck.get(cardType).get(i).
                                remove(getRandomNumber(mDeck.get(cardType).get(i).size()));

                //LOGGER
                mLogger.log(INFO, "Game: " + Game.GAME_ID +
                        " draw card # " + mCard.getCARD_N() +
                        " Card Name: " + mCard.getCardName() +
                        " Card Period: " + mCard.getPeriod());

                return mCard;
            }
        }
        return null;

    }

}
