package com.will.practice.pattern;

import java.sql.Connection;
import java.util.Arrays;
import java.util.Comparator;

public class ConcatStrnNumMax {
    public String minNumber(int[] nums) {
        if(nums.length==0) return "0";
        if(nums.length==1) return ""+nums[0];
        // 快排排序
        fastSort(nums,0,nums.length-1);
        // 输出结果
        StringBuilder result = new StringBuilder();
        for(int i=0;i<nums.length;i++){
            result.append(nums[i]);
        }
        return result.toString();
    }

    public void fastSort(int[] nums, int start, int end){
        if(nums.length<1||end-start<1) return;
        int mid = start;
        for(int i=start+1;i<=end;i++){
            if(larger(nums[mid],nums[i])){
                int temp = nums[i];
                for(int j=i;j>mid;j--){
                    nums[j]=nums[j-1];
                }
                nums[mid]=temp;
                mid++;
            }
        }
        fastSort(nums,start,mid-1);
        fastSort(nums,mid+1,end);
    }

    // 组成的顺序要改变时返回true
    public boolean larger(int num1, int num2){
        String strN1 = ""+num1+num2;
        String strN2 = ""+num2+num1;
        for(int i=0;i<strN1.length();i++){
            if(strN1.charAt(i)<strN2.charAt(i)){
                return false;
            }else if(strN1.charAt(i)>strN2.charAt(i)){
                return true;
            }
        }
        return false;
    }

    public String minNumber2(int[] nums) {
        Integer[] numsInt = new Integer[nums.length];
        for(int i=0;i<nums.length;i++){
            numsInt[i]=nums[i];
        }
        Arrays.sort(numsInt, (t, t1) -> (t.toString()+t1.toString()).compareTo(t1.toString()+t.toString()));
        StringBuilder result = new StringBuilder();
        for(int i=0;i<numsInt.length;i++){
            result.append(numsInt[i]);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        ConcatStrnNumMax csn = new ConcatStrnNumMax();
        System.out.println(csn.minNumber2(new int[]{}));
        System.out.println(csn.minNumber2(new int[]{0}));
        System.out.println(csn.minNumber2(new int[]{1,2,6,3}));
        System.out.println(csn.minNumber2(new int[]{10,0,21,3}));
        System.out.println(csn.minNumber2(new int[]{3,30,34,5,9}));
        System.out.println(csn.minNumber2(new int[]{4,40,44,444,41,2}));


    }
}
