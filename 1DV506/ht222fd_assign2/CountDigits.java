package ht222fd_assign2;

import java.util.Scanner;

/**
 * Created by hteva on 15/11/2016.
 * I did this exercise with integers, but at some point
 * I wanted to do it with large numbers. Of course I got errors
 * so I did it with doubles. Now it should work with large numbers also.
 */
public class CountDigits {
    public static void main(String[] args) {

        int countZero = 0, countEven = 0, countOdd = 0;
        double  input;
        double number;

        Scanner scan = new Scanner(System.in);
        System.out.print("Add integer:");
        input = scan.nextDouble();

        /*
        I want to know how many numbers my double has.
        I made a little method to do it.
        I used double instead of integers because I was using really long numbers
        when I was testing.
         */


        double inputLength = input;
        int lengthCount= 0;
        //Let's re-use "sum of three" exercise here

        while (inputLength >= 1){
            //The only thing I don't like. If you begin with zero, it doesn't count.
            lengthCount++;
            inputLength/=10;
        }


        for (int i = 0; i < lengthCount; i++) {
                number = input%10;

                if (number < 1){
                 countZero++;
                }
                else if (number%2 < 1){ //because doubles
                    countEven++;
                }
                else{
                    countOdd++;
                }
                input /= 10;
        }//end for

        System.out.println("Zero: " + countZero +
                "\nOdd: " + countOdd +
                "\nEven: " + countEven );
    }//end main
}
