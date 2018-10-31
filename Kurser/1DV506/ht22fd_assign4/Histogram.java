package ht22fd_assign4;
/*Future Helena list TODO:
 * change double to integers or parse it or whatever you want.
 * format histogram.
 * The absolute path to the data file should be provided as an argument to the main method.
 * */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Histogram {
	/* OBS: CLASS PathFile.java is a lazy class to write files.
	 * */

    public static void main(String[] args) throws FileNotFoundException {

        PathFile myFolder = new PathFile();

        File inputFile = new File(myFolder.getFullPath("HistoText.txt"));
        PrintAll(inputFile);

    }//end main

    /*Helper Method: Counting
     * Numbers will be counted in their similar position inside an array.
     * Example: [0] = numbers > 0; [1] = numbers > 10; and so on.
     * The last position [10] are numbers bigger than 100.
     * */
    private static double[] Counting(File userInput) throws FileNotFoundException {
        double[] counter = new double[11];


        Scanner in = new Scanner(userInput);
        while (in.hasNextDouble()) {
            double number = in.nextDouble();

            if (number > 100) {
                counter[10]++;
                //System.out.println(number + ">100 -- " + counter[10]);
            } else if (number > 90) {
                counter[9]++;
                //System.out.println(number + ">90 -- " + counter[9]);
            } else if (number > 80) {
                counter[8]++;
                //System.out.println(number + ">80 -- " + counter[8]);
            } else if (number > 70) {
                counter[7]++;
                //System.out.println(number + ">70 -- " + counter[7]);
            } else if (number > 60) {
                counter[6]++;
                //System.out.println(number + ">60 -- " + counter[69]);
            } else if (number > 50) {
                counter[5]++;
                //System.out.println(number + ">50 -- " + counter[5]);
            } else if (number > 40) {
                counter[4]++;
                //System.out.println(number + ">40 -- " + counter[4]);
            } else if (number > 30) {
                counter[3]++;
                //System.out.println(number + ">90 -- " + counter[3]);
            } else if (number > 20) {
                counter[2]++;
                //System.out.println(number + ">20 -- " + counter[2]);
            } else if (number > 10) {
                counter[1]++;
                //System.out.println(number + ">10 -- " + counter[1]);
            } else if (number > 0) {
                counter[0]++;
                //System.out.println(number + ">00 -- " + counter[0]);
            }


        }//end while

        in.close();

        return counter;


    }


    /*Helper Method: PrintHisto
     * Print numbers>100 using the knowing place for them array[10].
     *
     * After that, I made a little of math to write the range of numbers
     * without hard coding it, using the array position as reference.
     *  If numbers > 10 are in position [1], then write that position * 10 + 1
     *  and that + 9. At the end we get 11-20 automatically.
     * To make the actual histogram, I made a loop with "*" for each value of the array.
     * */
    private static void PrintHisto(double[] arrInput) {
        String others = "Others: " + arrInput[10];
        System.out.println(others);
        System.out.println("HISTOGRAM");

        for (int i = 0; i < arrInput.length - 1; i++) {
            int first = i * 10 + 1;
            int second = first + 9;
            String printOrder = first + " - " + second + " | ";
            for (int j = 0; j < arrInput[i]; j++) {
                printOrder += "*";
            }

            System.out.println(printOrder);

        }


    }

    private static void PrintAll(File userFile) throws FileNotFoundException {


        double[] inputCounter;
        //System.out.println(Arrays.toString(inputCounter));
        inputCounter = Counting(userFile);
        System.out.println(Arrays.toString(inputCounter));
        System.out.println("Reading integers from file: " + userFile.toString());

        int total = 0;
        for (int i = 0; i < inputCounter.length - 1; i++) {
            //length-1 because position [10] is "others" numbers.
            total += inputCounter[i];
        }

        System.out.println("Number of integers in the interval [1, 100]: " + total);
        PrintHisto(inputCounter);

    }
}