package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tdd.implementations.SmartDoor;
import tdd.interfaces.SmartDoorLock;

import static org.junit.jupiter.api.Assertions.*;

public class SmartDoorLockTest {

    private static final String PIN="1234";
    private static final String WRONG_PIN = "4321";
    private static final String NOT_NUMERIC_PIN ="abcd";
    private static final String SMALL_PIN="1";

    private static final int MAX_ATTEMPTS = 5;
    SmartDoorLock smartDoor;


    @BeforeEach
    public void beforeEach(){
        smartDoor=new SmartDoor();
    }

    public void setPinAndClose(){
        smartDoor.setPin(PIN);
        smartDoor.lock();
    }

    public void manyWrongAttempts(){
        for (int i = 0; i <MAX_ATTEMPTS; i++) {
            smartDoor.unlock(WRONG_PIN);
        }
    }

    @Test
    public void testInitiallyOpen() {
        assertFalse(smartDoor.isLocked());
    }

    @Test
    public void testSetPin(){
        if(!smartDoor.isLocked()) {
            smartDoor.setPin(PIN);
            assertFalse(smartDoor.isLocked());
        }
    }

    @Test
    public void testCloseDoor(){
        setPinAndClose();
        assertTrue(smartDoor.isLocked());
    }

    @Test
    public void testOpenDoor(){
        setPinAndClose();
        smartDoor.unlock(PIN);
        assertFalse(smartDoor.isLocked());
    }

    @Test
    public void testOpenDoorWrongPin(){
        setPinAndClose();
        smartDoor.unlock(WRONG_PIN);
        assertTrue(smartDoor.isLocked());
    }

    @Test
    public void testBlockDoor(){
        setPinAndClose();
        manyWrongAttempts();
        assertTrue(smartDoor.isBlocked());
    }

    @Test
    public void testBlockDoorAndOpen(){
        setPinAndClose();
        manyWrongAttempts();
        smartDoor.unlock(PIN);
        assertTrue(smartDoor.isLocked());
    }

    @Test
    public void testGetMaxAttempts(){
        assertEquals(smartDoor.getMaxAttempts(), MAX_ATTEMPTS);
    }

    @Test
    public void testSetPinWhenClosed(){
        setPinAndClose();
        assertThrows(IllegalStateException.class, ()->smartDoor.setPin(WRONG_PIN));
    }

    @Test
    public void testSetPinWhenBlocked(){
        setPinAndClose();
        manyWrongAttempts();
        assertThrows(IllegalStateException.class, ()->smartDoor.setPin(WRONG_PIN));
    }

    @Test
    public void testLockWithoutPin(){
        assertThrows(IllegalStateException.class, ()->smartDoor.lock());
    }

    @Test
    public void testSetInvalidPin(){
        assertAll(
                ()->assertThrows(IllegalArgumentException.class, ()->smartDoor.setPin(SMALL_PIN)),
                ()->assertThrows(IllegalArgumentException.class, ()->smartDoor.setPin(NOT_NUMERIC_PIN))
        );
    }




}
