package ht222fd_assign4.time.Ex3_NOT_FINISHED;

import java.util.Comparator;

public class InsertionSort {

    public static int[] insertionSort(int[] in){
        int [] newArr = in;
        for (int i = 1; i < newArr.length ; i++) {
            int temp = newArr[i];
            int j = i;
            while (j>0 && newArr[j-1]>temp){
                newArr[j] = newArr[j-1];
                j--;
            }
            newArr[j] = temp;
        }
        return newArr;
    }

    public static String[] insertionSort(String[] in, Comparator<String> c){
        String [] input = in;

        for (int i = 1; i < input.length ; i++) {
            String temp = input[i];
            int j = i;
            while ((j > 0) && c.compare(temp, input[j-1] ) > 0 ){
                input[j] = input[j-1];
                j--;
            }
            input[j] = temp;
        }
        return input;
    }
}
