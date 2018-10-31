package ht222fd_assign1.Ex2;


public class Car  extends Vehicle{
    private Type vType = Type.CAR;

    public Car (){super();}



    @Override
    public int getSize() {
        return vType.getSize();
    }

    @Override
    public int getTotalPrice() {
        return 100 + this.vehiclePassengers()*15 ;
    }

    @Override
    public Type getType() {
        return vType;
    }

    @Override
    public int getMaxPassengers() {
        return 4;
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
