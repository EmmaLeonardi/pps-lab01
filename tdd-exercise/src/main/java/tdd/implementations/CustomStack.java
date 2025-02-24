package tdd.implementations;

import tdd.interfaces.MinMaxStack;

import java.util.ArrayList;
import java.util.List;

public class CustomStack implements MinMaxStack {

    private final List<Integer> list;

    public CustomStack(){
        this.list=new ArrayList<>();
    }

    @Override
    public void push(int value) {
        list.add(value);
    }

    @Override
    public int pop() {
        if(!list.isEmpty()){
            var element=list.getLast();
            list.removeLast();
            return element;
        }else{
            throw new IllegalStateException("The stack is empty");
        }

    }

    @Override
    public int peek() {
        if(!list.isEmpty()){
            return list.getLast();
        }else{
            throw new IllegalStateException("The stack is empty");
        }
    }

    @Override
    public int getMin() {
        return 0;
    }

    @Override
    public int getMax() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int size() {
        return list.size();
    }
}
