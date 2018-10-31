package ht222fd_assign4.binheap;
import java.util.Arrays;

/* Material used:
 * Course Book.
 * https://www.cs.cmu.edu/~adamchik/15-121/lectures/Binary%20Heaps/heaps.html
 * http://www.sanfoundry.com/java-program-implement-binary-heap/
 */
public class BinaryIntHeap implements BinaryHeap<Integer> {

    private Integer heap[];
    private int size;
    private static final int TREE_SIZE = 8;


    /**
     * Constructor
     * In order to use the algorithm to get the child and parent easily,
     * never use the first position of the array.
     * Remember: Childs = index * 2 + 1 || index * 2 + 2
     */
    public BinaryIntHeap()
    {
        heap = new Integer[TREE_SIZE + 1];
        size = 0;
    }
    /*-------METHODS-----*/

    @Override
    public void insert(Integer n) {
        if (n == null)
            return;

        if (isFull())
            resize(); //I saw this in internet. I was thinking about throwing an Exception but this looks cooler.

        //OBS! index 0 must NOT be used.
        int pos = ++size;

        //OBS! dad = position/2; kids = index*2 +1 or +2
        while(pos > 1 && n.compareTo(heap[pos/2]) > 0)
        {
            heap[pos] = heap[pos/2];
            pos = pos/2;
        }
        heap[pos] = n;
    }

    @Override
    public Integer pullHighest() {
        Integer highest = heap[1];

        //Take the last number and put it in root
        Integer temp = heap[size];
        heap [1] = temp;
        heap[size] = null;
        size--;

        //Fix the tree. Check the child and move the last added around if needed.
        int pos = 1;
        while(pos < size && insideArrLength(pos*2))
        {
            int posB = pos*2;
            //If there is 2 child AND left is bigger than right...
            if (exists(posB) && exists(posB+1) && heap[posB] < heap[posB+1])
                posB++;

            //If there is no left child AND the last added is less than 0
            if (heap[posB] != null && temp.compareTo(heap[posB]) < 0)
            {
                heap[pos] = heap[posB];
                heap[posB] = temp;
                pos = posB;
            }
            else break;
        }

        return highest;
    }

    @Override
    public int size() { return size; }

    @Override
    public boolean isEmpty() { return size() == 0; }

    /*-----HELPER METHODS-----*/
   //Dear Lena from the future: Why do you always forget this thing...
    public String toString() { return Arrays.toString(heap); }

    /*I saw this in internet. I was thinking about throwing an Exception but this looks cooler.
    * It also makes sense. We studied about growing arrays before, so there is no reason to don't do it.*/
    private void resize()
    {
        int newSize = heap.length*2 - 1;
        Integer tmp[] = new Integer[newSize];
        System.arraycopy(heap, 1, tmp, 1, heap.length-1);
        heap = tmp;
    }


    private boolean isFull() { return size >= heap.length - 1; }

    /*Check if a given index exist inside our array*/
    private boolean insideArrLength(int index) { return index < heap.length; }


    //OBS [0] IS NULL
    private boolean exists(int index)
    {
        return insideArrLength(index) && heap[index] != null;
    }
}