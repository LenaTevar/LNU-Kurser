package ht22fd_assign4.DrunkenWalker;


import java.util.Scanner;
/*TODO:
 * - try catch user input
 * */

public class RandomWalkMain {
    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);

        boolean exit1=false;
        while (!exit1){
            System.out.println("\n==================\n"
                    +" Random Walk Game "
                    +"\n==================");
            System.out.println("1: Single Player.");
            System.out.println("2: The horde.");
            System.out.println("3: Exit.");
            System.out.print(">>");



            //method commented down
            isnumber(in);
            int user = in.nextInt();

            switch(user){
                case 1:
                    boolean onSinglePlayer = true;
                    System.out.println("\n=======================\n"
                            +" Playing single walker "
                            +"\n=======================");



                    System.out.print("Add map size: ");
                    isnumber(in);
                    int size = in.nextInt();

                    System.out.print("Add number of steps: ");
                    isnumber(in);
                    int steps = in.nextInt();

                    System.out.println("- Map size: "+size + "\n- Number of steps: " + steps);
                    RandomWalk myWalk = new RandomWalk(steps,size);

                    while(onSinglePlayer){
                        System.out.println("\n=======================\n"
                                +"        MENU "
                                +"\n=======================");
                        System.out.println("1: Take one Step.");
                        System.out.println("2: Walk all the steps.");
                        System.out.println("3: To the main menu.");
                        System.out.print(">>");

                        isnumber(in);
                        int answerSinglePlayer = in.nextInt();

                        switch(answerSinglePlayer){
                            case 1:
                                System.out.println("Taking steps:");
                                if (myWalk.inBounds() && myWalk.moreSteps()) {
                                    myWalk.takeStep();
                                    System.out.println(myWalk.toString());
                                    break;
                                }
                                else if (!myWalk.moreSteps()){
                                    System.out.println("You spent all your steps.");
                                }
                                else
                                    System.out.println("This person is wet and won't move.");
                                break;

                            case 2:
                                System.out.println("\nWalking all the steps...");
                                myWalk.walk();
                                onSinglePlayer = false;
                                break;
                            case 3:
                                onSinglePlayer = false;
                                break;

                            default:
                                System.out.println("Please repeat again:");
                                System.out.println("1: Take one Step.");
                                System.out.println("2: Walk all the steps.");
                                System.out.println("3: To the main menu.");
                                System.out.print(">>");
                                break;

                        }//switch single player
                    }//while single player
                    break;
                case 2:
                    System.out.println("\n===================\n"
                            +" Playing the Horde "
                            +"\n===================");


                    System.out.println("Add map size: ");
                    System.out.print(">>");
                    isnumber(in);
                    int sizeM = in.nextInt();

                    System.out.println("Add number of steps: ");
                    System.out.print(">>");
                    isnumber(in);
                    int stepsM = in.nextInt();

                    System.out.println("Add number of people: ");
                    System.out.print(">>");
                    isnumber(in);
                    int peopleM = in.nextInt();

                    System.out.println("- Map size: "+ sizeM + "\n- Number of steps: " + stepsM
                            + "\n- Number of people playing: " + peopleM);

                    DrunkenWalk myMultiWalk = new DrunkenWalk(stepsM,sizeM,peopleM);
                    myMultiWalk.horde();
                    break;

                case 3:
                    exit1=true;
                    break;

                default:
                    System.out.println("Ups! Something went wrong.");
                    break;

            }
        }
        System.out.println("Thanks for playing with us.");

        in.close();
    }//end main

    /*HELPER METHOD: isnumber(in);
     * I used this type of while to check
     * if the user has done right or wrong
     * when choosing something in the menu.
     * */
    public static void isnumber(Scanner in){
        while(!in.hasNextInt()){
            System.out.println("Sorry, I don't understand. Please repeat again.");
            in.next();
			/*My husband was testing the program and wrote "Erik 2" and the game begun.
			 * So... fixed with this with in.nextLine(); But if I do that, if I write
			 * a letter, it repeats itself twice.
			 * */
        }
    }

}