package it.polimi.ingsw.ps09.model;


import it.polimi.ingsw.ps09.model.DevelopmentCards.Building;
import it.polimi.ingsw.ps09.model.DevelopmentCards.Character;
import it.polimi.ingsw.ps09.model.DevelopmentCards.Territory;
import it.polimi.ingsw.ps09.model.DevelopmentCards.Venture;
import it.polimi.ingsw.ps09.model.Resources.Coins;
import it.polimi.ingsw.ps09.model.Resources.Servant;
import it.polimi.ingsw.ps09.model.Resources.Stone;
import it.polimi.ingsw.ps09.model.Resources.Wood;

import java.util.List;

/**
 * Created by francGianni on 09/05/2017.
 */

public class PersonalBoard {

    //VARIABLES

    private PersonalBoardCards mPersonalBoardCards;
    private UserResources mUserResources;


    //CONSTRUCTORS

    //Create an empty PersonalBoard
    public PersonalBoard(){
        this(0);
    }

    public PersonalBoard(int initialCoins){
        this(new PersonalBoardCards(), new UserResources(initialCoins));
    }

    //Create a populated PersonalBoard
    public PersonalBoard(PersonalBoardCards personalBoardCards, UserResources userResources){
        mPersonalBoardCards = personalBoardCards;
        mUserResources = userResources;
    }

    @Override
    public String toString(){

        String mString = "Personal Board: \n";

        mString += mPersonalBoardCards.toString();
        mString += "\n\nUser Resources: \n\n";
        mString += mUserResources.toString();

        return mString;

    }
    //other useful toString

    public String builidingToString(){

        String mString;
        if(mPersonalBoardCards.getBoardBuildings().size() > 1)
            mString = "Building cards: \n";
        else
            mString = "Building card: \n";

        mString += mPersonalBoardCards.getBoardBuildings().toString();

        return mString;
    }


    public String characterToString(){

        String mString;
        if(mPersonalBoardCards.getBoardCharacters().size() > 1)
            mString = "Character cards: \n";
        else
            mString = "Character card: \n";

        mString += mPersonalBoardCards.getBoardCharacters().toString();

        return mString;
    }


    public String territoryToString(){

        String mString;
        if(mPersonalBoardCards.getBoardTerritories().size() > 1)
            mString = "Territory cards: \n";
        else
            mString = "Territory card: \n";

        mString += mPersonalBoardCards.getBoardTerritories().toString();

        return mString;
    }


    public String ventureToString(){

        String mString;
        if(mPersonalBoardCards.getBoardVentures().size() > 1)
            mString = "Venture cards: \n";
        else
            mString = "Venture card: \n";

        mString += mPersonalBoardCards.getBoardVentures().toString();

        return mString;
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

    //Get DevelopmentCards list for specific type

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
    public void add(Building building){
        mPersonalBoardCards.add(building);
    }

    //Add CHARACTER
    public void add(Character character){
        mPersonalBoardCards.add(character);
    }

    //Add TERRITORY
    public void add(Territory territory){
        mPersonalBoardCards.add(territory);
    }

    //Add VENTURE
    public void add(Venture venture){
        mPersonalBoardCards.add(venture);
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

    public void add(Coins addCoins){
        mUserResources.add(addCoins);
    }

    public void add(Servant addServant){
        mUserResources.add(addServant);
    }

    public void add(Stone addStone){
        mUserResources.add(addStone);
    }

    public void add(Wood addWood){
        mUserResources.add(addWood);
    }


    //REMOVE A RESOURCE

    public void remove(Coins removeCoins){
        mUserResources.remove(removeCoins);
    }

    public void remove(Servant removeServant){
        mUserResources.remove(removeServant);
    }

    public void remove(Stone removeStone){
        mUserResources.remove(removeStone);
    }

    public void remove(Wood removeWood){
        mUserResources.remove(removeWood);
    }



}