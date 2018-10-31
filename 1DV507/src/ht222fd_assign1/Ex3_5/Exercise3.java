package ht222fd_assign1.Ex3_5;

public class Exercise3 {
    public static void main(String[] args) {
        /*Exercise 3
        Write a program SumMain, that includes a recursive method computing the sum of the integers 1, 2, 3, ..., N.
        The computation should be based on the following principle: the sum of the integers from 1 to N is equal
        to the sum of the integers from 1 to N/2 ***FIRS PART***
        added with the sum of the integers from N/2+1 to N ***SECOND PART***.
        Is this a good solution strategy? Motivate your answer!

        Algorithm (pseudo code)

        sumMain(n)
            sumMain (n/2) + sumMain(n) //But how we tell the algorithm that i != 0????

        ANSWER:
        No, is not correct.
        We need to tell to our algorithm that the second part (from N/2+1 to N)
        does NOT begin with 1 (because only works while you start with 1).
        But if we fix that, then we don't need the first part at all!
        To check that every part of the algorithm worked, I did 3 methods. sumMain contains sumA and sumB.
        sumA will work only if only the summation begins with 1. But following the algorithm, the second part
        needs a different beginning each time that is called.
         We can fix that just giving to the algorithm the beginning point of the second part, but then, if
         we do that, why do we need the first part then?? We can use the second part fixed to make a simple
         summation and the beginning of the summation can be anything we want.
        * */

        System.out.println("CHECK, summation of 10 : " + (1+2+3+4+5+6+7+8+9+10));//55
        System.out.println("variable sup = 10");
        System.out.println(sumMain(10));

        System.out.println("USING ONLY THE SECOND PART OF THE ALGORITHM WITH TWO VARIABLES 10-1");
        System.out.println(sumB(10,1));
    }//main

    public static int sumMain(int sup){
        return sumA(sup/2) + sumB(sup, sup/2 + 1);
    }//sumMain

    public static int sumA(int sup){
        System.out.println("sumA variable sup = " + sup);
        if(sup == 1){
            return 1;
        }
        int output = sup + sumA(sup-1);
        System.out.println("Output A: " + output);
        return output;
    }//sumA

    public static int sumB(int sup, int inf){
        System.out.println("sumB variable sup = " + sup + " -- variable inf: " + inf);
        if (sup==inf){
            return sup;
        }
        int outputB = sumB(sup, inf+1) + inf;
        System.out.println("Output B: " + outputB);
        return outputB;
    }
}
