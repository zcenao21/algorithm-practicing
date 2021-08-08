package com.will;

import java.util.Stack;

public class MinDistanceBetweenTreeNode {
    public static void main(String[] args){
        Solution17 solution = new Solution17();
        TreeNode root = new TreeNode(4);
        TreeNode left1 = new TreeNode(2);
        TreeNode right1 = new TreeNode(6);
        root.left = left1;
        root.right = right1;

        TreeNode left21=new TreeNode(1);
        TreeNode left22=new TreeNode(3);
        left1.left=left21;
        left1.right=left22;
        System.out.println(solution.minDiffInBST(root));
    }
}

class Solution17 {
    int minDiff;
    public int minDiffInBST(TreeNode root) {
        int lastVal = 0;
        minDiff = Integer.MAX_VALUE;
        minDiffInBST2(root, lastVal);
        return minDiff;
    }

    public int minDiffInBST2(TreeNode root, int lastVal){
        if(root==null) return Integer.MAX_VALUE;
        if(root.left!=null){
            lastVal = minDiffInBST2(root.left, lastVal);
        }
        minDiff = Math.min(minDiff, Math.abs(root.val - lastVal));
        lastVal = root.val;
        if(root.right!=null){
            lastVal = minDiffInBST2(root.right, lastVal);
        }
        return lastVal;
    }
}

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode() {}
  TreeNode(int val) { this.val = val; }
  TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
  }
}