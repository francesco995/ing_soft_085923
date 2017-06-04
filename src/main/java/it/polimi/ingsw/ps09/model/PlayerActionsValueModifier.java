package it.polimi.ingsw.ps09.model;

import java.util.HashMap;
import java.util.Map;

public class PlayerActionsValueModifier {

    private Map<String,Integer> mModifiers = new HashMap<String,Integer>();

    public PlayerActionsValueModifier() {
        mModifiers.put("TerritoryBonus", 0);
        mModifiers.put("BuildingBonus", 0);
        mModifiers.put("CharacterBonus", 0);
        mModifiers.put("VentureBonus", 0);
        mModifiers.put("ProductionBonus", 0);
        mModifiers.put("HarvestBonus", 0);
        mModifiers.put("PayLessWood", 0);
        mModifiers.put("PayLessStone", 0);
        mModifiers.put("PayLessGold", 0);
    }

    public Map<String, Integer> getModifiers() {
        return mModifiers;
    }

    public void addBonus(PlayerActionsValueModifier add){
        //  add iteratore che cicla tutto e fai equal alle stringhe se equal adda
        // mModifiers.addAll(add.getModifiers());

    }
}
