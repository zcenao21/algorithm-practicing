package com.will.algorithm4;

public class RedBlackTree<K extends Comparable<K>,V> {
    public Node root;

    enum Color{
        BLACK, RED;
    }

    private class Node{
        K key; // 节点键
        V value; // 节点值
        int N;  // 子节点个数
        Color color;
        Node left, right;
        public Node(K key, V value, int N, Color color){
            this.key=key;
            this.value=value;
            this.N=N;
            this.color=color;
        }
    }

    /**
     * 插入
     * @param key
     * @param value
     * @return
     */
    public Node put(K key, V value){
        //
        if(root==null){
            return new Node(key, value, 0,Color.BLACK);
        }
        return null;
    }


}
