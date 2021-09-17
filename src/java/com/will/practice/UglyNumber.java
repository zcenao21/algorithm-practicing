package com.will.practice;

public class UglyNumber {
    public static void main(String[] args){
        Solution13 solution = new Solution13();
        System.out.println(solution.isUgly(4));
    }
}

class Solution13 {
    public boolean isUgly(int n) {
        if(n<=0) return false;
        while(n%2==0){
            n/=2;
        }
        while(n%3==0){
            n/=3;
        }
        while(n%5==0){
            n/=5;
        }
        if(n==1) return true;
        return false;
    }
}
