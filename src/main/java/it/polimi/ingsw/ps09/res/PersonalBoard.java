package it.polimi.ingsw.ps09.res;


import it.polimi.ingsw.ps09.res.Cards.Building;
import it.polimi.ingsw.ps09.res.Cards.Territory;
import it.polimi.ingsw.ps09.res.Cards.Venture;

import java.util.List;

/**
 * Created by franc on 09/05/2017.
 */

public class PersonalBoard {

    //VARIABLES

/*    private enum mBonusTileSides{
        ONE, TWO
    }
    mBonusTileSides mSelectedBonusTile;*/

    PersonalBoardCards mPersonalBoardCards;

    //CONSTRUCTORS

    //Create an empty PersonalBoard
    public PersonalBoard(){
        new PersonalBoard(new PersonalBoardCards());
    }

    //Create a populated PersonalBoard
    public PersonalBoard(PersonalBoardCards personalBoardCards){
        mPersonalBoardCards = personalBoardCards;
    }


    //GETTERS

    //Get ALL BOARD CARDS
    public PersonalBoardCards getPersonalBoardCards() {
        return mPersonalBoardCards;
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


}