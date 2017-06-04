package it.polimi.ingsw.ps09.model.ExcommunicationTileEffect;

public class AddMalusEffect extends ExcommunicationTileEffect {
   //remember to add bonus class and map and all methods to add remove value

    private int mProductionMalus;

    public int getProductionMalus() {
        return Math.abs(mProductionMalus);
    }
}
