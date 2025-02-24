package tdd.implementations;

import tdd.interfaces.SmartDoorLock;

public class SmartDoor implements SmartDoorLock {

    private boolean lockedDoor;
    private boolean blockedDoor;
    private int pin;
    private int attempts;

    private final static int MAX_ATTEMPTS=5;


    public SmartDoor(){
        this.lockedDoor=false;
        this.blockedDoor=false;
        this.attempts=0;
    }

    @Override
    public void setPin(final int pin) {
        this.pin=pin;
    }

    @Override
    public void unlock(final int pin) {
        if(pin==this.pin&&!this.blockedDoor){
            this.lockedDoor=false;
        }else{
            this.attempts++;
            if(this.attempts==MAX_ATTEMPTS) {
                this.blockedDoor=true;
            }
        }
    }

    @Override
    public void lock() {
        this.lockedDoor=true;
    }

    @Override
    public boolean isLocked() {
        return this.lockedDoor;
    }

    @Override
    public boolean isBlocked() {
        return this.blockedDoor;
    }

    @Override
    public int getMaxAttempts() {
        return MAX_ATTEMPTS;
    }

    @Override
    public int getFailedAttempts() {
        return 0;
    }

    @Override
    public void reset() {

    }
}
