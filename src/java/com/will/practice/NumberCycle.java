package com.will.practice;

// 乐团站位问题
//https://leetcode-cn.com/problems/SNJvJP/
public class NumberCycle {
    public static void main(String[] args) {
//        int num = 3;
//        int xPos = 1;
//        int yPos =1;
        int num = 877225311;
        int xPos = 445777399;
        int yPos =843543753;
//        for(int i=0;i<num;i++){
//            for(int j=0;j<num;j++){
//                System.out.println("===================("+i+","+j+")===================");
//                xPos=i;yPos=j;
                Solution10 solution = new Solution10();
                System.out.println(solution.orchestraLayout(num, xPos, yPos));
                Solution11 solution11 = new Solution11();
                System.out.println(solution11.orchestraLayout(num, xPos, yPos));
//            }
//        }

    }
}

class Solution10 {
    public int orchestraLayout(int num, int xPos, int yPos) {
        // 首先找到是第几层
        long upLevel = Math.abs(0-xPos);
        long downLevel = Math.abs(num - 1 -xPos);
        long leftLevel = Math.abs(0-yPos);
        long rightLevel = Math.abs(num - 1 - yPos);
        long level = Math.min(Math.min(upLevel, downLevel), Math.min(leftLevel, rightLevel))+1;

        long steps = 0;
        if(xPos>yPos){
            steps = level * 4*(num-level)-xPos-yPos+2*level-1;
        }else{
            steps = (level-1)*4*(num-level+1)+xPos+yPos-2*level+3;
        }
        return (int)((steps-1)%9+1);
    }
}

class Solution11 {
    public int orchestraLayout(int num, int xPos, int yPos) {
        long x=xPos,y=yPos,n=num;
        if  (x <= y) {
            long  k= Math.min(x, n-1-y);
            return (int)((4*k*(n-k)+1+(x+y-k*2)-1)%9+1);
        }
        long k =Math.min(y, n-1-x)+1 ;
        return   (int)((4*k*(n-k)+1-(x+y-(k-1)*2)-1)%9+1);
    }
}
