package it.polimi.ingsw.ps09.res;


import it.polimi.ingsw.ps09.res.Cards.Building;
import it.polimi.ingsw.ps09.res.Cards.Territory;
import it.polimi.ingsw.ps09.res.Cards.Venture;
import it.polimi.ingsw.ps09.res.Resources.Coins;
import it.polimi.ingsw.ps09.res.Resources.Servant;
import it.polimi.ingsw.ps09.res.Resources.Stone;
import it.polimi.ingsw.ps09.res.Resources.Wood;

import java.util.List;

/**
 * Created by francGianni on 09/05/2017.
 */

public class PersonalBoard {

    //VARIABLES

/*    private enum mBonusTileSides{
        ONE, TWO
    }
    mBonusTileSides mSelectedBonusTile;*/

    private PersonalBoardCards mPersonalBoardCards;
    private UserResources mUserResources;


    //CONSTRUCTORS

    //Create an empty PersonalBoard
    public PersonalBoard(){
        this(new PersonalBoardCards(), new UserResources());
    }

    //Create a populated PersonalBoard
    public PersonalBoard(PersonalBoardCards personalBoardCards, UserResources userResources){
        mPersonalBoardCards = personalBoardCards;
        mUserResources = userResources;
    }


    //GETTERS

    //Get ALL BOARD CARDS
    public PersonalBoardCards getPersonalBoardCards() {
        return mPersonalBoardCards;
    }

    //Get UserResources
    public UserResources getUserResources(){
        return mUserResources;
    }

    //Get Cards list for specific type

    //Get BOARD BUILDINGS
    public List<Building> getBoardBuildings() {
        return mPersonalBoardCards.getBoardBuildings();
    }

    //Get BOARD CHARACTERS
    public List<Character> getBoardCharacters() {
        return mPersonalBoardCards.getBoardCharacters();
    }

    //Get BOARD TERRITORIES
    public List<Territory> getBoardTerritories() {
        return mPersonalBoardCards.getBoardTerritories();
    }

    //Get BOARD VENTURES
    public List<Venture> getBoardVentures() {
        return mPersonalBoardCards.getBoardVentures();
    }

    //SETTERS

    //Set Board Buildings
    public void setBoardBuildings(List<Building> buildings){
        mPersonalBoardCards.setBoardBuildings(buildings);
    }

    //Set Board Characters
    public void setBoardCharacters(List<Character> characters){
        mPersonalBoardCards.setBoardCharacters(characters);
    }

    //Set Board Territories
    public void setBoardTerritories(List<Territory> territories){
        mPersonalBoardCards.setBoardTerritories(territories);
    }

    //Set Board Ventures
    public void setBoardVentures(List<Venture> ventures){
        mPersonalBoardCards.setBoardVentures(ventures);
    }

    //Add single CARD
    //Add BUILDING
    public void addBuilding(Building building){
        mPersonalBoardCards.addBuilding(building);
    }

    //Add CHARACTER
    public void addCharacter(Character character){
        mPersonalBoardCards.addCharacter(character);
    }

    //Add TERRITORY
    public void addTerritory(Territory territory){
        mPersonalBoardCards.addTerritory(territory);
    }

    //Add VENTURE
    public void addVenture(Venture venture){
        mPersonalBoardCards.addVenture(venture);
    }


    //GETTERS FOR USER RESOURCES

    public Coins getCoins(){
        return mUserResources.getCoins();
    }

    public Servant getServant(){
        return mUserResources.getServant();
    }

    public Stone getStone(){
        return mUserResources.getStone();
    }

    public Wood getWood(){
        return mUserResources.getWood();
    }

    //ADD A RESOURCE

    public void addCoins(Coins addCoins){
        mUserResources.addCoins(addCoins);
    }

    public void addServant(Servant addServant){
        mUserResources.addServant(addServant);
    }

    public void addStone(Stone addStone){
        mUserResources.addStone(addStone);
    }

    public void addWood(Wood addWood){
        mUserResources.addWood(addWood);
    }

}