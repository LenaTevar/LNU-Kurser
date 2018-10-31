package Helpers;

import ht222fd_assign3.Ex4To7.Word;

import java.util.Iterator;

/**
 * Created by hteva on 29/03/2017.
 */
public class testbinarytree {
    /* Fields */
    private BST root = null;
    private int size;
    private StringBuilder str = new StringBuilder();
    private Word[] arr = new Word[8];
    private int count = 0;

    /* Inner private class */
    private class BST {

        /* Fields */
        private Word word;
        private BST left = null;
        private BST right = null;

        /* Constructor */
        public BST(Word word) {
            this.word = word;

        }

		/*
		 * According to the theory, if the element is smaller than parent then
		 * it will be left child otherwise right. So in this method, first we
		 * will check if the input parameter is smaller or greater than the
		 * parent. If its smaller, then we will check if the left child is null
		 * or not. If null, then we say to left that to add it in yourself and
		 * increase the size. If not then we will do recursion until we do not
		 * find the null space. Same logic applies if input parameter is greater
		 * than parent, we will send it to right and perform the same procedure.
		 */

        private void add(Word word) {
            if (word.compareTo(this.word) < 0) {
                if (left == null) {
                    left = new BST(word);
                    size++;
                } else
                    left.add(word);

            } else if (word.compareTo(this.word) > 0) {
                if (right == null) {
                    right = new BST(word);
                    size++;
                } else
                    right.add(word);

            }

        }

		/*
		 * As now we already know that the smaller ones are on left and bigger
		 * ones are on right, so first we will check the input parameter and
		 * send it to appropriate side. If its null, then false. Otherwise do
		 * recursion. In recursion if parameter element is found then return
		 * true, else after number of recursion base case will be executed.
		 */

        private boolean contains(Word word) {
            if (word.compareTo(this.word) < 0) {
                if (left == null)
                    return false;
                else
                    return left.contains(word);
            }

            else if (word.compareTo(this.word) > 0) {
                if (right == null)
                    return false;
                else
                    return right.contains(word);
            }
            return true;
        }

		/*
		 * In order to print the elements in sorted order we will start from
		 * left child. If left child is not null,do recursion and save the left
		 * child element in string builder. When left child is null, then do the
		 * same operation with right child.
		 */

        private String print() {

            if (left != null)
                left.print();

            str.append(word + " ");

            if (right != null)
                right.print();

            return str.toString();
        }

		/*
		 * Here again I am doing recursion and saving the elements in array
		 * which I will use for iteration.
		 */

        private Word[] getWordArray() {
            if (left != null)
                left.getWordArray();

            if (count == arr.length)
                resize();
            arr[count] = word;
            count++;
            if (right != null)
                right.getWordArray();

            return arr;
        }

    }

    /* Main class Constructor */
    public void TreeWordSet() {
        size = 0;

    }

    /* Iterator method */
    public Iterator<Word> iterator() {
        return new TreeWordSetIterator();
    }

    /*
     * If root is null, means initially add the element to root and increase the
     * size. For further elements, call the inner class methods. I wrote
     * separately how root.add() methods work.
     */
    public void add(Word word) {
        if (root == null) {
            root = new BST(word);
            size++;

        } else {
            root.add(word);

        }

    }

	/*
	 * In order to prevent the program from NullPointerException, I add one
	 * statement if size is 0 return immediately false. Otherwise call inner
	 * class contains() method. I wrote separately this methods work.
	 */


    public boolean contains(Word word) {
        if (size == 0)
            return false;
        else
            return root.contains(word);
    }

    /* Return number of elements in tree */
    public int size() {
        return size;
    }

    /*
     * Again saving the program from NullPointerException, if root is null means
     * tree is empty then return just brackets[ ]. Otherwise, call print()
     * method from inner class. I wrote separately this methods work.
     */
    @Override
    public String toString() {
        if (root != null)
            return "[ " + root.print() + " ]";
        else
            return "[ ]";

    }

	/* This method helps to grow word array. */

    private void resize() {
        Word[] temp = new Word[arr.length * 2];
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }
        arr = temp;
    }

    /* Inner class for iteration */
    private class TreeWordSetIterator implements Iterator<Word> {

        /* Field */
        private int count = 0;

        /* Constructor */
        public TreeWordSetIterator() {
            root.getWordArray(); // calling method to fill array
        }

        /*
         * If tree is empty return false. In case if array size is bigger than
         * the element present in the tree then check if element at position
         * count is null or not. If yes return false. Otherwise, check that
         * count will not be greater than array size.
         */
        @Override
        public boolean hasNext() {
            if (root == null)
                return false;
            else if (arr[count] == null)
                return false;

            else
                return count < arr.length;
        }

        /*
         * Return element at index count and increment count by 1 to get next
         * element
         */
        @Override
        public Word next() {
            return arr[count++];
        }
    }
}
