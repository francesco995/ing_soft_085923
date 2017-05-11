package it.polimi.ingsw.ps09.res;

/**
 * Created by franc on 10/05/2017.
 */
public enum Colors {
    BLUE("blue"),
    RED("red"),
    GREEN("green"),
    YELLOW("yellow");

    private String mColor;

    Colors(String color){
        mColor = color;
    }

    public String getColor(){
        return mColor;
    }


}
