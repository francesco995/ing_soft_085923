package it.polimi.ingsw.ps09.res.Points;

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

    public int showSupport(FaithPoints offer){
        int bonus = 0;
        switch (offer.getPoints())
        {
            case 1:
                bonus = BonusOne;
                break;
            case 2:
                bonus = BonusTwo;
                break;
            case 3:
                bonus = BonusThree;
                break;
            case 4:
                bonus = BonusFour;
                break;
            case 5:
                bonus = BonusFive;
                break;
            case 6:
                bonus = BonusSix;
                break;
            case 7:
                bonus = BonusSeven;
                break;
            case 8:
                bonus = BonusEight;
                break;
            case 9:
                bonus = BonusNine;
                break;
            case 10:
                bonus = BonusTen;
                break;
            case 11:
                bonus = BonusEleven;
                break;
            case 12:
                bonus = BonusTwelve;
                break;
            case 13:
                bonus = BonusThirteen;
                break;
            case 14:
                bonus = BonusFourteen;
                break;
            case 15:
                bonus = BonusFifteen;
                break;
        }
        return bonus;
    }
    public void sufferExcomunication(){

    }

    private int BonusOne;
    private int BonusTwo;
    private int BonusThree;
    private int BonusFour;
    private int BonusFive;
    private int BonusSix;
    private int BonusSeven;
    private int BonusEight;
    private int BonusNine;
    private int BonusTen;
    private int BonusEleven;
    private int BonusTwelve;
    private int BonusThirteen;
    private int BonusFourteen;
    private int BonusFifteen;

    public void chargeValues(){
        BonusOne = 1;
        BonusTwo = 2;
        BonusThree = 3;
        BonusFour = 4;
        BonusFive = 5;
        BonusSix = 7;
        BonusSeven = 9;
        BonusEight = 11;
        BonusNine = 13;
        BonusTen = 15;
        BonusEleven = 17;
        BonusTwelve = 19;
        BonusThirteen = 22;
        BonusFourteen = 25;
        BonusFifteen = 30;
    }
}
