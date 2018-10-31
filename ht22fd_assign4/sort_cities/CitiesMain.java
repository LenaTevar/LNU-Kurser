package ht22fd_assign4.sort_cities;

import ht22fd_assign4.PathFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class CitiesMain {
    public static void main(String[] args) throws IOException {

        /*Method PathFile:
        Again, this is a lazy method to don't write all the path to my text.
        * */
        PathFile myFolder = new PathFile();
        File inputFile = new File(myFolder.getFullPath("Post.txt"));


        /*ERROR: I couldn't read letters öäå from the text!
        * */
        Scanner sc = new Scanner(inputFile, "ISO-8859-1");
        ArrayList <City> cityArr = new ArrayList<>();
        int citiesCounter = 0;

        System.out.println("Reading: " + inputFile);

        while(sc.hasNext()){
            String line = sc.nextLine(); //take all the line
            String[] dividingLine = line.split(";");

            City aCity = new City (Integer.valueOf(dividingLine[0]), dividingLine[1]); //Dear Helena from the future. Remember parsing to int.
            cityArr.add(aCity);
            //System.out.println("Reading: " + aCity);
            citiesCounter++;
        }

       Collections.sort(cityArr);

        for (Object o : cityArr){
            System.out.println(o);
        }

        System.out.println("Number of cities: " + citiesCounter);

    sc.close();
    }
}
