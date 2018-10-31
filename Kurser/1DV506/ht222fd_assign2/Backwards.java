package ht222fd_assign2;

import java.util.Scanner;

/**
 * Created by hteva on 16/11/2016.
 */
public class Backwards {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner input = new Scanner(System.in);
        //String user;

        System.out.print("Insert a sentence: ");
        //user = input.nextLine();
        //sb.append(user);
        //Gosh, why wouldn't stringBuilder add directly from scanner??
        sb.append(input.nextLine());
        ///hahaha wait, it can.
        System.out.println(sb.reverse());

    }
}
