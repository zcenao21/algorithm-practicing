package com.will.practice.pattern;

import java.util.HashMap;
import java.util.Map;

public class SubArrEqDiff {
    public int longestSubsequence(int[] arr, int difference) {
        if(arr.length<1) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            int cnt = 1;
            if(map.containsKey(arr[i])){
                cnt = map.get(arr[i]);
                cnt++;
                map.remove(arr[i]);
            }
            if(map.containsKey(arr[i]+difference)){
                int currCnt = map.get(arr[i]+difference);
                map.put(arr[i]+difference,Math.max(cnt,currCnt));
            }else{
                map.put(arr[i]+difference,cnt);
            }
        }

        int result = 1;
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getValue()>result){
                result = entry.getValue();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SubArrEqDiff diff = new SubArrEqDiff();
        System.out.println(diff.longestSubsequence(new int[]{1,5,7,8,5,3,4,2,1},-2));
        System.out.println(diff.longestSubsequence(new int[]{1,2,3,4},1));
        System.out.println(diff.longestSubsequence(new int[]{1,3,5,7},1));
    }
}
