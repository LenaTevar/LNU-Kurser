package ht222fd_assign2;
import java.util.Scanner;


/**
 * Created by hteva on 15/11/2016.
 */
public class SecondLargest {
    public static void main(String[] args) {


        int input;
        int max = 0;
        int second = 0;

        Scanner scan = new Scanner(System.in);
        System.out.print("Add ten and only ten integers:");


        for (int i = 0; i < 10; i++) {
            input = scan.nextInt();


            if (input > max) {
                second = max;
                max = input;
            }

            else if (input > second) {
                second = input;
            }

        }//end for i

        System.out.print("\nLooks like the second larger is " + second);
    }//main
}
