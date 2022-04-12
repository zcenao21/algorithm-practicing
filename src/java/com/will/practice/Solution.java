package com.will.practice;
import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public String toString(){
        return this.val+"";
    }
}


public class Solution implements Serializable {
    public static void main(String[] args) {
        Solution s = new Solution();
//        List<Integer> result=s.findMinHeightTrees(4,new int[][]{{1,0},{1,2},{1,3}});
//        List<Integer> result=s.findMinHeightTrees(6,new int[][]{{3,0},{3,1},{3,2},{3,4},{5,4}});
//        List<Integer> result=s.findMinHeightTrees(4,new int[][]{{3,0},{3,1},{1,9},{3,2},{2,6},{6,8},{6,7},{3,4},{4,5},{4,10},{10,11}});
//        List<Integer> result=s.findMinHeightTrees(1,new int[][]{});
        List<Integer> result=s.findMinHeightTrees(2,new int[][]{{0,1}});
        System.out.println(result);
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n<=1){
            List<Integer> result = new LinkedList<>();
            result.add(0);
            return  result;
        }
        Map<Integer, Set<Integer>> nodeAndNext = new HashMap<>();
        for(int[] edge:edges){
            int first = edge[0];
            int second = edge[1];
            Set<Integer> firstSet = nodeAndNext.containsKey(first)?nodeAndNext.get(first):new HashSet<>();
            firstSet.add(second);
            nodeAndNext.put(first,firstSet);

            Set<Integer> secondSet = nodeAndNext.containsKey(second)?nodeAndNext.get(second):new HashSet<>();
            secondSet.add(first);
            nodeAndNext.put(second,secondSet);
        }
        Queue<Integer> q = new LinkedList<>();

        List<Integer> result = new LinkedList<>();
        // 得到只有叶节点
        for(Map.Entry<Integer,Set<Integer>> node:nodeAndNext.entrySet()){
            if(node.getValue().size()==1){
                q.add(node.getKey());
                result.add(node.getKey());
            }
        }
        int size = q.size();
        while(q.size()>0){
            Integer curr = q.poll();
            result.add(curr);

            Set<Integer> currValue = nodeAndNext.get(curr);
            for(Integer v:currValue){
                Set<Integer> vNext = nodeAndNext.get(v);
                vNext.remove(curr);
                if(vNext.size()==1){
                    q.add(v);
                }
            }

            if(--size==0){
                size = q.size();
                if(size==0){
                    return result;
                }
                result = new LinkedList<>();
            }
        }
        return result;
    }
}
