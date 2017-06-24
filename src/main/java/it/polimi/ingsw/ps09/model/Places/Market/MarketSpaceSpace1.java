package it.polimi.ingsw.ps09.model.Places.Market;

import com.google.gson.Gson;
import it.polimi.ingsw.ps09.model.BoardBonus;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by ale on 11/05/2017.
 */
public class MarketSpaceSpace1 extends MarketSpace {

    private File mDirectory = new File("./");

    private String mFilePath = mDirectory.getAbsolutePath().replace(".",
            "src/main/res/MarketSpacesBonus/");


    public MarketSpaceSpace1(int DiceValue, int Index) throws FileNotFoundException {
        super(DiceValue, Index);

        Scanner mScanner = new Scanner(new File(mFilePath + "MarketSpace1.json"));
        String mStringDeck = mScanner.useDelimiter("\\A").next();
        mScanner.close();

        mBoardBonus = new Gson().fromJson(mStringDeck, BoardBonus.class);
    }

    //TODO: ale Receive Bonus object created by FraL

}
