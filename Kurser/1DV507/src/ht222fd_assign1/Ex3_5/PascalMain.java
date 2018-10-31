package ht222fd_assign1.Ex3_5;

import java.util.Arrays;
import java.util.Scanner;

public class PascalMain {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.print("Add integer: ");
        int user = userCheck(in);

        int[] pascalTest = pascalRow(user);

        System.out.println("The binomial coefficient is: " + Arrays.toString(pascalTest));

        in.close();
    }//main

    public static int[] pascalRow(int n) {
        int[] pascal_1 = new int[n + 1];

        if (n == 0) {
            pascal_1[0] = 1;
            return pascal_1;
        }

        int[] pascal_2 = pascalRow(n - 1);

        pascal_1[0] = 1;
        pascal_1[n] = 1;

        for (int i = 1; i < pascal_2.length; i++) {
            /*Here I wrote i = 0 and it took me more time that I would confess to fix it...*/
            pascal_1[i] = pascal_2[i - 1] + pascal_2[i];
        }

        return pascal_1;
    }//pascal end

    private static int userCheck(Scanner input) {
        while (!input.hasNextInt()) {
            System.out.print("Please enter an integer: ");
            input.next();
        }
        return input.nextInt();

    }
}
