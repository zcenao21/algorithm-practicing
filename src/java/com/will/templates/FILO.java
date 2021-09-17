package com.will.templates;

import java.util.LinkedList;

public class FILO<T> {
    private LinkedList list = new LinkedList<T>();
    public void put(T ele){
        list.addFirst(ele);
    }

    public T pull(){
        return (T)list.removeFirst();
    }

    public int size(){
        return list.size();
    }
}
