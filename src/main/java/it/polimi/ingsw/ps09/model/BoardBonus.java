package it.polimi.ingsw.ps09.model;

/**
 * Created by ale on 16/05/2017.
 */
public class BoardBonus {

    private UserResources mResourcesBonus;
    private UserPoints mPointsBonus;
    private int mPrivilegesCount;

    public BoardBonus(UserResources ResourcesBonus, UserPoints PointsBonus, int PrivilegesCount) {
        mResourcesBonus = ResourcesBonus;
        mPointsBonus = PointsBonus;
        mPrivilegesCount = PrivilegesCount;
    }

    public UserResources getResourcesBonus() {
        return mResourcesBonus;
    }

    public UserPoints getPointsBonus() {
        return mPointsBonus;
    }

    public int getPrivilegesCount() {
        return mPrivilegesCount;
    }
}
