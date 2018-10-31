package ht22fd_assign4.newsagency;


import java.util.ArrayList;


public class NP {


    private String name;
    private ArrayList<NW> arrivalsNW = new ArrayList<NW>();
    private ArrayList<NW> ownedNW = new ArrayList<NW>();


    public NP (String nameNP){
        setName(nameNP);
    }

    public void pushArrivals(NW othersNews){
        arrivalsNW.add(othersNews);
        System.out.println(name + " recieved a new news.");
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String toString(){
        return name;
    }

}