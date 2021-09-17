package com.will.algorithm4.tests;

import com.will.algorithm4.BST;

import java.util.Random;

public class PrintTree {
    public static void main(String[] args) {
        BSTPrint<Integer, Integer> tree = new BSTPrint();
        tree.put(4,2);
        tree.put(2,3);
        tree.put(3,4);
        tree.put(12,3);
        tree.put(8,2);
//        tree.middleFirst();
//        System.out.println("=========================");
//        tree.leftFirst();
//        System.out.println("=========================");
//        tree.rightFirst();
//        System.out.println("=========================");
        tree.breadthFirst();
    }
}
