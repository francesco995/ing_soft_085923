package it.polimi.ingsw.ps09.model.Decks;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import it.polimi.ingsw.ps09.Constants;
import it.polimi.ingsw.ps09.model.DevelopmentCardEffects.DevelopmentCardEffect;
import it.polimi.ingsw.ps09.model.GsonAdapters.DevelopmentCardEffectAdapter;
import it.polimi.ingsw.ps09.model.GsonAdapters.LeaderCardEffectAdapter;
import it.polimi.ingsw.ps09.model.LeaderCard;
import it.polimi.ingsw.ps09.model.LeaderCardEffects.LeaderCardEffect;
import it.polimi.ingsw.ps09.model.PersonalBonusTile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by franc on 28/06/2017.
 */
public class PersonalBonusTilesDeck {


    //List of all the PersonalBonusTiles
    private ArrayList<PersonalBonusTile> mDeck = new ArrayList<>();


    /**
     * loadFromFile load all the ExcommunicationTiles in 3 different lists, one for each Period.
     * All the tiles are stored in an external .json file easily readable and editable
     * @throws FileNotFoundException - throws an exception if it cannot open file .json
     */
    /**
     * Loads the deck from file sources
     *
     * @throws FileNotFoundException
     */
    public PersonalBonusTilesDeck() throws FileNotFoundException {

        //Create the directory path
        File mDirectory = new File("./");
        String mFilePath = mDirectory.getAbsolutePath().replace(".",
                "src/main/res/PersonalBonusTilesDeck/");

        //For each mPeriod and for each type of card, fill the corresponding Map and LinkedList

        mDeck = loadDeck(mFilePath);

        //Shuffle Deck
        long seed = System.nanoTime();
        Collections.shuffle(mDeck, new Random(seed));


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

    private PersonalBonusTile loadTileFromString(String cardString) {

        Gson gsonExt = null;
        GsonBuilder builder = new GsonBuilder();

        builder.registerTypeAdapter(DevelopmentCardEffect.class, new DevelopmentCardEffectAdapter());

        gsonExt = builder.create();

        return gsonExt.fromJson(cardString, PersonalBonusTile.class);

    }

    /**
     * Import an object from the given file in json format
     *
     * @param fileName complete path of the file to load (from the project index)
     * @return
     * @throws FileNotFoundException
     */
    private ArrayList loadDeck(String fileName) throws FileNotFoundException {

        ArrayList<PersonalBonusTile> mTierDeck = new ArrayList<>();

        for (int i = 1; i <= Constants.TILE_TOTAL; i++) {
            mTierDeck.add(loadTileFromString(loadStringFromFile(fileName + i + ".json")));
        }

        return mTierDeck;

    }




    public ArrayList<PersonalBonusTile> getDeck() {
        return mDeck;
    }

}
