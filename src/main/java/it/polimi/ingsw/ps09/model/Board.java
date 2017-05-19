package it.polimi.ingsw.ps09.model;

import it.polimi.ingsw.ps09.controller.Game;
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
import it.polimi.ingsw.ps09.model.Resources.Bonus;

import java.util.ArrayList;
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

    /**
     * Create the board whit market, harvest, production, towers, church and council
     */
    public Board(ExcommunicationTile ExcomTile1, ExcommunicationTile ExcomTile2, ExcommunicationTile ExcomTile3){

        mMarket = new Market();
        mCouncil = new Council();
        mProduction = new Production();
        mHarvest = new Harvest();

        mCharactersTower = new CharactersTower();
        mTerritoriesTower = new TerritoriesTower();
        mVenturesTower = new VenturesTower();
        mBuildingsTower = new BuildingsTower();

        mExcommunicationTile1 = ExcomTile1;
        mExcommunicationTile2 = ExcomTile2;
        mExcommunicationTile3 = ExcomTile3;
        mExcommunicationTilesList = new ArrayList<ExcommunicationTile>();
        mOrder = new Order();
        mNumbeOfPlayers = Game.PLAYERS_NUMBER;

    }

    public void clearAll(){
        //metodo che svuota tutte le torri se presenti le carte
        //metodo che svuota tutti gli spazi azione
        //metodo che restituisce i familymember ai singoli giocatori se necessario

    }

    //##################### MarketSpace #####################

    /**
     *
     * @return Market spaces list
     */
    public List getMarket() {
        return mMarket.getMarketList();
    }
    
    /**
     *
     *
     * @param pos Specify in which market space looking for
     * @return Family member of the specified market space
     */
    public FamilyMember getMarketPawn(int pos){
        return mMarket.getMarketList().get(pos-1).getPawn();
    }

    /**
     *
     * @param pos Specify in which market space looking for
     * @return Get bonus object of the specified market space
     */
    public Bonus getMarketBonus(int pos){
        return mMarket.getMarketList().get(pos-1).getBonus();
    }

    /**
     *
     * @param pos Specify in which market space looking for
     * @return Get deice value of the specified market space
     */
    public int getMarketDiceValue(int pos){
        return mMarket.getMarketList().get(pos-1).getDiceValue();
    }

    /**
     *
     * @param pos Specify in which market space looking for
     * @return Boolean value: true if the specified market space is available, otherwise false
     */
    public boolean isMarketSpaceAvailable(int pos){
        return mMarket.getMarketList().get(pos-1).isAvailable();
    }

    /**
     *
     * @param pos Specify in which market space look for
     * @param pawn Specify in which family member put into the market space
     */
    public void setMarketSpaceFamilyMember(int pos, FamilyMember pawn) {
        mMarket.getMarketList().get(pos-1).setPawn(pawn);
    }

    /**
     *
     * @param pos Specify in which market space look for
     * @param bonus Specify the bonus to be set into the market space
     */
    public void setMarketSpaceBonus(int pos, Bonus bonus){
        mMarket.getMarketList().get(pos-1).setBonus(bonus);
    }

    /**
     *
     * @param pos Specify in which market space look for
     * @param dice Specify the dice value to set
     */
    public void setMarketSpaceDiceValue(int pos, int dice){
        mMarket.getMarketList().get(pos-1).setDiceValue(dice);
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
    public List getCouncilList(){
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
    //################# Production #######################

    //TODO: ALE L VEDI SE RIESCI A RIMANERE DRY CON HARVEST E PRODUCTION INSIEME

    /**
     *
     * @return Get production area object
     */
    public Production getProduction() {
        return mProduction;
    }

    /**
     *
     * @return Get list of those in production area
     */
    public List getProductionList() {
        return mProduction.getList();
    }

    /**
     *
     * @param pawn Family member to be add into production area
     */
    public void addFamilyMemberInProduction(FamilyMember pawn){
        mProduction.addMember(pawn);
    }

    //TODO: Ale try to do not hardcode

    /**
     *
     * @return Get production dice cost
     */
    public int getProductionSlotDiceValue(){
        if(mProduction.getList().size()==0)
            return 1;

        else
            return 3;
    }

    //####################################################
    //####################################################
    //#################### Harvest #######################

    /**
     *
     * @return Get harvest area object
     */
    public Harvest getHarvest() {
        return mHarvest;
    }

    /**
     *
     * @return Get list of those in harvest area
     */
    public List getHarvestList() {
       return mHarvest.getList();
    }

    /**
     *
     * @param pawn Family member to be add into production area
     */
    public void addFamilyMemberInHarvest(FamilyMember pawn){
        mHarvest.addMember(pawn);
    }

    //TODO: Ale try to do not hardcode

    /**
     *
     * @return Get production dice cost
     */
    public int getHarvestSlotDiceValue(){
        if(mHarvest.getList().size()==0)
            return 1;

        else
            return 3;
    }

    //####################################################
    //####################################################
    //################ CharacterTower ####################

    //TODO: ALE L STAY DRY CON LE TORRY INSIEME
    //TODO: ALE L Fra L passa le carte devel specifiche (Building, character, etc)

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


    public List getOrder() {
        return mOrder.getPlayerList();
    }

    public void setOrder(Order order) {
        mOrder = order;
    }
    */

    /**
     * Clear all the board
     */
    public void clearAll(){
        mHarvest.clearAll();
        mProduction.clearAll();
        mMarket.clearAll();
        mTerritoriesTower.clearAll();
        mCharactersTower.clearAll();
        mVenturesTower.clearAll();
        mBuildingsTower.clearAll();
        mCouncil.clearAll();
    }
}