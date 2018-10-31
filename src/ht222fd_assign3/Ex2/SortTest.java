package ht222fd_assign3.Ex2;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

import static org.junit.Assert.*;

/**
 * Created by hteva on 06/03/2017.
 */
public class SortTest {

    SortingAlgorithms sortingTest = new SortingAlgorithms();
    TestHelper longest = new TestHelper();

    int[] singelton = new int[]{1};
    int[] few = new int[]{285,9875,65,47,32,12};
    int[] fewOrdered = new int[]{12,32,47,65,285,9875};
    int[] longArray = longest.hundredIntUL();
    int[] longArrayOrdered = longest.hundredIntOL();


    Comparator<String> myComp =  (s1, s2) -> s2.length() - s1.length();
    String[] singelText = new String[]{"Ann"};
    String[] fewText = new String[]{"Torbjörn", "Hana", "Reinhardt", "Fariha", "Ana", "Lucio"};
    String[] fewTextOrdered = new String[]{"Ana", "Hana", "Lucio", "Fariha", "Torbjörn", "Reinhardt"};
    /*My idea was  to do the same as long array with strings.. but I had no time to do it
    * I'm sorry :( I was busy failing Software Technology
    * */

    /*INTEGERS*/
    @Test
    public void insertionSort() throws Exception {
        /*SINGELTON*/
        Assert.assertArrayEquals(singelton,sortingTest.insertionSort(singelton));
        /*FEW*/
        assertArrayEquals(fewOrdered, sortingTest.insertionSort(few));
        /*LONG ARRAY*/
        Assert.assertArrayEquals(longArrayOrdered,sortingTest.insertionSort(longArray));

    }

    @Test
    public void mergeSort() throws Exception {
        /*SINGELTON*/
        assertArrayEquals(singelton, sortingTest.mergeSort(singelton));
        /*FEW*/
        assertArrayEquals(fewOrdered, sortingTest.mergeSort(few));
        /*LONG ARRAY*/
        assertArrayEquals(longArrayOrdered, sortingTest.mergeSort(longArray));
    }

    /*STRINGS*/
    @Test
    public void insertionSort1() throws Exception {

        assertTrue(Arrays.asList(sortingTest.insertionSort(singelText,myComp)).contains(singelText));

        assertTrue(Arrays.asList(sortingTest.insertionSort(fewText,myComp)).contains(fewTextOrdered));
    }

    @Test
    public void mergeSort1() throws Exception {

        String[] s1 = sortingTest.mergeSort(singelText,myComp);
        String[] s2 = sortingTest.mergeSort(fewText,myComp);

        String s1Str = Arrays.toString(s1);
        String s2Str = Arrays.toString(s2);

        String sorted1 = Arrays.toString(singelText);
        String sorted2 = Arrays.toString(fewTextOrdered);

        System.out.println(sorted1);
        assertTrue(Objects.equals(s1Str,sorted1));

        System.out.println(sorted2);
        assertTrue(Objects.equals(s2Str,sorted2));
    }

}