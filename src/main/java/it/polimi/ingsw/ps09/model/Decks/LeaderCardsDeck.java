package it.polimi.ingsw.ps09.model.Decks;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import it.polimi.ingsw.ps09.model.GsonAdapters.LeaderCardEffectAdapter;
import it.polimi.ingsw.ps09.model.LeaderCard;
import it.polimi.ingsw.ps09.model.LeaderCardEffects.LeaderCardEffect;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LeaderCardsDeck {

    private final static int CARD_TOTAL = 20;
    private final static int HAND_SIZE = 4;

    //This list is the full deck of LeaderCards
    private List<LeaderCard> mDeck = new ArrayList<>();


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
    public LeaderCardsDeck() throws FileNotFoundException {

        //Create the directory path
        File mDirectory = new File("./");
        String mFilePath = mDirectory.getAbsolutePath().replace(".",
                "src/main/res/LeaderCardsDeck/");

        //For each period and for each type of card, fill the corresponding Map and LinkedList

        mDeck = loadDeck(mFilePath);


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

    private LeaderCard loadCardFromString(String cardString) {

        Gson gsonExt = null;
        GsonBuilder builder = new GsonBuilder();

        builder.registerTypeAdapter(LeaderCardEffect.class, new LeaderCardEffectAdapter());

        gsonExt = builder.create();

        return gsonExt.fromJson(cardString, LeaderCard.class);

    }

    /**
     * Import an object from the given file in json format
     *
     * @param fileName complete path of the file to load (from the project index)
     * @return
     * @throws FileNotFoundException
     */
    private List loadDeck(String fileName) throws FileNotFoundException {

        List<LeaderCard> mTierDeck = new ArrayList<>();

        for (int i = 1; i <= CARD_TOTAL; i++) {
            mTierDeck.add(loadCardFromString(loadStringFromFile(fileName + i + ".json")));
        }

        return mTierDeck;

    }


    /**
     *Randomly draw the hands of 4 cards for the player
     * @param mLeaderCards Deck of cards from which you want to draw the hand of cards for the player
     * @return returns List of 4 Leader Cards drawn from the passed deck
     */
    public List<LeaderCard> cardDraw(List<LeaderCard> mLeaderCards){

        List<LeaderCard> mHandOfCards = new ArrayList<LeaderCard>();
        int randomNumber;

        for(int counter = 1;counter <= HAND_SIZE; counter++) {

            randomNumber = (int) Math.random() * mLeaderCards.size();
            mHandOfCards.add(mLeaderCards.get(randomNumber));
            mLeaderCards.remove(randomNumber);

        }

        return mHandOfCards;
    }

    public static int getCardTotal() {
        return CARD_TOTAL;
    }

    public static int getHandSize() {
        return HAND_SIZE;
    }

    public List<LeaderCard> getDeck() {
        return mDeck;
    }
}
