package tdd;

public class SmartDoor implements SmartDoorLock {

    private boolean lockedDoor;

    public SmartDoor(){
        this.lockedDoor=false;
    }

    @Override
    public void setPin(int pin) {

    }

    @Override
    public void unlock(int pin) {
        this.lockedDoor=false;

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
        return false;
    }

    @Override
    public int getMaxAttempts() {
        return 0;
    }

    @Override
    public int getFailedAttempts() {
        return 0;
    }

    @Override
    public void reset() {

    }
}
