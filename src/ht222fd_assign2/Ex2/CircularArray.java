package ht222fd_assign2.Ex2;

import ht222fd_assign2.Ex1.Queue;

import java.util.Arrays;
import java.util.Iterator;

/**
 *
 */
public class CircularArray <Object> implements Queue{
    java.lang.Object[] arr = new java.lang.Object[8];
    int head = -1;
    int tail = -1;


    @Override
    public int size() {
        return arr.length;
    }

    @Override
    public boolean isEmpty() {
        if(head == -1 && tail == -1){
            return true;
        }
        return false;
    }



    @Override
    public void enqueue(java.lang.Object element) {
        if((tail+1)%size() == head){
            System.out.println("Array Full. Tail = " + tail);
            resize();

        }
        else if(isEmpty()){
            head = tail = 0;
        }
        else{
            tail = (tail+1)%size();
        }
        arr[tail] = element; //resize handle the tail+1 stuff.
    }

    @Override
    public Object dequeue() throws NullPointerException {
        if (isEmpty()){
            //System.out.println("Array Empty.");
            return null;
        }
        else if(tail == head){
            java.lang.Object temp = arr[tail];
            tail = head = -1;
            return (Object) temp;
        }
        else{
            java.lang.Object temp = arr[head];
            head = (head+1)%size();
            return (Object) temp;
        }
    }

    @Override
    public Object first() {
        return (Object) arr[head];
    }

    @Override
    public Object last() {
        return (Object) arr[tail];
    }

    @Override
    public Iterator<java.lang.Object> iterator() {

        return  new CircularArrayIte();
    }

    private class CircularArrayIte implements Iterator<java.lang.Object>{
        int counter = head;
        private java.lang.Object current = arr[counter];

        @Override
        public boolean hasNext() {
            if (current != null)
                return true;
            else
                return false;
        }

        @Override
        public java.lang.Object next() {
            java.lang.Object element = current;
            current = arr[counter];
            counter = counter + 1 % size();
            return element;
        }

        @Override
        public void remove() throws RuntimeException {
            new RuntimeException("Remove not implemented");
        }
    }

    private void resize(){

        int nwSize = size()*2;
        System.out.println("new Size: " + nwSize);
        java.lang.Object[] arrResize = new java.lang.Object[nwSize];

        int nwTail = -1;
        int oldCounter = head-1;

        while (oldCounter<tail){
            nwTail++;
            oldCounter = oldCounter+1%size();

            arrResize[nwTail] = arr[oldCounter];
            System.out.println(arrResize[nwTail]);
        }
        head = 0;
        tail = nwTail + 1 % arrResize.length;//Ready to add a new item.
        System.out.println("tail new " + tail);
        arr = arrResize;
    }

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
