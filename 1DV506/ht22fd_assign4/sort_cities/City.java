package ht22fd_assign4.sort_cities;


import java.lang.*;
import java.lang.Comparable;

public class City implements Comparable<City> {
    private int post = 0;
    private String name = "";

    public City(int post, String name){
        this.post = post;
        this.name = name;
    }

    public int getPost(){ return post; }

    public String getName(){ return name; }


    public String toString(){
        return getName() + " - Postnum: " + getPost();
    }


    @Override
    public int compareTo(City city) {
        return city.getPost() - this.getPost();
    }
}
