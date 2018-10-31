package ht22fd_assign4.newsagency;


import java.util.ArrayList;

public class Agency {
    private ArrayList<NP> registerList = new ArrayList<NP>();
    private String name;


    public Agency (String name_agency){
        name = name_agency;
    }

    public void register(NP newspaper){
        registerList.add(newspaper);
    }

    public void mailBox(NW notice){
        if (!isRegistered(notice.getOwner())){
            System.out.println("Sorry, but " + notice.getOwner()
                    + " is not registered in our Agency.");
        }

        else {
            for (NP np : registerList) {
                if (np != notice.getOwner()){
                    System.out.println(" Pushing news to " + np.toString());
                    np.pushArrivals(notice);
                }
            }

        }//end else
    }//end mailbox


    public boolean isRegistered(NP newspaper){
        return registerList.contains(newspaper);
    }
    public String registerToString(){
        String registerString="NEWSPAPERS REGISTER\n";

        for (NP np : registerList) {
            registerString = registerString + "- " + np.toString() + "\n";
        }

        return registerString;
    }



}