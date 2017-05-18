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
    /**
     *Randomly draw the hands of 4 cards for the player
     * @param mLeaderCards Deck of cards from which you want to draw the hand of cards for the player
     * @return returns List of 4 Leader Cards drawn from the passed deck
     */
    public List<LeaderCard> cardDraw(List<LeaderCard> mLeaderCards){

        List<LeaderCard> mHandOfCards = new ArrayList<LeaderCard>();
        int randomNumber;
        int size;

        for(int counter = 1;counter <= 4; counter++) {

            size = mLeaderCards.size();
            randomNumber = (int) Math.random();
            mHandOfCards.add(mLeaderCards.get(randomNumber));
            mLeaderCards.remove(randomNumber);

        }

        return mHandOfCards;
    }

}
