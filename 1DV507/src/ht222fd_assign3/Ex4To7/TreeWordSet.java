package ht222fd_assign3.Ex4To7;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class TreeWordSet implements WordSet {
    
    private Node root = null;
    public int size = 0;
    private Word[] wordIteArr = new Word[8]; //Stuff to help iterator
    private int counter = 0;//Stuff to help iterator
    StringBuilder nodeToString = new StringBuilder();
    //I changed nodeToString  in a hunch and I don't know exactly why it works.
    //In the hash set works just fine inside the toString method :/


    /*--------------CLASS NODE-------------------*/
    private class Node{
        public Word value;
        public Node left = null; // <
        public Node right = null; // >
        //public Node NodeParent = null;


        /*---CONSTRUCTOR---*/
        public Node(Word word){
            value = word;
        }

        /*---METHODS---*/
        /*Compare with this.value if lower go to left, if bigger go to right*/
        public void add (Word input){
            if (input.compareTo(value)<0){
                if( left == null){ left = new Node(input); }
                else
                    left.add(input);
            }//end if left

            else if (input.compareTo(value)>0){
                if(right == null){right = new Node(input); }
                else
                    right.add(input);
            }
        }//end add

        /*Search inside the tree and look if input is contained*/
        public boolean contains (Word input){
            int comparator = input.compareTo(value);

            if (comparator == 0) {return true; }

            /*Search inside branches.
            * If comparator is lower 0 and left child is not empty, then recurse
            * through the left branch. Same thing with right child. */

            else if (comparator <0 && left != null && left.contains(input)){
                return true;
            }
            else if (comparator >0 && right != null && right.contains(input)){
                return true;
            }
            return false;
        }//end contains

        private Word[] getwordIteArr(){
            if (left != null){
                left.getwordIteArr();
            }
            if (counter == wordIteArr.length ){
                resize();
            }
            wordIteArr[counter] = value;
            counter++;
            //now the same with right side
            if (right != null){
                right.getwordIteArr();
            }
            return wordIteArr;
        }

        private void resize(){}

        public String toString(){


            if (left != null){
                left.toString();
            }
            nodeToString.append(value + " ");

            if (right != null){
                right.toString();
            }
            return nodeToString.toString();
        }


    }//end class binary tree

    /*--------------HELPER--------------------*/


    /*---------------OVERRIDE-----------------*/


    @Override
    public void add(Word word) {
        if (contains(word)){
            return;
        }

        if (root == null){
            root = new Node(word);
            size = 1;
        }
        else {
            root.add(word);
            size++;
        }
    }

    @Override
    public boolean contains(Word word) {
        if (root == null){
            return false;
        }
        return root.contains(word);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder("Tree: ");
        if (root == null){
            str.append("NULL");
        }
        else{
            str.append(">" + root.toString()+ "<");
        }
            return str.toString();
    }

    /*------ITERATOR STUFF------*/
    @Override
    public Iterator<Word> iterator() {
        return new TreeIte();
    }

    private class TreeIte implements Iterator<Word>{
        /*Dear Lena from the future: This is super weird. So, the book
        * uses a queue and nodes, then they use the queue.size() to get the hasNext method done.
        * Let's try to do something with that and what we did with hashwordset. We cannot
        * use queue but we can use arrays. I'm adding an array to help this step.
        * Help: http://stackoverflow.com/questions/4581576/implementing-an-iterator-over-a-binary-search-tree
        * All the internet use a stack to do it :_)
        * */

        private Node[] allWords;

        private int current = 0;

        public TreeIte(){
            root.getwordIteArr();
        }


        @Override
        public boolean hasNext() {
            if (root == null || wordIteArr[current] == null){
                return false;
            }
            else{
                return current < wordIteArr.length;
            }

        }

        @Override
        public Word next() {
            return wordIteArr[counter++];
        }

        @Override
        public void remove(){
            throw new RuntimeException("Remove not implemented");
        }


    }//end Tree iterator
}
