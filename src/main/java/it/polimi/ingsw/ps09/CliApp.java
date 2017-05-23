package it.polimi.ingsw.ps09;


import it.polimi.ingsw.ps09.model.FamilyMembers.FamilyMember;
import it.polimi.ingsw.ps09.model.Places.HarvestAndProductionAreas.Harvest;
import it.polimi.ingsw.ps09.model.Places.Market.Market;
import it.polimi.ingsw.ps09.model.Places.Towers.CreateTower;
import it.polimi.ingsw.ps09.model.Places.Towers.Tower;
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

    public void displayCardsInTower(Tower tower){
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
    public void displayFreeMarketSpace(Market market){

        //Loop through all MarketSpaces
        for(int mNumberMarketSpace=0; mNumberMarketSpace<market.getMarketList().size(); mNumberMarketSpace++){

            //If its free, print it
            if(market.getMarketList().get(mNumberMarketSpace).isAvailable())
                System.out.println("MarketSpace space " + mNumberMarketSpace+1 + " is available. " +
                "Its bonus is: " + market.getMarketList().get(mNumberMarketSpace).getBoardBonus());
        }
    }

    public void displayFreeHarvest(Harvest harvest, FamilyMember Pawn){

        //Check if there is a FamilyMembers already
        if(harvest.isAvailable(Pawn)) {
            System.out.println("Available");

            //Check which slot is available; With 1 diceValue or 3 diceValue
            if(harvest.getSlotList().size() == 0)
                System.out.println("The first slot with diceValue 1 is available");

            //TODO: How to get NumberOfPlayer??? FraG: i'll add a method in game to get how many players are playing

            //Check other slot only if number of player is more than 2
         //   else if((harvest.getSlotList().size() != 0)&& (NumberOfPlayers>2))
                System.out.println("Slot available with DiceValue = 3");
        }

        else
            System.out.println("No space available");
    }
}
