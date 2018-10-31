package ht222fd_assign1.Ex6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*CLASS HISTOGRAMCLASS:
*This is kind of the exercise from Java 1.
* */

public class HistogramClass {

    private int[] counter = new int[11];
    private Scanner input;
    public HistogramClass (File user) throws FileNotFoundException {
        this.input = new Scanner(user);
    }


    public int[] Counter (){

        while (input.hasNextInt()){
            double number = input.nextInt();

            if (number>100){
                counter[10]++;
                //System.out.println(number + ">100 -- " + counter[10]);
            }
            else if (number>90){
                counter[9]++;
                //System.out.println(number + ">90 -- " + counter[9]);
            }
            else if (number>80){
                counter[8]++;
                //System.out.println(number + ">80 -- " + counter[8]);
            }
            else if (number>70){
                counter[7]++;
                //System.out.println(number + ">70 -- " + counter[7]);
            }
            else if (number>60){
                counter[6]++;
                //System.out.println(number + ">60 -- " + counter[69]);
            }
            else if (number>50){
                counter[5]++;
                //System.out.println(number + ">50 -- " + counter[5]);
            }
            else if (number>40){
                counter[4]++;
                //System.out.println(number + ">40 -- " + counter[4]);
            }
            else if (number>30){
                counter[3]++;
                //System.out.println(number + ">90 -- " + counter[3]);
            }
            else if (number>20){
                counter[2]++;
                //System.out.println(number + ">20 -- " + counter[2]);
            }
            else if (number>10){
                counter[1]++;
                //System.out.println(number + ">10 -- " + counter[1]);
            }
            else if (number>0){
                counter[0]++;
                //System.out.println(number + ">00 -- " + counter[0]);
            }
        }//end while

        input.close();

        return counter;
    }

}
