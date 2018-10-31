package ht222fd_assign4.time.Ex3_NOT_FINISHED;


import java.util.Arrays;

/**
 * Created by hteva on 08/03/2017.
 */
public class SortIntMain {
    public static void main(String[] args) {
        setUp mySetUp = new setUp();
        InsertionSort insert = new InsertionSort();
        MergeSort merge = new MergeSort();
        int[] a = mySetUp.getSmallArrayInt();
        long start = 0;
        long end = 0;
        long difference = 0;

        System.out.println("Unordered small Array: "+ Arrays.toString(a));
        int[] c = mySetUp.getLongArrayInt();
        System.out.println("Long array length:" + c.length);



        int[] b = insert.insertionSort(a);
        System.out.println("Insertion Sort result: " + Arrays.toString(b));

        /*-----MERGE SORT-----*/
        start = System.currentTimeMillis();
        int[] d = merge.mergeSort(c);
        end = System.currentTimeMillis();
        difference = end - start;
        System.out.println("Merge sort Long Array: "+ d.length);
        System.out.println("Time: " + difference + " time in millis");
    }


}
