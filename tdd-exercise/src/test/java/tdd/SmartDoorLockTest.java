package tdd;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SmartDoorLockTest {

    SmartDoorLock smartDoor;
    final int PIN=1234;

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

}
