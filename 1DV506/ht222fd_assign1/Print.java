package ht222fd_assign1;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Scanner;

/**
 * Created by htevar on 25/10/2016.
 */
public class Print {
    public static void main(String[] args) {
        System.out.print("Write a motivational phrase: ");
        Scanner input = new Scanner(System.in);
        String user = input.nextLine();

        //BEGIN ONE LINE
        System.out.println(user);
        //END ONE LINE

        //BEGIN DIFFERENT LINES
        //This.. is going to be difficult. Let's think. What if I change blank space with \n?
        System.out.println(user.replaceAll("\\s+", "\n"));
        //YES! IT WORKS!"\\s+" means one or more white spaces, perfect!
        //END DIFFERENT LINES

        //BEGIN SENTENCE IN BOX
        String sentence = "\n| " + user + " |\n"; // "\n| " + " |\n" = 4 char
        int numEquals = user.length();
        String equal = "===="; // We always have 4 char, so we need 4 equals.

        for (int i = 0; i < numEquals; i++)
            equal = equal + "=";

        System.out.print( equal + sentence + equal);
        //END SENTENCE IN BOX


    }
}
