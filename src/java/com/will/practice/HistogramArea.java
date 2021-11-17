package com.will.practice;

import jdk.internal.org.objectweb.asm.Handle;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

// 每到一个节点计算左右最大值，得到最大蓄水量,复杂度O(n^2)
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minimizedMaximum(6, new int[]{11,6}));
        System.out.println(solution.minimizedMaximum(7, new int[]{15,10,10}));
        System.out.println(solution.minimizedMaximum(1, new int[]{10000}));
    }

    public int trap(int[] height) {
        int area = 0;
        for(int i=1;i<height.length;i++){
            int maxLeft = i,maxRight = i;
            int j=i;
            while(--j>=0){
                if(height[j]>height[maxLeft]){
                    maxLeft = j;
                }
            }
            j = i;
            while(++j<height.length){
                if(height[j]>height[maxRight]){
                    maxRight = j;
                }
            }
            if(maxLeft!=i&&maxRight!=i){
                area += Math.min(height[maxLeft], height[maxRight])-height[i];
            }
        }
        return area;
    }

    public int minimizedMaximum(int n, int[] quantities) {
        if(n<quantities.length) return -1;
        int left = 1, right=1;
        for(int num:quantities){
            right=Math.max(right,num);
        }

        int mid=0;
        while(left<right){
            mid = (left+right)>>1;
            int cnt=0;
            for(int num:quantities){
                if(num%mid==0){
                    cnt+=num/mid;
                }else{
                    cnt+=num/mid+1;
                }
            }
            if(cnt<n){
                right=mid;
            }else if(cnt>n){
                left=mid+1;
            }else{
                right=mid;
            }
        }
        return left;
    }
}