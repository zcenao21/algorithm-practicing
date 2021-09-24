package com.will.practice;
import java.util.*;


public class Greedy {
//    /**
//     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
//     * 计算成功举办活动需要多少名主持人
//     * @param n int整型 有n个活动
//     * @param startEnd int整型二维数组 startEnd[i][0]用于表示第i个活动的开始时间，startEnd[i][1]表示第i个活动的结束时间
//     * @return int整型
//     */
//    public int minmumNumberOfHost (int n, int[][] startEnd) {
//        if(n<1||n!=startEnd.length) return -1;
//
//        PriorityQueue<Integer> minStack = new PriorityQueue<>();
//    }

    public static void main(String[] args) {
        PriorityQueue<Integer> minStack = new PriorityQueue<>();

        minStack.add(3);
        minStack.add(9);
        minStack.add(2);
        minStack.add(5);
        minStack.add(7);
        minStack.add(8);
        minStack.add(8);
        minStack.add(6);

        PriorityQueue<Integer> maxStack = new PriorityQueue((o1, o2) -> {
            Integer num1 = (Integer)o1;
            Integer num2 = (Integer)o2;
            return -num1.compareTo(num2);
        });

        maxStack.add(3);
        maxStack.add(9);
        maxStack.add(2);
        maxStack.add(5);
        maxStack.add(7);
        maxStack.add(8);
        maxStack.add(8);
        maxStack.add(6);

        while (minStack.size()>0){
            System.out.println(minStack.poll());
        }

        System.out.println("====================================\n\n\n");

        while (maxStack.size()>0){
            System.out.println(maxStack.poll());
        }

    }
}