package it.polimi.ingsw.ps09.model.LeaderCardEffects;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import it.polimi.ingsw.ps09.model.DevelopmentCardEffects.DevelopmentCardEffect;
import it.polimi.ingsw.ps09.model.DevelopmentCards.Building;
import it.polimi.ingsw.ps09.model.DevelopmentCards.Venture;
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
 * Created by walle on 08/07/17.
 */
public class DiscountDevelopmentCardMoneyTest {

    private Player mPlayer = new Player("Ale", "Green",1, 8 );
    private Building mBuildingDevCard1;
    private Venture mVentureDevCard;


    private List<UserResources> mResourcesCosts = new ArrayList<>();
    private List<UserPoints> mPointsCosts = new ArrayList<>();
    private List<DevelopmentCardEffect> mDevelopmentCardEffects = new ArrayList<>();
    private List<DevelopmentCardEffect> mEndGameEffects = new ArrayList<>();



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

        mScanner = new Scanner(new File(mFilePath + "20.json"));
        mStringDeck = mScanner.useDelimiter("\\A").next();
        mScanner.close();

        builder.registerTypeAdapter(LeaderCardEffect.class, new LeaderCardEffectAdapter());

        gson = builder.create();

        mLeaderCard = gson.fromJson(mStringDeck, LeaderCard.class);

        for(int cont = 0; cont<=4; cont++){

            mVentureDevCard = new Venture("", 1, mResourcesCosts, mPointsCosts, mDevelopmentCardEffects,
                    null, mEndGameEffects);

            mPlayer.addVentureCard(mVentureDevCard);
        }

        for(int cont = 0; cont<=1; cont++){

            mBuildingDevCard1 = new Building("first", 1, mResourcesCosts, mPointsCosts,
                    mDevelopmentCardEffects, 1, null);

            mPlayer.addBuildingCard(mBuildingDevCard1);
        }




    }

    @Test
    public void isValidTest() throws Exception {


        assertEquals(true, mLeaderCard.getLeaderCardEffect().get(0).isValid(mPlayer));
    }

    @Test
    public void doActionTestTerritory() throws Exception {
        mPlayer.getFamilyMemberPlacementBonus().addBonus("TERRITORY", 3);

        assertEquals(3, mPlayer.getFamilyMemberPlacementBonus().getBonus("TERRITORY"));
    }

    @Test
    public void doActionTestBuilding() throws Exception {
        mPlayer.getFamilyMemberPlacementBonus().addBonus("BUILDING", 3);

        assertEquals(3, mPlayer.getFamilyMemberPlacementBonus().getBonus("BUILDING"));
    }

    @Test
    public void doActionTestVENTURE() throws Exception {
        mPlayer.getFamilyMemberPlacementBonus().addBonus("VENTURE", 3);

        assertEquals(3, mPlayer.getFamilyMemberPlacementBonus().getBonus("VENTURE"));
    }

    @Test
    public void doActionTestCharacter() throws Exception {
        mPlayer.getFamilyMemberPlacementBonus().addBonus("CHARACTER", 3);

        assertEquals(3, mPlayer.getFamilyMemberPlacementBonus().getBonus("CHARACTER"));
    }

}