package ht222fd_assign3.Ex3;

import java.io.*;
import java.util.Scanner;

/*
* Write a program IdentyfyWordsMain that reads a text file(like HistoryOfProgramming) and divide the text into a
* sequence of words (word = sequence of letters). All non-letters (except whitespace) should be removed. Save the
 * result in a new file (words.txt).
* */
public class IdenfifyWordsMain {

    public static void main(String[] args) {
        try{
            Scanner in = new Scanner(new File("C:\\Users\\hteva\\IdeaProjects\\1DV507\\src\\ht222fd_assign3\\Ex3\\History.txt"));
            in.useDelimiter("[^a-zA-Z\\s]+"); //book, p.324

            FileWriter out = new FileWriter("C:\\Users\\hteva\\IdeaProjects\\1DV507\\src\\ht222fd_assign3\\Ex3\\HistoryOut.txt");
            BufferedWriter bw = new BufferedWriter(out);

            while(in.hasNext()){
                String x = (in.next());
                bw.write(x);
            }
            bw.close();
            in.close();
            System.out.println("Filtering done.");
        }
        catch (FileNotFoundException e) {
            System.out.println("Scanner failed.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Filewriter failed.");
            e.printStackTrace();
        }


    }
}
