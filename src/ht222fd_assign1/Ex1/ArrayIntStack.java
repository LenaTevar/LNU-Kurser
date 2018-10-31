package ht222fd_assign1.Ex1;

/**
 * Created by hteva on 2017-01-19.
 */
public class ArrayIntStack extends AbstractIntCollection implements IntStack{
    @Override
    public void push(int n) {
        System.out.println(">>>PUSH");
        System.out.println("size is: " + super.size());
        if (super.isEmpty()){
            values[size++] = n;
            System.out.println("Stack was empty - size is now: " + super.size());
        }
        else if (super.checkIndex(super.size(),values.length)){
            values[size++] = n;
            System.out.println("Check index true. size = " + super.size());
        }
        else {
            super.resize();
            values[size++] = n;
            System.out.println("resize done");
        }
        System.out.println(super.toString());
    }

    @Override
    /*Method pop:
    * Not going to repeat myself, but I don't like not being able to shrink the array. :-/
    * */
    public int pop() throws IndexOutOfBoundsException {
        System.out.println(">>>POP");
        if (super.isEmpty()){
            System.out.println("This Stack is Empty.");
            return -1;
        }

        else{
            System.out.println("pop not empty");
            System.out.println("length now " + values.length);
            int temp = values[super.size()-1];
            size--;
            super.resize();
            System.out.println("length" + values.length);
            System.out.println("size" + super.size());
            System.out.println(super.toString());

            return temp;
        }//end else
    }

    @Override
    public int peek() throws IndexOutOfBoundsException {
        System.out.println(">>>PEEK");
        if (super.isEmpty()){
            System.out.println("This Stack is Empty.");
            return -1;
        }
        else {
            int temp = values[super.size()-1];
            return temp;
        }
    }
}
