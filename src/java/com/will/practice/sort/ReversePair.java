package com.will.practice.sort;

import java.util.Arrays;
import java.util.LinkedList;

public class ReversePair {
    public int reversePairs(int[] nums) {
        return sort(nums,0,nums.length-1);
    }

    private int sort(int[] nums, int left, int right) {
        if(nums.length==0||right-left+1==1){
            return 0;
        }
        int m = (left + right) / 2;

        // 计算左边排完序需要多少次
        int cL = sort(nums, left, m);

        // 计算右边排序需要多少次
        int cR = sort(nums, m+1, right);

        LinkedList<Integer> list = new LinkedList();
        int ptl = left, ptr = m+1, sum = 0;
        while(true){
            if(ptl<=m&&ptr<=right){
                if(nums[ptl]<=nums[ptr]){
                    list.push(nums[ptl]);
                    ptl++;
                }else if(nums[ptl]>nums[ptr]){
                    sum+=m-ptl+1;
                    list.push(nums[ptr]);
                    ptr++;
                }
            }else if(ptl>m&&ptr>right){
                break;
            } else if(ptr>right){
                list.push(nums[ptl]);
                ptl++;
                if(ptl>m){
                    break;
                }
            }else{
                list.push(nums[ptr]);
                ptr++;
                if(ptr>right){
                    break;
                }
            }
        }
        for(int i=left;i<=right;i++){
            nums[i]=list.removeLast();
        }
        return cL + cR + sum;
    }

    public static void main(String[] args) {
        ReversePair pair = new ReversePair();
        int result = pair.reversePairs(new int[]{});
        System.out.println(result);
    }
}

class Solution2 {
    public int reversePairs(int[] nums) {
        int n = nums.length;
        int[] tmp = new int[n];
        System.arraycopy(nums, 0, tmp, 0, n);
        // 离散化
        Arrays.sort(tmp);
        for (int i = 0; i < n; ++i) {
            nums[i] = Arrays.binarySearch(tmp, nums[i]) + 1;
        }
        // 树状数组统计逆序对
        BIT bit = new BIT(n);
        int ans = 0;
        for (int i = n - 1; i >= 0; --i) {
            ans += bit.query(nums[i] - 1);
            bit.update(nums[i]);
        }
        return ans;
    }
}

class BIT {
    private int[] tree;
    private int n;

    public BIT(int n) {
        this.n = n;
        this.tree = new int[n + 1];
    }

    public static int lowbit(int x) {
        return x & (-x);
    }

    public int query(int x) {
        int ret = 0;
        while (x != 0) {
            ret += tree[x];
            x -= lowbit(x);
        }
        return ret;
    }

    public void update(int x) {
        while (x <= n) {
            ++tree[x];
            x += lowbit(x);
        }
    }
}
