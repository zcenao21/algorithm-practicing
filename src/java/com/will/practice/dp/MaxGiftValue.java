package com.will.practice.dp;

/**
 * 2021/10/21
 * 动态规划求礼物最大价值问题
 * https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof/
 */
public class MaxGiftValue {
    public int maxValue(int[][] grid) {
        if(grid.length==0) return 0;
        int row = grid.length, col = grid[0].length;
        int[][] gridMaxValue = new int[row][col];
        gridMaxValue[0][0]=grid[0][0];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(i-1<0&&j-1<0) continue;
                if(i-1<0){
                    gridMaxValue[i][j]=gridMaxValue[i][j-1]+grid[i][j];
                }else if(j-1<0){
                    gridMaxValue[i][j]=gridMaxValue[i-1][j]+grid[i][j];
                }else{
                    gridMaxValue[i][j]=Math.max(gridMaxValue[i-1][j]+grid[i][j],gridMaxValue[i][j-1]+grid[i][j]);
                }
            }
        }
        return gridMaxValue[row-1][col-1];
    }

    public int maxValue2(int[][] grid) {
        if(grid.length==0) return 0;
        int row = grid.length, col = grid[0].length;
        int[][] gridMaxValue = new int[row+1][col+1];
        gridMaxValue[1][1]=grid[0][0];
        for(int i=1;i<row+1;i++){
            for(int j=1;j<col+1;j++){
                gridMaxValue[i][j]=Math.max(gridMaxValue[i-1][j]+grid[i-1][j-1],gridMaxValue[i][j-1]+grid[i-1][j-1]);
            }
        }
        return gridMaxValue[row][col];
    }

    public static void main(String[] args) {
        MaxGiftValue mg = new MaxGiftValue();
        int result = mg.maxValue2(new int[][]{{1,3,1},{1,5,1},{4,2,1}});
        System.out.println(result);
    }
}
