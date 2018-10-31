package ht222fd_assign2;

import java.util.Scanner;


/**
 * Created by hteva on 13/11/2016.
 */
public class Stars {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int x;
        boolean exit = true;

        while (exit == true) {
            System.out.print("Number: ");
            x = input.nextInt();

            if (x % 2 == 0) {
                System.out.println("Sorry, your number is not even. Try again.");
            } else {
                //Isosceles triangle
                for (int i = 0; i <= x; i++) {
                    StringBuilder sb = new StringBuilder();

                    for (int k = x - i; k > 0; k--) {
                        sb.append(" ");
                    }

                    for (int j = 0; j <= 2 * i; j++) {
                        sb.append("*");
                    }
                    String out = sb.toString();
                    System.out.println(out);
                    exit = false;
                }//for i

            } //else

        }//while
    }//main

}
