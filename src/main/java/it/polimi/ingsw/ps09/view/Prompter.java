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
public abstract class Prompter {


    public static int promptForInt(String message) throws IOException {

        BufferedReader mBufferedStringReader = new BufferedReader(new InputStreamReader(System.in));
        Scanner mReader = new Scanner(System.in);

        System.out.println(message);
        String answer;

        do {
            answer = mReader.nextLine();

        } while (answer.isEmpty());

        return Integer.valueOf(answer);
    }


    public static String promptForString(String message) throws IOException {

        BufferedReader mBufferedStringReader = new BufferedReader(new InputStreamReader(System.in));
        Scanner mReader = new Scanner(System.in);

        System.out.println(message);
        String answer;

        do {
            answer = mReader.nextLine();

        } while (answer.isEmpty());

        return answer;
    }

    public static int promptForIntChoiceZero(String message, List<String> options){

        BufferedReader mBufferedStringReader = new BufferedReader(new InputStreamReader(System.in));
        Scanner mReader = new Scanner(System.in);

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

    public static int promptForIntChoice(String message, List<String> options){

        BufferedReader mBufferedStringReader = new BufferedReader(new InputStreamReader(System.in));
        Scanner mReader = new Scanner(System.in);

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

    public static void printStringList(List<String> items) {
        IntStream.rangeClosed(1, items.size())
                .mapToObj( i -> String.format("%d. %s", i, items.get( i - 1 ) ) )
                .forEach(System.out::println);
    }



    public static ArrayList<Integer> PromptForMultipleDifferentChoices(String message, List<String> options, int numberOfChoices, int maxNumber) {

        BufferedReader mBufferedStringReader = new BufferedReader(new InputStreamReader(System.in));
        Scanner mReader = new Scanner(System.in);

        ArrayList<Integer> mChoices =  new ArrayList<Integer>();

        //First prints the message
        System.out.println(message);

        //Prints all the options available
        printStringList(options);

        //Asks for all the choices

        do {

            System.out.println("\nYour choice max number("+ maxNumber +"), remember no repetitions? -> ");
            int control = mReader.nextInt();

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
