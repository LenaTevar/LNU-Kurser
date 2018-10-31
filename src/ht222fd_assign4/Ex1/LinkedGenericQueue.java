package ht222fd_assign4.Ex1;

import java.util.Iterator;


public class LinkedGenericQueue <E> implements Queue{

    private Node head = null;
    private Node tail = null;
    private int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (head == null){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public void enqueue(Object o) {
        Node nw = new Node (o);

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

    @Override
    public E dequeue() {
        Node out = head;
        head = head.next;
        size--;
        return (E) out.value;
    }

    @Override
    public E first() {
        return (E) head.value;
    }

    @Override
    public E last() {
        return (E) tail.value;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder(" Queue -> ");

        Iterator<java.lang.Object> iteStr =  this.iterator();
        while (iteStr.hasNext()){
            output.append(iteStr.next().toString() + " | ");
        }
        return output.toString();
    }

    @Override
    public Iterator iterator() {
        return new LinkedQueueIterator();
    }

    private class LinkedQueueIterator implements Iterator<E>{
        private Node current = head;

        @Override
        public boolean hasNext() {
            if (current != null)
                return true;
            else
                return false;
        }

        @Override
        public E next() {
            E element = (E) current.value;
            current = current.next;
            return element;
        }
    }
}
