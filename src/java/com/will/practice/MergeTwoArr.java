package com.will.practice;

public class MergeTwoArr {
    public static void main(String[] args) {
        Solution6 solution6 = new Solution6();
        int[] nums1 = new int[]{2,5,6};
        int[] nums2 = new int[]{0,0,0};
        int m=3;
        int n=0;
        solution6.merge(nums1,m,nums2,n);
        System.out.println();
    }
}

class Solution6 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int k=nums1.length-1,i=m-1,j=n-1;k>=0;k--){
            if(j<0||(i>=0 && nums1[i]>=nums2[j])){
                nums1[k]=nums1[i];
                i--;
                continue;
            }
            if(i<0|| ( j>=0 && nums1[i]<nums2[j])){
                nums1[k]=nums2[j];
                j--;
                continue;
            }
        }
    }
}