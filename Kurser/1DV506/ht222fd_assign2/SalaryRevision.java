package ht222fd_assign2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by hteva on 27/11/2016.
 */
public class SalaryRevision {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] inputs = new int[1];
        int currentSize = 0;
        int length;
        int gap;
        int media;
        int sum=0;
        int avg;

        System.out.print("Provide salaries (and terminate input with 'X' \n /*actually, you can press whatever letter you want...*/ : ");

        //I'm going to use the growing array from ReverseOrder.java
        //but slightly changed with "hasNextInt"

        while (in.hasNextInt()){
            int number = in.nextInt();

            if (currentSize >= inputs.length){
                inputs= Arrays.copyOf(inputs, 2*inputs.length);
            }
            inputs[currentSize]= number;
            currentSize++;
        }//end while growing array

        //cleaning and sorting the array
        inputs = Arrays.copyOf(inputs, currentSize);
        length = inputs.length;
        Arrays.sort(inputs);

        //GAP
        gap = inputs[length-1] - inputs[0];
        System.out.println("Gap: " + gap);

        //MEDIAN
        if (length%2 == 0) {
            media = (inputs[length / 2] + inputs[length / 2 - 1]) / 2;
            System.out.println("Median: " + media);

        }
        else if (length%2 != 0){
            media = inputs[length/2];
            System.out.println("Median: " + media);
        }

        //AVERAGE
        for (int salaries : inputs){
            sum += salaries;
        }

        avg = sum/length;
        System.out.println("Average: " + avg);


    }
}
