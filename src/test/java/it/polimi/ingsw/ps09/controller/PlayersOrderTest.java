package it.polimi.ingsw.ps09.controller;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by francesco995 on 10/07/2017.
 */
public class PlayersOrderTest {

    PlayersOrder mPlayersOrder;

    @Before
    public void setUp() throws Exception {

        mPlayersOrder = new PlayersOrder(new ArrayList<>(
                Arrays.asList(101, 102, 103, 104)
        ));

    }

    @Test
    public void rearrangePlayers1() throws Exception {

        ArrayList<Integer> councilList = new ArrayList<>(Arrays.asList(104));
        mPlayersOrder.rearrangePlayers(councilList);
        assertTrue(mPlayersOrder.getPlayersOrder().equals(new ArrayList<>(Arrays.asList(104, 101, 102, 103))));

    }

    @Test
    public void rearrangePlayers2() throws Exception {

        ArrayList<Integer> councilList = new ArrayList<>(Arrays.asList(104, 102));
        mPlayersOrder.rearrangePlayers(councilList);
        assertTrue(mPlayersOrder.getPlayersOrder().equals(new ArrayList<>(Arrays.asList(104, 102, 101, 103))));

    }

    @Test
    public void rearrangePlayers3() throws Exception {

        ArrayList<Integer> councilList = new ArrayList<>(Arrays.asList(104, 102, 103));
        mPlayersOrder.rearrangePlayers(councilList);
        assertTrue(mPlayersOrder.getPlayersOrder().equals(new ArrayList<>(Arrays.asList(104, 102, 103, 101))));

    }

    @Test
    public void rearrangePlayers4() throws Exception {

        ArrayList<Integer> councilList = new ArrayList<>(Arrays.asList(104, 102, 103, 101));
        mPlayersOrder.rearrangePlayers(councilList);
        assertTrue(mPlayersOrder.getPlayersOrder().equals(new ArrayList<>(Arrays.asList(104, 102, 103, 101))));

    }

    @Test
    public void rearrangePlayersDuplicates() throws Exception {

        ArrayList<Integer> councilList = new ArrayList<>(Arrays.asList(104, 104, 102, 104, 103, 101, 103, 102, 101));
        mPlayersOrder.rearrangePlayers(councilList);
        assertTrue(mPlayersOrder.getPlayersOrder().equals(new ArrayList<>(Arrays.asList(104, 102, 103, 101))));

    }

    @Test
    public void rearrangePlayersDuplicates2() throws Exception {

        ArrayList<Integer> councilList = new ArrayList<>(Arrays.asList(102, 102, 102, 103, 102, 103, 103));
        mPlayersOrder.rearrangePlayers(councilList);
        assertTrue(mPlayersOrder.getPlayersOrder().equals(new ArrayList<>(Arrays.asList(102, 103, 101, 104))));

    }

}