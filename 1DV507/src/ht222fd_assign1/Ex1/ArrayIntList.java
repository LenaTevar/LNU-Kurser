package ht222fd_assign1.Ex1;

import java.util.Iterator;

public class ArrayIntList extends AbstractIntCollection implements IntList {
    @Override
    public void add(int n) {
        System.out.println(">>>ADDING...");
        //System.out.println("size is: " + super.size());
        if (super.isEmpty()){
            values[size++] = n;
            //System.out.println("The array was empty but now its size is: " + super.size());
        }
        else if (super.checkIndex(super.size(),values.length)){
            values[size++] = n;
            //System.out.println("SIZE WAS OK" + super.size());
        }
        else {
            super.resize();
            values[size++] = n;
            //System.out.println("resize done");
        }
        System.out.println(super.toString());
    }

    @Override
    public void addAt(int n, int index) throws IndexOutOfBoundsException {
        System.out.println(">>>ADDING AT...");
        System.out.println(index +"-"+ super.size());



        if(index<super.size()){
            values[index]=n;
            System.out.println("Your number was added: " + super.toString());
        }
        else{
            System.out.println("Sorry but the index entered does not exist.");
        }

    }

    /*Method remove:
    * I would love to resize the array to shrink it but I guess I cannot.
     * If I change the variable size, it will mess with the add method.
     * Without being allowed to shrink the array, I cannot see better answer
     * than leaving size at it is and if you print the array after removing, it
     * will appear as "0".
     * */
    @Override
    public void remove(int index) throws IndexOutOfBoundsException {
        if (checkIndex(index, super.size())){
            for (int i = index; i < super.size() ; i++) {
                values[i]=values[i+1];
            }
        }
        else {
            throw new IndexOutOfBoundsException("Index " + index
                    + " is out of bounds!");
        }
    }

    @Override
    public int get(int index) throws IndexOutOfBoundsException {
        if (checkIndex(index, super.size())) {
            return values[index];
        }
        else {
            throw new IndexOutOfBoundsException("Index " + index
                    + " is out of bounds!");

        }
    }

    @Override
    /* Method: indexOf
    A for-i loop iterates through the iterator and at the same time
    works as counter for the position in the array.
    If the for-i doesn't find "n" inside the array, it will jump to
    return -1 */
    public int indexOf(int n) {
        System.out.println(">>>INDEX OF");
        Iterator<Integer> indexOfIte = super.iterator();
        for (int i = 0; i < super.size() ; i++) {
            if (n == indexOfIte.next()){return i;}
        }
        return -1;
    }
}
