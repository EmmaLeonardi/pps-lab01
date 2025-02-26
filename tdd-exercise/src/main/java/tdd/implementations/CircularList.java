package tdd.implementations;

import tdd.interfaces.CircularQueue;

import java.util.ArrayList;
import java.util.List;

public class CircularList implements CircularQueue {

    private final int maxSizeQueue;
    private final List<Integer> queue;
    private final static int DEFAULT_QUEUE_LENGTH =5;

    public CircularList(final int size){
        this.maxSizeQueue=size>0?size: DEFAULT_QUEUE_LENGTH;
        this.queue= new ArrayList<>();
    }

    public CircularList(){
        this(DEFAULT_QUEUE_LENGTH);
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
        if(this.getSize()==this.getMaxSize()){
            queue.removeFirst();
        }
        queue.add(element);
    }

    @Override
    public int removeOldest() {
        if(!queue.isEmpty()){
            return queue.removeFirst();
        }else{
            throw new IllegalStateException("Can't remove an element from an empty list");
        }
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public int removeNewest() {
        if(!queue.isEmpty()){
            return queue.removeLast();
        }else{
            throw new IllegalStateException("Can't remove an element from an empty list");
        }
    }

    @Override
    public String toString() {
        StringBuilder queueString= new StringBuilder();
        for(var element : queue){
            queueString.append(element).append(" ");
        }
        return queueString.toString();
    }
}
