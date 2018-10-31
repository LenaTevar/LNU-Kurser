package ht222fd_assign2.Ex1;

import org.junit.Test;

import static org.junit.Assert.*;


/**
 * I didn't understands the exercise pretty well...
 * I don't know how to make this test work with both Linked and Circular, but
 * I did it thinking in both.
 */
public class LinkedQueueTest {
    LinkedQueue<Integer> testLQ = new LinkedQueue<>();
    LinkedQueue<Object> testObj = new LinkedQueue<>();



    @Test
    public void testEmpty(){
        assertEquals(0, testLQ.size());
        assertTrue(testLQ.isEmpty());
    }

    @Test
    public void enqueueSingleton()  {

        testLQ.enqueue(1);

        assertEquals(1, testLQ.size());
        assertTrue(!testLQ.isEmpty());
    }

    /**
     * Circular Array has a basic size of 8.
     * Adding 10 should trigger the resize.
     */
    @Test
    public void enqueueTen()  {
        for (int i = 0; i <10 ; i++) {
            testLQ.enqueue(i);
        }
        assertEquals(10, testLQ.size());
        assertTrue(!testLQ.isEmpty());
    }

    @Test
    public void enqueueString() {
        for (int i = 0; i < 10 ; i++) {
            testObj.enqueue("A");
        }
        assertEquals(10, testObj.size());
        assertTrue(!testObj.isEmpty());
    }


    @Test
    public void InAndOut() throws Exception {
        for (int i = 0; i < 50 ; i++) {
            testLQ.enqueue(i);
        }
        assertEquals(50, testLQ.size());
        assertTrue(!testLQ.isEmpty());
        assertEquals(0,testLQ.first());
        assertEquals(49, testLQ.last());

        for (int i = 0; i < 50 ; i++) {
            testLQ.dequeue();
        }

        assertEquals(0, testLQ.size());
        assertTrue(testLQ.isEmpty());

    }

    @Test
    public void testToString(){

    }

    @Test(expected = NullPointerException.class)
    public void testNullDequeue(){
        testLQ.enqueue(1);
        testLQ.dequeue();
        testLQ.first();
        testLQ.last();
    }
}