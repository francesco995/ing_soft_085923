package it.polimi.ingsw.ps09.cli;


import it.polimi.ingsw.ps09.res.Places.Market.CreateMarket;
import it.polimi.ingsw.ps09.res.Places.Market.Market;
import it.polimi.ingsw.ps09.res.Places.Towers.CreateTower;
import it.polimi.ingsw.ps09.res.Places.Towers.Tower;

import java.util.LinkedList;
import java.util.List;
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

        //Print floor number, card and dice value into a specified Tower
        for(int mFloor = 0; mFloor<tower.getFloors().size(); mFloor++){
            System.out.println("floor: " + mFloor+1 + "\t card: " + tower.getFloors().get(mFloor).getCard() +
            "\t dice cost: " + tower.getFloors().get(mFloor).getDiceValue());
        }
    }

    //When a TowerList is passed (got when CreateTower.CreateTower is called) shows if and which Tower is free
    public void displayFreeTowers(CreateTower TowerList){

        int mFloor;

        //Loop through all towers to see which one is available
        for(int mTowerNum=0; mTowerNum<TowerList.getTowerList().size(); mTowerNum++){

            mFloor = 0;

            //Loop through each floor of the tower to see if all of them are available.
            //If one floor is available, check the next one
            while(TowerList.getTowerList().get(mTowerNum).getFloors().get(mFloor).isAvailable()){

                mFloor++;
            }

            //If the number of floor is equal mFloor, it means the tower is free
            if(mFloor==TowerList.getTowerList().size()){
                System.out.println("Tower " + TowerList.getTowerList().get(mTowerNum).getColor() + "is available");
            }
        }

    }

    //Display only available MarketSpaces
    public void DisplayFreeMarketSpace(CreateMarket market){

        //Loop through all MarketSpaces
        for(int mNumberMarkeSpace=0; mNumberMarkeSpace<market.getMarketList().size(); mNumberMarkeSpace++){

            //If its free, print it
            if(market.getMarketList().get(mNumberMarkeSpace).isAvailable())
                System.out.println("Market space " + mNumberMarkeSpace+1 + " is available. " +
                "Its bonus is: " + market.getMarketList().get(mNumberMarkeSpace).getBonus());
        }
    }
}
