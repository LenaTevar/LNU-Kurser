package ht222fd_assign1;

import java.util.Scanner;

/**
 * Created by hteva on 26/10/2016.
 * Write a program SumOfThree.java which asks the user to provide a three digit number. The program should then compute the sum of the three digits. For example:
 * Provide a three digit number: 483
 * Sum of digits: 15
 */
public class SumOfThree {
    public static void main(String[] args) {
        int n;
        int sum = 0;

        Scanner sc = new Scanner(System.in);
        System.out.println("Number:");
        n = sc.nextInt();
        sc.close();

        while (n != 0){
            sum += n % 10;
            n /= 10;
        }
        System.out.println(sum);

    }
}
