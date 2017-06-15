package it.polimi.ingsw.ps09.model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import it.polimi.ingsw.ps09.model.Points.VictoryPoints;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Player bonus on personal board, can be loaded from editable file
 */
public class PersonalBoardBonus {


    private List<VictoryPoints> mTerritoriesBonus = new ArrayList<VictoryPoints>();
    private List<VictoryPoints> mCharacterBonus = new ArrayList<VictoryPoints>();

    public PersonalBoardBonus() throws FileNotFoundException {
        loadTerritoriesBonus();
        loadCharacterBonus();
    }

    /**
     * loadTerritoriesBonus load all the Victory Points bonus of the Territories form one file.
     * All stored into a .json file easily readable and editable
     * @throws FileNotFoundException - throws an exception if it cannot open file .json
     */

    public void loadTerritoriesBonus() throws FileNotFoundException {


        File mDirectory = new File("./");

        String mFilePath = mDirectory.getAbsolutePath().replace(".",
                "src/main/res/PersonalBoardBonus/");

        String mStringDeck;

        //read from a .json file and it imports it as a String into mStringDeck
        Scanner mScanner = new Scanner(new File(mFilePath+ "TerritoriesBonus.json"));
        mStringDeck = mScanner.useDelimiter("\\A").next();
        mScanner.close();

        //using Gson insert the string into mExcommunication tiles
        Type mListType = new TypeToken<ArrayList<VictoryPoints>>() {
        }.getType();
        mTerritoriesBonus = new Gson().fromJson(mStringDeck, mListType);


    }

    /**
     * loadCharacterBonus load all the Bonus of Character from one file
     * @throws FileNotFoundException -throws exception if it cannot open .json file
     */
    public void loadCharacterBonus() throws FileNotFoundException {


        File mDirectory = new File("./");

        String mFilePath = mDirectory.getAbsolutePath().replace(".",
                "src/main/res/PersonalBoardBonus/");

        String mStringDeck;

        //read from a .json file and it imports it as a String into mStringDeck
        Scanner mScanner = new Scanner(new File(mFilePath+ "CharactersBonus.json"));
        mStringDeck = mScanner.useDelimiter("\\A").next();
        mScanner.close();

        //using Gson insert the string into mExcommunication tiles
        Type mListType = new TypeToken<ArrayList<VictoryPoints>>() {
        }.getType();
        mCharacterBonus = new Gson().fromJson(mStringDeck, mListType);


    }

    //TO STRING
    @Override
    public String toString(){
        String mBonus ="\n";

        mBonus += "Territories Bonus";
        for (int i = 0; i<mTerritoriesBonus.size(); i++){
            mBonus += (i+1) + "->" + mTerritoriesBonus.get(i).getValue();
        }
        mBonus += "\n";
        mBonus += "Characters Bonus";
        for (int i = 0; i<mCharacterBonus.size(); i++){
            mBonus += (i+1) + "->" + mCharacterBonus.get(i).getValue();
        }

        return mBonus;

    }


    /**
     * return the number of victory points linked to the number of card owned by the player
     * @param number its the number of Territory card that the player has
     * @return
     */
    public VictoryPoints EndTerritoriesBonus(int number){

        return mTerritoriesBonus.get(number);

    }

    /**
     * return the number of victory points linked to the number of card owned by the player
     * @param number its the number of Character card that the player has
     * @return
     */
    public VictoryPoints EndCharactersBonus(int number){

        return mCharacterBonus.get(number);

    }



    //getters

    public List<VictoryPoints> getTerritoriesBonus() {
        return mTerritoriesBonus;
    }

    public List<VictoryPoints> getCharacterBonus() {
        return mCharacterBonus;
    }
}
