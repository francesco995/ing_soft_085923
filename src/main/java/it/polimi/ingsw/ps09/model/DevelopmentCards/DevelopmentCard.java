package it.polimi.ingsw.ps09.model.DevelopmentCards;

import it.polimi.ingsw.ps09.model.DevelopmentCardEffects.DevelopmentCardEffect;
import it.polimi.ingsw.ps09.model.Resources.UserResource;
import it.polimi.ingsw.ps09.model.UserPoints;
import it.polimi.ingsw.ps09.model.UserResources;

import java.util.LinkedList;
import java.util.List;


/**
 * Created by franc on 10/05/2017.
 */

public abstract class DevelopmentCard {

    //VARIABLES

    //Card INFO
    private String mCardName;
    private int mPeriod;

    //Instant COSTS in UserResources and UserPoints
    private UserResources mResourcesCosts;
    private UserPoints mPointsCosts;

    //Immediate Effect Resources and Points
    private UserResources mImmediateEffectResources;
    private UserPoints mImmediateEffectPoints;

    //Immediate Effects
    private List<DevelopmentCardEffect> mImmediateEffects;

/*

    //CONSTRUCTORS
    public DevelopmentCard(String cardName, int cardPeriod) {
        this(   cardName,
                cardPeriod,
                new UserResources(0,0,0,0),
                new UserPoints(0, 0, 0),
                new UserPoints(0, 0, 0),
                new LinkedList<>(),
                new LinkedList<>());
    }

    public DevelopmentCard(String cardName,
                           int period,
                           UserResources resourcesCosts,
                           UserPoints pointsCosts,
                           UserPoints pointsRequirements,
                           LinkedList<String> immediateEffects,
                           LinkedList<String> permanentEffects) {

        mCardName = cardName;
        mPeriod = period;
        mResourcesCosts = resourcesCosts;
        mPointsCosts = pointsCosts;
        mPointsRequirements = pointsRequirements;
        mImmediateEffects = immediateEffects;
        mPermanentEffects = permanentEffects;
    }
*/

    //GETTERS
    public String getCardName() {
        return mCardName;
    }

    public int getPeriod() {
        return mPeriod;
    }

    public UserResources getResourcesCosts() {
        return mResourcesCosts;
    }

    public UserPoints getPointsCosts() {
        return mPointsCosts;
    }


    /*

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
*/

}
