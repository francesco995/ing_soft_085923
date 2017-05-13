package it.polimi.ingsw.ps09.res.Cards;

import it.polimi.ingsw.ps09.res.Resources.Coins;
import it.polimi.ingsw.ps09.res.Resources.Servant;
import it.polimi.ingsw.ps09.res.Resources.Stone;
import it.polimi.ingsw.ps09.res.Resources.Wood;
import it.polimi.ingsw.ps09.res.Points.FaithPoints;
import it.polimi.ingsw.ps09.res.Points.MilitaryPoints;
import it.polimi.ingsw.ps09.res.Points.VictoryPoints;


/**
 * Created by franc on 10/05/2017.
 */
public class Card {

    //VARIABLES COMMON TO ALL
    private String mCardName;
    private int mPeriod;
    private Costs mCosts;
    private Gains mGains;


    //COMMON VAR CONSTRUCTOR
    public Card(String cardName, int period) {
        mCardName = cardName;
        mPeriod = period;
    }


    //GETTER
    public String getCardName() {
        return mCardName;
    }

    public int getPeriod() {
        return mPeriod;
    }

    private class Costs {

        //COST VARIABLES (NOT ALL NEED TO BE SET TO VALUE)
        private Coins mCoinsCost;
        private Wood mWoodCost;
        private Stone mStoneCost;
        private Servant mServantCost;
        private MilitaryPoints mMilitaryPointsRequirement;
        private MilitaryPoints mMilitaryPointsCost;

        //COST CONSTRUCTOR

        public Costs(Coins coinsCost, Wood woodCost, Stone stoneCost,
                     Servant servantCost, MilitaryPoints militaryPointsRequirement,
                     MilitaryPoints militaryPointsCost) {
            mCoinsCost = coinsCost;
            mWoodCost = woodCost;
            mStoneCost = stoneCost;
            mServantCost = servantCost;
            mMilitaryPointsRequirement = militaryPointsRequirement;
            mMilitaryPointsCost = militaryPointsCost;
        }
        //GETTER

        public Coins getCoinsCost() {
            return mCoinsCost;
        }

        public Wood getWoodCost() {
            return mWoodCost;
        }

        public Stone getStoneCost() {
            return mStoneCost;
        }

        public Servant getServantCost() {
            return mServantCost;
        }

        public MilitaryPoints getMilitaryPointsRequirement() {
            return mMilitaryPointsRequirement;
        }

        public MilitaryPoints getMilitaryPointsCost() {
            return mMilitaryPointsCost;
        }
    }

    private class Gains {
        //GAINS VARIABLES
        private Coins mCoinsGain;
        private Wood mWoodGain;
        private Stone mStoneGain;
        private Servant mServantGain;
        private FaithPoints mFaithPointsGain;
        private MilitaryPoints mMilitaryPointsGain;
        private VictoryPoints mVictoryPoints;
        //GAINS CONSTRUCTOR

        public Gains(Coins coinsGain, Wood woodGain, Stone stoneGain,
                     Servant servantGain, FaithPoints faithPointsGain,
                     MilitaryPoints militaryPointsGain, VictoryPoints victoryPoints) {
            mCoinsGain = coinsGain;
            mWoodGain = woodGain;
            mStoneGain = stoneGain;
            mServantGain = servantGain;
            mFaithPointsGain = faithPointsGain;
            mMilitaryPointsGain = militaryPointsGain;
            mVictoryPoints = victoryPoints;
        }
        //GETTER

        public Coins getCoinsGain() {
            return mCoinsGain;
        }

        public Wood getWoodGain() {
            return mWoodGain;
        }

        public Stone getStoneGain() {
            return mStoneGain;
        }

        public Servant getServantGain() {
            return mServantGain;
        }

        public FaithPoints getFaithPointsGain() {
            return mFaithPointsGain;
        }

        public MilitaryPoints getMilitaryPointsGain() {
            return mMilitaryPointsGain;
        }

        public VictoryPoints getVictoryPoints() {
            return mVictoryPoints;
        }
    }

}
