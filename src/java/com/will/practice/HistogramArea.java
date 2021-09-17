package com.will.practice;

import java.util.Stack;

public class HistogramArea {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();
        Solution3 solution3 = new Solution3();
//        int[] a = {9,6,8,8,5,6,3};
        int[] a = {0,1,0,2,1,0,1,3,2,1};
        System.out.println(solution.trap(a));
        System.out.println(solution2.trap(a));
        System.out.println(solution3.trap(a));
    }
}

// 每到一个节点计算左右最大值，得到最大蓄水量,复杂度O(n^2)
class Solution {
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
}

// 简化上述方法，先得到每个节点左右最大值，遍历三遍，复杂度O(n)
class Solution2 {
    public int trap(int[] height) {
        if(height==null||height.length<1) return 0;
        // 记录每个位置左侧最大值和右侧最大值
        int[] maxLeftArr = new int[height.length];
        int[] maxRightArr = new int[height.length];
        maxLeftArr[0]=height[0];
        for(int i=1;i<height.length;i++){
            maxLeftArr[i]=Math.max(maxLeftArr[i-1],height[i]);
        }
        maxRightArr[height.length-1]=height[height.length-1];
        for(int i=height.length-2;i>=0;i--){
            maxRightArr[i]=Math.max(maxRightArr[i+1],height[i]);
        }
        int area=0;
        for(int i=0;i<height.length;i++){
            area += Math.min(maxLeftArr[i], maxRightArr[i])-height[i];
        }
        return area;
    }
}

// 递减堆栈法
class Solution3 {
    public int trap(int[] height) {
        int area = 0;
        Stack<Integer> stack = new Stack();
        for(int i=0;i<height.length;i++){
            if(stack.isEmpty()){
                stack.push(i);
                continue;
            }
            if(height[stack.peek()]>height[i]){
                stack.push(i);
                continue;
            }else if(height[stack.peek()]==height[i]){
                stack.pop();
                stack.push(i);
                continue;
            }else{
                // 当堆栈中元素个数少于２个时，无法盛水
                if(stack.size()<2){
                    stack.pop();
                    stack.push(i);
                    continue;
                }
                int top1 = stack.pop();
                int top2 = stack.peek();
                area += (Math.min(height[i], height[top2])-height[top1])*(i-top2-1);
                if(height[i]>=height[top2]){
                    i--;
                }else{
                    stack.push(i);
                }
            }
        }
        return area;
    }
}