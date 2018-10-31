package ht222fd_assign2;

import java.util.Scanner;

/**
 * Created by hteva on 27/11/2016.
 */
public class Palindrome {
    public static void main(String[] args) {
        char a;
        char b;

        Scanner input = new Scanner(System.in);
        System.out.print("Add a sentence: ");
        String user = input.nextLine();
        String save = user;

        user = user.toLowerCase();
        user = user.replaceAll("[^a-z]","");
        /*yep, I found that in internet... I guessed that it had to be a way
        to select only letters already implemented. C# has something like that also.
        [^a-zA-Z] means any character that IS NOT a-z OR A-Z*/

        StringBuilder sb = new StringBuilder(user);
        String stringOne = sb.reverse().toString();
        int length = user.length();

//        System.out.println(user);
//        System.out.println(stringOne);


            for (int i = 0; i <length ; i++) {
                a = user.charAt(i);
                b = stringOne.charAt(i);
                //System.out.println(a + " vs " + b);

                if(a != b){
                    System.out.println("\"" + save + "\" is not a Palindrome.");
                    break;
                }
                else if (i == length-1){
                    System.out.println("\"" + save + "\" is a Palindrome." );
                }
            }
    }
}
