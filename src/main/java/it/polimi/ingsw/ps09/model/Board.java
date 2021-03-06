package it.polimi.ingsw.ps09.model;

import it.polimi.ingsw.ps09.model.DevelopmentCards.DevelopmentCard;
import it.polimi.ingsw.ps09.model.Dices.BlackDice;
import it.polimi.ingsw.ps09.model.Dices.OrangeDice;
import it.polimi.ingsw.ps09.model.Dices.WhiteDice;
import it.polimi.ingsw.ps09.model.FamilyMembers.FamilyMember;
import it.polimi.ingsw.ps09.model.Places.Council;
import it.polimi.ingsw.ps09.model.Places.HarvestAndProductionAreas.Harvest;
import it.polimi.ingsw.ps09.model.Places.HarvestAndProductionAreas.Production;
import it.polimi.ingsw.ps09.model.Places.Market.Market;
import it.polimi.ingsw.ps09.model.Places.Market.MarketSpace;
import it.polimi.ingsw.ps09.model.Places.Towers.BuildingsTower;
import it.polimi.ingsw.ps09.model.Places.Towers.CharactersTower;
import it.polimi.ingsw.ps09.model.Places.Towers.TerritoriesTower;
import it.polimi.ingsw.ps09.model.Places.Towers.VenturesTower;

import java.util.*;

/**
 * Created by ale on 14/05/2017.
 */
public class Board{

    private Market mMarket;
    private Council mCouncil;
    private Production mProductionArea;
    private Harvest mHarvestArea;

    private CharactersTower mCharactersTower;
    private TerritoriesTower mTerritoriesTower;
    private VenturesTower mVenturesTower;
    private BuildingsTower mBuildingsTower;

    private ExcommunicationTile mExcommunicationTile1;
    private ExcommunicationTile mExcommunicationTile2;
    private ExcommunicationTile mExcommunicationTile3;
    private ArrayList<ExcommunicationTile> mExcommunicationTilesList;

    private Order mOrder;

    private BlackDice mBlackDice;
    private OrangeDice mOrangeDice;
    private WhiteDice mWhiteDice;

    /**
     * Create the board whit market, harvest, production, towers, church and council
     */
    public Board(ExcommunicationTile ExcomTile1, ExcommunicationTile ExcomTile2, ExcommunicationTile ExcomTile3){

        mMarket = new Market();
        mCouncil = new Council();
        mProductionArea = new Production();
        mHarvestArea = new Harvest();

        mCharactersTower = new CharactersTower();
        mTerritoriesTower = new TerritoriesTower();
        mVenturesTower = new VenturesTower();
        mBuildingsTower = new BuildingsTower();

        mExcommunicationTile1 = ExcomTile1;
        mExcommunicationTile2 = ExcomTile2;
        mExcommunicationTile3 = ExcomTile3;
        mExcommunicationTilesList = new ArrayList<ExcommunicationTile>();
        mOrder = new Order();

        mBlackDice = new BlackDice();
        mOrangeDice = new OrangeDice();
        mWhiteDice = new WhiteDice();

    }



    private void updated() {
        //setChanged();
        //notifyObservers();
    }

    //##################### MarketSpace #####################

    /**
     *
     * @return Market spaces list
     */
    public List<MarketSpace> getMarketList() {
        return mMarket.getMarketList();
    }

    /**
     *
     * @return Market
     */
    public Market getMarket() {
        return mMarket;
    }

    /**
     *
     *
     * @param pos Specify in which market space looking for
     * @return Family member of the specified market space
     */
    public FamilyMember getMarketFamilyMember(int pos){
        return mMarket.getMarketList().get(pos).getFamilyMember();
    }

    /**
     *
     * @param pos Specify in which market space looking for
     * @return Get bonus object of the specified market space
     */
    public BoardBonus getMarketBonus(int pos){
        return mMarket.getMarketList().get(pos).getBoardBonus();
    }

    /**
     *
     * @param pos Specify in which market space looking for
     * @return Get deice value of the specified market space
     */
    public int getMarketDiceValue(int pos){
        return mMarket.getMarketList().get(pos).getDiceValue();
    }

    /**
     *
     * @param pos Specify in which market space looking for
     * @return Boolean value: true if the specified market space is available, otherwise false
     */
    public boolean isMarketSpaceAvailable(int pos){
        return mMarket.getMarketList().get(pos).isAvailable();
    }

    /**
     *
     * @param pos Specify in which market space look for
     * @param pawn Specify in which family member put into the market space
     */
    public void setMarketSpaceFamilyMember(int pos, FamilyMember pawn) {
        mMarket.getMarketList().get(pos).setFamilyMember(pawn);
        updated();
    }

    /**
     *
     * @param pos Specify in which market space look for
     * @param boardBonus Specify the boardBonus to be set into the market space
     */
    public void setMarketSpaceBonus(int pos, BoardBonus boardBonus){
        mMarket.getMarketList().get(pos).setBoardBonus(boardBonus);
        updated();
    }

    /**
     *
     * @param pos Specify in which market space look for
     * @param dice Specify the dice value to set
     */
    public void setMarketSpaceDiceValue(int pos, int dice){
        mMarket.getMarketList().get(pos).setDiceValue(dice);
        updated();
    }

    //####################################################
    //####################################################
    //##################### Council ######################

    /**
     *
     * @return Council object
     */
    public Council getCouncil() {
        return mCouncil;
    }

    /**
     *
     * @return Get family member list of those are in the council
     */
    public ArrayList<FamilyMember> getCouncilList(){
        return mCouncil.getList();
    }

    /**
     *
     * @param pawn Family member object to be add into family member
     */
    public void addMemberCouncil(FamilyMember pawn){
        mCouncil.addFamilyMember(pawn);
    }

    //####################################################
    //####################################################
    //################# ProductionArea #######################

    /**
     *
     * @return Get production area object
     */
    public Production getProduction() {
        return mProductionArea;
    }

    /**
     *
     * @return Get list of those in production area
     */
    public List getProductionList() {
        return mProductionArea.getList();
    }

    /**
     *
     * @param pawn Family member to be add into production area
     */
    public void addFamilyMemberInProduction(FamilyMember pawn){
        mProductionArea.addMember(pawn);
    }

    /**
     *
     * @return Get production dice cost
     */
    public int getProductionSlotDiceValue(){
        if(mProductionArea.getList().size()==0)
            return 1;

        else
            return 3;
    }

    //####################################################
    //####################################################
    //#################### HarvestArea #######################

    /**
     *
     * @return Get harvest area object
     */
    public Harvest getHarvest() {
        return mHarvestArea;
    }

    /**
     *
     * @return Get list of those in harvest area
     */
    public List getHarvestList() {
       return mHarvestArea.getList();
    }

    /**
     *
     * @param pawn Family member to be add into production area
     */
    public void addFamilyMemberInHarvest(FamilyMember pawn){
        mHarvestArea.addMember(pawn);
    }

    /**
     *
     * @return Get production dice cost
     */
    public int getHarvestSlotDiceValue(){
        if(mHarvestArea.getList().size()==0)
            return 1;

        else
            return 3;
    }

    //####################################################
    //####################################################
    //################ CharacterTower ####################

    public CharactersTower getCharactersTower() {
        return mCharactersTower;
    }

    public List getCharacterTowerFloors(){
        return mCharactersTower.getFloors();
    }

    public String getCharacterTowerColor() {
        return mCharactersTower.getColor();
    }

    public int getCharacterTowerDiceValue(int floor){
        return mCharactersTower.getFloors().get(floor).getDiceValue();
    }

    public DevelopmentCard getCharacterTowerCard(int floor){
        return mCharactersTower.getFloors().get(floor).getCard();
    }

    public FamilyMember getCharacterTowerFamilyMember(int floor){
        return mCharactersTower.getFloors().get(floor).getFamilyMember();
    }

    public BoardBonus getCharacterTowerBonus(int floor){
        return mCharactersTower.getFloors().get(floor).getBoardBonus();
    }

    public boolean isCharacterTowerAvailable(){
        return mCharactersTower.hasFamilyMember();
    }

    public boolean isCharacterTowerFloorAvailable(int floor){
        return mCharactersTower.isFree(floor);
    }

    public void setCharacterTowerFamilyMember(int floor, FamilyMember pawn) {
        mCharactersTower.getFloors().get(floor).setFamilyMember(pawn);
        updated();
    }

    public void setCharacterTowerBonus(int floor, BoardBonus boardBonus) {
        mCharactersTower.getFloors().get(floor).setBoardBonus(boardBonus);
        updated();
    }

    public void setCharacterTowerCard(int floor, DevelopmentCard card) {
        mCharactersTower.getFloors().get(floor).setCard(card);
        updated();
    }

    //####################################################
    //####################################################
    //################ TerritoriesTower ####################

    public TerritoriesTower getTerritoriesTower() {
        return mTerritoriesTower;
    }

    public List getTerritoriesTowerFloors(){
        return mTerritoriesTower.getFloors();
    }

    public String getTerritoriesTowerColor() {
        return mTerritoriesTower.getColor();
    }

    public int getTerritoriesTowerDiceValue(int floor){
        return mTerritoriesTower.getFloors().get(floor).getDiceValue();
    }

    public DevelopmentCard getTerritoriesTowerCard(int floor){
        return mTerritoriesTower.getFloors().get(floor).getCard();
    }

    public FamilyMember getTerritoriesTowerFamilyMember(int floor){
        return mTerritoriesTower.getFloors().get(floor).getFamilyMember();
    }

    public BoardBonus getTerritoriesTowerBonus(int floor){
        return mTerritoriesTower.getFloors().get(floor).getBoardBonus();
    }

    public boolean isTerritoriesTowerAvailable(){
        return mTerritoriesTower.hasFamilyMember();
    }

    public boolean isTerritoriesTowerFloorAvailable(int floor){
        return mTerritoriesTower.isFree(floor);
    }

    public void setTerritoriesTowerFamilyMember(int floor, FamilyMember pawn) {
        mTerritoriesTower.getFloors().get(floor).setFamilyMember(pawn);
        updated();
    }

    public void setTerritoriesTowerBonus(int floor, BoardBonus boardBonus) {
        mTerritoriesTower.getFloors().get(floor).setBoardBonus(boardBonus);
        updated();
    }

    public void setTerritoriesTowerCard(int floor, DevelopmentCard card) {
        mTerritoriesTower.getFloors().get(floor).setCard(card);
        updated();
    }

    //####################################################
    //####################################################
    //################ VenturesTower #####################

    public VenturesTower getVenturesTower() {
        return mVenturesTower;
    }

    public List getVenturesTowerFloors(){
        return mVenturesTower.getFloors();
    }

    public String getVenturesTowerColor() {
        return mVenturesTower.getColor();
    }

    public int getVenturesTowerDiceValue(int floor){
        return mVenturesTower.getFloors().get(floor).getDiceValue();
    }

    public DevelopmentCard getVenturesTowerCard(int floor){
        return mVenturesTower.getFloors().get(floor).getCard();
    }

    public FamilyMember getVenturesTowerFamilyMember(int floor){
        return mVenturesTower.getFloors().get(floor).getFamilyMember();
    }

    public BoardBonus getVenturesTowerBonus(int floor){
        return mVenturesTower.getFloors().get(floor).getBoardBonus();
    }

    public boolean isVenturesTowerAvailable(){
        return mVenturesTower.hasFamilyMember();
    }

    public boolean isVenturesTowerFloorAvailable(int floor){
        return mVenturesTower.isFree(floor);
    }

    public void setVenturesTowerFamilyMember(int floor, FamilyMember pawn) {
        mVenturesTower.getFloors().get(floor).setFamilyMember(pawn);
        updated();
    }

    public void setVenturesTowerBonus(int floor, BoardBonus boardBonus) {
        mVenturesTower.getFloors().get(floor).setBoardBonus(boardBonus);
        updated();
    }

    public void setVenturesTowerCard(int floor, DevelopmentCard card) {
        mVenturesTower.getFloors().get(floor).setCard(card);
        updated();
    }

    //####################################################
    //####################################################
    //################ BuildingsTower #####################

    public BuildingsTower getBuildingsTower() {
        return mBuildingsTower;
    }

    public List getBuildingsTowerFloors(){
        return mBuildingsTower.getFloors();
    }

    public String getBuildingsTowerColor() {
        return mBuildingsTower.getColor();
    }

    public int getBuildingsTowerDiceValue(int floor){
        return mBuildingsTower.getFloors().get(floor).getDiceValue();
    }

    public DevelopmentCard getBuildingsTowerCard(int floor){
        return mBuildingsTower.getFloors().get(floor).getCard();
    }

    public FamilyMember getBuildingsTowerFamilyMember(int floor){
        return mBuildingsTower.getFloors().get(floor).getFamilyMember();
    }

    public BoardBonus getBuildingsTowerBonus(int floor){
        return mBuildingsTower.getFloors().get(floor).getBoardBonus();
    }

    public boolean isBuildingsTowerAvailable(){
        return mBuildingsTower.hasFamilyMember();
    }

    public boolean isBuildingsTowerFloorAvailable(int floor){
        return mBuildingsTower.isFree(floor);
    }

    public void setBuildingsTowerFamilyMember(int floor, FamilyMember pawn) {
        mBuildingsTower.getFloors().get(floor).setFamilyMember(pawn);
        updated();
    }

    public void setBuildingsTowerBonus(int floor, BoardBonus boardBonus) {
        mBuildingsTower.getFloors().get(floor).setBoardBonus(boardBonus);
        updated();
    }

    public void setBuildingsTowerCard(int floor, DevelopmentCard card) {
        mBuildingsTower.getFloors().get(floor).setCard(card);
        updated();
    }

    //####################################################
    //####################################################

    public ArrayList<ExcommunicationTile> getExcommunicationTilesList() {

        mExcommunicationTilesList = new ArrayList<>();

        mExcommunicationTilesList.add(mExcommunicationTile1);
        mExcommunicationTilesList.add(mExcommunicationTile2);
        mExcommunicationTilesList.add(mExcommunicationTile3);

        return mExcommunicationTilesList;
    }


    //####################################################
    //####################################################
    //#################### Dices #########################

    public void setBlackDice(int diceValue){
        mBlackDice.setValue(diceValue);
    }

    public void setOrangeDice(int diceValue){
        mOrangeDice.setValue(diceValue);
    }

    public void setWhiteDice(int diceValue){
        mWhiteDice.setValue(diceValue);
    }



    //####################################################
    //####################################################


  /*  //TODO: Remember to create setTitleName in Excommunication
    public void setExcommunicationTitleName(String name, int mPeriod) {
        if(mPeriod==1)
            mExcommunicationTile1.setTitleName(name);
            updated();

        else if(mPeriod==2)
            mExcommunicationTile2.setTitleName(name);
            updated();

        else if(mPeriod==3)
            mExcommunicationTile3.setTitleName(name);
            updated();
    }

    public void setExcommunicationEffect(LinkedList effect, int mPeriod){
        if(mPeriod==1)
            mExcommunicationTile1.setEffects(effect);
            updated();

        else if(mPeriod==2)
            mExcommunicationTile2.setEffects(effect);
            updated();

        else if(mPeriod==3)
            mExcommunicationTile3.setEffects(effect);
            updated();
    }

    public LinkedList getExcommunicationEffect(int mPeriod){
        if(mPeriod==1)
            return mExcommunicationTile1.getEffects();

        else if(mPeriod==2)
            return mExcommunicationTile2.getEffects();

        else if(mPeriod==3)
            return mExcommunicationTile3.getEffects();

        else
            return null;
    }


    public List getOrder() {
        return mOrder.getPlayerList();
    }

    public void setOrder(Order order) {
        mOrder = order;
        updated();
    }
    */

    /**
     * Clear all the board
     */
    public void clearAll(){
        mHarvestArea.clearAll();
        mProductionArea.clearAll();
        mMarket.clearAll();
        mTerritoriesTower.clearAll();
        mCharactersTower.clearAll();
        mVenturesTower.clearAll();
        mBuildingsTower.clearAll();
        mCouncil.clearAll();
    }

    @Override
    public String toString(){

        StringJoiner mStringBoard = new StringJoiner("\n", "", "");

        mStringBoard.add("Here's the board:");

        mStringBoard.add(mTerritoriesTower.toString());
        mStringBoard.add(mCharactersTower.toString());
        mStringBoard.add(mBuildingsTower.toString());
        mStringBoard.add(mVenturesTower.toString());

        mStringBoard.add(mHarvestArea.toString());
        mStringBoard.add(mProductionArea.toString());
        mStringBoard.add(mMarket.toString());
        mStringBoard.add(mCouncil.toString());

        return mStringBoard.toString();
    }

    public BlackDice getBlackDice() {
        return mBlackDice;
    }

    public OrangeDice getOrangeDice() {
        return mOrangeDice;
    }

    public WhiteDice getWhiteDice() {
        return mWhiteDice;
    }
}