package it.polimi.ingsw.ps09.res.BoardPoints;

/**
 * Created by franc on 09/05/2017.
 */
public class Points {

    //VALUES
    private int mPoints;

    //CONSTRUCTORS
    public Points(){
        new Points(0);
    }

    public Points(int initialPoints) {
        mPoints = initialPoints;
    }

    //GETTERS
    public int getPoints() {
        return mPoints;
    }

    //SETTERS
    public void setPoints(int points) {
        mPoints = points;
    }

    public void addPoints(int points) {
        mPoints = mPoints + points;
    }

}
