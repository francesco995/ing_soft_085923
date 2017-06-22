package it.polimi.ingsw.ps09.model.Places.Market;

import com.google.gson.Gson;
import it.polimi.ingsw.ps09.model.BoardBonus;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by ale on 11/05/2017.
 */
public class MarketSpaceSpace2 extends MarketSpace {

    private File mDirectory = new File("./");

    private String mFilePath = mDirectory.getAbsolutePath().replace(".",
            "src/main/res/MarketSpacesBonus/");


    public MarketSpaceSpace2(int DiceValue) throws FileNotFoundException {
        super(DiceValue);

        Scanner mScanner = new Scanner(new File(mFilePath + "MarketSpace2.json"));
        String mStringDeck = mScanner.useDelimiter("\\A").next();
        mScanner.close();

        mBoardBonus = new Gson().fromJson(mStringDeck, BoardBonus.class);
    }
}
