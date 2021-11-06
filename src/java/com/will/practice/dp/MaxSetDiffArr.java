package com.will.practice.dp;

import java.util.HashMap;
import java.util.Map;

public class MaxSetDiffArr {
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer,Integer> map = new HashMap<>();
        int maxRes = 0;
        for(int num:arr){
            map.put(num,map.getOrDefault(num-difference,0)+1);
            maxRes=Math.max(maxRes,map.get(num));
        }
        return maxRes;
    }

    public static void main(String[] args) {
        MaxSetDiffArr arr = new MaxSetDiffArr();
        int rest = arr.longestSubsequence(new int[]{1,5,7,8,5,3,4,2,1},-2);
        System.out.println(rest);
    }
}
