package tdd;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SmartDoorLockTest {

    private static final int WRONG_PIN = 4321;
    private static final int MAX_ATTEMPTS = 5;
    SmartDoorLock smartDoor;
    private static final int PIN=1234;

    @BeforeEach
    public void beforeEach(){
        smartDoor=new SmartDoor();
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
        smartDoor.setPin(PIN);
        smartDoor.lock();
        assertTrue(smartDoor.isLocked());
    }

    @Test
    public void testOpenDoor(){
        smartDoor.setPin(PIN);
        smartDoor.lock();
        smartDoor.unlock(PIN);
        assertFalse(smartDoor.isLocked());
    }

    @Test
    public void testOpenDoorWrongPin(){
        smartDoor.setPin(PIN);
        smartDoor.lock();
        smartDoor.unlock(WRONG_PIN);
        assertTrue(smartDoor.isLocked());
    }

    @Test
    public void testBlockDoor(){
        smartDoor.setPin(PIN);
        for (int i = 0; i <MAX_ATTEMPTS; i++) {
            smartDoor.unlock(WRONG_PIN);
        }
        assertTrue(smartDoor.isBlocked());
    }


}
