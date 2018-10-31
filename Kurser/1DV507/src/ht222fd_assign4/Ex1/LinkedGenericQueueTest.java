package ht222fd_assign4.Ex1;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by hteva on 20/03/2017.
 */
public class LinkedGenericQueueTest {
    //SINGLE
    private int[] testA = new int[]{1};
    private String[] testStrA = new String[]{"paper"};
    //SMALL
    private int[] testB = new int[]{10, 36, -32, -5, 9};
    private String[] testStrB = new String[]{"Lorem", "ipsum",  "dolor",  "sit",  "amet"};

    //BIG
    private int[] testC = new int[]{-7, 9, 6, 18, 3, -2, 16, 10, -12, 8, 26, 13, -10, 35, 32, -14, -20, 35, 24, 20};
    private String[] testStrC = new String[]{"China","Eritrea","Barbados","Singapore","Kenya", "Ecuador", "Bhutan","Albania",
            "Vietnam","Haiti" };

    LinkedGenericQueue<Integer> inteQueue = new LinkedGenericQueue<>();
    LinkedGenericQueue<String> strQueue = new LinkedGenericQueue<>();


    @Test
    public void testInt(){
        System.out.println("TEST LINKED GENERIC QUEUE");

        System.out.println("\n----- SINGLE ARRAY-----");

        inteQueue.enqueue(1);
        System.out.printf("Size heap: %d - Size test: %d \n", inteQueue.size(), testA.length);
        System.out.printf("First: %d. Last: %d. Dequeue: %d.",
                inteQueue.first(), inteQueue.last(), inteQueue.dequeue());
        System.out.println("Is Empty: " + inteQueue.isEmpty());

        System.out.println("Test 2: Single array string");
        strQueue.enqueue("paper");
        System.out.println("Size heap: " + strQueue.size() + " - Size Test: " + testStrA.length);
        System.out.println("First: " + strQueue.first() + ". Last: " + strQueue.last()+ ". Dequeue: " + strQueue.dequeue());
        System.out.println("Is Empty: " + strQueue.isEmpty());

        System.out.println("\n-----SMALL ARRAY-----");
        System.out.println("Test Array: " + Arrays.toString(testB));
        for (int n : testB ) {
            inteQueue.enqueue(n);
        }
        System.out.println("Test is Empty: " + inteQueue.isEmpty());
        System.out.print("Dequeue: ");
        for (int i = 0; i < testB.length ; i++) {
            System.out.print(inteQueue.dequeue()+ " ");
        }
        System.out.println("\nTest is Empty: " + inteQueue.isEmpty());

        System.out.println("\nSmall array strings");
        System.out.println("Test Array: " + Arrays.toString(testStrB));
        for (String n : testStrB) {
            strQueue.enqueue(n);
        }
        System.out.println("Test is Empty: " + strQueue.isEmpty());
        System.out.print("Dequeue: ");
        for (int i = 0; i < testStrB.length ; i++) {
            System.out.print(strQueue.dequeue()+ " ");
        }
        System.out.println("\nTest is Empty: " + strQueue.isEmpty());



        System.out.println("\n-----\"BIG\" ARRAY-----");
        System.out.println("Test Array: " + Arrays.toString(testC));
        for (int n : testC ) {
            inteQueue.enqueue(n);
        }
        System.out.println("Test is Empty: " + inteQueue.isEmpty());
        System.out.print("Dequeue: ");
        for (int i = 0; i < testC.length ; i++) {
            System.out.print(inteQueue.dequeue()+ " ");
        }
        System.out.println("\nTest is Empty: " + inteQueue.isEmpty());

        System.out.println("\nSmall array strings");
        System.out.println("Test Array: " + Arrays.toString(testStrC));
        for (String n : testStrC) {
            strQueue.enqueue(n);
        }
        System.out.println("Test is Empty: " + strQueue.isEmpty());
        System.out.print("Dequeue: ");
        for (int i = 0; i < testStrC.length ; i++) {
            System.out.print(strQueue.dequeue()+ " ");
        }
        System.out.println("\nTest is Empty: " + strQueue.isEmpty());









    }


}