package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tdd.implementations.CircularList;
import tdd.interfaces.CircularQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    public final int LIST_SIZE=5;
    public final int VALUE=7;
    public CircularQueue circularQueue;

    @BeforeEach
    public void beforeEach(){
        circularQueue=new CircularList(LIST_SIZE);
    }

    @Test
    public void testMaxSize() {
        assertEquals(LIST_SIZE, circularQueue.getMaxSize());
    }

    @Test
    public void testActualSize(){
        assertEquals(0, circularQueue.getSize());
    }

    @Test
    public void testAddElement(){
        circularQueue.add(VALUE);
        assertTrue(circularQueue.getSize()>0);
    }

    @Test
    public void testAddElementWithFullQueue(){
        for (int i=0; i<=circularQueue.getMaxSize(); i++){
            circularQueue.add(i);
        }
        assertEquals(circularQueue.getSize(), circularQueue.getMaxSize());
    }
}
