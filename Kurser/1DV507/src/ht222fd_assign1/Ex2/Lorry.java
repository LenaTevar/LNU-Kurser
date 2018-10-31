package ht222fd_assign1.Ex2;

/**
 * Created by hteva on 21/01/2017.
 */
public class Lorry extends Vehicle {
    private Type vType = Type.LORRY;

    public Lorry(){super();}

    @Override
    public int getSize() {
        return vType.getSize();
    }

    @Override
    public int getTotalPrice() {
        return 300 + this.vehiclePassengers()*15;
    }

    @Override
    public Type getType() {
        return vType;
    }

    @Override
    public int getMaxPassengers() {
        return 2;
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
