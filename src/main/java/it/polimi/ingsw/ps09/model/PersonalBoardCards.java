package it.polimi.ingsw.ps09.model;

import it.polimi.ingsw.ps09.model.DevelopmentCards.*;
import it.polimi.ingsw.ps09.model.DevelopmentCards.Character;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * Created by francesco995 on 09/05/2017.
 */
public class PersonalBoardCards {


    //VARIABLES
    // A list for each type of card
    private List<Building> mBoardBuildings = new ArrayList<>();
    private List<Character> mBoardCharacters = new ArrayList<>();
    private List<Territory> mBoardTerritories = new ArrayList<>();
    private List<Venture> mBoardVentures = new ArrayList<>();
    

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
    public void add(Building building){
        mBoardBuildings.add(building);
    }

    //Add a CHARACTER
    public void add(Character character){
        mBoardCharacters.add(character);
    }

    //Add a TERRITORY
    public void add(Territory territory){
        mBoardTerritories.add(territory);
    }

    //Add a VENTURE
    public void add(Venture venture){
        mBoardVentures.add(venture);
    }


    private String toStringCards(List cardsList){

        StringJoiner mStringCards = new StringJoiner("\n  ", "", "");

        cardsList.stream()
                .forEach(card -> {
                    mStringCards.add("");
                    mStringCards.add(card.toString());
                });

        return mStringCards.toString();

    }

    @Override
    public String toString(){

        String mString = "\nPersonal Board Cards:";

        if(!getBoardTerritories().isEmpty()){
            mString += "\n\nTerritories:\n";
            mString += toStringCards(getBoardTerritories());
        }

        if(!getBoardBuildings().isEmpty()){
            mString += "\n\nBuildings:\n";
            mString += toStringCards(getBoardBuildings());
        }

        if(!getBoardCharacters().isEmpty()){
            mString += "\n\nCharacters:\n";
            mString += toStringCards(getBoardCharacters());
        }

        if(!getBoardVentures().isEmpty()){
            mString += "\n\nVentures:\n";
            mString += toStringCards(getBoardVentures());
        }

        return mString;

    }





}
