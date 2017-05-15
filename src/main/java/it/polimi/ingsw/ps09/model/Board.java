package it.polimi.ingsw.ps09.model;

import it.polimi.ingsw.ps09.model.DevelopmentCards.DevelopmentCard;
import it.polimi.ingsw.ps09.model.FamilyMembers.FamilyMember;
import it.polimi.ingsw.ps09.model.Places.Council;
import it.polimi.ingsw.ps09.model.Places.HarvestAndProductionAreas.Harvest;
import it.polimi.ingsw.ps09.model.Places.HarvestAndProductionAreas.Production;
import it.polimi.ingsw.ps09.model.Places.Market.Market;
import it.polimi.ingsw.ps09.model.Places.Towers.BuildingsTower;
import it.polimi.ingsw.ps09.model.Places.Towers.CharactersTower;
import it.polimi.ingsw.ps09.model.Places.Towers.TerritoriesTower;
import it.polimi.ingsw.ps09.model.Places.Towers.VenturesTower;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ale on 14/05/2017.
 */
public class Board {

    private Market mMarket;
    private Council mCouncil;
    private Production mProduction;
    private Harvest mHarvest;

    private CharactersTower mCharactersTower;
    private TerritoriesTower mTerritoriesTower;
    private VenturesTower mVenturesTower;
    private BuildingsTower mBuildingsTower;

    private LinkedList effect;
    private ExcommunicationTile mExcommunicationTile1;
    private ExcommunicationTile mExcommunicationTile2;
    private ExcommunicationTile mExcommunicationTile3;
    private List<ExcommunicationTile> mExcommunicationTilesList;

    private Order mOrder;

    public void CreateBoard(){

        mMarket = new Market();
        mCouncil = new Council();
        mProduction = new Production();
        mHarvest = new Harvest();

        mCharactersTower = new CharactersTower();
        mTerritoriesTower = new TerritoriesTower();
        mVenturesTower = new VenturesTower();
        mBuildingsTower = new BuildingsTower();

       /* mExcommunicationTile1 = new ExcommunicationTile("TileName", 1, effect);
        mExcommunicationTile2 = new ExcommunicationTile("TileName", 2, effect);
        mExcommunicationTile3 = new ExcommunicationTile("TileName", 3, effect);
        mExcommunicationTilesList = new ArrayList<ExcommunicationTile>();
*/
        mOrder = new Order();

    }

    //##################### MarketSpace #####################

    public List getMarket() {
        return mMarket.getMarketList();
    }

    public FamilyMember getMarketPawn(int pos){
        return mMarket.getMarketList().get(pos-1).getPawn();
    }

    public Bonus getMarketBonus(int pos){
        return mMarket.getMarketList().get(pos-1).getBonus();
    }

    public int getMarketDiceValue(int pos){
        return mMarket.getMarketList().get(pos-1).getDiceValue();
    }

    public boolean isMarketSpaceAvailable(int pos){
        return mMarket.getMarketList().get(pos-1).isAvailable();
    }

    public void setMarketSpaceFamilyMember(int pos, FamilyMember pawn) {
        mMarket.getMarketList().get(pos-1).setPawn(pawn);
    }

    public void setMarketSpaceBonus(int pos, Bonus bonus){
        mMarket.getMarketList().get(pos-1).setBonus(bonus);
    }

    public void setMarketSpaceDiceValue(int pos, int dice){
        mMarket.getMarketList().get(pos-1).setDiceValue(dice);
    }

    //####################################################
    //####################################################
    //##################### Council ######################

    public Council getCouncil() {
        return mCouncil;
    }

    public List getCouncilList(){
        return mCouncil.getList();
    }

    public void addMemberCouncil(FamilyMember pawn){
        mCouncil.addFamilyMember(pawn);
    }

    //####################################################
    //####################################################
    //################# Production #######################


    public Production getProduction() {
        return mProduction;
    }

    public List getProductionList() {
        return mProduction.getList();
    }

    public void addFamilyMemberInProduction(FamilyMember pawn){
        mProduction.addMember(pawn);
    }

    //TODO: Ale try to do not hardcode

    public int getProductionSlotDiceValue(){
        if(mProduction.getList().size()==0)
            return 1;

        else
            return 3;
    }

    //####################################################
    //####################################################
    //#################### Harvest #######################

    public Harvest getHarvest() {
        return mHarvest;
    }

    public List getHarvestList() {
       return mHarvest.getList();
    }

    public void addFamilyMemberInHarvest(FamilyMember pawn){
        mHarvest.addMember(pawn);
    }

    //TODO: Ale try to do not hardcode

    public int getHarvestSlotDiceValue(){
        if(mHarvest.getList().size()==0)
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
        return mCharactersTower.getFloors().get(floor-1).getDiceValue();
    }

    public DevelopmentCard getCharacterTowerCard(int floor){
        return mCharactersTower.getFloors().get(floor-1).getCard();
    }

    public FamilyMember getCharacterTowerFamilyMember(int floor){
        return mCharactersTower.getFloors().get(floor-1).getPawn();
    }

    public Bonus getCharacterTowerBonus(int floor){
        return mCharactersTower.getFloors().get(floor-1).getBonus();
    }

    public boolean isCharacterTowerAvailable(){
        return mCharactersTower.hasPawn();
    }

    public boolean isCharacterTowerFloorAvailable(int floor){
        return mCharactersTower.isFree(floor);
    }

    public void setCharacterTowerFamilyMember(int floor, FamilyMember pawn) {
        mCharactersTower.getFloors().get(floor).setPawn(pawn);
    }

    public void setCharacterTowerBonus(int floor, Bonus bonus) {
        mCharactersTower.getFloors().get(floor).setBonus(bonus);
    }

    public void setCharacterTowerCard(int floor, DevelopmentCard card) {
        mCharactersTower.getFloors().get(floor).setCard(card);
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
        return mTerritoriesTower.getFloors().get(floor-1).getDiceValue();
    }

    public DevelopmentCard getTerritoriesTowerCard(int floor){
        return mTerritoriesTower.getFloors().get(floor-1).getCard();
    }

    public FamilyMember getTerritoriesTowerFamilyMember(int floor){
        return mTerritoriesTower.getFloors().get(floor-1).getPawn();
    }

    public Bonus getTerritoriesTowerBonus(int floor){
        return mTerritoriesTower.getFloors().get(floor-1).getBonus();
    }

    public boolean isTerritoriesTowerAvailable(){
        return mTerritoriesTower.hasPawn();
    }

    public boolean isTerritoriesTowerFloorAvailable(int floor){
        return mTerritoriesTower.isFree(floor);
    }

    public void setTerritoriesTowerFamilyMember(int floor, FamilyMember pawn) {
        mTerritoriesTower.getFloors().get(floor).setPawn(pawn);
    }

    public void setTerritoriesTowerBonus(int floor, Bonus bonus) {
        mTerritoriesTower.getFloors().get(floor).setBonus(bonus);
    }

    public void setTerritoriesTowerCard(int floor, DevelopmentCard card) {
        mTerritoriesTower.getFloors().get(floor).setCard(card);
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
        return mVenturesTower.getFloors().get(floor-1).getDiceValue();
    }

    public DevelopmentCard getVenturesTowerCard(int floor){
        return mVenturesTower.getFloors().get(floor-1).getCard();
    }

    public FamilyMember getVenturesTowerFamilyMember(int floor){
        return mVenturesTower.getFloors().get(floor-1).getPawn();
    }

    public Bonus getVenturesTowerBonus(int floor){
        return mVenturesTower.getFloors().get(floor-1).getBonus();
    }

    public boolean isVenturesTowerAvailable(){
        return mVenturesTower.hasPawn();
    }

    public boolean isVenturesTowerFloorAvailable(int floor){
        return mVenturesTower.isFree(floor);
    }

    public void setVenturesTowerFamilyMember(int floor, FamilyMember pawn) {
        mVenturesTower.getFloors().get(floor).setPawn(pawn);
    }

    public void setVenturesTowerBonus(int floor, Bonus bonus) {
        mVenturesTower.getFloors().get(floor).setBonus(bonus);
    }

    public void setVenturesTowerCard(int floor, DevelopmentCard card) {
        mVenturesTower.getFloors().get(floor).setCard(card);
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
        return mBuildingsTower.getFloors().get(floor-1).getDiceValue();
    }

    public DevelopmentCard getBuildingsTowerCard(int floor){
        return mBuildingsTower.getFloors().get(floor-1).getCard();
    }

    public FamilyMember getBuildingsTowerFamilyMember(int floor){
        return mBuildingsTower.getFloors().get(floor-1).getPawn();
    }

    public Bonus getBuildingsTowerBonus(int floor){
        return mBuildingsTower.getFloors().get(floor-1).getBonus();
    }

    public boolean isBuildingsTowerAvailable(){
        return mBuildingsTower.hasPawn();
    }

    public boolean isBuildingsTowerFloorAvailable(int floor){
        return mBuildingsTower.isFree(floor);
    }

    public void setBuildingsTowerFamilyMember(int floor, FamilyMember pawn) {
        mBuildingsTower.getFloors().get(floor).setPawn(pawn);
    }

    public void setBuildingsTowerBonus(int floor, Bonus bonus) {
        mBuildingsTower.getFloors().get(floor).setBonus(bonus);
    }

    public void setBuildingsTowerCard(int floor, DevelopmentCard card) {
        mBuildingsTower.getFloors().get(floor).setCard(card);
    }

    //####################################################
    //####################################################

    public List getExcommunicationTilesList() {

        mExcommunicationTilesList.add(mExcommunicationTile1);
        mExcommunicationTilesList.add(mExcommunicationTile2);
        mExcommunicationTilesList.add(mExcommunicationTile3);

        return mExcommunicationTilesList;
    }

  /*  //TODO: Remember to create setTitleName in Excommunication
    public void setExcommunicationTitleName(String name, int period) {
        if(period==1)
            mExcommunicationTile1.setTitleName(name);

        else if(period==2)
            mExcommunicationTile2.setTitleName(name);

        else if(period==3)
            mExcommunicationTile3.setTitleName(name);
    }

    public void setExcommunicationEffect(LinkedList effect, int period){
        if(period==1)
            mExcommunicationTile1.setEffects(effect);

        else if(period==2)
            mExcommunicationTile2.setEffects(effect);

        else if(period==3)
            mExcommunicationTile3.setEffects(effect);
    }

    public LinkedList getExcommunicationEffect(int period){
        if(period==1)
            return mExcommunicationTile1.getEffects();

        else if(period==2)
            return mExcommunicationTile2.getEffects();

        else if(period==3)
            return mExcommunicationTile3.getEffects();

        else
            return null;
    }
    */

    public List getOrder() {
        return mOrder.getPlayerList();
    }

    public void setOrder(Order order) {
        mOrder = order;
    }
}