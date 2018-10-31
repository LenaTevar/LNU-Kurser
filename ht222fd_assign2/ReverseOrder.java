package ht222fd_assign2;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.Scanner;

/**Create a program ReverseOrder.java that reads an arbitrary number of positive integers
 * from the keyboard and then prints them in reverse order.
 * The reading stops when the user inputs a negative number.
 * Created by hteva on 23/11/2016.
 */
public class ReverseOrder {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int[] inputs = new int[1];
        int currentSize = 0;
        boolean done = false;

        /*Using the book here!
         Chapter 6 - page 265
        *How to grow Arrays
        * */
        System.out.print("Add numbers, input a negative number to stop: ");
        while (!done){
            int number = in.nextInt();

            if (number < 0)
                done = true;

            else {

                if (currentSize >= inputs.length) {
                    inputs = Arrays.copyOf(inputs, 2 * inputs.length);
                }

                inputs[currentSize] = number;
                currentSize++;
            }
        }

        //cleaning the array
        inputs = Arrays.copyOf(inputs, currentSize);

        System.out.println("Number of positive integers: " + currentSize);
        System.out.print("In reverse order: ");

        //Printing reverse
        for (int i = inputs.length-1; i >= 0 ; i--) {
            if (i < inputs.length-1){
                System.out.print(", ");
            }
            System.out.print(inputs[i]);
        }



    }
}
