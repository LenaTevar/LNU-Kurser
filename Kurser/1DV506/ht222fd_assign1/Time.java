package ht222fd_assign1;

import java.util.Scanner;

/**
 * Created by hteva on 26/10/2016.
 * Write a program Time.java, which reads a number of seconds (an integer) and then prints the same amount of time given in hours, minutes and seconds. An example of an execution:
 * Give a number of seconds: 9999
 * This corresponds to: 2 hours, 46 minutes and 39 seconds.
 */
public class Time {
    public static void main(String[] args) {
        int input;
        int secTotal;
        int sec;
        int min;
        int hours;
        System.out.print("Give a number of seconds: ");
        Scanner sc = new Scanner(System.in);
        input = sc.nextInt();
        sc.close();

        secTotal = input % 3600; //how many seconds are left when divided by hours
        sec = secTotal % 60; //how many seconds are left when divided by minutes
        min = secTotal / 60;
        hours = input/3600;
        System.out.print( "This corresponds to: " + hours + " hours, " + min + " minutes and " + sec + " seconds.");
    }
}
