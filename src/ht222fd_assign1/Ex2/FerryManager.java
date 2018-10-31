package ht222fd_assign1.Ex2;

import java.util.ArrayList;
import java.util.Iterator;

public class FerryManager implements Ferry{
    public ArrayList<Vehicle> myVehicles = new ArrayList<>();
    public ArrayList<Passenger> myPassengers = new ArrayList<>();
    public ArrayList<Integer> myMoney = new ArrayList<>();


    @Override
    /*
    * Let's think that vehicles are more important than passengers
    * so we want to count first passengers in vehicles and then passengers.
    * */
    public int countPassengers() {
        int temp = 0;
        for (Vehicle v : myVehicles) {
            temp+= v.vehiclePassengers();
        }
        temp+= myPassengers.size();
        return temp;
    }

    @Override
    public int countVehicleSpace() {
        int temp = 0;
        for (Vehicle v : myVehicles) {
            temp+=v.getSize();
        }
        /*If we have 5 bikes, then divide by 5. If we have more than 5 but less than
        * 10, then bikes/5+1
        * */
        if (temp%5==0){return temp/5;}
        return temp/5+1;
    }

    @Override
    public int countMoney() {
        int tempMoney = 0;
        for(Vehicle v : myVehicles){
            tempMoney+= v.getTotalPrice();
        }

        int moneyPassengers = 20 * myPassengers.size();
        tempMoney += moneyPassengers;
        return tempMoney;
    }

    public int countBikeSpace(){
        int counterBikes=0;
        for(Vehicle v : myVehicles){
            counterBikes+= v.getSize();
        }
        return counterBikes;
    }

    @Override
    public Iterator<Vehicle> iterator() {
        return myVehicles.iterator();
    }

    @Override
    public void embark(Vehicle v) {
        int onBoard=countPassengers() + v.vehiclePassengers();
        if (onBoard<200 && hasSpaceFor(v)){
            System.out.println("Embarking new vehicle.");
            myVehicles.add(v);
        }
        else
        {
            System.out.println("Sorry, there is no place for your vehicle.");
            if (onBoard<200)
                System.out.println("Limit of Passengers reached. " + onBoard);
            else
                System.out.println("Limit of Vehicles reached." + countVehicleSpace());
        }


    }

    @Override
    public void embark(Passenger p) {
        if(hasRoomFor(p)){
            myPassengers.add(p);
        }
        else{
            System.out.println("We cannot embark more passengers.");
        }

    }

    @Override
    public void disembark() {
        myMoney.add(countMoney());
        myVehicles.clear();
        myPassengers.clear();
        System.out.println("Ferry empty.");
    }

    @Override
    /*Method hasSpaceFor:
    * Not using countingSpace because using bikes as measurement was to easy, isn't it?
    * */
    public boolean hasSpaceFor(Vehicle v) {
        return (countBikeSpace()<200);
    }

    @Override
    /*HAS ROOM FOR
    * OBS! If you want to know if there is room for more people
    * you should add +1 passenger to the count.
    * */
    public boolean hasRoomFor(Passenger p) {
        if (countPassengers()+1 <200){
            int tempTotal = 200 - (countPassengers()+1);
            System.out.println("The ferry has place for " + tempTotal + " extra passengers.");
            return true;
        }
        else{
            System.out.println("There is no room for more passengers.");
            return false;}
    }

    @Override
    public String toString(){

        int moneyList = 0;

        String statusSTR = "FERRY STATUS\nVehicle space: " + countVehicleSpace()
                            + "\nPassenger space: " + countPassengers();


        Iterator<Vehicle> itr = iterator();
        while(itr.hasNext()){
            Vehicle v = itr.next();
            statusSTR+=v.toString();
        }
        statusSTR += "\nPASSENGERS WITHOUT VEHICLE:\n";

        Iterator<Passenger> itrPass = myPassengers.iterator();


        while(itrPass.hasNext()){
            Passenger anna = itrPass.next();
            statusSTR+= anna.toString();
        }

        for (Integer integer : myMoney) {
            moneyList+=integer;
        }

        statusSTR += "\nTOTAL MONEY:" + (countMoney()+ moneyList);

        return statusSTR;
    }
}
