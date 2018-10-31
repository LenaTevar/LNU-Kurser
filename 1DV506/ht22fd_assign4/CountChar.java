package ht22fd_assign4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/* OBS: READ CLASS PathFile.java before continuing.
 * */

/*Future Helena list to do:
 * white spaces/tabs etc at the end of a text/string is not counting!
 * */

public class CountChar {

    public static void main(String[] args) throws FileNotFoundException {
        PathFile myFolder = new PathFile();

        File inputFile = new File(myFolder.getFullPath("HistoProgramming.txt"));

        int[] myCounter = Counting(inputFile);
        //System.out.println(Arrays.toString(myCounter));
        PrintCounter(myCounter);

    }
    /*
     * [0] = Digit; [1] = UPPER; [2] = lower; [3] = BLANK; [4] = SPECIAL
     * */
    public static int[] Counting (File input) throws FileNotFoundException{
        int[] counter = {0, 0, 0, 0};
        String strToCompare;
        Scanner in = new Scanner (input);

        while (in.hasNext()){
            strToCompare= in.nextLine();
            //System.out.println(strToCompare);
            for (int i = 0; i < strToCompare.length(); i++){
                char c = strToCompare.charAt(i);

                if (Character.isUpperCase(c)){
                    counter[0]++;
                }
                else if (Character.isLowerCase(c)){
                    counter[1]++;
                }
                else if (Character.isWhitespace(c)){
                    counter[2]++; //OBS!!! IS NOT COUNTING WHITESPC AT THE END OF STRINGS
                }
                else {
                    counter[3]++;
                }
            }
        }//end while
        in.close();
        return counter;
    }

    public static void PrintCounter(int[] counter){
        System.out.println("Number of upper case letters: " + counter[0]);
        System.out.println("Number of lower case letters: " + counter[1]);
        System.out.println("Number of \"whitespaces\": " + counter[2]);
        System.out.println("Number of others: " + counter[3]);
    }
}