package tdd.implementations;

import tdd.interfaces.CircularQueue;

import java.util.ArrayList;
import java.util.List;

public class CircularList implements CircularQueue {

    private final int maxSizeQueue;
    private final List<Integer> queue;

    public CircularList(final int size){
        this.maxSizeQueue=size;
        this.queue=new ArrayList<Integer>();
    }

    public CircularList(){
        this(5);
    }

    public int getMaxSize(){
        return maxSizeQueue;
    }

    @Override
    public int getSize() {
        return queue.size();
    }

    @Override
    public void add(int element) {
        queue.add(element);
    }
}
