package com.will.practice;

public class FindSmallestInArr {
    public static void main(String[] args){
        Solution12 solution = new Solution12();
        int[] nums = new int[]{4};
        System.out.println(solution.findMin(nums));
    }
}

class Solution12 {
    public int findMin(int[] nums) {
        int left=0,right=nums.length-1;
        int mid;
        while(left<=right){
            if(nums[left]==nums[right]){
                right--;
            }else{
                mid=(left+right)/2;
                if(nums[mid]>nums[right]){
                    left=mid+1;
                }else if(nums[mid]==nums[right]) {
                    right--;
                }else{
                    right=mid;
                }
            }
        }
        return nums[left];
    }
}