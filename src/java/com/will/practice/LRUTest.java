package com.will.practice;

import java.util.HashMap;
import java.util.Map;

class Node {
    public int key, val;
    public Node next, prev;
    public Node(int k, int v) {
        this.key = k;
        this.val = v;
    }
}

public class LRUTest {
    public static void main(String[] args) {
        LRU lru = new LRU();
        lru.setCap(3);
        lru.put(5,6);
        lru.put(1,3);
        lru.put(4,2);
        lru.show();
        lru.put(7,8);
        lru.show();
        lru.get(1);
        lru.show();
        lru.get(4);
        lru.show();
        lru.get(7);
        lru.show();
    }

}


class LRU {
    DoubleList doubleList = new DoubleList();
    Map<Integer,Node> map = new HashMap<>();
    int cap = 0;

    public int get(int key){
        if(!map.containsKey(key)){
            return -1;
        }
        int val = map.get(key).val;
        put(key,val);
        return val;
    }

    public void put(int key, int val){
        Node node = new Node(key, val);

        if(map.containsKey(key)){
            doubleList.remove(map.get(key));
        }else{

            if(doubleList.size>=cap){
                Node remNode = doubleList.removeLast();
                map.remove(remNode);
            }
        }
        doubleList.addFirst(node);
        map.put(key,node);
    }

    public void setCap(int cap){
        this.cap = cap;
    }

    public void show(){
        System.out.println(doubleList.showDoubleList());
    }
}

class DoubleList{
    Node first;
    Node last;
    int size=0;
    public DoubleList(){
        this.first = new Node(0,0);
        this.last = new Node(0,0);
        first.next=last;
        last.prev=first;
    }

    // 队首新增 o(1)
    public void addFirst(Node node){
        Node mNext = first.next;
        first.next=node;
        node.next=mNext;

        node.prev=first;
        mNext.prev=node;
        size++;
    }

    // 删除元素
    public void remove(Node node){
        node.next.prev=node.prev;
        node.prev.next=node.next;
        size--;
    }

    // 删除队尾 o(1)
    public Node removeLast() {
        Node node = last.prev;
        remove(node);
        return node;
    }

    // size o(1)
    public int size(){
        return size;
    }

    public String showDoubleList(){
        StringBuilder sb = new StringBuilder();
        Node node = first.next;
        sb.append("|");
        while(node!=last){
            sb.append("->"+node.val);
            node = node.next;
        }
        return sb.toString();
    }
}
