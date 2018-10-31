package ht22fd_assign4.newsagency;

import java.util.Date;

public class NW {
    private NP owner;
    private String title;
    private String text;
    private Date date;

    public NW(NP owner_nw, String title_nw, String text_nw){
        owner = owner_nw;
        title = title_nw;
        text = text_nw;
        date = new Date();
    }

    public String toString(){
        String nw_string = "Date: " + date + " - Owner: " + owner
                + "\nTitle: " + title
                + "\nText: " + text;
        return nw_string;
    }

    public NP getOwner(){
        return owner;
    }



}