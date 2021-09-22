package com.will;

public class RebuildBST {
    public TreeNode reConstructBinaryTree(int [] pre,int [] vin) {
        if(pre.length<1||vin.length<1){
            return null;
        }

        return reConstructBinaryTreeInner(pre, 0, pre.length-1, vin, 0, vin.length-1);
    }

    private TreeNode reConstructBinaryTreeInner(int[] pre, int preStart, int preEnd, int[] vin, int vinStart, int vinEnd) {
        if(preStart>preEnd||vinStart>vinEnd) return null;

        TreeNode root = new TreeNode(pre[preStart]);
        for(int i=vinStart;i<=vinEnd;i++){
            if(vin[i]==root.val){
                TreeNode left = reConstructBinaryTreeInner(pre,preStart+1,preStart+1+i-vinStart,vin,vinStart,i-1);
                TreeNode right = reConstructBinaryTreeInner(pre,i+1,preEnd,vin,i+1,vinEnd);
                root.left = left;
                root.right = right;
                return root;
            }
        }
        return root;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {

    }
}
