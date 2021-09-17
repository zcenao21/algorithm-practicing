package com.will.practice;

public class MaximumNumber {
    public static void main(String[] args){
        Solution16 solution = new Solution16();
        int[] nums = new int[]{1};
        int[] nums1 = new int[]{1,2};
        int[] nums2 = new int[]{10,2};
        int[] nums3 = new int[]{1,20};
        int[] nums5 = new int[]{432,43243};
        int[] nums4 = new int[]{11,21,210,198,342,132,54,3};
        int[] nums6 = new int[]{0,0,0};
        System.out.println(solution.largestNumber(nums6));
    }
}

class Solution16 {
    public String largestNumber(int[] nums) {
        if(nums==null || nums.length<1) return "";

        fastSort(nums,0, nums.length-1);
        if(nums[nums.length-1]==0) return "0";
        StringBuilder s = new StringBuilder();
        for(int i=nums.length-1;i>=0;i--){
            s.append(nums[i]);
        }
        return s.toString();
    }

    public void fastSort(int[] nums, int start, int end){
        if(start>=end) return;
        int mid = start;
        for(int i=start+1;i<=end;i++){
            if(compare2IntStr(nums[mid], nums[i])){
                int temp = nums[i];
                for(int j=i;j>mid;j--){
                    nums[j] = nums[j-1];
                }
                nums[mid]=temp;
                mid = mid+1;
            }
        }
        fastSort(nums, start, mid-1);
        fastSort(nums, mid+1, end);
    }

    public boolean compare2IntStr(int input1, int input2){
        String first = Integer.valueOf(input1).toString();
        String second = Integer.valueOf(input2).toString();

        String firstSecond = first+second;
        String secondFirst = second + first;

        for(int i=0;i<firstSecond.length();i++){
            int compResult = compare2IntChar(firstSecond.charAt(i), secondFirst.charAt(i%second.length()));
            if(compResult > 0){
                return true;
            }else if(compResult == 0){
                continue;
            }else{
                return false;
            }
        }

        return false;
    }

    public int compare2IntChar(Character str1, Character str2){
        int v1 = Integer.valueOf(str1);
        int v2 = Integer.valueOf(str2);
        if(v1 > v2){
            return 1;
        }else if( v1 == v2){
            return 0;
        }else{
            return -1;
        }
    }
}
