package ht222fd_assign1.Ex3_5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/*Exercise 4:
 Both the name of the file and the size, given as the number of rows, should be printed.
 All exceptions should be handled in the program.
* */

public class printJavaMain {
    public static void main(String[] args) throws IOException{
        File directory = new File("C:\\Users\\hteva\\OneDrive\\Documents\\Neon2\\ht222fd_assign");

        if (directory.exists())
            System.out.println("Start: "+directory);
        else
            System.out.println("Can't find directory: "+directory);

        printAllJavaFiles(directory);

        System.out.println("Exit.");

    }//main

    public static void printAllJavaFiles(File input) throws IOException {
        /*Special Thanks to the "Wrap in try/catch" option.*/

        try {
            File[] files = input.listFiles();
            for (File file : files) {
                System.out.println("Opening a new File.");
                if (file.isDirectory()) {
                    System.out.println("New directory found: " +  file.getName());
                    printAllJavaFiles(file);

                } else {
                    System.out.println(printFile(file));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    /*Method printFile:
    Yes, I mistook size with "that" size.. but it looks good anyways, so I'm keeping it.
    * */
    public static String printFile (File input){
        int lines = countLines(input);
        String output = "  >>";
        output += " Name: " + input.getName() + " -- Not that size: " + input.length() + " -- Lines: " + lines;
        return output;
    }

    public static int countLines(File input){
        int counterLines = 0;

        try {
            Scanner readFile = new Scanner(input);

            while (readFile.hasNextLine()){
                counterLines++;
                readFile.nextLine();
            }
            readFile.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error counting lines");
            e.printStackTrace();
        }
        return counterLines;
    }//end countlines

}
