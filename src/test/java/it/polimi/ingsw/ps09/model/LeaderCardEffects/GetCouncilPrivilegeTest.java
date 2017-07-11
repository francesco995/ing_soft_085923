package it.polimi.ingsw.ps09.model.LeaderCardEffects;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import it.polimi.ingsw.ps09.model.GsonAdapters.LeaderCardEffectAdapter;
import it.polimi.ingsw.ps09.model.LeaderCard;
import it.polimi.ingsw.ps09.model.Player;
import it.polimi.ingsw.ps09.model.Resources.Servant;
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
public class GetCouncilPrivilegeTest {

    private Player mPlayer = new Player("Ale", "Green",1, 8 );
    private Servant mServant;


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


        mScanner = new Scanner(new File(mFilePath + "19.json"));
        mStringDeck = mScanner.useDelimiter("\\A").next();
        mScanner.close();

        builder.registerTypeAdapter(LeaderCardEffect.class, new LeaderCardEffectAdapter());

        gson = builder.create();

        mLeaderCard = gson.fromJson(mStringDeck, LeaderCard.class);

        mServant = new Servant(20);

        mPlayer.add(mServant);

    }

    @Test
    public void isValid() throws Exception {

        assertEquals(true, mLeaderCard.getLeaderCardEffect().get(0).isValid(mPlayer));

    }

    @Test
    public void doAction() throws Exception {

        mLeaderCard.getLeaderCardEffect().get(0).doAction(null, mPlayer, null, 0);

        assertEquals(1, mPlayer.getCouncilPrivilege());

    }

}