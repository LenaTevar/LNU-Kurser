package ht222fd_assign1.Ex2;

import java.util.Iterator;
import java.util.Scanner;
/*Assignment 2:
Don't worry, it looks messy but it's because the menus.
I used menus to let you choose what do you want to embark,
how many people, and so on. Because of that I made a LOT of
things to check that you can write whatever you want and
it won't crash. Helper methods are below main.
* */

public class FerryMain  {
    public static void main(String[] args) {

        FerryManager thorVXJ = new FerryManager(); //I don't think Thor can handle 200 persons + cars but... ok xD


        boolean exitMain = false;
        int userMain;
        Scanner in = new Scanner(System.in);
        /*CLASS PRINTMENU
        * I took a step further in my way to writing menus.
        * Why to write 2/3 different menus, when a static class
        * can do it for me?
        * */
        PrintMenu.main();

        //MAIN MENU
        while(!exitMain){
            do{
                System.out.print("Enter your selection from the Menu: ");
                userMain = userCheck(in);
            }while(userMain<0);

            switch (userMain){
                case 1: //EMBARK VEHICLE MENU
                    boolean exitEmbarkVehicles=false;
                    int userEmbarkVehicles;

                    PrintMenu.vehicles();

                    while(!exitEmbarkVehicles){
                        do{
                            System.out.print("Enter your selection from the Menu: ");
                            userEmbarkVehicles = userCheck(in);
                        }while(userEmbarkVehicles<0);


                        switch (userEmbarkVehicles){
                            case 1: //bike
                                Bike embarkingBike = new Bike();
                                String plateBike;

                                do {
                                    System.out.print("Add plate: ");
                                    plateBike = in.next();
                                } while (containsPlate(thorVXJ.iterator(),plateBike));
                                //checking that you don't use 2 times the same vehicle

                                embarkingBike.setPlate(plateBike);

                                System.out.print("Add driver name: ");
                                Passenger vehiclePassenger = new Passenger(in.next());

                                embarkingBike.addPassenger(vehiclePassenger);
                                thorVXJ.embark(embarkingBike);
                                PrintMenu.vehicles();
                                break;
                            case 2: //CAR
                                /*CASE EMBARKING A CAR || VEHICLE IN GENERAL:
                                * I used loops type Do-While to check what the user inputs
                                * every time, so they don't mess up.
                                * 1: Checks if the vehicle has been already embarked using
                                * its plate.
                                * 2: Checks if the user want to add more passengers than
                                * the vehicle can have.
                                * It doesn't happens with bikes because they only have 1 passenger.
                                * */
                                Car embarkingCar = new Car();
                                int passCar;
                                String carPlate;

                                do {
                                    System.out.print("Add plate: ");
                                    carPlate = in.next();
                                }while(containsPlate(thorVXJ.iterator(),carPlate));
                                embarkingCar.setPlate(carPlate);

                                do {
                                    System.out.print("Number of Passengers (MAX 4, including driver): ");
                                    passCar = userCheck(in);
                                } while (passCar < 1 || passCar > embarkingCar.getMaxPassengers());

                                for (int i = 0; i <passCar ; i++) {
                                    System.out.print("Add name for passenger " + (i+1) + ":");
                                    Passenger carPassenger = new Passenger(in.next());
                                    embarkingCar.addPassenger(carPassenger);
                                }

                                thorVXJ.embark(embarkingCar);
                                PrintMenu.vehicles();
                                break;

                            case 3: //BUS
                                Bus embarkingBus = new Bus();
                                int passBus;
                                String busPlate;
                                //1
                                do{
                                    System.out.print("Add plate: ");
                                    busPlate=in.next();
                                }while(containsPlate(thorVXJ.iterator(),busPlate));
                                embarkingBus.setPlate(busPlate);
                                //2
                                do {
                                    System.out.print("Number of Passengers (MAX 20, including driver): ");
                                    passBus = userCheck(in);
                                } while (passBus < 1 || passBus > embarkingBus.getMaxPassengers());

                                for (int i = 0; i <passBus ; i++) {
                                    System.out.print("Add name for passenger " + (i+1) + ":");
                                    Passenger busPassenger = new Passenger(in.next());
                                    embarkingBus.addPassenger(busPassenger);
                                }
                                thorVXJ.embark(embarkingBus);
                                PrintMenu.vehicles();
                                break;
                            case 4: // LORRY
                                Lorry embarkingLorry = new Lorry();
                                int passLorry;
                                String lorryPlate;
                                //1
                                do{
                                    System.out.print("Add plate: ");
                                    lorryPlate = in.next();
                                }while (containsPlate(thorVXJ.iterator(),lorryPlate));
                                //2
                                do{System.out.print("Number of Passengers (MAX 2, including driver): ");
                                    passLorry = userCheck(in);
                                }while (passLorry < 1 || passLorry > embarkingLorry.getMaxPassengers());


                                for (int i = 0; i < passLorry; i++) {
                                    System.out.print("Add name for passenger " + (i+1) + ":");
                                    Passenger LorryPassenger = new Passenger(in.next());
                                    embarkingLorry.addPassenger(LorryPassenger);
                                }

                                thorVXJ.embark(embarkingLorry);
                                PrintMenu.vehicles();
                                break;
                            case 5: //EXIT
                                exitEmbarkVehicles = true;
                                System.out.println("Leaving embark of vehicles.");

                                break;
                            default:
                                System.out.println("Something went wrong.");
                                PrintMenu.vehicles();
                                break;
                        }
                    }//end embarking vehicles
                    PrintMenu.main();
                    break;
                case 2://embark passenger

                    System.out.println("Add name: ");
                    thorVXJ.embark(new Passenger(in.next()));
                    System.out.println("Passenger added.");
                    PrintMenu.main();
                    break;
                case 3: //print ferry
                    System.out.println(thorVXJ.toString());
                    PrintMenu.main();
                    break;
                case 4: //disembark
                    thorVXJ.disembark();
                    PrintMenu.main();
                    break;
                case 5:
                    System.out.println("Leaving program.");
                    exitMain = true;
                    break;
                default:
                    PrintMenu.main();
                    break;

            }
        }
    }//end main

    /*HELPER METHODS
    * ContainsPlate: It says if contains... you guess... plates.
    * UserCheck: I use this every time, checks if the user input is a number
    * to use the switch without problems.
    * */

    public static boolean containsPlate(Iterator<Vehicle> itePlates, String plate){
        while (itePlates.hasNext()){
            if(itePlates.next().getPlate().contains(plate)){
                return true;
            }
        }
        return false;
    }

    public static int userCheck (Scanner input){
        while(!input.hasNextInt()){
            System.out.println("Please enter a number from the Menu: ");
            input.next();
        }
        return input.nextInt();
    }




}
