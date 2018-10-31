package ht222fd_assign3.Ex4To7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by hteva on 28/03/2017.
 */
public class WordCount2Main {
    public static void main(String[] args) throws FileNotFoundException {


        Scanner input = new Scanner(new File("C:\\Users\\hteva\\IdeaProjects\\1DV507\\src\\ht222fd_assign3\\Ex3\\HistoryOut.txt"));
        Scanner input2 = new Scanner(new File("C:\\Users\\hteva\\IdeaProjects\\1DV507\\src\\ht222fd_assign3\\Ex3\\HistoryOut.txt"));

        HashWordSet myHashWordSet = createHashSet(input);
        TreeWordSet myTreeWordSet =  createTreeWordSet(input2);

        System.out.println("HashWordSet SIZE: " + myHashWordSet.size());
        System.out.println(myHashWordSet.toString());
        System.out.println("TreeWordSet SIZE: " + myTreeWordSet.size());
        System.out.println(myTreeWordSet.toString());

        input.close();
        input2.close();
    }//end main

    /*-----------HELPER METHODS------------------*/
    public static HashWordSet createHashSet (Scanner input){
        HashWordSet temp = new HashWordSet();
        while (input.hasNext()){
            Word inputWord = new Word(input.next());
            temp.add(inputWord);
        }
        return temp;
    }

    public static TreeWordSet createTreeWordSet (Scanner input){
        TreeWordSet temp = new TreeWordSet();
        while (input.hasNext()){
            Word inputWord = new Word(input.next());
            temp.add(inputWord);
        }
        return temp;
    }
}