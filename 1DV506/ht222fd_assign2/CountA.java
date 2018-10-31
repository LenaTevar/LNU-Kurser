package ht222fd_assign2;

import java.util.Scanner;

/**
 * Created by hteva on 16/11/2016.
 */
public class CountA {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count_a=0;
        int count_A=0;
        char char_a = 'a';
        char char_A = 'A';
        System.out.print("Write a phrase: ");
        String user = input.nextLine();

        for (int i = 0; i <user.length() ; i++) {
            if (char_a == user.charAt(i))
                count_a++;
            else if (char_A == user.charAt(i))
                count_A++;
        }
        System.out.print("Number of A: "+ count_A + "\nNumber of a: " + count_a);

        /*I don't know what to comment here... It's pretty obvious.
        * */
    }

}
