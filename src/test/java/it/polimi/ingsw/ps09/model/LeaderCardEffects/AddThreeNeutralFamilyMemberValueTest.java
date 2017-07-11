package it.polimi.ingsw.ps09.model.LeaderCardEffects;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import it.polimi.ingsw.ps09.model.Dices.BlackDice;
import it.polimi.ingsw.ps09.model.FamilyMembers.NeutralFamilyMember;
import it.polimi.ingsw.ps09.model.GsonAdapters.LeaderCardEffectAdapter;
import it.polimi.ingsw.ps09.model.LeaderCard;
import it.polimi.ingsw.ps09.model.Player;
import it.polimi.ingsw.ps09.model.Points.FaithPoints;
import it.polimi.ingsw.ps09.model.Points.MilitaryPoints;
import it.polimi.ingsw.ps09.model.Resources.Wood;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.*;

/**
 * Created by walle on 08/07/17.
 */
public class AddThreeNeutralFamilyMemberValueTest {

    Player mPlayer = new Player("Ale", "Green",1, 8 );
    BlackDice mBlackDice = new BlackDice();

    MilitaryPoints mMilitaryPoints = new MilitaryPoints(8);
    FaithPoints mFaithPoints = new FaithPoints(4);


    String mStringDeck;

    Scanner mScanner;

    Gson gson = new Gson();

    GsonBuilder builder = new GsonBuilder();

    LeaderCard mLeaderCard;

    File mDirectory = new File("./");
    String mFilePath = mDirectory.getAbsolutePath().replace(".",
            "src/main/res/LeaderCardsDeckTest/");



    @Before
    public void setUp() throws Exception {


        mPlayer.add(mFaithPoints);
        mPlayer.add(mMilitaryPoints);
        mBlackDice.setValue(2);
        mPlayer.getFamilyMember("Neutral").setPower(mBlackDice);


        mScanner = new Scanner(new File(mFilePath + "4.json"));
        mStringDeck = mScanner.useDelimiter("\\A").next();
        mScanner.close();

        builder.registerTypeAdapter(LeaderCardEffect.class, new LeaderCardEffectAdapter());

        gson = builder.create();

        mLeaderCard = gson.fromJson(mStringDeck, LeaderCard.class);


    }

    @Test
    public void isValidTest() throws Exception {


        assertEquals(true, mLeaderCard.getLeaderCardEffect().get(0).isValid(mPlayer));


    }

    @Test
    public void doActionTest() throws Exception {

        mLeaderCard.getLeaderCardEffect().get(0).doAction(null, mPlayer,null, 0);

        assertEquals(5, mPlayer.getFamilyMember("Neutral").getPower());

    }

}