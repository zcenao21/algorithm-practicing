package com.will.practice;

import java.util.HashMap;
import java.util.Map;

public class PackageInf {
    static int[] values=new int[1001];

    // 1≤N≤1000,1≤V≤20000
    // 每件物品的体积和价值范围在[1,500]
    public static long maxValue(int V, int N, Map<Integer, Integer> sizeAndValue){
        for(int i=1;i<=V;i++){
            for(Map.Entry<Integer,Integer> entry:sizeAndValue.entrySet()){
                if(i-entry.getKey()>=0 && values[i-entry.getKey()]+entry.getValue()>values[i]){
                    values[i]=values[i-entry.getKey()]+entry.getValue();
                }
            }
            if(values[i]<values[i-1]) values[i]=values[i-1];
        }
        return values[V];
    }

    public static void main(String[] args) {
        int V = 6;
        int N = 3;
        Map<Integer,Integer> map=new HashMap<>();
        map.put(3,5);
        map.put(2,4);
        map.put(4,2);

        System.out.println(maxValue(V, N, map));
    }
}
