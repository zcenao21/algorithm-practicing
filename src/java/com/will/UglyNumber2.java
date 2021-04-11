package com.will;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 第n个丑数
 * https://leetcode-cn.com/problems/ugly-number-ii/solution/
 */
public class UglyNumber2 {
    public static void main(String[] args){
        Solution15 solution = new Solution15();
        System.out.println(solution.nthUglyNumber(122));
    }
}

/**
 * 解法１：使用最小堆
 * 每次弹出堆顶元素，将它乘以2,3,5,再压入３个数进入堆
 * 需要注意：元素可能重复，比如2*5和5*2是相同值，需要借助set去重
 * 此方法缺点是使用了额外的最大堆和Set空间
 */
class Solution14 {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> queue = new PriorityQueue();
        Set<Long> uniqNums = new HashSet();
        int cnt=1;
        int num=1;
        queue.add(1L);
        while(cnt<=n){
            num = queue.poll().intValue();
            cnt++;
            if(!uniqNums.contains(num*2L)){
                uniqNums.add(num*2L);
                queue.add(num*2L);
            }
            if(!uniqNums.contains(num*3L)){
                uniqNums.add(num*3L);
                queue.add(num*3L);
            }
            if(!uniqNums.contains(num*5L)){
                uniqNums.add(num*5L);
                queue.add(num*5L);
            }
        }
        return num;
    }
}

/**
 * 三指针法
 * 这种解法的好处在于空间复杂度比较低，只需要一个额外数组
 * 主要思想是维护４个指针，前三个表示某元素乘以2,3,5前的位置，第四个表示丑数数组当前计算到的地方
 * 经过分析可以得到，每一个丑数都可以由前某个元素乘以2/3/5得到，所以维护３个指针表示做乘法运算前的位置
 */
class Solution15 {
    public int nthUglyNumber(int n) {
        int[] result = new int[1691];
        int i=0,j=0,k=0;
        result[0]=1;
        int cnt=1;
        while(cnt<n) {
            int min = Math.min(Math.min(result[i]*2,result[j]*3),result[k]*5);
            if(result[i]*2==min) i++;
            if(result[j]*3==min) j++;
            if(result[k]*5==min) k++;
            result[cnt]=min;
            cnt++;
        }
        return result[cnt-1];
    }
}