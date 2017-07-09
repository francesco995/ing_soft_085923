package it.polimi.ingsw.ps09.model.LeaderCardEffects;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import it.polimi.ingsw.ps09.model.DevelopmentCardEffects.DevelopmentCardEffect;
import it.polimi.ingsw.ps09.model.DevelopmentCards.Territory;
import it.polimi.ingsw.ps09.model.Dices.BlackDice;
import it.polimi.ingsw.ps09.model.GsonAdapters.LeaderCardEffectAdapter;
import it.polimi.ingsw.ps09.model.LeaderCard;
import it.polimi.ingsw.ps09.model.Player;
import it.polimi.ingsw.ps09.model.UserPoints;
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
public class SetOneFamilyMemberValueToSixTest {

    private Player mPlayer = new Player("Ale", "Green",1, 8 );

    private BlackDice mBlackDice = new BlackDice();

    private List<UserResources> mResourcesCosts = new ArrayList<>();
    private List<UserResources> mUserResources = new ArrayList<>();
    private List<UserPoints> mPointsCosts = new ArrayList<>();
    private List<UserPoints> mUserPoints = new ArrayList<>();
    private List<DevelopmentCardEffect> mDevelopmentCardEffects = new ArrayList<>();
    private List<DevelopmentCardEffect> mEndGameEffects = new ArrayList<>();
    private List<DevelopmentCardEffect> mPermanentEffects = new ArrayList<>();

    private Territory mTerritoryDevCard;

    private String mStringDeck;

    private Scanner mScanner;

    private Gson gson = new Gson();

    private GsonBuilder builder = new GsonBuilder();

    private LeaderCard mLeaderCard;

    private File mDirectory = new File("./");
    private String mFilePath = mDirectory.getAbsolutePath().replace(".",
            "src/main/res/LeaderCardsDeck/");


    @Before
    public void setUp() throws Exception {

        mScanner = new Scanner(new File(mFilePath + "12.json"));
        mStringDeck = mScanner.useDelimiter("\\A").next();
        mScanner.close();

        builder.registerTypeAdapter(LeaderCardEffect.class, new LeaderCardEffectAdapter());

        gson = builder.create();

        mLeaderCard = gson.fromJson(mStringDeck, LeaderCard.class);

        for(int cont = 0; cont<=4; cont++){

            mTerritoryDevCard = new Territory("first", 1, 2, mUserResources,
                    mUserPoints, mDevelopmentCardEffects, null);

            mPlayer.addTerritoryCard(mTerritoryDevCard);
        }

        mPlayer.setFamilyMemberPower("BLACK", mBlackDice);

    }

    @Test
    public void isValidTest() throws Exception {

        assertEquals(true, mLeaderCard.getLeaderCardEffect().get(0).isValid(mPlayer));

    }

    @Test
    public void doActionTest() throws Exception {

        mLeaderCard.getLeaderCardEffect().get(0).doAction(null, mPlayer, mPlayer.getFamilyMember("Black"), 0);

        assertEquals(6, mPlayer.getFamilyMember("Black").getPower());

    }

}