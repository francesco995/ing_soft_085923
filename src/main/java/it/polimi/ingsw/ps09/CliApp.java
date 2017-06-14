package it.polimi.ingsw.ps09;


import it.polimi.ingsw.ps09.controller.Game.Game;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class CliApp {


    public static void main(String[] args) {


        Game mGame;

        List<String> mUserNamesQueue = new LinkedList<>();
        List<String> mUserColorsQueue = new LinkedList<>();
        List<Integer> mUserIDsQueue = new LinkedList<>();

        Scanner mScanner = new Scanner(System.in);

        mUserColorsQueue.add("RED");
        mUserColorsQueue.add("GREEN");
        mUserColorsQueue.add("BLUE");
        mUserColorsQueue.add("YELLOW");

        mUserIDsQueue.add(101);
        mUserIDsQueue.add(102);
        mUserIDsQueue.add(103);
        mUserIDsQueue.add(104);

        List<String> mGameUserColorsQueue = new LinkedList<>();
        List<Integer> mGameUserIDsQueue = new LinkedList<>();

        //SETUP
        System.out.println("\n\n---Hello and Welcome to Lorenzo il Magnifico---\n\n");

        String input;

        do {

            System.out.println("Tell me your name, or start to start the Game");
            input = mScanner.nextLine();

            if(!input.equalsIgnoreCase("start")){
                mUserNamesQueue.add(input);
                mGameUserColorsQueue.add(mUserColorsQueue.get(0));
                mGameUserIDsQueue.add(mUserIDsQueue.get(0));

                mUserColorsQueue.remove(0);
                mUserIDsQueue.remove(0);
            }

        } while (!input.equalsIgnoreCase("start") && mUserNamesQueue.size() < 4);



        mGame = new Game(mGameUserIDsQueue, mUserNamesQueue, mGameUserColorsQueue, 100);

        mGame.run();

        System.out.println("DONE");

    }


}
