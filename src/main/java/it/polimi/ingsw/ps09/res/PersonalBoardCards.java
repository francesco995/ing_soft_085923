package it.polimi.ingsw.ps09.res;

import it.polimi.ingsw.ps09.res.Cards.Building;
import it.polimi.ingsw.ps09.res.Cards.Territory;
import it.polimi.ingsw.ps09.res.Cards.Venture;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by franc on 09/05/2017.
 */
public class PersonalBoardCards {

    // A list for each type of card
    private List<Building> mBoardBuildings = new ArrayList<>();
    private List<Character> mBoardCharacter = new ArrayList<>();
    private List<Territory> mBoardTerritory = new ArrayList<>();
    private List<Venture> mBoardVenture = new ArrayList<>();

    //Return a list of all the cards of a given kind a PersonalBoard contains
    public List<Building> getBoardBuildings() {
        return mBoardBuildings;
    }

    public List<Character> getBoardCharacter() {
        return mBoardCharacter;
    }

    public List<Territory> getBoardTerritory() {
        return mBoardTerritory;
    }

    public List<Venture> getBoardVenture() {
        return mBoardVenture;
    }

    //TODO: Add cards to the array lists

}
