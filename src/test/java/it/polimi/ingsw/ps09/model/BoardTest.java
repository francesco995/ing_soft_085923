package it.polimi.ingsw.ps09.model;

import it.polimi.ingsw.ps09.model.Decks.ExcommunicationTilesDeck;
import it.polimi.ingsw.ps09.model.DevelopmentCards.DevelopmentCard;
import it.polimi.ingsw.ps09.model.Dices.BlackDice;
import it.polimi.ingsw.ps09.model.Dices.OrangeDice;
import it.polimi.ingsw.ps09.model.Dices.WhiteDice;
import it.polimi.ingsw.ps09.model.ExcommunicationTileEffects.ExcommunicationTileEffect;
import it.polimi.ingsw.ps09.model.FamilyMembers.BlackFamilyMember;
import it.polimi.ingsw.ps09.model.FamilyMembers.FamilyMember;
import it.polimi.ingsw.ps09.model.Places.Council;
import it.polimi.ingsw.ps09.model.Places.HarvestAndProductionAreas.Harvest;
import it.polimi.ingsw.ps09.model.Places.HarvestAndProductionAreas.Production;
import it.polimi.ingsw.ps09.model.Places.Market.Market;
import it.polimi.ingsw.ps09.model.Places.Market.MarketSpaceSpace1;
import it.polimi.ingsw.ps09.model.Places.Towers.BuildingsTower;
import it.polimi.ingsw.ps09.model.Places.Towers.CharactersTower;
import it.polimi.ingsw.ps09.model.Places.Towers.TerritoriesTower;
import it.polimi.ingsw.ps09.model.Places.Towers.VenturesTower;
import it.polimi.ingsw.ps09.model.Points.FaithPoints;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by walle on 09/07/17.
 */
public class BoardTest {

    private Board mBoard;
    private ExcommunicationTilesDeck mExcommunicationTilesDeck;

    private BlackFamilyMember mBlackFamilyMember;

    private BoardBonus mBoardBonus;

    private DevelopmentCard mDevelopmentCard;


    @Before
    public void setUp() throws Exception {

        mExcommunicationTilesDeck = new ExcommunicationTilesDeck();

        mBoard = new Board(mExcommunicationTilesDeck.drawCard(1), mExcommunicationTilesDeck.drawCard(2),
                mExcommunicationTilesDeck.drawCard(3));

        mBlackFamilyMember = new BlackFamilyMember("Smith");

        mBoard.getMarketList().get(0).setFamilyMember(mBlackFamilyMember);

        mBoardBonus = new BoardBonus(null, null, 2);

        mDevelopmentCard = mBoard.getCharacterTowerCard(0);

    }


    @Test
    public void getMarketListTest() throws Exception{

        assertEquals(4, mBoard.getMarketList().size());

    }

    @Test
    public void getMarketTest() throws Exception{

        assertEquals(1, mBoard.getMarket().getMarketList().get(0).getDiceValue());

    }

    @Test
    public void getMarketFamilyMemberTest() throws Exception {

        assertEquals("Smith", mBoard.getMarketFamilyMember(0).getFamily());
    }

    @Test
    public void getMarketBonusTest() throws Exception{

        assertEquals(5, mBoard.getMarketBonus(0).getResourcesBonus().getCoins().getValue());

    }

    @Test
    public void getMarketDiceValueTest() throws Exception{

        assertEquals(1, mBoard.getMarketDiceValue(0));

    }

    @Test
    public void isMarketSpaceAvailableTestFalse() throws Exception{

        assertEquals(false, mBoard.isMarketSpaceAvailable(0));

    }

    @Test
    public void isMarketSpaceAvailableTestTrue() throws Exception{

        assertEquals(true, mBoard.isMarketSpaceAvailable(1));

    }

    @Test
    public void setMarketSpaceFamilyMemberTest() throws Exception{

        mBoard.setMarketSpaceFamilyMember(1, mBlackFamilyMember);

        assertEquals(false, mBoard.isMarketSpaceAvailable(1));

    }

    @Test
    public void setMarketSpaceBonusTest() throws Exception{

        mBoard.setMarketSpaceBonus(1, mBoardBonus);

        assertEquals(2, mBoard.getMarketBonus(1).getPrivilegesCount());


    }

    @Test
    public void setMarketSpaceDiceValueTest() throws Exception{

        mBoard.setMarketSpaceDiceValue(0, 2);

        assertEquals(2, mBoard.getMarketDiceValue(0));

    }

    @Test
    public void getCouncilTest() throws Exception{

        assertEquals(0, mBoard.getCouncil().getList().size());

    }

    @Test
    public void getCouncilListTest() throws Exception{

        assertEquals(0, mBoard.getCouncilList().size());

    }

    @Test
    public void addMemberCouncilTest() throws Exception{

        mBoard.addMemberCouncil(mBlackFamilyMember);

        assertEquals(1, mBoard.getCouncilList().size());

    }

    @Test
    public void getProductionTest() throws Exception{

        assertEquals(0, mBoard.getProduction().getList().size());

    }

    @Test
    public void getProductionListTest() throws Exception{

        assertEquals(0, mBoard.getProductionList().size());

    }

    @Test
    public void getProductionSlotDiceValueTestOne() throws Exception{

        assertEquals(1, mBoard.getProductionSlotDiceValue());

    }

    @Test
    public void getProductionSlotDiceValueTestThree() throws Exception{

        mBoard.getProduction().addMember(mBlackFamilyMember);

        assertEquals(3, mBoard.getProductionSlotDiceValue());

    }


    @Test
    public void getHarvestTest() throws Exception{

        assertEquals(0, mBoard.getHarvest().getList().size());

    }

    @Test
    public void getHarvestListTest() throws Exception{

        assertEquals(0, mBoard.getHarvestList().size());

    }

    @Test
    public void getHarvestSlotDiceValueTestOne() throws Exception{

        assertEquals(1, mBoard.getHarvestSlotDiceValue());

    }

    @Test
    public void getHarvestSlotDiceValueTestThree() throws Exception{

        mBoard.getHarvest().addMember(mBlackFamilyMember);

        assertEquals(3, mBoard.getHarvestSlotDiceValue());

    }

    @Test
    public void getCharactersTowerTest() throws Exception{

        assertEquals(4, mBoard.getCharactersTower().getFloors().size());

    }

    @Test
    public void isCharacterTowerAvailableTestFalse() throws Exception{

        assertEquals(false, mBoard.isCharacterTowerAvailable());

    }

    @Test
    public void isCharacterTowerAvailableTestTrue() throws Exception{

        mBoard.getCharactersTower().getFloor(0).setFamilyMember(mBlackFamilyMember);

        assertEquals(true, mBoard.isCharacterTowerAvailable());

    }

    @Test
    public void setCharacterTowerCardTest() throws Exception{

        mBoard.setCharacterTowerCard(1, mDevelopmentCard);

        assertEquals(true, mBoard.getCharacterTowerCard(1)==mDevelopmentCard);


    }

    @Test
    public void getTerritoriesTowerTest() throws Exception{

        assertEquals(4, mBoard.getTerritoriesTower().getFloors().size());

    }

    @Test
    public void isTerritoriesTowerAvailableTestFalse() throws Exception{

        assertEquals(false, mBoard.isTerritoriesTowerAvailable());

    }

    @Test
    public void isTerritoriesTowerAvailableTestTrue() throws Exception{

        mBoard.getTerritoriesTower().getFloor(0).setFamilyMember(mBlackFamilyMember);

        assertEquals(true, mBoard.isTerritoriesTowerAvailable());

    }

    @Test
    public void setTerritoriesTowerCardTest() throws Exception{

        mBoard.setTerritoriesTowerCard(1, mDevelopmentCard);

        assertEquals(true, mBoard.getTerritoriesTowerCard(1)==mDevelopmentCard);


    }

    @Test
    public void getVenturesTowerTest() throws Exception{

        assertEquals(4, mBoard.getVenturesTower().getFloors().size());

    }

    @Test
    public void isVenturesTowerAvailableTestFalse() throws Exception{

        assertEquals(false, mBoard.isVenturesTowerAvailable());

    }

    @Test
    public void isVenturesTowerAvailableTestTrue() throws Exception{

        mBoard.getVenturesTower().getFloor(0).setFamilyMember(mBlackFamilyMember);

        assertEquals(true, mBoard.isVenturesTowerAvailable());

    }

    @Test
    public void setVenturesTowerCardTest() throws Exception{

        mBoard.setVenturesTowerCard(1, mDevelopmentCard);

        assertEquals(true, mBoard.getVenturesTowerCard(1)==mDevelopmentCard);


    }

    @Test
    public void getBuildingsTowerTest() throws Exception{

        assertEquals(4, mBoard.getBuildingsTower().getFloors().size());

    }

    @Test
    public void isBuildingsTowerAvailableTestFalse() throws Exception{

        assertEquals(false, mBoard.isBuildingsTowerAvailable());

    }

    @Test
    public void isBuildingsTowerAvailableTestTrue() throws Exception{

        mBoard.getBuildingsTower().getFloor(0).setFamilyMember(mBlackFamilyMember);

        assertEquals(true, mBoard.isBuildingsTowerAvailable());

    }

    @Test
    public void setBuildingsTowerCardTest() throws Exception{

        mBoard.setBuildingsTowerCard(1, mDevelopmentCard);

        assertEquals(true, mBoard.getBuildingsTowerCard(1)==mDevelopmentCard);


    }

    @Test
    public void setBlackDiceTest() throws Exception{

        mBoard.setBlackDice(3);

        assertEquals(3, mBoard.getBlackDice().getValue());

    }

    @Test
    public void setWhiteDiceTest() throws Exception{

        mBoard.setWhiteDice(3);

        assertEquals(3, mBoard.getWhiteDice().getValue());

    }

    @Test
    public void setOrangeDiceTest() throws Exception{

        mBoard.setOrangeDice(3);

        assertEquals(3, mBoard.getOrangeDice().getValue());

    }

    @Test
    public void clearAllHarvestTest() throws Exception{

        mBoard.getHarvest().addMember(mBlackFamilyMember);

        mBoard.clearAll();

        assertEquals(0, mBoard.getHarvestList().size());

    }

    @Test
    public void clearAllProductionTest() throws Exception{

        mBoard.getProduction().addMember(mBlackFamilyMember);

        mBoard.clearAll();

        assertEquals(0, mBoard.getProductionList().size());

    }

    @Test
    public void clearAllMarketTest() throws Exception{

        mBoard.getMarketList().get(0).setFamilyMember(mBlackFamilyMember);

        mBoard.clearAll();

        assertEquals(null, mBoard.getMarketList().get(0).getFamilyMember());

    }

    @Test
    public void clearAllTerritoriesTowerTest() throws Exception{

        mBoard.setTerritoriesTowerFamilyMember(0, mBlackFamilyMember);

        mBoard.clearAll();

        assertEquals(null, mBoard.getTerritoriesTowerFamilyMember(0));

    }

    @Test
    public void clearAllBuildingsTowerTest() throws Exception{

        mBoard.setBuildingsTowerFamilyMember(0, mBlackFamilyMember);

        mBoard.clearAll();

        assertEquals(null, mBoard.getBuildingsTowerFamilyMember(0));

    }

    @Test
    public void clearAllVentureTowerTest() throws Exception{

        mBoard.setVenturesTowerFamilyMember(0, mBlackFamilyMember);

        mBoard.clearAll();

        assertEquals(null, mBoard.getVenturesTowerFamilyMember(0));

    }

    @Test
    public void clearAllCharacterTowerTest() throws Exception{

        mBoard.setCharacterTowerFamilyMember(0, mBlackFamilyMember);

        mBoard.clearAll();

        assertEquals(null, mBoard.getCharacterTowerFamilyMember(0));

    }

}