package com.will.practice;


import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


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

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<String> wordList = new LinkedList<>();
//        String[] strArr = new String[]{"si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"};
//        wordList=Arrays.asList(strArr);
//        List<List<String>> result = s.findLadders("qa","sq",wordList);

//        String[] strArr = new String[]{"hot","dot","dog","lot","log","cog"};
//        wordList=Arrays.asList(strArr);
//        List<List<String>> result = s.findLadders("hit","cog",wordList);

//        String[] strArr = {"kid","tag","pup","ail","tun","woo","erg","luz","brr","gay","sip","kay","per","val","mes","ohs","now","boa","cet","pal","bar","die","war","hay","eco","pub","lob","rue","fry","lit","rex","jan","cot","bid","ali","pay","col","gum","ger","row","won","dan","rum","fad","tut","sag","yip","sui","ark","has","zip","fez","own","ump","dis","ads","max","jaw","out","btu","ana","gap","cry","led","abe","box","ore","pig","fie","toy","fat","cal","lie","noh","sew","ono","tam","flu","mgm","ply","awe","pry","tit","tie","yet","too","tax","jim","san","pan","map","ski","ova","wed","non","wac","nut","why","bye","lye","oct","old","fin","feb","chi","sap","owl","log","tod","dot","bow","fob","for","joe","ivy","fan","age","fax","hip","jib","mel","hus","sob","ifs","tab","ara","dab","jag","jar","arm","lot","tom","sax","tex","yum","pei","wen","wry","ire","irk","far","mew","wit","doe","gas","rte","ian","pot","ask","wag","hag","amy","nag","ron","soy","gin","don","tug","fay","vic","boo","nam","ave","buy","sop","but","orb","fen","paw","his","sub","bob","yea","oft","inn","rod","yam","pew","web","hod","hun","gyp","wei","wis","rob","gad","pie","mon","dog","bib","rub","ere","dig","era","cat","fox","bee","mod","day","apr","vie","nev","jam","pam","new","aye","ani","and","ibm","yap","can","pyx","tar","kin","fog","hum","pip","cup","dye","lyx","jog","nun","par","wan","fey","bus","oak","bad","ats","set","qom","vat","eat","pus","rev","axe","ion","six","ila","lao","mom","mas","pro","few","opt","poe","art","ash","oar","cap","lop","may","shy","rid","bat","sum","rim","fee","bmw","sky","maj","hue","thy","ava","rap","den","fla","auk","cox","ibo","hey","saw","vim","sec","ltd","you","its","tat","dew","eva","tog","ram","let","see","zit","maw","nix","ate","gig","rep","owe","ind","hog","eve","sam","zoo","any","dow","cod","bed","vet","ham","sis","hex","via","fir","nod","mao","aug","mum","hoe","bah","hal","keg","hew","zed","tow","gog","ass","dem","who","bet","gos","son","ear","spy","kit","boy","due","sen","oaf","mix","hep","fur","ada","bin","nil","mia","ewe","hit","fix","sad","rib","eye","hop","haw","wax","mid","tad","ken","wad","rye","pap","bog","gut","ito","woe","our","ado","sin","mad","ray","hon","roy","dip","hen","iva","lug","asp","hui","yak","bay","poi","yep","bun","try","lad","elm","nat","wyo","gym","dug","toe","dee","wig","sly","rip","geo","cog","pas","zen","odd","nan","lay","pod","fit","hem","joy","bum","rio","yon","dec","leg","put","sue","dim","pet","yaw","nub","bit","bur","sid","sun","oil","red","doc","moe","caw","eel","dix","cub","end","gem","off","yew","hug","pop","tub","sgt","lid","pun","ton","sol","din","yup","jab","pea","bug","gag","mil","jig","hub","low","did","tin","get","gte","sox","lei","mig","fig","lon","use","ban","flo","nov","jut","bag","mir","sty","lap","two","ins","con","ant","net","tux","ode","stu","mug","cad","nap","gun","fop","tot","sow","sal","sic","ted","wot","del","imp","cob","way","ann","tan","mci","job","wet","ism","err","him","all","pad","hah","hie","aim","ike","jed","ego","mac","baa","min","com","ill","was","cab","ago","ina","big","ilk","gal","tap","duh","ola","ran","lab","top","gob","hot","ora","tia","kip","han","met","hut","she","sac","fed","goo","tee","ell","not","act","gil","rut","ala","ape","rig","cid","god","duo","lin","aid","gel","awl","lag","elf","liz","ref","aha","fib","oho","tho","her","nor","ace","adz","fun","ned","coo","win","tao","coy","van","man","pit","guy","foe","hid","mai","sup","jay","hob","mow","jot","are","pol","arc","lax","aft","alb","len","air","pug","pox","vow","got","meg","zoe","amp","ale","bud","gee","pin","dun","pat","ten","mob"};
//        wordList=Arrays.asList(strArr);
//        List<List<String>> result = s.findLadders("cet","ism",wordList);

        String[] strArr = new String[]{"hot", "dog"};
        wordList = Arrays.asList(strArr);
//        List<String> result = s.restoreIpAddresses("25525511135");
//        int[][] grid =
//                {{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
//                 {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
//                 {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
//                 {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
//                 {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
//                 {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
//                 {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
//                 {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
//                 {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
//                 {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
//                 {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
//                 {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
//                 {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
//                 {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
//                 {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
//                 {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
//                 {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
//                 {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
//                 {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}};
        int[][] grid =
                {{1, 0, 1},
                        {1, 0, 0},
                        {0, 1, 1}};
//        List<List<Integer>> result = s.combinationSum(new int[]{2,3,6,7}, 7);
//        List<List<Integer>> result = s.combinationSum(new int[]{2,3,5}, 8);
//        List<List<Integer>> result = s.combinationSum(new int[]{2}, 1);
//        List<List<Integer>> result = s.combinationSum(new int[]{1}, 1);
//        boolean result = s.canPartitionKSubsets(new int[]{4,3,2,3,5,2,1},4);
        boolean result = s.canPartitionKSubsets(new int[]{7628,3147,7137,2578,7742,2746,4264,7704,9532,9679,8963,3223,2133,7792,5911,3979},6);
        System.out.println(result);
//        List<String> result = s.restoreIpAddresses("1111");
//        List<String> result = s.restoreIpAddresses("0279245587303");


//        TreeNode node1 = new TreeNode(6);
//        TreeNode node2 = new TreeNode(2);
//        TreeNode node3 = new TreeNode(8);
//        TreeNode node4 = new TreeNode(0);
//        TreeNode node5 = new TreeNode(4);
//        TreeNode node6 = new TreeNode(7);
//        TreeNode node7 = new TreeNode(9);
//        TreeNode node8 = new TreeNode(3);
//        TreeNode node9 = new TreeNode(5);
//        node1.left = node2;
//        node1.right = node3;
//        node2.left=node4;
//        node2.right=node5;
//        node5.left=node8;
//        node5.right=node9;
//        node3.left=node6;
//        node3.right=node7;
//        TreeNode result = s.inorderSuccessor(node1,node1);
//        System.out.println(result);
//
//        TreeNode nodeCopy1 = new TreeNode(4);
//        TreeNode nodeCopy2 = new TreeNode(1);
//        TreeNode nodeCopy3 = new TreeNode(2);
//        nodeCopy1.left = nodeCopy2;
//        nodeCopy1.right = nodeCopy3;
//
//        System.out.println(s.isSubtree(node1,nodeCopy1));

//        int[][] grid =
//        {{0,0,0},
//        {1,1,0},
//        {0,0,0},
//        {0,1,1},
//        {0,0,0}};

    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        if(nums.length<1) return false;
        long sum = 0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        
        // 确定可以分成k等分
        int avg = (int)sum/k;
        if(sum%avg!=0) return false;
        
        int[] parts = new int[k];
        Arrays.fill(parts,avg);
        Arrays.sort(nums);
        for(int i=1;i<nums.length/2;i+=2){
            int temp=nums[i];
            nums[i]=nums[nums.length-1-i];
            nums[nums.length-1-i]=temp;
        }
        
        Boolean result = canPartitionKSubsetsInner(nums,0, parts,avg);
        return result;
    }

    private Boolean canPartitionKSubsetsInner(int[] nums, int curr, int[] parts,int avg) {
        if(curr==nums.length){
            for(int j=0;j<parts.length;j++){
                if(parts[j]!=0){
                    return false;
                }
            }
            return true;
        }
        if(nums[curr]>avg) return false;
        boolean result =false;
        for(int i=0;i<parts.length;i++){
            if(parts[i]-nums[curr]>=0){
                parts[i]=parts[i]-nums[curr];
                result=result|canPartitionKSubsetsInner(nums,curr+1,parts,avg);
                parts[i]+=nums[curr];
                if(result){
                    return true;
                }
            }
        }
        return false;
    }
    
    int[] bucket;
	boolean[] used;
    public boolean canPartitionKSubsets2(int[] nums, int k) {
    	bucket = new int[k];
    	used = new boolean[nums.length];
    	int sum = 0;
    	for(int i = 0; i < nums.length; i++) {
    		sum += nums[i];
    	}
    	if(sum < k || sum % k != 0) {
    		return false;
    	}
    	int target = sum / k;
    	int len = nums.length;
    	
    	Arrays.sort(nums);
    	int temp = 0;
    	for(int i = 0; i < len/2; i++) {
    		temp = nums[i];
    		nums[i] = nums[len - 1 - i];
    		nums[len - i - 1] = temp;
    	}
    	
    	return backtrack(k, 0, nums, 0, used, target);
    }
    
    //每个桶判断自己是否应该装那个数字
    boolean backtrack(int k, int bucket, 
    	    int[] nums, int start, boolean[] used, int target) {
    	if(k == 0) {
    		//所有桶都满了
    		return true;
    	}
    	if(bucket == target) {
    		return backtrack(k - 1, 0, nums, 0, used, target);
    	}
    	
    	for(int i = start; i < nums.length; i++) {
    		if(used[i]) {
    			continue;
    		}
    		if(nums[i] + bucket > target) {
    			continue;
    		}
    		used[i] = true;
    		bucket += nums[i];
    		if(backtrack(k, bucket, nums, i + 1, used, target)) {
    			return true;
    		}
    		//撤销选择
    		used[i] = false;
    		bucket -= nums[i];
    	}
    	return false;
    }
    

}