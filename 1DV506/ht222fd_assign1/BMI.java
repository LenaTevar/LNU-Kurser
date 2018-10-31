package ht222fd_assign1;

import java.util.Scanner;

/**
 * Created by hteva on 25/10/2016.
 */
public class BMI {
    public static void main(String[] args) {
        float length;
        float weight;
        Scanner sc = new Scanner(System.in);

        System.out.print("Please enter your length (meters): ");
        length = sc.nextFloat();

        System.out.print("Please enter your weight: ");
        weight = sc.nextFloat();
        sc.close();

        float total =  weight/(length * length);
        System.out.print("Your BMI is: " + total);
    }
}
