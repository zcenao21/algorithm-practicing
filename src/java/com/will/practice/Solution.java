package com.will.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<String> l1= Arrays.asList(new String[]{"J", "j1@mail.com", "j2@mail.com"});
        List<String> l2= Arrays.asList(new String[]{"J", "j4@mail.com","j2@mail.com"});
        List<String> l3= Arrays.asList(new String[]{"J", "j1@mail.com", "j3@mail.com", "j5@mail.com"});
        List<String> l4= Arrays.asList(new String[]{"J", "m1@mail.com"});
        List<List<String>> accounts = new ArrayList<>();
        accounts.add(l1);
        accounts.add(l2);
        accounts.add(l3);
        accounts.add(l4);

        System.out.println(s.accountsMerge(accounts));
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> result = new ArrayList<>();

        // 记录用户名映射关系
        Map<String,String> mailOwner = new HashMap<>();
        Map<String,Integer> mailId = new HashMap<>();
        Map<Integer,String> idMail = new HashMap<>();

        // 首先得到邮箱和ID及邮箱和用户名映射关系
        for(List<String> userMails:accounts){
            for(int i=1;i<userMails.size();i++){
                if(!mailId.containsKey(userMails.get(i))){
                    mailId.put(userMails.get(i),0);
                }
                mailOwner.put(userMails.get(i),userMails.get(0));
            }
        }
        // 将mail映射到Id
        int cnt=0;
        for(String mail:mailId.keySet()){
            idMail.put(cnt,mail);
            mailId.put(mail,cnt++);
        }

        // 初始化并查集
        Set<String> currAllEmail = new HashSet<>();
        MergeFind mergeFind = new MergeFind(mailId.size());
        // 维护并查集
        for(List<String> userMails:accounts){
            for(int i=1;i<userMails.size();i++){
                int currMailId = mailId.get(userMails.get(i));
                int firstMailId = mailId.get(userMails.get(1));
                mergeFind.merge(currMailId,firstMailId);
                if(currAllEmail.contains(userMails.get(i))){ // 说明有重复
                    mergeFind.merge(mailId.get(userMails.get(i)),currMailId);
                }
            }
        }

        Map<Integer,List<Integer>> resultMap = new HashMap<>();
        for(int i=0;i<mailId.size();i++){
            int parent = mergeFind.find(i);
            if(!resultMap.containsKey(parent)){
                List<Integer> tempList = new LinkedList<>();
                tempList.add(i);
                resultMap.put(parent,tempList);
            }else{
                List<Integer> tempList = resultMap.get(parent);
                tempList.add(i);
                resultMap.put(parent,tempList);
            }
        }

        for(int parent:resultMap.keySet()){
            List<String> resultPart = new LinkedList<>();

            // 得到父节点的owner
            String owner = mailOwner.get(idMail.get(parent));
            resultPart.add(owner);
            List<Integer> parentNodes = resultMap.get(parent);
            List<String> parentNodesMail = new LinkedList<>();
            for(int i:parentNodes){
                parentNodesMail.add(idMail.get(i));
            }
            String[] mailArr = parentNodesMail.toArray(new String[]{});
            Arrays.sort(mailArr);
            for(String mail:mailArr){
                resultPart.add(mail);
            }
            result.add(resultPart);
        }

        return result;
    }

    class MergeFind{
        int[] tree;

        public MergeFind(int size){
            tree = new int[size];
            for(int i=0;i<size;i++){
                tree[i]=i;
            }
        }

        public void merge(int i, int j){
            tree[find(j)] = find(i);
        }

        public int find(int i){
            return tree[i]==i?i:(tree[i]=find(tree[i]));
        }
    }
}
