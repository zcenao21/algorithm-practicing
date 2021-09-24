package com.will.practice.pkg;

import java.util.HashMap;
import java.util.Map;

public class Package01 {
    static int[][] Q=new int[1001][20001];

    // 1≤N≤1000,1≤V≤20000
    // 每件物品的体积和价值范围在[1,500]
    public static long maxValue(int V, int N, int[] sizes, int[] values){
        for(int j=1;j<=sizes.length;j++){
            for(int v=1;v<=V;v++){
                if(v-sizes[j-1]>0){
                    Q[j][v]=Math.max(Q[j-1][v-sizes[j-1]]+values[j-1],Q[j-1][v]);
                }else{
                    Q[j][v]=Q[j-1][v];
                }
            }
        }

        return Q[N][V];
    }

    public static void main(String[] args) {
        int V = 6;
        int N = 3;
        int[] sizes=new int[]{3,2,4};
        int[] values=new int[]{5,4,2};

        System.out.println(maxValue(V, N, sizes,values));
    }
}
