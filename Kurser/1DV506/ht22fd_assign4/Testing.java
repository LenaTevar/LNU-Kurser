package ht22fd_assign4;


import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Testing {
    public static void main(String[] args) throws IOException {

        File inputFile = new File("C:\\Users\\hteva\\IdeaProjects\\1DV506\\src\\ht22fd_assign4\\Copy.txt");

        Scanner sc = new Scanner(inputFile, "ISO-8859-1");

        if(sc.hasNext()){
            System.out.println("*****");
            String next = sc.nextLine();
            System.out.println(next);
        }
        else if (!sc.hasNext())
        {
            System.out.println("+++++++");
        }
        System.out.println("-----");
        sc.close();
    }
}
