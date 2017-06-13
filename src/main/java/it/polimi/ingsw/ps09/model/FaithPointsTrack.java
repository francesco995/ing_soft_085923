package it.polimi.ingsw.ps09.model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import it.polimi.ingsw.ps09.model.Points.FaithPoints;
import it.polimi.ingsw.ps09.model.Points.VictoryPoints;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;

public class FaithPointsTrack {

    private List<VictoryPoints> mVictoryPointsBonus = new ArrayList<VictoryPoints>();


    /**
     * loadFromFile load all the Victory Points bonus of the track form one file.
     * All stored into a .json file easily readable and editable
     * @throws FileNotFoundException - throws an exception if it cannot open file .json
     */

    public void loadFromFile() throws FileNotFoundException {


        File mDirectory = new File("./");

        String mFilePath = mDirectory.getAbsolutePath().replace(".",
                "src\\main\\res\\");

        String mStringDeck;

        //read from a .json file and it imports it as a String into mStringDeck
        Scanner mScanner = new Scanner(new File(mFilePath+ "FaithPointsTrack.json"));
        mStringDeck = mScanner.useDelimiter("\\A").next();
        mScanner.close();

        //using Gson insert the string into mExcommunication tiles
        Type mListType = new TypeToken<ArrayList<VictoryPoints>>() {
        }.getType();
        mVictoryPointsBonus = new Gson().fromJson(mStringDeck, mListType);


    }

    /**
     * Returns the Victory Points bonus linked to the amount of points offered
     * @param offer FaithPoints variable passed by Game
     * @return the ammount of Victory Points that you get by offering to the church 
     */
    public VictoryPoints convertToBonus(FaithPoints offer){

        int amount = offer.getValue();

        return mVictoryPointsBonus.get(amount);

    }

    //TO STRING
    @Override
    public String toString(){
        String mStringTrack ="\n";

        mStringTrack = mStringTrack + "Faith Track Bonus:\n";

           for(int i=0;i<mVictoryPointsBonus.size(); i++)
           {
               mStringTrack = mStringTrack + "bonus " + (i+1) +": " + mVictoryPointsBonus.get(i).getValue() + ";";
           }

           return mStringTrack.toString();
        }
    }

