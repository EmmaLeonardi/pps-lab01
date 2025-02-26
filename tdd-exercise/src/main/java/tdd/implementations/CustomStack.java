package tdd.implementations;

import tdd.interfaces.MinMaxStack;

import java.util.*;
import java.util.concurrent.Callable;

public class CustomStack implements MinMaxStack {

    private final List<Integer> stackList;
    private final List<Integer> orderedList;

    public CustomStack(){
        this.stackList =new ArrayList<>();
        this.orderedList=new ArrayList<>();
    }

    @Override
    public void push(int value) {
        stackList.add(value);
        orderedList.add(value);
        Collections.sort(orderedList);
    }

    @Override
    public int pop() {
        if(!stackList.isEmpty()){
            var element= stackList.getLast();
            stackList.removeLast();
            orderedList.remove(element);
            return element;
        }else{
            throw new IllegalStateException("The stack is empty");
        }

    }

    @Override
    public int peek() {
        if(!stackList.isEmpty()){
            return stackList.getLast();
        }else{
            throw new IllegalStateException("The stack is empty");
        }
    }

    @Override
    public int getMin() {
        if(!stackList.isEmpty()){
            return orderedList.getFirst();
        }else{
            throw new IllegalStateException("The stack is empty");
        }
    }

    @Override
    public int getMax() {
        if(!stackList.isEmpty()) {
            return orderedList.getLast();
        }else{
            throw new IllegalStateException("The stack is empty");
        }
    }

    @Override
    public boolean isEmpty() {
        return stackList.isEmpty();
    }

    @Override
    public int size() {
        return stackList.size();
    }
}
