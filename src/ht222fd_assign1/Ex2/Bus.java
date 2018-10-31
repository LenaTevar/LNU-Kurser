package ht222fd_assign1.Ex2;

/**
 * Created by hteva on 21/01/2017.
 */
public class Bus extends Vehicle{
    private Type vType = Type.BUS;

    public Bus(){super();}




    @Override
    public int getSize() {
        return vType.getSize();
    }

    @Override
    public int getTotalPrice() {
        return 200 + this.vehiclePassengers()*10;
    }

    @Override
    public Type getType() {
        return vType;
    }

    @Override
    public int getMaxPassengers() {
        return 20;
    }

    @Override
    public String toString() {
        String temp = " \nType: " + getType()+ ">>Plate: " + getPlate()
                + " Ferry ID number: " + getNumber() + "\nPassengers:\n";
        for (Passenger otto : vehiclePassengers){
            temp += " -> "+ otto.toString();
        }
        return temp;
    }
}
