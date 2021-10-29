package com.will.practice.graph;

import java.util.HashSet;
import java.util.Set;

public class Dijkstra {
    public static int MAX_INT = Integer.MAX_VALUE;

    class Pair<A,B>{
        A a;
        B b;

        public Pair(A a, B b){
            this.a = a;
            this.b = b;
        }

        public A getKey(){
            return a;
        }

        public B getValue(){
            return b;
        }

        public void setValue(B b){
            this.b = b;
        }

        public void setKey(A a){
            this.a = a;
        }
    }

    public int minLen(int[][] g, int startPos, int endPos){
        Set<Pair<Integer,Integer>> V = new HashSet<>();
        HashSet<Pair<Integer,Integer>> T = new HashSet<>();
        V.add(genPair(startPos,0));
        for(int i=0;i<g.length;i++){
            if(i!=startPos){
                T.add(genPair(i,g[startPos][i]));
            }
        }

        int curr = startPos;
        while(T.size()>0){
            // 首先得到T最小的那个
            Pair<Integer,Integer> smallEle = null;
            int smallest = MAX_INT;
            for(Pair<Integer,Integer> ele:T){
                if(ele.getValue()<smallest){
                    smallEle = ele;
                    smallest = smallEle.getValue();
                }
            }

            // 若所有都是无穷大，说明到不了
            if(smallEle==null){
                return MAX_INT;
            }

            T.remove(smallEle);
            V.add(smallEle);
            for(Pair<Integer,Integer> ele:T){
                // 计算从当前节点出发到其他节点距离
                int sumVal = g[smallEle.getKey()][ele.getKey()]+smallEle.getValue();
                if(sumVal>0&&sumVal<ele.getValue()){
                    ele.setValue(sumVal);
                }
            }
        }

        for(Pair<Integer,Integer> ele:V){
            if(ele.getKey().equals(endPos)){
                return ele.getValue();
            }
        }

        return 0;
    }

    public Pair<Integer,Integer> genPair(Integer node, Integer num){
        return new Pair<>(node, num);
    }

    public static void main(String[] args) {
        int[][] graph = new int[][]{
                 {0,            12,         MAX_INT,        MAX_INT,        MAX_INT,            16,         14}
                ,{12,           0,          10,             MAX_INT,        MAX_INT,            7,          MAX_INT}
                ,{MAX_INT,      10,         0,              3,              5,                  6,          MAX_INT}
                ,{MAX_INT,      MAX_INT,    3,              0,              4,                  MAX_INT,    MAX_INT}
                ,{MAX_INT,      MAX_INT,    5,              4,              0,                  2,          8}
                ,{16,           7,          6,              MAX_INT,        2,                  0,          9}
                ,{14,           MAX_INT,    MAX_INT,        MAX_INT,        8,                  9,          0}
        };
        Dijkstra dj = new Dijkstra();
        int startPosition = 0, endPosition = 3;
        System.out.println(dj.minLen(graph, startPosition, endPosition));
    }
}
