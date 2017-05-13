package it.polimi.ingsw.ps09.cli;


import it.polimi.ingsw.ps09.res.Towers.Tower;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CliApp {
    public static void main(String[] args) {
        //SETUP
        System.out.println("---Hello and Welcome to Lorenzo il Magnifico---");
        Scanner scanner = new Scanner(System.in);
        System.out.println("num of player");
        int number = scanner.nextInt();
        scanner.nextLine();
        Queue<String> mUserNamesQueue = new LinkedList<>();
        do {
            System.out.println("Tell me your name");
            String mUserName = scanner.nextLine();
            mUserNamesQueue.add(mUserName);
            System.out.println(mUserName);
            number--;
        }while (number!=0);


    }

    public void displayCardsinTower(Tower tower){
        System.out.println("the cards in the" +tower.getColor() + "tower are:");


    }
}
