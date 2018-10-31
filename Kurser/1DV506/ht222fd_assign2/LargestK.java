package ht222fd_assign2;
import java.util.Scanner;
/**
 * Created by hteva on 16/11/2016.
 */
public class LargestK {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int sum2 = 0;
        int sumTotal = 0;
        int input;
        System.out.print("Add a positive integer: ");
        input = sc.nextInt();

        
        while (sumTotal<input){
            sum2 += 2;
            sumTotal += sum2;
        }//while
        System.out.println("The larges K such that 0+2+4+6+...+K < " + input + " => " +(sum2-2));
    }//main
    /*I don't know what to comment here neither... also pretty obvious.*/
}
