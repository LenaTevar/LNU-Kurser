package ht222fd_assign1.Ex1;

import java.util.Scanner;


public class ListNStackMain {
    public static void main(String[] args) {

        /*MENU MAIN*/

        boolean exitMain = false;
        int userMain;
        Scanner in = new Scanner(System.in);


        printlnMenuMain();


        while(!exitMain){
            /*ArrayIntList:
            I forgot to declare this array outside the while loop
            and it gave me nightmares...
            * */
            ArrayIntList myList = new ArrayIntList();


            /*USER INPUT MAIN*/
            do{
                System.out.println("Enter your selection from the Menu: ");
                userMain = userCheck(in);
            }while(userMain<0);
            /*END USER INPUT MAIN*/

            switch (userMain){
                case 1:
                    System.out.println("List selected");
                    System.out.println("====================================");
                    System.out.println("|          LIST SELECTION          |");
                    System.out.println("====================================");
                    System.out.println("| Options:                         |");
                    System.out.println("|        1. Add number             |");
                    System.out.println("|        2. Add number at index    |");
                    System.out.println("|        3. Remove at index        |");
                    System.out.println("|        4. Get number from index  |");
                    System.out.println("|        5. Get index from number  |");
                    System.out.println("|        6. println List           |");
                    System.out.println("|        7. Exit                   |");
                    System.out.println("====================================");

                    boolean exitList = false;

                    while(!exitList){



                    /*USER INPUT LIST*/
                        int userList;

                        do{
                            System.out.println("Enter your selection: ");
                            userList = userCheck(in);
                        }while(userList<0);
                    /*END USER INPUT LIST*/

                        switch (userList) {
                            case 1://add
                                System.out.println("Selected - Add number:");
                                int userAdd = userCheck(in);
                                myList.add(userAdd);
                                break;
                            case 2://addat
                                System.out.println("Selected - Add number at index. ");
                                System.out.print("Number: ");
                                int userAddTo = userCheck(in);
                                System.out.print("Index: ");
                                int userIndex = userCheck(in);
                                myList.addAt(userAddTo,userIndex);
                                break;
                            case 3://remove
                                System.out.println("Selected - Remove at index");
                                System.out.print("Enter index: ");
                                int userRemove = userCheck(in);
                                myList.remove(userRemove);
                                break;
                            case 4://get
                                System.out.println("Selected - Get number from index: ");
                                System.out.print("Enter index: ");
                                int userGetIndex = userCheck(in);
                                myList.get(userGetIndex);
                                break;
                            case 5://indexof
                                System.out.println("Selected - Get index from number: ");
                                int userGetN = userCheck(in);
                                myList.indexOf(userGetN);
                                break;
                            case 6://tostring
                                System.out.println("Selected - println List: ");
                                System.out.println(myList.toString());
                                break;
                            case 7:
                                exitList = true;
                                System.out.println("Leaving List");
                                printlnMenuMain();
                                break;
                            default:
                                System.out.println("Ups, something went wrong.");
                                break;
                        }
                    }//end whileList
                    break; //break case 1 Main
                case 2:
                    ArrayIntStack myStack = new ArrayIntStack();

                    System.out.println("Stack selected");

                    System.out.println("================================");
                    System.out.println("|       STACK SELECTION        |");
                    System.out.println("================================");
                    System.out.println("| Options:                     |");
                    System.out.println("|        1. Push               |");
                    System.out.println("|        2. Pop                |");
                    System.out.println("|        3. Peek               |");
                    System.out.println("|        4. Get size           |");
                    System.out.println("|        5. Check if is Empty  |");
                    System.out.println("|        6. Show String        |");
                    System.out.println("|        7. Exit               |");
                    System.out.println("================================");

                    boolean exitStack = false;
                    while (!exitStack){
                        int userStack;
                     /*USER INPUT LIST*/
                        do{
                            System.out.println("Enter your selection: ");
                            userStack = userCheck(in);
                        }while(userStack<=0);
                    /*END USER INPUT LIST*/

                        switch (userStack) {
                            case 1://push
                                System.out.println("Selected - Push: ");
                                int push = userCheck(in);
                                myStack.push(push);
                                break;
                            case 2://pop
                                System.out.println("Selected - Pop: ");
                                int pop = myStack.pop();
                                System.out.println(pop);
                                break;
                            case 3://peek
                                System.out.println("Selected - Peek: ");
                                int peek = myStack.peek();
                                System.out.println(peek);
                                break;
                            case 4://get size
                                System.out.println("Selected - Get size: ");
                                int size = myStack.size();
                                System.out.println(size);
                                break;
                            case 5://check empty
                                System.out.println("Selected - check empty: ");
                                if (myStack.isEmpty()){
                                    System.out.println("Stack Empty.");
                                }
                                else {
                                    System.out.println("Stack NOT Empty.");
                                }

                                break;
                            case 6://tostring
                                System.out.println("Selected - println: ");
                                System.out.println(myStack.toString());
                                break;
                            case 7://exit
                                exitStack=true;
                                System.out.println("Leaving Stack");
                                printlnMenuMain();
                                break;
                            default:
                                System.out.println("Sorry, something went wrong.");
                                break;
                        }
                    }//end while stack

                    break;//break case 2 Main
                case 3:
                    exitMain= true;
                    break;
                default:
                    System.out.println("Sorry, something went wrong.");
                    break;
            }



        }//end while MAIN







    }//END MAIN

    /*HELPER METHOD: userCheck
     it checks if the user is entering a number or something else.
     I think I use this in aaaaaallllll the assignments ;)
    * */
    public static int userCheck (Scanner input){
        while(!input.hasNextInt()){
            System.out.println("Please enter a number from the Menu: ");
            input.next();
        }
        int user = input.nextInt();

        return user;
    }

    /*LAZY METHOD:
    It is what it looks....
    * */
    public static void printlnMenuMain(){
        System.out.println("============================");
        System.out.println("|      MENU SELECTION      |");
        System.out.println("============================");
        System.out.println("| Options:                 |");
        System.out.println("|        1. New List       |");
        System.out.println("|        2. New Stack      |");
        System.out.println("|        3. Exit           |");
        System.out.println("============================");
    }



}
