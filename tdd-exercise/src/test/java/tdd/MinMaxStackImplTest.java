package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tdd.implementations.CustomStack;
import tdd.interfaces.MinMaxStack;

import static org.junit.jupiter.api.Assertions.*;

class MinMaxStackImplTest {

    final private int VALUE=3;

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
        stack.push(VALUE);
        assertFalse(stack.isEmpty());
    }

    @Test
    public void testPop(){
        stack.push(VALUE);
        var retrieved=stack.pop();
        assertEquals(retrieved, VALUE);
    }

    @Test
    public void testPopFail(){
        assertThrows(IllegalStateException.class, ()->stack.pop());
    }

    @Test
    public void testPeek(){
        stack.push(VALUE);
        var oldSize= stack.size();
        stack.peek();
        assertEquals(oldSize, stack.size());
    }

    @Test
    public void testPeekFail(){
        assertThrows(IllegalStateException.class, ()->stack.peek());
    }





}