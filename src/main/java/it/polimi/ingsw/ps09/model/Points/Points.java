package it.polimi.ingsw.ps09.model.Points;

public class Points {

    //VARIABLES
    private int mPoints;

    //CONSTRUCTORS
    public Points(){
        this(0);
    }

    public Points(int initialPoints) {
        mPoints = initialPoints;
    }

    //GETTERS
    public int getPoints() {
        return mPoints;
    }

    //Override toString method to get points value
    public String toString(){
        return String.valueOf(mPoints);
    }

    //ADD Points

    public void add(Points add){
        mPoints = mPoints + add.getPoints();
    }


}
