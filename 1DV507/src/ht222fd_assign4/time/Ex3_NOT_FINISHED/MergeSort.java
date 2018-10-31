package ht222fd_assign4.time.Ex3_NOT_FINISHED;

import java.util.Comparator;


public class MergeSort {
    public  static int[] mergeSort(int[] in){
        int [] copy = in;

        if (copy.length <= 1) {return copy; }


        int half = copy.length/2;
        int [] first = new int [half];
        int [] second = new int [copy.length - first.length];

        for (int i = 0; i < first.length; i++) {
            first[i] = copy[i];
        }

        for (int i = 0; i < second.length ; i++) {
            second [i] = copy[half++];
        }
        /*IT HAS TO SAVE FIRST AND SECOND*/
        first = mergeSort(first);
        second = mergeSort(second);


        //MERGE
        int iFirst = 0;
        int iSecond = 0;
        int j = 0;

        while (iFirst < first.length && iSecond < second.length){
            if (first[iFirst] < second[iSecond]){
                copy[j] = first[iFirst];
                iFirst++;
            }
            else{
                copy[j] = second[iSecond];
                iSecond++;
            }
            j++;

        }

        if (iFirst<first.length){
            for (int i = iFirst; i < first.length ; i++) {
                copy[j] = first[i];
                j++;
            }
        }
        else {
            for (int i = iSecond; i < second.length ; i++) {
                copy[j] = second[i];
                j++;
            }
        }

        //merge(first, second, copy);
        return copy;
    }

    public static String[] mergeSort(String[] in, Comparator<String> c){
        String [] temp = in;

        if (temp.length <= 1) {return temp; }

        String [] first = new String [temp.length/2];
        String [] second = new String [temp.length - first.length];

        for (int i = 0; i < first.length; i++) {
            first[i] = temp[i];
        }

        for (int i = 0; i < second.length ; i++) {
            second [i] = temp[first.length + i];
        }

        mergeSort(first,c);
        mergeSort(second,c);


        //MERGE
        int iFirstStr = 0;
        int iSecondStr = 0;
        int j = 0;

        while (iFirstStr < first.length && iSecondStr < second.length) {
            if (c.compare(first[iFirstStr], second[iSecondStr]) > 0) {
                temp[j] = first[iFirstStr];
                iFirstStr++;
            } else {
                temp[j] = second[iSecondStr];
                iSecondStr++;
            }
            j++;

        }


        if (iFirstStr<first.length){
            for (int i = iFirstStr; i <first.length ; i++) {
                temp[j]= first[i];
                j++;
            }
        }

        else {
            for (int i = iSecondStr; i <second.length ; i++) {
                temp[j]=second[i];
                j++;
            }
        }

        //merge(first, second, copy);
        return temp;
    }
}
