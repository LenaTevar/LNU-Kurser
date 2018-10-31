package Helpers;

import ht222fd_assign3.Ex4To7.Word;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by hteva on 29/03/2017.
 */
public class testhash {


    /* Fields */
    private int size;
    private Node[] buckets = new Node[5];

    /* Inner Node class */
    private class Node {
        /* Fields */
        Word word;
        Node next = null;

        /* Inner class Constructor */
        public Node(Word word) {
            this.word = word;
        }

        @Override
        public String toString() {
            return word.toString(); // to string
        }
    }

    /* Constructor */
    public void HashWordSet() {
        size = 0; // initially size is 0
    }

	/*
	 * This method will call the getBucketNumer() method. I wrote separately how
	 * that method work. That method will then return an index position in the
	 * bucket array. Then we will create a node which start from position pos.
	 * With the help of while loop we will try to find out if the parameter word
	 * is already contained in the array or not. If yes, we will return out from
	 * this method without saving. Otherwise, we will increment the node with
	 * the help of field variable next.This loop will runs until it found
	 * duplicate element or null position(means no duplicate). When node found
	 * null position we will create a new node with parameter variable. Now we
	 * will save this node at position pos and increase the size.
	 */

    public void add(Word word) {
        int pos = getBucketNumber(word);
        Node node = buckets[pos];
        while (node != null) {
            if (node.word.equals(word)) {
                return;
            } else
                node = node.next;
        }

		/* When node found null position */
        node = new Node(word);
        node.next = buckets[pos];
        buckets[pos] = node;
        size++;
        if (size == buckets.length)
            rehash(); // method call
    }

	/*
	 * This method will basically first save all the elements in temporary array
	 * and then double the size of bucket array. In other words, when size is
	 * equal to the bucket array this method helps to resize the array. Note: we
	 * must change the size to 0, otherwise the size will give wrong output. Eg:
	 * if array size is 10 and we want to add 11th element, first rehash method
	 * will be called and in this method if we do not write size = 0, it will
	 * start adding the size in this way size = size + size++ because when we
	 * will save all the elements back to bucket array we will use add() method
	 * and inside the add method I already mentioned that increase the size
	 * whenever new word will be added. Furthermore, we will skip those nodes
	 * which are null and only save the nodes which contains element.
	 */

    private void rehash() {
        Node[] temp = buckets;
        buckets = new Node[2 * temp.length];
        size = 0;
        for (Node n : temp) {
            if (n == null)
                continue;
            while (n != null) {
                add(n.word);
                n = n.next;
            }
        }

    }

	/*
	 * This method first get the hash code of parameter variable and then check
	 * if its negative. Sometimes, its possible to get negative hash code. If
	 * its negative change it to positive in order to get the modulus(modulus is
	 * always positive). This modulus will be always between the bucket array
	 * length. This method then returns the Integer which is the index number in
	 * bucket array. This index number will help to save the parameter variable
	 * as well as to find if bucket array has duplicate of it.
	 */

    private int getBucketNumber(Word word) {
        int hash = word.hashCode();
        if (hash < 0)
            hash = -hash;
        return hash % buckets.length;
    }

	/*
	 * First get the reference index number with the help of getBucketNumber()
	 * method and then create a node with the help of this index position. Run
	 * the for loop and compare the word of each node with parameter variable If
	 * its same return true else increment the node until node is not equal to
	 * null. In that case, return false.
	 */

    public boolean contains(Word word) {
        int pos = getBucketNumber(word);
        Node node = buckets[pos];
        while (node != null) {
            if (node.word.equals(word))
                return true;
            else
                node = node.next;
        }

        return false;
    }

    /* Return how many elements are in bucket array */
    public int size() {
        return size;
    }

	/*
	 * Run the loop around the bucket array. Make a node at position i and then
	 * check if its null or not. if null, increment the i. If not, save the
	 * element in string builder and increment the node until it is not equal to
	 * null.
	 */

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("[ ");
        for (int i = 0; i < buckets.length; i++) {
            Node node = buckets[i];
            while (node != null) {
                str.append(node.word + " ");
                node = node.next;
            }
        }
        str.append(" ]");
        return str.toString(); // change to string
    }

    public Iterator<Word> iterator() {
        return new HashWordSetIterator();
    }

	/* Private inner class for iterator */

    private class HashWordSetIterator implements Iterator<Word> {

        /* Fields */
        private int count = 0;
        private Node node = null;

		/*
		 * If node is null return false. Else check if node and next node is not
		 * null. If both these nodes are not null return true. If one of the
		 * node is null, then run the for loop around bucket array to check if
		 * other node is null or not.
		 */


        public boolean hasNext() {
            if (node != null && node.next != null) {
                return true;
            }

            for (int i = count; i < buckets.length; i++) {
                if (buckets[i] != null) {
                    return true;
                }
            }
            return false;
        }

        /*
         * If node and next node are not null, increment the node and return
         * word at that position. Otherwise, increase the count variable to skip
         * all the null position and when its not null, return word at that
         * position
         */

        public Word next() throws NoSuchElementException {
            if (node != null && node.next != null) {
                node = node.next;
            } else do {
                    /* Throw error in case count is equal to array size */
                if (count == buckets.length) {
                    throw new NoSuchElementException();
                }
                node = buckets[count++];
            } while (node == null);
            return node.word;

        }

    }

}
