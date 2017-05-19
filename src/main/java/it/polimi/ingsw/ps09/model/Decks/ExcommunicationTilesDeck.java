package it.polimi.ingsw.ps09.model.Decks;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import it.polimi.ingsw.ps09.model.ExcommunicationTile;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Type;
import java.util.*;

import static sun.plugin2.os.windows.OSVERSIONINFOA.size;

/**
 * Created by franc on 15/05/2017.
 */
public class ExcommunicationTilesDeck {

    //DEFINE

    static final int MAX_PERIODS = 3;


    //three ExcommunicationTile list one for each period

    private Map<Integer,List<ExcommunicationTile>> mExcommunicationTilesDecks = new HashMap<Integer,List<ExcommunicationTile>>();



    /**
     * loadFromFile load all the ExcommunicationTiles in 3 different lists, one for each Period.
     * All the tiles are stored in an external .json file easily readable and editable
     * @throws FileNotFoundException - throws an exception if it cannot open file .json
     */
    public void loadFromFile() throws FileNotFoundException {

        //crea percorso comune a tutti i file
        File mDirectory = new File("./");

        String mFilePath = mDirectory.getAbsolutePath().replace(".",
                "src\\main\\res\\ExcommunicationTilesDecks\\");


        for (int i = 1; i <= MAX_PERIODS; i++ ) {

            String mStringDeck;

            //read from a .json file and it imports it as a String into mStringDeck

            Scanner mScanner = new Scanner(new File(mFilePath + "ExcommunicationDeck" + i + ".json"));
            System.out.println(mFilePath + "ExcommunicationDeck" + i + ".json");
            mStringDeck = mScanner.useDelimiter("\\A").next();
            mScanner.close();

            //using Gson insert the string into mExcommunicationtilesDecks

            Type mListType = new TypeToken<ArrayList<ExcommunicationTile>>() {
            }.getType();

            mExcommunicationTilesDecks.put(i,new Gson().fromJson(mStringDeck, mListType));
        }


    }


     //random card picker
     /**
     *Randomly draw a tile from the List passed and returns the single tile drawn
     * @param period of tiles from which you want to draw the single tile
     * @return return object ExcommunicationTile drawn from the whole list
     */
    public ExcommunicationTile drawCard(int period){


        int size = mExcommunicationTilesDecks.get(period).size();
        int randomNumber = (int) Math.random() * size;
        return mExcommunicationTilesDecks.get(period).get(randomNumber);


    }
}
