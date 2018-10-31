package ht222fd_assign2.Ex1;

import java.util.Iterator;

/**
 * LinkedQueue implements the interface Queue.
 * @see package ht222fd_assign2.Ex1.Node.java
 * @author Helena Tevar Hernandez
 */

public class LinkedQueue<Object> implements Queue {
    private Node head = null;
    private Node tail = null;
    private int size = 0;


    /**
     * current queue size
     *@return  <code>Integer</code> current size of the queue.
     *
     */
    @Override
    public int size() {
        return size;
    }

    /**
     *true if queue is empty
     * @return <code>true</code> if the queue is empty; <code>false</code> otherwise.
     */
    @Override
    public boolean isEmpty() {
        if (head == null){return true;}
        else {return false;}
    }

    /**
     * Adds objects to the queue.
     * @param element Object to be added to the queue.
     */
    @Override
    public void enqueue(java.lang.Object element) {

        Node nw = new Node (element);

        if (head == null){
            head = nw;
            tail = head;
        }
        else{
            tail.next = nw;
            tail = tail.next;
        }
        size++;
    }

    /**
     *return and remove first element.
     * @return the first object from the queue and delete it after that.
     *
     * @throws IndexOutOfBoundsException when you try to dequeue more objects than you have spared in your queue.
     */
    @Override
    public java.lang.Object dequeue() throws IndexOutOfBoundsException {
        Node out = head;
        head = head.next;
        size--;
        return out.value;
    }

    /**
     *return (without removing) first element
     * @return the value of the first element without removing it.
     * @throws IndexOutOfBoundsException when head is null.
     */
    @Override
    public java.lang.Object first()throws NullPointerException {
        return head.value;
    }

    /**
     *return (without removing) last element
     * @return the value of the last element without removing it.
     * @throws IndexOutOfBoundsException when tail is null.
     */
    @Override
    public java.lang.Object last() throws NullPointerException {

            return tail.value;
    }


    /**
     * Returns an iterator much better than the one I planned the first time.
     * @return the result of the method LinkedQueueIte().
     */
    @Override
    public Iterator<java.lang.Object> iterator() {

        return new LinkedQueueIte();
    }

    /**
     * Implements Iterator for our queue.
     */
    private class LinkedQueueIte implements Iterator<java.lang.Object> {
        private Node current = head;

        /**
         * @return <code>true</code> if the iterator has a next item or <code>false</code> if <br>
         *     there is no more items.
         */
        @Override
        public boolean hasNext() {

            if (current != null)
                return true;
            else
                return false;
        }

        /**
         * @return The next element of the queue.
         */
        @Override
        public java.lang.Object next() {

            java.lang.Object element = current.value;
            current = current.next;
            return  element;

        }

        /**
         * Method not implemented.
         * @throws RuntimeException
         */
        @Override
        public void remove() throws RuntimeException {
            new RuntimeException("Remove not implemented");
        }


    }

    /**
     *
     * @return a string representation of the queue content
     *
     */
    @Override
    public java.lang.String toString() {
        StringBuilder output = new StringBuilder(" Queue -> ");

        Iterator<java.lang.Object> iteStr =  this.iterator();
        while (iteStr.hasNext()){
            output.append(iteStr.next().toString() + " | ");
        }
        return output.toString();
    }
}
