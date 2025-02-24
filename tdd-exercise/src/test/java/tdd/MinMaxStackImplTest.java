package tdd;

import org.junit.jupiter.api.Test;
import tdd.implementations.CustomStack;
import tdd.interfaces.MinMaxStack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MinMaxStackImplTest {
    @Test
    public void testStackStartsEmpty(){
        MinMaxStack stack=new CustomStack();
        assertTrue(stack.isEmpty());
    }
}