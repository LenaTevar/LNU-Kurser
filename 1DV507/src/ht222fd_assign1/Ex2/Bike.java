package ht222fd_assign1.Ex2;


public class Bike extends Vehicle {

    private Type vType = Type.BIKE;

    public Bike (){super();}


    @Override
    public int getSize() {
        return vType.getSize();
    }

    @Override
    public int getTotalPrice() {
        return 40;
    }

    @Override
    public Type getType() {
        return vType;
    }

    @Override
    public int getMaxPassengers() {
        return 1;
    }

    @Override
    public String toString() {
        String temp = " \nType: " + getType()+ ">>Plate: " + getPlate()
                    + " Ferry ID number: " + getNumber() + "\nPassengers:\n";
        for (Passenger otto : vehiclePassengers){
            temp += " -"+otto.toString();
        }
        return temp;
    }
}
