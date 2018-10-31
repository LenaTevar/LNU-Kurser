package ht222fd_assign4.Ex1;

import java.util.Iterator;

    /**
     * <h1>Exercise 1</h1>
     * <h2>Tasks:</h2>
     * <ul>
     *     <li>Create a linked implementation LinkedQueue.java of the interface Queue. Use the head-and-tail approach.</li>
     *     <li>Write also a program QueueMain.java showing how all methods work.</li>
     *     <li>Create Javadoc comments in the code and generate good-looking and extensive HTML documentation for the interface and the class. All public class members shall be documented.</li>
     * </ul>
     */
    public interface Queue <E> {
        public int size();                     // current queue size
        public boolean isEmpty();              // true if queue is empty
        public void enqueue(E e);   // add element at end of queue
        public E dequeue();               // return and remove first element.
        public E first();                 // return (without removing) first element
        public E last();                  // return (without removing) last element
        public String toString();              // return a string representation of the queue content
        public Iterator<E> iterator();    // element iterator
    }


