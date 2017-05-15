package it.polimi.ingsw.ps09.model.Decks;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import it.polimi.ingsw.ps09.model.LeaderCard;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LeaderCardsDeck {

    private List<LeaderCard> mLeaderCards = new ArrayList<>();

    public void loadFromFile() throws FileNotFoundException {

        String mStringDeck;
        //read from a .json file and it imports it as a String into mStringDeck
        Scanner mScanner = new Scanner(new File("D:\\file4.json"));
        mStringDeck = mScanner.useDelimiter("\\A").next();
        mScanner.close();
        //using Gson insert the string into mExcommunication tiles
        Type mListType = new TypeToken<ArrayList<LeaderCard>>() {
        }.getType();
        mLeaderCards = new Gson().fromJson(mStringDeck, mListType);


        System.out.println(mLeaderCards.get(0).getCardName());

    }
}
