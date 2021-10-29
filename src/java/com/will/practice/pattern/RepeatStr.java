package com.will.practice.pattern;

public class RepeatStr {
    public int repeatedStringMatch(String a, String b) {
        int i=0,round=0,result=1;
        for(int j=round;round<a.length();){
            if(j==a.length()){
                j = j % a.length();
                result++;
            }

            if(b.charAt(i)==a.charAt(j)){
                i++;j++;
            }else{
                round++;
                i=0;
                j=round;
                result=1;
            }
            if(i==b.length()){
                break;
            }
        }

        if(round==a.length()) return -1;
        return result;
    }

    public int repeatedStringMatchOk(String a, String b) {
        int lenA = a.length();
        int lenB = b.length();
        String currA = "";
        for(int i=1;i<=lenB/lenA+2;i++){
            currA += a;
            if(currA.contains(b)){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        RepeatStr repeatStr = new RepeatStr();
        String a = "abcdabcd";
        String b = "bcda";
        System.out.println(repeatStr.repeatedStringMatch(a,b));
        System.out.println(repeatStr.repeatedStringMatchOk(a,b));
    }
}
