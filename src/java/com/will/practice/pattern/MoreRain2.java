package com.will.practice.pattern;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MoreRain2 {
    class Node{
        int i=0; // 行
        int j=0; // 列
        int height=0; // 高

        public Node(int i,int j,int height){
            this.i=i;
            this.j=j;
            this.height=height;
        }
    }

    public int trapRainWater(int[][] heightMap) {
        // 若某边的长度小于3则直接返回0
        if(heightMap.length<3||heightMap[0].length<3) return 0;
        int xLen = heightMap.length;
        int yLen = heightMap[0].length;

        // 记录是否访问过的数组
        boolean[][] goThrough = new boolean[heightMap.length][heightMap[0].length];

        // 首先将四周的放进最小堆
        PriorityQueue<Node> queue = new PriorityQueue(new Comparator<Node>(){

            @Override
            public int compare(Node o1, Node o2) {
                return Integer.compareUnsigned(o1.height,o2.height);
            }
        });

        for(int i=0;i<xLen;i++){
            queue.add(new Node(i,0,heightMap[i][0]));
            goThrough[i][0]=true;

            queue.add(new Node(i,yLen-1,heightMap[i][yLen-1]));
            goThrough[i][yLen-1]=true;
        }
        for(int j=1;j<yLen-1;j++){
            queue.add(new Node(0,j,heightMap[0][j]));
            goThrough[0][j]=true;

            queue.add(new Node(xLen-1,j,heightMap[xLen-1][j]));
            goThrough[xLen-1][j]=true;
        }


        int result = 0;
        // 开始从最小堆遍历
        while (queue.size()>0){
            Node n = queue.poll();
            // 标记最小元素周围四个元素为已经访问过
            // 如果是第一次访问的点要和最小元素对比，若大于则直接加入队列，否则赋值为
            // 最小元素，接雨水量加上最小元素和此元素的差，再放最小元素到队列中
            // 上,且没有访问过
            result+=checkOnedirection(n.i-1,n.j,n.height, xLen,yLen,heightMap,goThrough,queue);
            // 下
            result+=checkOnedirection(n.i+1,n.j,n.height, xLen,yLen,heightMap,goThrough,queue);
            // 左
            result+=checkOnedirection(n.i,n.j-1,n.height, xLen,yLen,heightMap,goThrough,queue);
            // 右
            result+=checkOnedirection(n.i,n.j+1,n.height, xLen,yLen,heightMap,goThrough,queue);
        }
        return result;
    }

    private int checkOnedirection(int i, int j, int height, int xLen, int yLen, int[][] heightMap, boolean[][] goThrough,PriorityQueue<Node> queue) {
        int rain =0;
        if(isInHeightMap(i,j,xLen,yLen)&&!goThrough[i][j]){
            goThrough[i][j]=true;
            if(height>heightMap[i][j]){
                rain=height-heightMap[i][j];
                heightMap[i][j]=height;
            }
            queue.add(new Node(i,j,heightMap[i][j]));
        }
        return rain;
    }

    public boolean isInHeightMap(int x,int y, int xLen, int yLen){
        if(x>=0&&x<xLen&&y>=0&&y<yLen){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        MoreRain2 m2=new MoreRain2();
        int[][] heightMap ={{2,2,2},{2,1,2},{2,1,2},{2,1,2}};
//        int[][] heightMap ={{3,3,3,3,3},{3,2,2,2,3},{3,2,1,2,3},{3,2,2,2,3},{3,3,3,3,3}};

        System.out.println(m2.trapRainWater(heightMap));
    }
}