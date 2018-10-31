package ht222fd_assign2;

/**
 * Created by hteva on 23/11/2016.
 */
public class Reverse {
    public static void main(String[] args) {
        char temp;
        char[] text = { '!', 'y', 's', 'a', 'E', ' ', 's', 'a', 'w', ' ',
                's', 'i', 'h', 'T' };
        int loopTimes = (text.length/2);
        //because if we use only length, it would make a 360 grades change...
        int length = text.length-1;
        //because 14 is outside the array

        System.out.println(text);

        for (int i = 0; i < loopTimes ; i++) {

            temp = text[i];

            text[i] = text[length-i];

            text[length-i] = temp;

        }//for

        System.out.println(text);


    }
}
