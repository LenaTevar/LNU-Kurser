package ht222fd_assign3.Ex4To7;

import java.util.Iterator;
import java.util.NoSuchElementException;

/*In the case of hashing, a rehash shall be performed when the number
of inserted elements equals the number of buckets.
*/
public class HashWordSet implements WordSet {

    private Node[] buckets = new Node[8];
    private int size;

    public HashWordSet (){
        size = 0;
    }

    /*-----------------NODE CLASS--------------------*/

    /*Lena from the future: Remember the variables are public here.*/
    private class Node {
        public Word nodeWord;
        public Node next;
        /*----CONSTRUCTOR----*/
        public Node (Word word){
            nodeWord = word;
        }
    }

    /*-------------------HELPER-------------------*/
    /*Copy-paste from the lecture*/
    private int getBucketNumber(Word word) {
        int hc = word.hashCode();
        if (hc < 0) { hc = -hc; }
        return hc % buckets.length;
    }

    /*Copy-paste from the lecture
    * Wow... Jonas really did almost everything in the lecture xD
    * VG for him
    * */
    private void rehash() {
        Node[] temp = buckets;
        buckets = new Node[2 * temp.length];
        size = 0;

        for (Node n : temp) {
            if (n == null) continue;
            while (n != null ) {
                add(n.nodeWord);
                n = n.next;
            }
        }
    }

    /*-----------------OVERRIDE--------------------*/

    /*Copy-paste from the lecture
    * I changed the order of the methods because I couldn't
    * remember "contains" and repeated it inside add...
    * yuhuu...
    * */
    @Override
    public boolean contains(Word word) {
        int pos = getBucketNumber(word);
        Node node = buckets[pos];
        while (node != null) { // Search list for element
            if (node.nodeWord.equals( word ))
                return true; // Found!
            else
                node = node.next;
        }
        return false ; // Not found
    }

    @Override
    public void add(Word word) {
        if (contains(word)){
            return;
        }
        /*If contains == false, the word is not found.
        * Actually adding here.
        * */
        int position = getBucketNumber(word);

        Node node = new Node (word);
        node.next = buckets[position];
        buckets[position] = node;
        size++;

        /*OBS: If the size is bigger than the array!!!*/
        if (size == buckets.length){
            rehash();
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("HASH: ");
        for (int i = 0; i < buckets.length; i++) {
            Node node = buckets[i];
            while (node != null) {
                str.append(node.nodeWord + " ");
                node = node.next;
            }
        }
        return str.toString();
    }

    /*------------------------ ITERATOR -------------------------*/
    /*Checking LinkedQueue exercise here ;) */
    @Override
    public Iterator<Word> iterator() {
        return new HashIte();
    }

    private class HashIte implements Iterator<Word>{
        private int position;
        private Node current;

        public HashIte(){
            position = -1; //beginning
            current = null;
        }

        @Override
        public boolean hasNext() {
            /*If current is null... */

            if (current != null && current.next != null){
                return true;
            }

            /*OJO! if current is the first one, position is -1.
            * PD: OJO == OBS in spanish :P */
            for (int i = position+1; i < buckets.length ; i++) {
                if (buckets[i] != null)
                    return true;
            }
            return false;
        }

        @Override
        public Word next() {
            /*Do this if current is null or next is null (Last?)*/
            if (current == null || current.next == null) {
                if (current != null){
                    position++; //move one
                }
                /*If position is inside the buckets
                 current would be the node in that position.
                * */
                if (position < buckets.length){
                    current = buckets[position];
                }
                /*If position is NOT inside the bucket
                * throw error
                * */
                else{
                    throw new NoSuchElementException();
                }
            }
            /*If current is not null neither its next node */
            else {
                current = current.next;
            }

            return current.nodeWord;
        }//END NEXT
    }//END HASH ITERATOR
}
