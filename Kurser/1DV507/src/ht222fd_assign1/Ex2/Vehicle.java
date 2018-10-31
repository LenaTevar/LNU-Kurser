package ht222fd_assign1.Ex2;

import java.util.ArrayList;

public abstract class  Vehicle {
    private String plate;
    private static int counterID = 0;
    private int vehicleID;
    private Type vType;
    private int size;
    ArrayList<Passenger> vehiclePassengers;

    protected  Vehicle (){
        this.plate="none";
        this.vehicleID=counterID++;
        vehiclePassengers=new ArrayList<Passenger>();
    }



    public int getNumber(){
        return vehicleID;
    }

    public abstract int getSize();
    public abstract int getTotalPrice();
    public abstract Type getType();
    public abstract int getMaxPassengers();
    public abstract String toString();
    public void addPassenger(Passenger p){
        if (vehiclePassengers.size()<getMaxPassengers()){
            vehiclePassengers.add(p);
        }
        else {
            System.out.println("There is no more place for your passenger.");
        }
    }
    public int vehiclePassengers(){
        return vehiclePassengers.size();
    }
    public String getPlate(){ return plate;}
    public void setPlate(String user){this.plate = user;}




}//end vehicle