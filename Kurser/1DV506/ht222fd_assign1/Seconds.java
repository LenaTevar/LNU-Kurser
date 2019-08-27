package ht222fd_assign1;

import java.util.Scanner;

/**
 * Created by hteva on 25/10/2016.
 */
public class Seconds {
    public static void main(String[] args) {
        int hours;
        int minutes;
        int seconds;

        Scanner sc = new Scanner(System.in);
        System.out.print("Hours: ");
        hours = sc.nextInt();
        System.out.print("Minutes: ");
        minutes = sc.nextInt();
        System.out.print("Seconds: ");
        seconds = sc.nextInt();
        int total = seconds + minutes*60 + hours*3600;
        System.out.print("Total time measured in seconds: " + total);
        sc.close();

    }
}
/*
Hello, this is Lena from the future. 
Don't hardcode numbers... that's not polite. 
int oneMinuteSeconds = 60;
int oneHourSeconds = 3600;

then 
int total = seconds + minutes * oneMinuteSeconds + hours * oneHourSeconds

Actually, why not making a method? 
public int timeToSeconds(int hours, int minutes, int seconds){
    return seconds + minutes * oneMinuteSeconds + hours * oneHourSeconds;
    }
*/
