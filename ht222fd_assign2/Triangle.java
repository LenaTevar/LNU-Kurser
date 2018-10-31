package ht222fd_assign2;

import java.util.Scanner;

/**
 * Created by hteva on 22/11/2016.
 */
public class Triangle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int x;
        boolean exit = true;

        //This will make a loop if you write an even name

        while (exit == true) {
            System.out.print("Number: ");
            x = input.nextInt();

            if (x % 2 == 0)
                System.out.println("Sorry, your number is not even. Try again.");
            else {
                System.out.println("RIGHT SIDE TRIANGLE");
                //TRIANGLE RIGHT-SIDE
                for (int i = 0; i < x; i++) {
                    String stars = "";

                    //Spaces before the star
                    for (int j = 0; j < x - i; j++) {
                        stars += " ";
                    }
                    //stars after spaces
                    for (int j = 0; j <= x - (x - i); j++) {
                        /*Dear helena from the future. That "="
                        makes the triangle last stars*/
                        stars += "*";
                    }
                    System.out.println(stars);
                }

                System.out.println("\n");

                //EQ TRIANGLE
                /*Here I'm using 3 for loops. The first one control the rows.
                It's x/2 because we don't need x number of rows but x number
                of stars at the end.
                Inside that one, we have one for loop spaces and another for
                loop for stars.
                * */
                System.out.println("EQ. TRIANGLE");
                for (int i = 0; i <= x/2; i++) {
                    String stars = "";

                    //Spaces before the star
                    for (int j = x/2 - i; j > 0; j--) {
                        stars += " ";
                    }
                    //Stars after spaces
                    for (int j = 0; j <= 2 * i; j++) {
                        /*Dear helena from the future. That "="
                        makes the triangle first star*/
                        stars += "*";
                    }
                    System.out.println(stars);
                }
                exit = false;

            }//else
        }//while
    }//end main

}