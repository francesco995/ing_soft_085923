package it.polimi.ingsw.ps09.model;

import it.polimi.ingsw.ps09.model.Resources.UserResource;

/**
 * Created by ale on 16/05/2017.
 */
public class BoardBonus {

    UserResources mResourcesBonus = new UserResources();
    UserPoints mPointsBonus = new UserPoints();

    public UserResources getResourcesBonus() {
        return mResourcesBonus;
    }

    public UserPoints getPointsBonus() {
        return mPointsBonus;
    }
}
