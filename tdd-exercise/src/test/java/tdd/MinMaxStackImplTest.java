package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tdd.implementations.CustomStack;
import tdd.interfaces.MinMaxStack;

import static org.junit.jupiter.api.Assertions.*;

class MinMaxStackImplTest {

    final private int TEST_VALUE =3;
    final private int MAX_ITERATIONS=5;
    final private int MIN_ITERATIONS=1;

    MinMaxStack stack;


    @BeforeEach
    public void beforeEach(){
        stack=new CustomStack();
    }

    @Test
    public void testStackStartsEmpty(){
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testPush(){
        stack.push(TEST_VALUE);
        assertFalse(stack.isEmpty());
    }

    @Test
    public void testPop(){
        stack.push(TEST_VALUE);
        var retrieved=stack.pop();
        assertEquals(retrieved, TEST_VALUE);
    }

    @Test
    public void testPopFail(){
        assertThrows(IllegalStateException.class, ()->stack.pop());
    }

    @Test
    public void testPeek(){
        stack.push(TEST_VALUE);
        var oldSize= stack.size();
        stack.peek();
        assertEquals(oldSize, stack.size());
    }

    @Test
    public void testPeekFail(){
        assertThrows(IllegalStateException.class, ()->stack.peek());
    }

    @Test
    public void testGetMin(){
        for(int i=MIN_ITERATIONS;i<=MAX_ITERATIONS; i++){
            stack.push(i);
        }
        assertEquals(stack.getMin(), MIN_ITERATIONS);
    }

    @Test
    public void testGetMinFail(){
        assertThrows(IllegalStateException.class, ()->stack.getMin());
    }

    @Test
    public void testGetMax(){
        for(int i=MIN_ITERATIONS;i<=MAX_ITERATIONS; i++){
            stack.push(i);
        }
        assertEquals(stack.getMax(), MAX_ITERATIONS);
    }

    @Test
    public void testGetMaxFail(){
        assertThrows(IllegalStateException.class, ()->stack.getMax());
    }





}