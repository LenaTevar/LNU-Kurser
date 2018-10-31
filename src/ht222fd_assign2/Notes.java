package ht222fd_assign2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.Arrays;
import java.util.Iterator;

public class Notes {
    public static void main(String[] args) {
        String[] myStringArray = new String[3];

        ArrayList<String> places = new ArrayList<String>();

        places.add("Hola");
        for (String x : places ) {


        }
        System.out.println();

        Iterator<String> ite = Arrays.stream(myStringArray).iterator();
    }


    public Object[] GrowingArray(Object[] old){

        Object[] tempArray = Arrays.copyOf(old, old.length*2);
        return tempArray;



    }

    public Integer money(int x){
        return x+1;
    }
}


/**
 * 30/01/2001
 * Data structures:
 *  Stack
 *      push
 *      peek
 *      pop
 *  Queue
 *      dequeue
 *      unqueue
 *  Deque
 *      addFirst
 *      removeFirst
 *      addLast
 *      removeLast
 *  OBject type - everything can be stored.
 *  A generic type <T> type decided when data structure created.
 *
 *
 *  Iterable
 *  Iterators are easy to iterate over all elements and give access
 *  to data without chance to modify content.
 *
 *  Node
 *  Es un tipo de variable que parece implementar automaticamente
 *  algo asi como un stack.
 *
 *  Node head = null
 *  add(7)
 *  if node == null, head = 7, next = null
 *
 *  add(8)
 *  head = 7, node.next == null, next = 8, node.next = null
 *
 *  indexOf(){ while the node is not null, counter++}
 *
 *  remove(5){
 *  1 - 3- 5- 7
 *      node before = head
 *
 *      fori
 *          node before is 3
 *          delete the node before
 *          IT ONLY GOES FURHTER, NOT BACKWARDS
 *          before.next = delete.next
 *          the next node after 3 is now as after deleting next???
 *          size--
 *
 *  }
 *
 *  add(){
 *      locate the node before the one your index
 *      add it next to that. before.next = nw.next
 *
 *  }
 *
 *  Heads and tails
 *  we check the head and the tail, so if we want to add a new node at the end
 *  we just have to make tail.next = new node (n)
 *                      tail = tail.next;
 * Head have to point always to the first one, tails always to the last one
 *
 *
 */

/** OneTwoThree arrays
 *      empty list
 *      singleton
 *          list Array = new {7;}
 *      even size
 *      odd size
 *      very large array
 *
 * Test extreme cases, few standard cases, large case
 * White-box:
 *      every method is tested (Minimun)
 *      every statement is tested (while, if, else...)
 *      every possible execution path
 *
 */