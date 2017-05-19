package it.polimi.ingsw.ps09.model.Points;

public abstract class Points {

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

    /**
     * Compare this Points object to an other one
     * @param thanThis Points object to compare this. to
     * @return returns true if the Points that invokes the method
     * is GREATER or EQUALS the one passed as parameter
     */
    public boolean isGreaterOrEqual(Points thanThis){
        if(mPoints >= thanThis.getPoints())
            return true;
        return false;
    }


}
