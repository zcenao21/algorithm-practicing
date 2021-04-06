package com.will;

public class RemoveArrElements {
   public static void main(String[] args){
        Solution7 solution7 = new Solution7();
        int[] nums = new int[]{1,1,1,2,2,3};
        solution7.removeDuplicates(nums);
       System.out.println();
   }
}

class Solution7 {
    public int removeDuplicates(int[] nums) {
        if(nums==null || nums.length<1) return 0;
        int newLen = nums.length;
        Integer eleLast = -10001;
        Integer eleBeforeLast = -10001;
        for(int i=0;i<newLen;i++){
            if(nums[i]==eleLast&&nums[i]==eleBeforeLast){
                for(int j=i+1;j<newLen;j++){
                    nums[j-1]=nums[j];
                }
                i--;
                newLen--;
            }else{
                eleBeforeLast=eleLast;
                eleLast=nums[i];
            }
        }
        return newLen;
    }
}
