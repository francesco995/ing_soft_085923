package it.polimi.ingsw.ps09.res;

import it.polimi.ingsw.ps09.res.DevelopmentCards.Building;
import it.polimi.ingsw.ps09.res.DevelopmentCards.Territory;
import it.polimi.ingsw.ps09.res.DevelopmentCards.Venture;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by francGianni on 09/05/2017.
 */
public class PersonalBoardCards {


    //VARIABLES
    // A list for each type of card
    private List<Building> mBoardBuildings = new ArrayList<>();
    private List<Character> mBoardCharacters = new ArrayList<>();
    private List<Territory> mBoardTerritories = new ArrayList<>();
    private List<Venture> mBoardVentures = new ArrayList<>();

    public PersonalBoardCards(){

    }

    //GETTERS
    //Return a list of all the cards of a given kind a PersonalBoard contains

    public List<Building> getBoardBuildings() {
        return mBoardBuildings;
    }

    public List<Character> getBoardCharacters() {
        return mBoardCharacters;
    }

    public List<Territory> getBoardTerritories() {
        return mBoardTerritories;
    }

    public List<Venture> getBoardVentures() {
        return mBoardVentures;
    }

    //SETTERS

    //Set entire Lists

    public void setBoardBuildings(List<Building> boardBuildings) {
        mBoardBuildings = boardBuildings;
    }

    public void setBoardCharacters(List<Character> boardCharacters) {
        mBoardCharacters = boardCharacters;
    }

    public void setBoardTerritories(List<Territory> boardTerritories) {
        mBoardTerritories = boardTerritories;
    }

    public void setBoardVentures(List<Venture> boardVentures) {
        mBoardVentures = boardVentures;
    }

    //Add DevelopmentCards to lists

    //Add a BUILDING
    public void addBuilding(Building building){
        mBoardBuildings.add(building);
    }

    //Add a CHARACTER
    public void addCharacter(Character character){
        mBoardCharacters.add(character);
    }

    //Add a TERRITORY
    public void addTerritory(Territory territory){
        mBoardTerritories.add(territory);
    }

    //Add a VENTURE
    public void addVenture(Venture venture){
        mBoardVentures.add(venture);
    }





}
