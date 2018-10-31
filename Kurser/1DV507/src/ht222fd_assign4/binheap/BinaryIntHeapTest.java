package ht222fd_assign4.binheap;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by hteva on 20/03/2017.
 */
public class BinaryIntHeapTest {
    /*------SET UP------*/


    BinaryIntHeap heap = new BinaryIntHeap();
    //SINGLE
    private int[] testA = new int[]{1};
    //FIVE
    private int[] testB = new int[]{10, 36, -32, -5, 9};

    //TWENTY
    private int[] testC = new int[]{-7, 9, 6, 18, 3, -2, 16, 10, -12, 8, 26, 13, -10, 35, 32, -14, -20, 35, 24, 20};

    private int heapSize;
    private int testSize;

    @Test
    public void test(){
        System.out.println("*****TEST*****");

        System.out.println("-----SINGLE ARRAY-----");
        heap.insert(1);
        heapSize = heap.size();
        testSize = testA.length;
        System.out.printf("Size heap: %d - Size test: %d \n", heapSize, testSize);
        System.out.println("Pull Highest: " + heap.pullHighest());
        System.out.println("Test is Empty: " + heap.isEmpty());

        System.out.println("\n-----SMALL ARRAY-----");
        System.out.println("Test Array: " + Arrays.toString(testB));
        for (int n : testB ) {
            heap.insert(n);
        }
        System.out.println("Test is Empty: " + heap.isEmpty());
        heapSize = heap.size();
        testSize = testB.length;
        System.out.printf("Size heap: %d - Size test: %d \n", heapSize, testSize);
        System.out.print("Pull Highest: ");
        for (int i = 0; i < heapSize ; i++) {
            System.out.print(+heap.pullHighest() + " ");
        }
        System.out.println("\nTest is Empty: " + heap.isEmpty());


        System.out.println("\n-----BIG ARRAY + DUPLICATES-----"); //"It's not a bug, it's a feature"
        System.out.println("Test Array: " + Arrays.toString(testC));
        for (int n : testC ) {
            heap.insert(n);
        }
        System.out.println("Test is Empty: " + heap.isEmpty());
        heapSize = heap.size();
        testSize = testC.length;
        System.out.printf("Size heap: %d - Size test: %d \n", heapSize, testSize);
        System.out.print("Pull Highest: ");
        for (int i = 0; i < heapSize ; i++) {
            System.out.print(+heap.pullHighest() + " ");
        }
        System.out.println("\nTest is Empty: " + heap.isEmpty());


    }





}