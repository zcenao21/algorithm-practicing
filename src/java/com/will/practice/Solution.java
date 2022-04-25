package com.will.practice;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


public class Solution implements Serializable {
    public static void main(String[] args) {
        Solution s = new Solution();
        Map<String,String> map = new HashMap<>();
        map.put("A","A1");
        map.put("A1","A2");
        map.put("A2","A3");
        map.put("A3","A4");
        map.put("B","B1");
        map.put("B1","B2");
        map.put("B2","B3");

        Map<String,String> result = s.findFirst(map);
        System.out.println(result.get("A2"));
        System.out.println(result.get("A1"));
        System.out.println(result.get("A3"));
        System.out.println(result.get("B1"));
        System.out.println(result.get("B2"));
        System.out.println(result.get("B3"));
    }

    public Map<String,String> findFirst(Map<String,String> map){
        Map<String,String> firstMap = new HashMap<>();
        for(Map.Entry<String,String> entry:map.entrySet()) {
            firstMap.put(entry.getValue(),entry.getKey());
        }
        for(Map.Entry<String,String> entry:map.entrySet()){
            String out = entry.getValue();
            String next = out;
            if(firstMap.containsKey(out)){
                next = firstMap.get(out);
                while(firstMap.containsKey(next)){
                    next = firstMap.get(next);
                }
            }
            firstMap.put(out,next);
        }
        return firstMap;
    }

}

