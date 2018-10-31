package ht222fd_assign1;

import java.util.Scanner;

/**
 * Created by hteva on 25/10/2016.
 */
public class Quote {
    public static void main(String[] args) {

        String lyric;
        Scanner sc = new Scanner(System.in);
        System.out.print("Please, write a melancholic song lyric here: ");
        lyric = sc.nextLine();
        System.out.print("\"" + lyric + "\"");
        sc.close();


    }
}
