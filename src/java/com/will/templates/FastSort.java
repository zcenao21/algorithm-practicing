package com.will.templates;

import java.util.LinkedList;

public class FastSort {
    public static void fastSort(int[] nums, int start, int end){
        if(start>=end||start>nums.length-1||end>nums.length-1){
            return;
        }

        int mid = start;
        for(int i=start+1;i<=end;i++){
            if(nums[mid]>nums[i]){
                int temp=nums[i];
                for(int j=i;j>mid;j--){
                    nums[j]=nums[j-1];
                }
                nums[mid]=temp;
                mid=mid+1;
            }
        }
        fastSort(nums,start,mid-1);
        fastSort(nums,mid+1,end);
    }

    public static void main(String[] args) {
        int[] nums={9,10,12,3,4,91,81,7};
        fastSort(nums,100, 110);
        System.out.println();
    }
}
