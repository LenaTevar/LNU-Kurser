package ht222fd_assign4.time.Ex3_NOT_FINISHED;

import java.util.Random;

/**
 * Created by hteva on 08/03/2017.
 */
public class setUp {
    private int[] smallArrayInt;
    private int[] longArrayInt;
    private String[] smallArrayStr;
    private String[] longArrayStr;
    private Random rnd = new Random();
    private final int SMALL_LENGTH = 5;
    private final int LONG_LENGTH = 5000000;

    public int[] getSmallArrayInt() {
        smallArrayInt = new int[SMALL_LENGTH];
        for (int i = 0; i < SMALL_LENGTH ; i++) {
            int x = rnd.nextInt(SMALL_LENGTH*2);
            smallArrayInt[i] = x;
        }

        return smallArrayInt;
    }

    public int[] getLongArrayInt() {
        longArrayInt = new int[LONG_LENGTH];
        for (int i = 0; i < LONG_LENGTH ; i++) {
            int x = rnd.nextInt(LONG_LENGTH*2);
            longArrayInt[i] = x;
        }
        return longArrayInt;
    }

}
