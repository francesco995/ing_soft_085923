package it.polimi.ingsw.ps09.res;

public enum Colors {
    BLUE("blue"),
    RED("red"),
    GREEN("green"),
    YELLOW("yellow");

    /**
     * Created by francGianni on 10/05/2017.
     */
    private String mColor;

    Colors(String color){
        mColor = color;
    }

    public String getColor(){
        return mColor;
    }


}
