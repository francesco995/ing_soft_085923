package it.polimi.ingsw.ps09.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Created by francesco995 on 25/05/2017.
 */
public class Prompter {

    BufferedReader mBufferedStringReader = new BufferedReader(new InputStreamReader(System.in));
    Scanner mReader = new Scanner(System.in);


    public int promptForInt(String message) throws IOException {
        System.out.println(message);
        String answer;

        do {
            answer = mReader.nextLine();

        } while (answer.isEmpty());

        return Integer.valueOf(answer);
    }


    public String promptForString(String message) throws IOException {
        System.out.println(message);
        String answer;

        do {
            answer = mReader.nextLine();

        } while (answer.isEmpty());

        return answer;
    }

    public int promptForIntChoiceZero(String message, List<String> options){

        int choice;

        //First prints the message
        System.out.println(message);

        //Prints all the options available
        printStringList(options);

        //Asks for the choice
        do {
            System.out.print("\nYour choice? -> ");
            choice = mReader.nextInt();
        }while(choice < 0 || choice > options.size());

        return (choice);
    }

    public int promptForIntChoice(String message, List<String> options){

        int choice;

        //First prints the message
        System.out.println(message);

        //Prints all the options available
        printStringList(options);

        //Asks for the choice
        do {
            System.out.print("\nYour choice? -> ");
            choice = mReader.nextInt();
        }while(choice < 1 || choice > options.size());

        return (choice);
    }

    private void printStringList(List<String> options) {
        IntStream.rangeClosed(1, options.size())
                .mapToObj( i -> String.format("%d. %s", i, options.get( i - 1 ) ) )
                .forEach(System.out::println);
    }

    public ArrayList<Integer> PromptForMultipleDifferentChoices(String message, List<String> options, int numberOfChoices, int maxNumber) {

        ArrayList<Integer> mChoices =  new ArrayList<Integer>();

        //First prints the message
        System.out.println(message);

        //Prints all the options available
        printStringList(options);

        //Asks for all the choices

        do {

            System.out.println("\nYour choice max number("+ maxNumber +"), remember no repetitions? -> ");
            int control =mReader.nextInt();

            if(control<maxNumber) {
                boolean isUsed = false;

                //control if already entered
                for (int i = 0; i < mChoices.size(); i++) {
                    if (control == mChoices.get(i))
                        isUsed = true;

                }
                //if isUsed is false actually add number else print user error and let him chose again
                if (isUsed == false) {
                    mChoices.add(control);
                    numberOfChoices--;
                } else
                    System.out.println("\nChoice already used, don't try to cheat!!!");
            }
            else
                System.out.println("\nnumber out of bound, try again");

        }while (numberOfChoices > 0);

        return mChoices;
    }

}
