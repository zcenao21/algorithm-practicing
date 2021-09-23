package com.will;

//  重建二叉树
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
                TreeNode left = reConstructBinaryTreeInner(pre,preStart+1,preStart+i-vinStart,vin,vinStart,i-1);
                TreeNode right = reConstructBinaryTreeInner(pre,preStart+i-vinStart+1,preEnd,vin,i+1,vinEnd);
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
//        int[] pre=new int[]{1,2,4,7,3,5,6,8};
//        int[] vin=new int[]{4,7,2,1,5,3,8,6};
//        int[] pre=new int[]{1};
//        int[] vin=new int[]{1};
        int[] pre=new int[]{4,2,7,6,8,9,3,2};
        int[] vin=new int[]{7,2,6,4,3,2,9,8};
        RebuildBST rebuildBST = new RebuildBST();
        TreeNode root= rebuildBST.reConstructBinaryTree(pre,vin);
        System.out.println();
    }
}
