package ht222fd_assign2.Ex1;

import java.util.Iterator;

/**
 * Main class to test the queue.
 * I like NOT hardcoding but I have to
 * like a tone of stuff to do :(
 */
public class QueueMain {
    public static void main(String[] args) {
        LinkedQueue <String> zelda = new LinkedQueue<>();
        System.out.println("Empty: " + zelda.isEmpty());
        System.out.println("\nAdding a string...");

        String a = "Ganodorf";
        zelda.enqueue(a);
        System.out.println("Empty: " + zelda.isEmpty());
        System.out.println("Head: " + zelda.first());
        System.out.println("Tail: " + zelda.last());
        //System.out.println("ToString" + zelda.toString());

        System.out.println("\nAdding another string...");
        String b = "Navi";
        zelda.enqueue(b);
        System.out.println("Empty: " + zelda.isEmpty());
        System.out.println("Head: " + zelda.first());
        System.out.println("Tail: " + zelda.last());

        System.out.println("\nAdding few more...");
        String c = "Midna";
        String d = "Epona";
        zelda.enqueue(c);
        zelda.enqueue(d);
        System.out.println("Empty: " + zelda.isEmpty());
        System.out.println("Head: " + zelda.first());
        System.out.println("Tail: " + zelda.last());
        System.out.println("Size: " + zelda.size());

        System.out.println("\nChecking Iterator");
        Iterator<Object> myIte = zelda.iterator();
        while (myIte.hasNext()){
            System.out.println(myIte.next().toString());
        }
        System.out.println("\nChecking toString:" + zelda.toString());

        System.out.println("\nDequeue one: " + zelda.dequeue());
        System.out.println("Dequeue one: " + zelda.dequeue());
        System.out.println("Dequeue one: " + zelda.dequeue());
        System.out.println("Dequeue one: " + zelda.dequeue());

        System.out.println("Empty: " + zelda.isEmpty());



    }
}
