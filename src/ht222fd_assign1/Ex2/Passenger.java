package ht222fd_assign1.Ex2;

public class Passenger  {
    private String name = "";
    private static int passIDCounter=0;
    private int passID = passIDCounter++;

    public Passenger (String name){
        this.name=name;
    }
    public Passenger(){

    }
    public String toString(){
        return "NAME: " + name  + " ID: " + passID;
    }
//    public int getTotalPrice(){
//        return 20;
//    }

}
