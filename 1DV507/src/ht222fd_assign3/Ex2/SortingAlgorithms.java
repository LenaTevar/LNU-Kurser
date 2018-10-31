package ht222fd_assign3.Ex2;

import java.util.*;

/**
 * All methods return a new sorted array where all elements are sorted in ascending order (lowest first) <br>
 * in the first two integer array methods, as defined by the Comparator in the final two String array methods.<br>
 * The input arrays in should not be changed. The methods should of course use the Insertion Sort and Merge Sort algorithms.<br>
 *     <ul>
 *         <li>Our suggestion is that you start to implement (and test) the integer versions.</li>
 *         <li>Both algorithms are described in the lecture slides and in the textbook by Horstmann.<br> You can also<br>
 *         find plenty of information on the Internet.</li>
 *         <li>The textbook (and Internet) also describes how to implement these algorithms (integer version) in Java.<br>
 *         Feel free to take any such implementation as your starting point. However, in this case you must clearly<br>
 *         state in your assignments submission which implementation you have used. Provide a web site if you have<br>
 *         taken it from the Internet.</li>
 *     </ul>
 *
 * Created by hteva
 */
public class SortingAlgorithms {
    public static void main(String[] args) {
        int [] first = new int []{2,4,1,7,4};
        int [] second = insertionSort(first);
        System.out.println("ORIGINAL: " + Arrays.toString(first));
        System.out.println(Arrays.toString(second));
        int[] few = new int[]{285,9875,65,47,32,12};
        System.out.println("few"+Arrays.toString(few));
        int[] fewOrdered = mergeSort(few);
        System.out.println("merge few" + Arrays.toString(fewOrdered));


        String[] primero = new String[]{"pedro", "ana", "patricia", "jose", "bo"};
        Comparator<String> myComp =  (s1, s2) -> s2.length() - s1.length();
        System.out.println("ORIGINAL: " + Arrays.toString(primero));
        String [] segundo = insertionSort(primero, myComp);
        System.out.println(Arrays.toString(segundo));

        System.out.println("MERGE SORTING");

        int[] merge1 = mergeSort(first);
        System.out.println(Arrays.toString(merge1));

        String [] merge2 = mergeSort(primero,myComp);

        System.out.println(Arrays.toString(merge2));
    }

    /**
     * Insertion Sorting of and int array.
     * @param in
     * @return
     */
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

    /**
     * Merge sorting of and int array. I used our class book to do this exercise.
     * VG Exercise
     * @param in
     * @return
     */
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


    /**
     * Insertion sort with Comparator.<br>
     *     Dear Lena from the future. I know you will need this: <br>
     *     http://www.codexpedia.com/java/java-comparator-with-insertion-sort/ <br>
     *     OBS! If you change compare(temp, input) > 0
     * @param in
     * @param c
     * @return
     */
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

    /**
     * Merge sort with Comparator.
     * VG Exercise
     * @param in
     * @param c
     * @return
     */
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
