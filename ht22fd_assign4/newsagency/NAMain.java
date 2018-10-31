package ht22fd_assign4.newsagency;
/* CLASSES:
 * NW - News
 * NP - NewsPaper
 *
 * */

public class NAMain {

    public static void main(String[] args) {
        /*I know I use to make different menus to let you check
        * the assignment with whatever you want. But I think this is way
        * to complicated to do it with menus. I would need tones of
        * switches to make as I like.
        * Now I'm so used to do it with a menu that I feel bad hardcoding >.<
        * btw "news + news papers + declarations couldn't be more confusing.
        * */

        NP dailyP = new NP ("The Daily Prophet");
        NP gothamH = new NP("Gotham Herald");
        NP aminquirer = new NP("The Ankh-Morpork Inquirer");

        NW newnew = new NW(dailyP, "Something happens", "Something happens somewhere.");
        NW newnew2 = new NW(aminquirer, "Thing does a thing", "A thing did a thing that was supposed to do. ");

        System.out.println("***Printing an example of news\n" + newnew);

        Agency superAgency = new Agency ("The Super Agency");

        superAgency.register(dailyP);
        superAgency.register(gothamH);
        superAgency.register(aminquirer);

        System.out.println("****Created 3 newspapers and adding them to the Super Agency.");
        System.out.println(superAgency.registerToString());

        System.out.println("\n**** Daily Prophet pushing news:");
        superAgency.mailBox(newnew);
        System.out.println("\n**** The Ankh-Morpork Inquierer pusing news:");
        superAgency.mailBox(newnew2);

        System.out.println("**** Creating a new newspaper that will try to push news without being registered.");
        NP dailybugle = new NP ("Daily Bugle");
        NW newnew3 = new NW(dailybugle, "REWARD!", "Reward for photos of Spider-man!");

        superAgency.mailBox(newnew3);

    }
}