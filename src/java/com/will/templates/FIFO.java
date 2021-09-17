package com.will.templates;

import java.util.LinkedList;

public class FIFO<T> {
    private LinkedList list = new LinkedList<T>();
    public void put(T ele){
        list.addLast(ele);
    }

    public T pull(){
        return (T)list.removeFirst();
    }

    public int size(){
        return list.size();
    }
}
