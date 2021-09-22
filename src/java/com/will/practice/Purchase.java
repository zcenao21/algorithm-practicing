package com.will.practice;

public class Purchase {
    public static void main(String[] args) {
        int[] nums = new int[]{40330,31957,63879,13204,47923,56282,75126,3423,98483};
        int target = 60482;
        Solution4 solution = new Solution4();
        System.out.println(solution.purchasePlans(nums,target));
    }
}

class Solution4 {
    public int purchasePlans(int[] nums, int target) {
        int plans = 0;
        quickSort(nums, 0, nums.length-1);
        for(int i=0,j=nums.length-1;i<j;){
            if(nums[i]+nums[j]<=target){
                plans+=j-i;
                i++;
            }else{
                j--;
            }
        }

        return plans%1000000007;
    }

    public void quickSort(int[] nums, int start, int end){
        if(start>=end) return;
        int comp = start;
        for(int i=start+1;i<=end;i++){
             if(nums[i]<nums[comp]){
                int temp = nums[i];
                for(int k=i;k>comp;k--){
                    nums[k]=nums[k-1];
                }
                nums[comp]=temp;
                comp = comp+1;
            }
        }
        quickSort(nums,start,comp-1);
        quickSort(nums,comp+1,end);
    }
}