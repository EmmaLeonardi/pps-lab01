package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tdd.implementations.CircularList;
import tdd.interfaces.CircularQueue;

import static org.junit.jupiter.api.Assertions.*;

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

    public void fillQueue(){
        for (int i=0; i<=circularQueue.getMaxSize(); i++){
            circularQueue.add(i);
        }
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
        fillQueue();
        assertEquals(circularQueue.getSize(), circularQueue.getMaxSize());
    }

    @Test
    public void testRemoveOldest(){
        fillQueue();
        circularQueue.removeOldest();
        assertEquals(circularQueue.getSize(), circularQueue.getMaxSize()-1);
    }

    @Test
    public void testRemoveOldestIsCorrect(){
        circularQueue.add(VALUE);
        final int retrived=circularQueue.removeOldest();
        assertEquals(VALUE, retrived);
    }

    @Test
    public void testRemoveOldestFail(){
        assertThrows(IllegalStateException.class, ()->circularQueue.removeOldest());
    }

    @Test
    public void testIsEmpty(){
        assertTrue(circularQueue.isEmpty());
    }

    @Test
    public void testRemoveNewest(){
        fillQueue();
        circularQueue.removeNewest();
        assertEquals(circularQueue.getSize(), circularQueue.getMaxSize()-1);
    }

    @Test
    public void testRemoveNewestFail(){
        assertThrows(IllegalStateException.class, ()->circularQueue.removeNewest());
    }

    @Test
    public void testRemoveNewestIsCorrect(){
        circularQueue.add(VALUE);
        final int retrived=circularQueue.removeNewest();
        assertEquals(VALUE, retrived);
    }

    @Test
    public void testPeekNewest(){
        circularQueue.add(VALUE);
        final int peeked=circularQueue.peekNewest();
        assertAll(()->assertEquals(peeked, VALUE),
                ()->assertFalse(circularQueue.isEmpty()));
    }

    @Test
    public void testPeekNewestFail(){
        assertThrows(IllegalStateException.class, ()->circularQueue.peekNewest());
    }

    @Test
    public void testPeekOldest(){
        circularQueue.add(VALUE);
        final int peeked=circularQueue.peekOldest();
        assertAll(()->assertEquals(peeked, VALUE),
                ()->assertFalse(circularQueue.isEmpty()));
    }

    @Test
    public void testPeekOldestFail(){
        assertThrows(IllegalStateException.class, ()->circularQueue.peekOldest());
    }
}
