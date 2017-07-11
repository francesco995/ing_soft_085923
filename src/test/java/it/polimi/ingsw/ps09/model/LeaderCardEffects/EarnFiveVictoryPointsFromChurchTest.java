package it.polimi.ingsw.ps09.model.LeaderCardEffects;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import it.polimi.ingsw.ps09.model.GsonAdapters.LeaderCardEffectAdapter;
import it.polimi.ingsw.ps09.model.LeaderCard;
import it.polimi.ingsw.ps09.model.Player;
import it.polimi.ingsw.ps09.model.Points.VictoryPoints;
import it.polimi.ingsw.ps09.model.Resources.Coins;
import it.polimi.ingsw.ps09.model.Resources.Servant;
import it.polimi.ingsw.ps09.model.Resources.Stone;
import it.polimi.ingsw.ps09.model.Resources.Wood;
import it.polimi.ingsw.ps09.model.UserResources;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.*;

/**
 * Created by walle on 09/07/17.
 */
public class EarnFiveVictoryPointsFromChurchTest {

    private Player mPlayer = new Player("Ale", "Green",1, 8 );

    private UserResources mUserResources;
    private Wood mWood;
    private Coins mCoins;
    private Servant mServant;
    private Stone mStone;

    private VictoryPoints mVictoryPoints;

    private String mStringDeck;

    private Scanner mScanner;

    private Gson gson = new Gson();

    private GsonBuilder builder = new GsonBuilder();

    private LeaderCard mLeaderCard;

    private File mDirectory = new File("./");
    private String mFilePath = mDirectory.getAbsolutePath().replace(".",
            "src/main/res/LeaderCardsDeckTest/");



    @Before
    public void setUp() throws Exception {

        mWood = new Wood(7);
        mCoins = new Coins(7);
        mServant = new Servant(7);
        mStone = new Stone(7);

        mUserResources = new UserResources(mCoins, mServant, mStone, mWood);

        mVictoryPoints = new VictoryPoints(2);

        mPlayer.add(mUserResources);
        mPlayer.add(mVictoryPoints);

        mScanner = new Scanner(new File(mFilePath + "14.json"));
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

        mLeaderCard.getLeaderCardEffect().get(0).doAction(null, mPlayer, null, 0);

        assertEquals(7, mPlayer.getVictoryPoints().getValue());

    }

}