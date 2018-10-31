package ht222fd_assign4.time;


public class Ex2 {
    public static void main(String[] args) {

        String testShortStr = "";
        String testLongStr = "";

        StringBuilder testShortSb = new StringBuilder();
        StringBuilder testLongSb = new StringBuilder();

        String shortStr = "*";

        int LONG_STRING_LENGTH = 80;
        String longStr = "";


        for (int i = 0; i < LONG_STRING_LENGTH ; i++) {
            longStr += "*";

        }


        /*SHORT STRING - STRING*/
        long endTime = System.currentTimeMillis() + 1000;
        while (System.currentTimeMillis() < endTime) {
            testShortStr = testShortStr + shortStr;
        }



        /*SHORT STRING - STRINGBUILDER*/
        endTime = System.currentTimeMillis()+1000;
        while (System.currentTimeMillis() < endTime) {
            testShortSb.append(shortStr);
        }



        /*LONG STRING - STRING*/
        endTime = System.currentTimeMillis()+1000;
        while (System.currentTimeMillis() < endTime) {
            testLongStr = testLongStr + longStr;
        }



        /*RESET ENDTIME AND CONCATENATING LOOP FOR STRINGBUILDER*/
        endTime = System.currentTimeMillis()+1000;
        while (System.currentTimeMillis() < endTime) {
            testLongSb.append(longStr);
        }

        /*-----REPORT------ */
        System.out.println("Short concatenation in 1 second with String = " + testShortStr.length());
        System.out.println("Short concatenation in 1 second with StringBuilder = "  + testShortSb.toString().length());
        System.out.println("Difference = " + (Math.max(testShortStr.length(),testShortSb.length()) - Math.min(testShortStr.length(),testShortSb.length())) + " length");
        System.out.println("Long String length: " + longStr.length());
        System.out.println("Long concatenation in 1 second with String = " + testLongStr.length());
        System.out.println("Long concatenation in 1 second with StringBuilder = " + testLongSb.length());
        System.out.println("Difference = " + (Math.max(testLongStr.length(),testLongSb.length()) - Math.min(testLongStr.length(),testLongSb.length()))+ " length");

        /*When using string concatenation in a loop, you create a new string each time you loop. SB creates */

    }
}
