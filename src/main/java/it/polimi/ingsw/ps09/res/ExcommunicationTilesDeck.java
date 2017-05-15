package it.polimi.ingsw.ps09.res;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by franc on 15/05/2017.
 */
public class ExcommunicationTilesDeck {

    private List<ExcommunicationTile> mExcommunicationTilesTierOne = new ArrayList<ExcommunicationTile>();
    private List<ExcommunicationTile> mExcommunicationTilesTierTwo = new ArrayList<ExcommunicationTile>();
    private List<ExcommunicationTile> mExcommunicationTilesTierThree = new ArrayList<ExcommunicationTile>();

    public void loadFromFile() throws FileNotFoundException {

        String mStringDeck;
        //read from a .json file and it imports it as a String into mStringDeck
        Scanner mScanner = new Scanner(new File("D:\\file.json"));
        mStringDeck = mScanner.useDelimiter("\\A").next();
        mScanner.close();
        //using Gson insert the string into mExcommunication tiles
        Type mListType = new TypeToken<ArrayList<ExcommunicationTile>>() {
        }.getType();
        mExcommunicationTilesTierOne = new Gson().fromJson(mStringDeck, mListType);

        //read from a .json file and it imports it as a String into mStringDeck
        mScanner = new Scanner(new File("D:\\file2.json"));
        mStringDeck = mScanner.useDelimiter("\\A").next();
        mScanner.close();
        //using Gson insert the string into mExcommunication tiles
        mListType = new TypeToken<ArrayList<ExcommunicationTile>>() {
        }.getType();
        mExcommunicationTilesTierTwo = new Gson().fromJson(mStringDeck, mListType);

        //read from a .json file and it imports it as a String into mStringDeck
        mScanner = new Scanner(new File("D:\\file3.json"));
        mStringDeck = mScanner.useDelimiter("\\A").next();
        mScanner.close();
        //using Gson insert the string into mExcommunication tiles
        mListType = new TypeToken<ArrayList<ExcommunicationTile>>() {
        }.getType();
        mExcommunicationTilesTierThree = new Gson().fromJson(mStringDeck, mListType);


        System.out.println(mExcommunicationTilesTierOne.get(0).getTileName());
        System.out.println(mExcommunicationTilesTierTwo.get(0).getPeriod());
        System.out.println(mExcommunicationTilesTierThree.get(0).getEffect());
    }
}
