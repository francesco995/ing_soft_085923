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


    //This list is the full deck of LeaderCards
    private List<LeaderCard> mLeaderCards = new ArrayList<>();


    /**
     * loadFromFile load all the Leader Cards in one lists.
     * All the cards are stored in an external .json file easily readable and editable
     * @throws FileNotFoundException - throws an exception if it cannot open file .json
     */
    public void loadFromFile() throws FileNotFoundException {

        File mDirectory = new File("./");

        String mFilePath = mDirectory.getAbsolutePath().replace(".",
                "src\\main\\res\\");

        String mStringDeck;

        //read from a .json file and it imports it as a String into mStringDeck
        Scanner mScanner = new Scanner(new File(mFilePath+ "LeaderCardsDeck.json"));
        mStringDeck = mScanner.useDelimiter("\\A").next();
        mScanner.close();

        //using Gson insert the string into mExcommunication tiles
        Type mListType = new TypeToken<ArrayList<LeaderCard>>() {
        }.getType();
        mLeaderCards = new Gson().fromJson(mStringDeck, mListType);


    }


    /**
     *Randomly draw the hands of 4 cards for the player
     * @param mLeaderCards Deck of cards from which you want to draw the hand of cards for the player
     * @return returns List of 4 Leader Cards drawn from the passed deck
     */
    public List<LeaderCard> cardDraw(List<LeaderCard> mLeaderCards){

        List<LeaderCard> mHandOfCards = new ArrayList<LeaderCard>();
        int randomNumber;

        for(int counter = 1;counter <= 4; counter++) {

            randomNumber = (int) Math.random() * mLeaderCards.size();
            mHandOfCards.add(mLeaderCards.get(randomNumber));
            mLeaderCards.remove(randomNumber);

        }

        return mHandOfCards;
    }

}
