package ht222fd_assign1;

import java.nio.channels.Pipe;
import java.util.Scanner;

/**
 * Created by hteva on 27/10/2016.
 */
public class Change {
    public static void main(String[] args) {
        int [] kronor = new int[]{1000, 500, 200, 100, 50, 20, 10, 5, 1};
        int [] ttChange = new int[] {0,0,0,0,0,0,0,0,0}; //number of billets
        int price;
        int payment;
        int change;

        Scanner sc = new Scanner(System.in);
        System.out.print("Write a price: ");
        price = Math.round(sc.nextFloat());
        //float price = sc.nextFloat();
        System.out.print("Insert payment: ");
        payment = sc.nextInt();
        change = payment - price;
        System.out.println("Change: " + change + "\r\n");

        for(int i=0; i < kronor.length; i++){
            ttChange[i]= change / kronor[i];
            change = change % kronor[i];
            System.out.println( kronor[i]+": " + ttChange[i]);

        }//end for loop

    }
}
