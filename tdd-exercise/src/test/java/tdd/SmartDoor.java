package tdd;

public class SmartDoor implements SmartDoorLock {

    private boolean lockedDoor;
    private int pin;

    public SmartDoor(){
        this.lockedDoor=false;
    }

    @Override
    public void setPin(int pin) {
        this.pin=pin;
    }

    @Override
    public void unlock(int pin) {
        if(pin==this.pin){
            this.lockedDoor=false;
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
