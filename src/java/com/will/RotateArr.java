package com.will;

public class RotateArr {
    public static void main(String[] args) {
        Solution9 solution = new Solution9();
        int[] nums = new int[]{2,3,4,5,6,7,8,9,10,0};
        System.out.println(solution.findMin(nums));
    }
}

class Solution8 {
    public boolean search(int[] nums, int target) {
        if(nums==null||nums.length==0) return false;
        // 首先找到原数组的末位元素
        int originArrLastEle = 0;
        // 原数组的首位元素
        int originArrFirstEle = 0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]<nums[i-1]){
                originArrFirstEle = i;
                originArrLastEle = i-1;
                break;
            }
        }

        // 再分别用二分法找是否有指定元素
        return binarySearch(nums, 0, originArrLastEle, target)||binarySearch(nums, originArrFirstEle, nums.length - 1,target);
    }

    public boolean binarySearch(int[] nums, int left, int right, int target){
        if(nums==null || nums.length<1) return false;
        for(int middle = 0;left<=right;){
            middle = (left+right)/2;
            if(nums[middle]>target){
                right=middle-1;
            }else if(nums[middle]<target){
                left = middle +1;
            }else{
                return true;
            }
        }
        return false;
    }
}

// https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
// 旋转数组，每次旋转一个元素
class Solution9 {
    public int findMin(int[] nums) {
        int left=0,right=nums.length-1;
        while(left<right){
            int mid = (left+right)/2;
            if(nums[mid]>nums[right]) {
                left = mid+1;
            }else{
                right = mid;
            }
        }
        return nums[left];
    }
}