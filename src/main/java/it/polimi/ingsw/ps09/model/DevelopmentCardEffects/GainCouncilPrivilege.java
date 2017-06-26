package it.polimi.ingsw.ps09.model.DevelopmentCardEffects;

import it.polimi.ingsw.ps09.model.Player;

/**
 * Created by franc on 30/05/2017.
 * Gain Council Privilege
 */
public class GainCouncilPrivilege implements DevelopmentCardEffect{

    private int mPrivilegesCount;

    public GainCouncilPrivilege(int privilegesCount) {
        mPrivilegesCount = privilegesCount;
    }

    /**
     * Apply effect to a Player
     * @param player Player to apply effect to
     */
    @Override
    public void applyEffect(Player player) {
        player.addCouncilPrivilege(mPrivilegesCount);
    }

    /**
     * Describe object as a string to CLI Clients
     */
    @Override
    public String toString(){
        return String.format("Gain Council Privileges: %d", mPrivilegesCount);
    }
}
