package tdd.implementations;

import tdd.interfaces.SmartDoorLock;

public class SmartDoor implements SmartDoorLock {

    private boolean lockedDoor;
    private boolean blockedDoor;
    private String pin;
    private int attempts;

    private final static int MAX_ATTEMPTS=5;


    public SmartDoor(){
        this.lockedDoor=false;
        this.blockedDoor=false;
        this.attempts=0;
        this.pin=null;
    }

    @Override
    public void setPin(final String pin) {
        if(!this.lockedDoor&&!this.blockedDoor){
            if(isPinLegal(pin)){
                this.pin=pin;
            }else{
                throw new IllegalArgumentException("Pin must be 4 digits");
            }
        }else{
            if(this.lockedDoor){
                throw new IllegalStateException("Can't set the pin when the door is closed");
            }else if(this.blockedDoor){
                throw new IllegalStateException("Can't set the pin when the door is blocked");
            }
        }
    }

    private boolean isPinLegal(String pin) {
        if(pin.length()==4){
            try {
                Integer.parseInt(pin);
                return true;
            }catch (NumberFormatException e){
                return false;
            }
        }
        return false;
    }

    @Override
    public void unlock(final String pin) {
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
        if(pin==null){
            throw new IllegalStateException("Can't lock the door when the pin is not set");
        }else{
            this.lockedDoor=true;
        }
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
