package tdd.implementations;

import tdd.interfaces.CircularQueue;

public class CircularList implements CircularQueue {

    private final int maxSizeQueue;

    public CircularList(final int size){
        this.maxSizeQueue=size;
    }

    public CircularList(){
        this(5);
    }

    public int getMaxSize(){
        return maxSizeQueue;
    }
}
