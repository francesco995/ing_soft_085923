package it.polimi.ingsw.ps09.model.Places.Towers.Floor;

import com.google.gson.Gson;
import it.polimi.ingsw.ps09.model.BoardBonus;
import it.polimi.ingsw.ps09.model.DevelopmentCards.DevelopmentCard;
import it.polimi.ingsw.ps09.model.FamilyMembers.FamilyMember;
import it.polimi.ingsw.ps09.model.Places.Market.Market;
import it.polimi.ingsw.ps09.model.UserPoints;
import it.polimi.ingsw.ps09.model.UserResources;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringJoiner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by ale on 10/05/2017.
 */
public class Floor {

    private int mDiceValue;
    private BoardBonus mBoardBonus;
    private DevelopmentCard mCard;
    private FamilyMember mFamilyMember;

    /**
     *
     * @param diceValue Set dice value to access on the floor
     */
    public Floor(int diceValue, String finalFilePath) {
        mDiceValue = diceValue;

        String mStringDeck = "";

        File mDirectory = new File("./");

        String mFilePath = mDirectory.getAbsolutePath().replace(".",
                "src/main/res/TowerInstantBonus/");

        try {
            Scanner mScanner = new Scanner(new File(mFilePath + finalFilePath));
            mStringDeck = mScanner.useDelimiter("\\A").next();
            mScanner.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Market.class.getName()).log(Level.SEVERE, null, ex);
        }

        mBoardBonus = new Gson().fromJson(mStringDeck, BoardBonus.class);



    }

    /**
     *
     * @param familyMember Set floor's family memeber
     */
    public void setFamilyMember(FamilyMember familyMember) {
        mFamilyMember = familyMember;
    }

    /**
     *
     * @param boardBonus Set floor's boardBonus you get when access to a specified floor
     */
    public void setBoardBonus(BoardBonus boardBonus) {
        mBoardBonus = boardBonus;
    }

    /**
     *
     * @param card Set floor's card
     */
    public void setCard(DevelopmentCard card) {
        mCard = card;
    }

    /**
     *
     * @return Get family member object who is on the floor
     */
    public FamilyMember getFamilyMember() {
        return mFamilyMember;
    }

    /**
     *
     * @return Get floor's dice value
     */
    public int getDiceValue() {
        return mDiceValue;
    }

    /**
     *
     * @return Get the floor's instant bonus which is gained when a family member is set on that floor
     */
    public BoardBonus getBoardBonus() {
        return mBoardBonus;
    }

    /**
     *
     * @return Get floor's development card
     */
    public DevelopmentCard getCard() {
        return mCard;
    }

    /**
     *
     * @return Boolean value: true if the specified floor is available, false if not
     */
    public boolean isAvailable(){
        if(mFamilyMember!=null)
            return false;

        else
            return true;
    }

    /**
     *
     * @return All floor's information
     */
    @Override
    public String toString() {


        StringJoiner mStringFloor = new StringJoiner("\n    ", "        ", "");

        mStringFloor.add("");
        mStringFloor.add("Dice value: " + mDiceValue);

        String stringBonus = "Bonus: ";

        if (mBoardBonus.getPointsBonus().isGreaterOrEqual(new UserPoints(0, 0, 0)))
            stringBonus += mBoardBonus.getPointsBonus().toString();

        if (mBoardBonus.getResourcesBonus().isGreaterOrEqual(new UserResources(0, 0, 0, 0)))
            stringBonus += mBoardBonus.getResourcesBonus().toString();

        if (mBoardBonus.getPrivilegesCount() > 0)
            stringBonus += mBoardBonus.getPrivilegesCount();

        mStringFloor.add(stringBonus);

        if(mCard!=null)
            mStringFloor.add("Card: " + mCard.toString());

        if (!isAvailable()) {
            mStringFloor.add(mFamilyMember.toString());
        }
        else
            mStringFloor.add("Floor free");

        mStringFloor.add("\n");

        return mStringFloor.toString();

    }
}
