package ht222fd_assign2.Ex2;

import java.util.Iterator;

/**<h1>Exercise 2 VG</h1>
 * Created by ht222fd on 01/02/2017.
 */
public class CircularArrayMain {

    public static void main (String[] args){
        CircularArray <String> finalFantasy = new CircularArray<String>();
        System.out.println("Empty: " + finalFantasy.isEmpty());
        System.out.println("\nAdding a string...");

        String a = "Rikku";
        finalFantasy.enqueue(a);
        System.out.println("Empty: " + finalFantasy.isEmpty());
        System.out.println("Head: " + finalFantasy.first());
        System.out.println("Tail: " + finalFantasy.last());
        //System.out.println("ToString" + zelda.toString());

        System.out.println("\nAdding another string...");
        String b = "Sefirot";
        finalFantasy.enqueue(b);
        System.out.println("Empty: " + finalFantasy.isEmpty());
        System.out.println("Head: " + finalFantasy.first());
        System.out.println("Tail: " + finalFantasy.last());

        System.out.println("\nAdding few more...");
        String c = "Cloud";
        finalFantasy.enqueue(c);
        String d = "Lighting";
        finalFantasy.enqueue(d);
        String e = "Squall";
        finalFantasy.enqueue(e);
        String f = "Tifa";
        finalFantasy.enqueue(f);
        String g = "Tidus";
        finalFantasy.enqueue(g);
        String h = "Yuna";
        finalFantasy.enqueue(h);
        System.out.println("Head: " + finalFantasy.first());
        System.out.println("Tail: " + finalFantasy.last());

        String i = "Rina"; //RESIZE
        finalFantasy.enqueue(i);
        String j = "Terra";
        finalFantasy.enqueue(j);


        System.out.println("Empty: " + finalFantasy.isEmpty());
        System.out.println("Head: " + finalFantasy.first());
        System.out.println("Tail: " + finalFantasy.last());
        System.out.println("Size: " + finalFantasy.size());

        System.out.println("\nChecking Iterator:");
        Iterator<Object> myIte = finalFantasy.iterator();
        while (myIte.hasNext()){
            System.out.println(myIte.next().toString());
        }
        System.out.println("\nChecking toString:" + finalFantasy.toString());

        System.out.println("\nDequeue one: " + finalFantasy.dequeue());
        System.out.println("Dequeue one: " + finalFantasy.dequeue());
        System.out.println("Dequeue one: " + finalFantasy.dequeue());
        System.out.println("Dequeue one: " + finalFantasy.dequeue());

        System.out.print("Dequeue all:");
        for (int k = 0; k <7 ; k++) {
            finalFantasy.dequeue();
            System.out.print("*");
        }

        System.out.println("\nEmpty: " + finalFantasy.isEmpty());



    }
}
