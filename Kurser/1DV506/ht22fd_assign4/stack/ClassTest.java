package ht22fd_assign4.stack;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Iterator;

public class ClassTest implements Stack {

    private ArrayList<Example> listTest;

    public ArrayList<Example> getListTest() {
        return listTest;
    }

    public void setListTest(ArrayList<Example> inputList) {
        this.listTest = inputList;
    }

    @Override
    public int size() {
        int stackSize = listTest.size();
        return stackSize;
    }

    @Override
    public boolean isEmpty() {
        if (listTest.isEmpty())
            return true;
        else
            return false;
    }

    @Override
    public void push(Example element) {
        listTest.add(element);
    }

    @Override
    public Example pop() {
        if (this.isEmpty()){
            throw new EmptyStackException();
        }

        else {
            Example popTest = listTest.get(listTest.size()-1);
            listTest.remove(listTest.size()-1);
            return popTest;
        }
    }

    @Override
    public Example peek() {
        if (this.isEmpty()){
            throw new EmptyStackException();
        }

        else {
            Example peekTest = listTest.get(listTest.size()-1);
            return peekTest;
        }
    }

    @Override
    public Iterator<Example> iterator() {

        return listTest.iterator();

    }
}