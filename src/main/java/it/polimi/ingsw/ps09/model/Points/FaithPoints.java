package it.polimi.ingsw.ps09.model.Points;

public class FaithPoints extends Points{

    //CONSTRUCTORS
    //Create from initial int Value
    public FaithPoints(int initialPoints) {
        super(initialPoints);
    }

    //Create with 0 value
    public FaithPoints(){
        this(0);
    }

    public void setZero() {
        setPoints(0);
    }
}
