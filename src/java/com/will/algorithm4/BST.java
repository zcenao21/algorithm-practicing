package com.will.algorithm4;

import java.util.LinkedList;
import java.util.Queue;

public class BST<Key extends Comparable<Key>, Value> {
    private Node root;

    private class Node{
        private Key key;
        private Value value;
        private Node left, right;
        private int N;

        public Node(Key key, Value value, int N){
            this.key = key;
            this.value = value;
            this.N = N;
        }
    }

    public int size(){
        return size(root);
    }

    private int size(Node x){
        if(x == null){
            return 0;
        }else{
            return x.N;
        }
    }

    public void put(Key key, Value value){
        root = put(root, key, value);
    }

    private Node put(Node x, Key key, Value value){
        if(x==null) return new Node(key, value,1);
        int comp = key.compareTo(x.key);
        if(comp<0){
            x.left=put(x.left,key,value);
        }else if(comp>0){
            x.right=put(x.right,key,value);
        }else{
            x.value = value;
        }
        x.N=size(x.left)+size(x.right)+1;
        return x;
    }

    public void middleFirst(){
        middleFirst(root);
    }

    private void middleFirst(Node root){
        if(root==null){
            System.out.println("null");
            return;
        }
        System.out.println(root.value);
        middleFirst(root.left);
        middleFirst(root.right);
    }

    public void leftFirst(){
        leftFirst(root);
    }

    private void leftFirst(Node root){
        if(root==null){
            System.out.println("null");
            return;
        }
        leftFirst(root.left);
        System.out.println(root.value);
        leftFirst(root.right);
    }

    public void rightFirst(){
        rightFirst(root);
    }

    private void rightFirst(Node root){
        if(root==null){
            System.out.println("null");
            return;
        }
        rightFirst(root.left);
        rightFirst(root.right);
        System.out.println(root.value);
    }

    public void breadthFirst(){
        breadthFirst(root);
    }

    public void breadthFirst(Node root){
        Queue<Node> stack = new LinkedList<>();
        Node node = root;
        stack.add(node);
        while(stack.size()>0){
            Node currNode = stack.poll();
            if(currNode==null){
                System.out.println("null");
            } else{
                System.out.println(currNode.value);
            }
            if(currNode!=null){
                stack.add(currNode.left);
                stack.add(currNode.right);
            }
        }
    }
}
