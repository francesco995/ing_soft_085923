package it.polimi.ingsw.ps09.model;

import it.polimi.ingsw.ps09.model.Points.FaithPoints;
import it.polimi.ingsw.ps09.model.Points.MilitaryPoints;
import it.polimi.ingsw.ps09.model.Points.VictoryPoints;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by francesco995 on 26/05/2017.
 */
public class PlayerTest {

    //CONSTANTS
    private static final int INITIAL_SERVANT = 3;
    private static final int INITIAL_STONE = 2;
    private static final int INITIAL_WOOD = 2;


    Player mPlayer;

    @Before
    public void setUp() throws Exception {

        mPlayer = new Player("UserName", "COLOR", 100, 5);

    }

    @Test (expected = IllegalArgumentException.class)
    public void createPlayerWithNegativeCoinsException() throws Exception{

        mPlayer = new Player("UserName", "COLOR", 100, -5);

    }

    @Test (expected = IllegalArgumentException.class)
    public void createPlayerNoNameException() throws Exception{

        mPlayer = new Player("", "COLOR", 100, 5);

    }

    @Test (expected = IllegalArgumentException.class)
    public void createPlayerNoColorException() throws Exception{

        mPlayer = new Player("UserName", "", 100, 5);

    }

    @Test
    public void getUserNameTest() throws Exception {

        assertEquals("UserName", mPlayer.getUserName());

    }

    @Test
    public void getUserColorTest() throws Exception {

        assertEquals("COLOR", mPlayer.getUserColor());

    }

    @Test
    public void getLeaderCardsTest() throws Exception {

        assertEquals(0, mPlayer.getLeaderCards().size());

    }

    @Test
    public void getLeaderCardsTest2() throws Exception {

        mPlayer.add(new LeaderCard("LeaderCard", true, "effect"));

        assertEquals(1, mPlayer.getLeaderCards().size());

    }


    @Test
    public void getTerritoriesCountTest() throws Exception {

        assertEquals(0, mPlayer.getTerritoriesCount());

        //TODO: FraG add Territories Count when add method is available
    }

    @Test
    public void getCharactersCountTest() throws Exception {

        assertEquals(0, mPlayer.getCharactersCount());

        //TODO: FraG add Characters Count when add method is available

    }

    @Test
    public void getBuildingsCountTest() throws Exception {

        assertEquals(0, mPlayer.getBuildingsCount());

        //TODO: FraG add Buildings Count when add method is available

    }

    @Test
    public void getVenturesCountTest() throws Exception {

        assertEquals(0, mPlayer.getVenturesCount());

        //TODO: FraG add Ventures Count when add method is available

    }

    @Test
    public void addLeaderCardTest() throws Exception {

        mPlayer.add(new LeaderCard("LeaderCard", true, "effect"));

        assertEquals(1, mPlayer.getLeaderCards().size());

    }


    //####################################################
    //####################################################
    //############ Tests on User Resources ###############


    @Test
    public void getCoinsTest() throws Exception {

        assertEquals(5, mPlayer.getCoins().getValue());

    }

    @Test
    public void getServantTest() throws Exception {

        assertEquals(INITIAL_SERVANT, mPlayer.getServant().getValue());

    }

    @Test
    public void getStoneTest() throws Exception {

        assertEquals(INITIAL_STONE, mPlayer.getStone().getValue());

    }

    @Test
    public void getWoodTest() throws Exception {

        assertEquals(INITIAL_WOOD, mPlayer.getWood().getValue());

    }

    @Test
    public void addUserResourceTest() throws Exception {

        mPlayer.add(new UserResources(10, 10, 10,10));

        assertEquals(15, mPlayer.getCoins().getValue());
        assertEquals(10 + INITIAL_STONE, mPlayer.getStone().getValue());
        assertEquals(10 + INITIAL_SERVANT, mPlayer.getServant().getValue());
        assertEquals(10 + INITIAL_WOOD, mPlayer.getWood().getValue());

    }

    @Test
    public void hasUserResourceEqualsReturnsTrue() throws Exception {

        assertTrue(mPlayer.has(new UserResources(
                5,
                INITIAL_SERVANT,
                INITIAL_STONE,
                INITIAL_WOOD)));

    }

    @Test
    public void hasUserResourceMoreReturnsTrue() throws Exception {

        assertTrue(mPlayer.has(new UserResources(
                4,
                INITIAL_SERVANT - 1,
                INITIAL_STONE - 1,
                INITIAL_WOOD - 1)));

    }

    @Test
    public void hasUserResourceLessCoinsReturnFalse() throws Exception {

        assertFalse(mPlayer.has(new UserResources(
                6,
                INITIAL_SERVANT,
                INITIAL_STONE,
                INITIAL_WOOD
        )));

    }

    @Test
    public void hasUserResourceLessServantReturnFalse() throws Exception {

        assertFalse(mPlayer.has(new UserResources(
                5,
                INITIAL_SERVANT + 1,
                INITIAL_STONE,
                INITIAL_WOOD
        )));

    }

    @Test
    public void hasUserResourceLessStoneReturnFalse() throws Exception {

        assertFalse(mPlayer.has(new UserResources(
                5,
                INITIAL_SERVANT,
                INITIAL_STONE + 1,
                INITIAL_WOOD
        )));

    }

    @Test
    public void hasUserResourceLessWoodReturnFalse() throws Exception {

        assertFalse(mPlayer.has(new UserResources(
                5,
                INITIAL_SERVANT,
                INITIAL_STONE,
                INITIAL_WOOD + 1
        )));

    }

    @Test
    public void removeUserResourceTest() throws Exception {

        mPlayer.remove(new UserResources(2, 1, 1, 1));

        assertEquals(3, mPlayer.getCoins().getValue());
        assertEquals(INITIAL_SERVANT - 1, mPlayer.getServant().getValue());
        assertEquals(INITIAL_STONE - 1, mPlayer.getStone().getValue());
        assertEquals(INITIAL_WOOD - 1, mPlayer.getWood().getValue());

    }

    @Test (expected = UnsupportedOperationException.class)
    public void removeMoreCoinsThanHasException() throws Exception {

        mPlayer.remove(new UserResources(
                10,
                INITIAL_SERVANT,
                INITIAL_STONE,
                INITIAL_WOOD));

    }

    @Test (expected = UnsupportedOperationException.class)
    public void removeMoreServantThanHasException() throws Exception {

        mPlayer.remove(new UserResources(
                5,
                INITIAL_SERVANT + 1,
                INITIAL_STONE,
                INITIAL_WOOD));

    }

    @Test (expected = UnsupportedOperationException.class)
    public void removeMoreStoneThanHasException() throws Exception {

        mPlayer.remove(new UserResources(
                5,
                INITIAL_SERVANT,
                INITIAL_STONE + 1,
                INITIAL_WOOD));

    }

    @Test (expected = UnsupportedOperationException.class)
    public void removeMoreWoodThanHasException() throws Exception {

        mPlayer.remove(new UserResources(
                5,
                INITIAL_SERVANT,
                INITIAL_STONE,
                INITIAL_WOOD + 1));

    }


    //####################################################
    //####################################################
    //############### Tests on User Points ###############


    @Test
    public void getFaithPointsTest() throws Exception {

        assertEquals(0, mPlayer.getFaithPoints().getPoints());

    }

    @Test
    public void getMilitaryPointsTest() throws Exception {

        assertEquals(0, mPlayer.getMilitaryPoints().getPoints());

    }

    @Test
    public void getVictoryPointsTest() throws Exception {

        assertEquals(0, mPlayer.getVictoryPoints().getPoints());

    }

    @Test
    public void addFaithPointsTest() throws Exception {

        mPlayer.add(new FaithPoints(10));

        assertEquals(10, mPlayer.getFaithPoints().getPoints());

    }

    @Test
    public void addMilitaryPointsTest() throws Exception {

        mPlayer.add(new MilitaryPoints(10));

        assertEquals(10, mPlayer.getMilitaryPoints().getPoints());

    }

    @Test
    public void addVictoryPointsTest() throws Exception {

        mPlayer.add(new VictoryPoints(10));

        assertEquals(10, mPlayer.getVictoryPoints().getPoints());

    }

    @Test
    public void addUserPoints() throws Exception {

        mPlayer.add(new UserPoints(10, 10, 10));

        assertEquals(10, mPlayer.getFaithPoints().getPoints());
        assertEquals(10, mPlayer.getMilitaryPoints().getPoints());
        assertEquals(10, mPlayer.getVictoryPoints().getPoints());

    }

    @Test
    public void clearFaithPoints() throws Exception {

        mPlayer.add(new FaithPoints(100));

        assertEquals(100, mPlayer.clearFaithPoints().getPoints());
        assertEquals(0, mPlayer.getVictoryPoints().getPoints());

    }

    @Test
    public void hasUserPointsEqualsReturnsTrue() throws Exception {

        assertTrue(mPlayer.has(new UserPoints(0, 0, 0)));

    }

    @Test
    public void hasUserPointsMoreReturnsTrue() throws Exception {

        mPlayer.add(new UserPoints(10, 10, 10));

        assertTrue(mPlayer.has(new UserPoints(5, 5, 5)));

    }

    @Test
    public void hasUserPointsLessReturnsFalse() throws Exception {

        assertFalse(mPlayer.has(new UserPoints(100, 100, 100)));

    }


    @Test
    public void removeTest() throws Exception {

        mPlayer.add(new UserPoints(100, 100, 100));
        mPlayer.remove(new UserPoints(50, 50, 50));

        assertEquals(50, mPlayer.getVictoryPoints().getPoints());
        assertEquals(50, mPlayer.getMilitaryPoints().getPoints());
        assertEquals(50, mPlayer.getFaithPoints().getPoints());

    }

    @Test
    public void removeToZeroTest() throws Exception {

        mPlayer.add(new UserPoints(100, 100, 100));
        mPlayer.remove(new UserPoints(100, 100, 100));

        assertEquals(0, mPlayer.getVictoryPoints().getPoints());
        assertEquals(0, mPlayer.getMilitaryPoints().getPoints());
        assertEquals(0, mPlayer.getFaithPoints().getPoints());

    }

    @Test (expected = UnsupportedOperationException.class)
    public void removeMoreVictoryPointThanHasException() throws Exception {

        mPlayer.remove(new UserPoints(0, 0, 10));

    }

    @Test (expected = UnsupportedOperationException.class)
    public void removeMoreMilitaryPointThanHasException() throws Exception {

        mPlayer.remove(new UserPoints(0, 10, 0));

    }

    @Test (expected = UnsupportedOperationException.class)
    public void removeMoreFaithPointThanHasException() throws Exception {

        mPlayer.remove(new UserPoints(10, 0, 0));

    }



}