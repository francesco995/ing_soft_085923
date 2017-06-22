package it.polimi.ingsw.ps09.model.Places.Towers.Floor;

import com.google.gson.Gson;
import it.polimi.ingsw.ps09.model.BoardBonus;
import it.polimi.ingsw.ps09.model.DevelopmentCards.DevelopmentCard;
import it.polimi.ingsw.ps09.model.FamilyMembers.FamilyMember;
import it.polimi.ingsw.ps09.model.Places.Market.Market;

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

    @Override
    public String toString(){

        StringJoiner mStringFloor = new StringJoiner("\n    ", "", "");

        mStringFloor.add("");
        mStringFloor.add("Dice value: " + mDiceValue);

        mStringFloor.add("Bonus: "
                + mBoardBonus.getPointsBonus().toString()
                + mBoardBonus.getResourcesBonus().toString()
                + "Privilage count: " + mBoardBonus.getPrivilegesCount());

        mStringFloor.add("Card: " + mCard);
        mStringFloor.add("Family Memeber: " + mFamilyMember);
        mStringFloor.add("\n");



        return mStringFloor.toString();
    }

}
