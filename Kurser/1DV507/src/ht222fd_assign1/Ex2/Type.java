package ht222fd_assign1.Ex2;

/**
 * Created by hteva on 21/01/2017.
 */
public enum Type {
    BIKE (1), CAR (5), BUS (20), LORRY (40);
    private int size;


    private Type (int size){this.size = size;}
    public int getSize(){return size;}

}
