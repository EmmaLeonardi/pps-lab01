package tdd.implementations;

import tdd.interfaces.MinMaxStack;

import java.util.*;

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
        return orderedList.getFirst();
    }

    @Override
    public int getMax() {
        return 0;
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
