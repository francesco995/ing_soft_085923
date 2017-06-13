package it.polimi.ingsw.ps09;


import it.polimi.ingsw.ps09.model.FamilyMembers.FamilyMember;
import it.polimi.ingsw.ps09.model.Places.HarvestAndProductionAreas.HarvestArea;
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

    public void displayFreeHarvest(HarvestArea harvestArea, FamilyMember Pawn){

        //Check if there is a FamilyMembers already
        if(harvestArea.isAvailable(Pawn)) {
            System.out.println("Available");

            //Check which slot is available; With 1 diceValue or 3 diceValue
            if(harvestArea.getSlotList().size() == 0)
                System.out.println("The first slot with diceValue 1 is available");

            //TODO: How to get NumberOfPlayer??? FraG: i'll add a method in game to get how many players are playing

            //Check other slot only if number of player is more than 2
         //   else if((harvestArea.getSlotList().size() != 0)&& (NumberOfPlayers>2))
                System.out.println("Slot available with DiceValue = 3");
        }

        else
            System.out.println("No space available");
    }

}
