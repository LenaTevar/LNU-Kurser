package ht22fd_assign4.stack;


import java.util.ArrayList;
import java.util.Iterator;

public class StackMain {
	/*ASSIGNMENT 4
	 * I made 4 documents:
	 * 		- Stack (no explanation needed)
	 * 		- Example: A simple class with just a variable called id, getters and setters.
	 * 		- ClassTest: The class that overrides Stack
	 * 		- Main (no explanation needed neither)
	 * */

    public static void main(String[] args) {

        Example user1 = new Example (1);
        Example user2 = new Example (2);
        Example user3 = new Example (3);
        ArrayList <Example> userList = new ArrayList <Example>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);


		/*Checking if everything is fine by now */
        System.out.println("Checking if userList works: ");
        for (Example user : userList){
            System.out.println(user.getId());
        }


        ClassTest usersStack = new ClassTest();
        usersStack.setListTest(userList);

		/*Peeking after each step to check the Stack.
		 * */
        System.out.println("Peeking user: " + usersStack.peek().getId());

        System.out.println("Pushing a new Example user4.");
        Example user4 = new Example (4);
        usersStack.push(user4);
        System.out.println("Peeking user: " + usersStack.peek().getId());

        System.out.println("Poping user: " + usersStack.pop().getId());
        System.out.println("Poping... could it sound worse?");
        System.out.println("Peeking user: " + usersStack.peek().getId());

        System.out.println("Size: " + usersStack.size());


        Iterator <Example> it = usersStack.iterator();
        while (it.hasNext()){
            Example userIT = it.next();
            System.out.println(userIT.getId());
        }

        System.out.println("Peeking user: " + usersStack.peek().getId());

        if (usersStack.isEmpty())
            System.out.println("It's empty");
        else if(!usersStack.isEmpty())
            System.out.println("It's NOT empty");

    }

}