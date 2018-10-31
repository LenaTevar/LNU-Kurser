package ht222fd_assign2;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by hteva on 24/11/2016.
 */
public class FrequencyTable {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] times = {0, 0, 0, 0, 0, 0};
        int numberDices;

        System.out.print("How many times do you want to roll the dice? ");
        numberDices = input.nextInt();
        /*Looks funnier if you can choose how many times you want to roll the dice*/

        for (int i = 0; i < numberDices ; i++) {


            int dice = (int) (Math.random() * 6) + 1;
            times[dice - 1]++;
        }
        System.out.println("Frequencies when rolling a dice " + numberDices + " times.");
        for (int i = 0; i <times.length ; i++) {
            System.out.print("Result: " + (i+1) + " -> " + times[i]+ "\n");
        }
    }
}
