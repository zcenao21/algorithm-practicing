package com.will.practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

// 主持人调度问题
public class CompereSchedule extends Thread {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 计算成功举办活动需要多少名主持人
     * @param n int整型 有n个活动
     * @param startEnd int整型二维数组 startEnd[i][0]用于表示第i个活动的开始时间，startEnd[i][1]表示第i个活动的结束时间
     * @return int整型
     */
    public int minmumNumberOfHost (int n, int[][] startEnd) {
        if(n<1||startEnd.length!=n) return -1;

        // 按照开始时间排序
        Arrays.sort(startEnd, Comparator.comparingInt((int[] o) -> o[0]));

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(startEnd[0][1]);

        for(int i=1;i<startEnd.length;i++) {
            if (queue.peek() <= startEnd[i][0]) {
                queue.poll();
                queue.add(startEnd[i][1]);
            } else {
                queue.add(startEnd[i][1]);
            }
        }
        return queue.size();

    }

    public static void main(String[] args) {
        CompereSchedule compereSchedule=new CompereSchedule();
        int[][] arr = new int[][]{
                {348,813},{340,385},{465,676},{64,400},{744,959},{130,974},{769,963},{269,901},{406,880},{30,980},{439,854},{451,658}
                ,{341,650},{40,796},{332,982},{14,647},{777,787},{614,823},{74,545},{114,199},{406,665},{546,943},{577,806},{640,986},{499,866},{392,554},{388,693},{191,622},{586,997},{114,808},{41,775},{52,884},{184,718},{118,938},{224,498},{78,746},{87,672},{117,216},{66,313},{605,874},{41,876},{269,771},{180,368},{462,677},{185,736},{136,188},{178,821},{195,931}
        };
        int result=compereSchedule.minmumNumberOfHost(48,arr);
        System.out.println(result);
    }
}