package ht222fd_assign2.Ex1;

/**
 * This class saves an object as a value and a reference to the next node of the queue.
 * @see package ht222fd_assign2.Ex1.LinkedQueue.java
 * The next node may be <code>null</code> if it is the last one or if the queue is empty.
 */
public class Node <E> {

    E value;
    Node next;

    /**
     * Now is a String but I want to be a generic object.
     * @param element is the object saved inside the node.
     */
    public Node(E element){
        value = element;
    }

}
