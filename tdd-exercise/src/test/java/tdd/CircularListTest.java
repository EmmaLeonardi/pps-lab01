package tdd;

import org.junit.jupiter.api.Test;
import tdd.implementations.CircularList;
import tdd.interfaces.CircularQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    @Test
    public void testMaxSize() {
        CircularQueue circularQueue=new CircularList(5);
        assertEquals(5, circularQueue.getMaxSize());
    }

    @Test
    public void testActualSize(){
        CircularQueue circularQueue=new CircularList(5);
        assertEquals(0, circularQueue.getSize());
    }
}
