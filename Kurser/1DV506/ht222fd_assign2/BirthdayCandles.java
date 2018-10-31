package ht222fd_assign2;

import java.util.Scanner;

/**
 * Created by hteva on 22/11/2016.
 */
public class BirthdayCandles {
    public static void main(String[] args) {
        int ini = 0;
        int dead = 100;
        int y = 0;
        int candles = 24;

        while (ini <= dead){
            ini++;
            y+=ini;
            /*ini will count the years while
            y will count the sum of years
            * */

            if (y >= candles){
                int box = y / candles;
                y = y % candles;
                /*If you have a sum bigger than candles you have spared
                from last year, that means you need more for your b-day!
                So go and buy a new box. The module would be the spare
                candles for the next year.
                * */

                System.out.println("You have " + y + " candles spared.");
                System.out.println("Before b-day " + ini + " buy " + box + " boxes.\n");
            }
        }
        System.out.println("You are 100 years. RIP user.");

    }
}
