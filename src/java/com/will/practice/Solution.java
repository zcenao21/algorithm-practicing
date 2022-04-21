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


//给定两个大小分别为 m 和 n 的正序（从小到大）数组nums1 和nums2。请你找出并返回这两个正序数组的 中位数 。
//
//算法的时间复杂度应该为 O(log (m+n)) 。
//
//
//
//示例 1：
//
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
//示例 2：
//
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class Solution implements Serializable {
    public static void main(String[] args) {
        Solution s = new Solution();
        
        LRUCache cache = new LRUCache(2);
        
    }

}

class LRUCache {
    class InnerEle{
        Integer key;
        Integer value;
        InnerEle upper;
        InnerEle next;
        private InnerEle(Integer key, Integer value){
            this.key=key;
            this.value= value;
        }
    }
    
    int capacity=0,currSize=0;
    InnerEle start=new InnerEle(0,0);
    InnerEle last=start;
    HashMap<Integer,InnerEle> map = new HashMap<>();
    
    public LRUCache(int capacity) {
        this.capacity=capacity;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            InnerEle ele = map.get(key);
            last=last==ele?last.upper:last;
            
            // 去掉原来的元素
            ele.upper.next=ele.next;
            move2First(ele);
            return map.get(key).value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            InnerEle ele = map.get(key);
            last=last==ele?last.upper:last;
            ele.upper.next=ele.next;
            move2First(ele);
            if(ele.value!=value){
                ele.value=value;
            }
        }else{
            InnerEle ele = new InnerEle(key,value);
            move2First(ele);
            if(++currSize>capacity){
                last=last.upper;
                last.next=null;
            }
        }
    }
    
    public void move2First(InnerEle ele){
        InnerEle temp = start.next;
        start.next=ele;
        
        ele.upper=start;
        ele.next=temp;
        
        temp.upper=ele;
    }
}
