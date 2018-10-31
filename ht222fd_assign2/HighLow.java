package ht222fd_assign2;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by hteva on 16/11/2016.
 */
public class HighLow {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random randomN = new Random();
        int secret = randomN.nextInt(100)+1;
        int counter = 0;
        int answer;
        boolean bool = true;

            while (counter<10 && bool == true){
                System.out.print("Guess " + (counter + 1) + ": ");
                answer = input.nextInt();

                if (answer > secret) {
                    System.out.println("Clue: lower");
                } else if (answer < secret) {
                    System.out.println("Clue: higher");
                } else {
                    System.out.println("Correct answer after only " + (counter + 1) + " guesses - Excellent!");
                    bool = false;
                    //It will break the while loop even when counter is < 10
                }
                counter++;
            }

        // it's an if because when you break from last else, it won't speaks
        if (counter >= 10)
            System.out.println("Sorry, you used all your guesses.");
    }
}
