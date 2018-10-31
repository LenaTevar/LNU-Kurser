package ht222fd_assign3.Ex4To7;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class WordCount1Main {
    public static void main(String[] args) throws FileNotFoundException {
        File test = new File("C:\\Users\\hteva\\IdeaProjects\\1DV507\\src\\ht222fd_assign3\\Ex3\\testOut.txt");

        Scanner input = new Scanner(new File("C:\\Users\\hteva\\IdeaProjects\\1DV507\\src\\ht222fd_assign3\\Ex3\\HistoryOut.txt"));

        HashSet<Word> myHashSet = createHashSet(input);

        Scanner input2 = new Scanner(new File("C:\\Users\\hteva\\IdeaProjects\\1DV507\\src\\ht222fd_assign3\\Ex3\\HistoryOut.txt"));

        TreeSet<Word> myTreeSet = createTreeSet(input2);

        System.out.println("HASH SIZE: " + myHashSet.size());
        System.out.println("TREE SIZE: " + myTreeSet.size());

        input.close();
        input2.close();
    }//end main

    /*-------------HELPER METHODS-----------------*/
    public static HashSet<Word> createHashSet (Scanner input){
        HashSet<Word> temp = new HashSet<>();
        while (input.hasNext()){
            Word inputWord = new Word(input.next());
            temp.add(inputWord);
        }
        return temp;
    }

    public static TreeSet<Word> createTreeSet (Scanner input){
        TreeSet<Word> temp = new TreeSet<>();
        while (input.hasNext()){
            Word inputWord = new Word(input.next());
            temp.add(inputWord);
        }
        return temp;
    }


}
