package com.will.practice.pattern;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class MaxNotCotainSubStr {
    public int lengthOfLongestSubstring(String s) {
        if(s==null||s.length()<1) return 0;
        LinkedList<Character> currMax = new LinkedList<>();
        Set<Character> currSet = new HashSet<Character>();
        int maxLen = 0;
        for(int i=0;i<s.length();i++){
            Character c = s.charAt(i);
            if(currSet.contains(c)){
                while(!currMax.getFirst().equals(c)){
                    Character chRemove = currMax.removeFirst();
                    currSet.remove(chRemove);
                }
                currMax.removeFirst();

                currMax.addLast(c);
            }else{
                currMax.addLast(c);
                currSet.add(c);
                maxLen = maxLen < currSet.size()?currSet.size():maxLen;
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        MaxNotCotainSubStr mcs = new MaxNotCotainSubStr();
        System.out.println(mcs.lengthOfLongestSubstring("pwwkew"));
        System.out.println(mcs.lengthOfLongestSubstring("abcabccca"));
        System.out.println(mcs.lengthOfLongestSubstring("abcdef"));
        System.out.println(mcs.lengthOfLongestSubstring("abab"));
        System.out.println(mcs.lengthOfLongestSubstring("baba"));
        System.out.println(mcs.lengthOfLongestSubstring("cccccc"));
    }
}
