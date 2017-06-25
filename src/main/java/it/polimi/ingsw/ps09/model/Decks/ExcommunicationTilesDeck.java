package it.polimi.ingsw.ps09.model.Decks;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import it.polimi.ingsw.ps09.model.ExcommunicationTile;
import it.polimi.ingsw.ps09.model.ExcommunicationTileEffects.ExcommunicationTileEffect;
import it.polimi.ingsw.ps09.model.GsonAdapters.ExcommunicationTileEffectAdapter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * This is a container of all the different excommunication tiles in the game
 * they all get charged into a single HashMap.
 * It also offers the draw card method
 */
public class ExcommunicationTilesDeck {

    //three ExcommunicationTile list one for each period

    private Map<Integer, List<ExcommunicationTile>> mDeck = new HashMap<Integer, List<ExcommunicationTile>>();


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
    public ExcommunicationTilesDeck() throws FileNotFoundException {

        //Create the directory path
        File mDirectory = new File("./");
        String mFilePath = mDirectory.getAbsolutePath().replace(".",
                "src/main/res/ExcommunicationTilesDecks/");


        //For each period and for each type of card, fill the corresponding Map and LinkedList

        mDeck.put(1, loadDeck(mFilePath + "/Tier1/"));

        mDeck.put(2, loadDeck(mFilePath + "/Tier2/"));

        mDeck.put(3, loadDeck(mFilePath + "/Tier3/"));


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

    private ExcommunicationTile loadCardFromString(String cardString) {

        Gson gsonExt = null;
        GsonBuilder builder = new GsonBuilder();

        builder.registerTypeAdapter(ExcommunicationTileEffect.class, new ExcommunicationTileEffectAdapter());

        gsonExt = builder.create();

        return gsonExt.fromJson(cardString, ExcommunicationTile.class);

    }

    /**
     * Import an object from the given file in json format
     *
     * @param fileName complete path of the file to load (from the project index)
     * @return
     * @throws FileNotFoundException
     */
    private List loadDeck(String fileName) throws FileNotFoundException {

        List<ExcommunicationTile> mTierDeck = new ArrayList<>();

        for (int i = 1; i <= 7; i++) {
            mTierDeck.add(loadCardFromString(loadStringFromFile(fileName + i + ".json")));
        }

        return mTierDeck;

    }


    //random card picker

    /**
     * Randomly draw a tile from the List passed and returns the single tile drawn
     *
     * @param period of tiles from which you want to draw the single tile
     * @return return object ExcommunicationTile drawn from the whole list
     */
    public ExcommunicationTile drawCard(int period) {


        int size = mDeck.get(period).size();
        int randomNumber = (int) Math.random() * size;
        return mDeck.get(period).get(randomNumber);


    }

    public Map<Integer, List<ExcommunicationTile>> getDeck() {
        return mDeck;
    }
}
