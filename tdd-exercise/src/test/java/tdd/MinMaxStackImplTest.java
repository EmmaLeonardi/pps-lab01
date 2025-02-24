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

}