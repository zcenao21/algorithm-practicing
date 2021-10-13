package com.will.practice.pattern;

import java.util.Arrays;
import java.util.LinkedList;

public class NumberExpr {
    String[] numBasic = new String[]{"Zero","One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
            "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tensBasic = new String[]{"","","Twenty","Thirty","Forty", "Fifty", "Sixty", "Seventy", "Eighty","Ninety"};
    String hundred = "Hundred";
    String[] unit = new String[]{"","Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        LinkedList<String> output = new LinkedList<String>();

        for(int j=1;;j++){
            int numThousand = num % 1000;
            int left = num / 1000;

            output.addFirst(strOfNumLessThan1000(numThousand));
            if(left==0){ // 不足1000了
                break;
            }else{
                output.addFirst(unit[j]);
            }
            num = left;
        }

        if(output.contains("Zero")&&output.size()>1){
            while(output.contains("Zero")){
                output.remove("Zero");
            }
        }

        StringBuilder builder = new StringBuilder();
        String lastStr="";
        for(String s:output){
            if(!lastStr.equals("")&&Arrays.asList(unit).contains(s)&&Arrays.asList(unit).contains(lastStr)){
                // 当连续两个单位出现时跳过
            }else{
                builder.append(s);
                builder.append(" ");
            }
            lastStr=s;
        }
        builder.deleteCharAt(builder.length()-1);
        return builder.toString();
    }

    public String strOfNumLessThan1000(int num){
        if(num<100){
            return strOfNumLessThan100(num);
        }else{
            int hundredNum = num / 100;
            int left = num % 100;
            if(left==0){
                return numBasic[hundredNum]+" "+hundred;
            }else{
                return numBasic[hundredNum]+" "+hundred+" "+strOfNumLessThan100(left);
            }
        }
    }

    public String strOfNumLessThan100(int num){
        if(num<20){
            return numBasic[num];
        }else{
            int tenNum = num / 10;
            int left = num % 10;
            if(left==0){
                return tensBasic[tenNum];
            }else{
                return tensBasic[tenNum]+" "+numBasic[left];
            }
        }
    }

    public static void main(String[] args) {
        NumberExpr numberExpr = new NumberExpr();
//        int[] ns = {5, 15, 34,334,1000,1000000,21334,4213334,2109877653};
        int[] ns = {1000000};
        Solution solution = new Solution();
        for(int num:ns){
            String s = numberExpr.numberToWords(num);
            System.out.println(s);

            String s1 = solution.numberToWords(num);
            System.out.println(s1);
        }
    }
}

class Solution {
    static String[] num2str_small = {
            "Zero",
            "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    };
    static String[] num2str_medium = {
            "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };
    static String[] num2str_large = {
            "Billion", "Million", "Thousand", "",
    };
    String num2Str(int x) {
        String ans = "";
        if (x >= 100) {
            ans += num2str_small[x / 100] + " Hundred ";
            x %= 100;
        }
        if (x >= 20) {
            ans += num2str_medium[x / 10] + " ";
            x %= 10;
        }
        if (x != 0) ans += num2str_small[x] + " ";
        return ans;
    }
    public String numberToWords(int num) {
        if (num == 0) return num2str_small[0];
        StringBuilder sb = new StringBuilder();
        for (int i = (int)1e9, j = 0; i >= 1; i /= 1000, j++) {
            if (num < i) continue;
            sb.append(num2Str(num / i) + num2str_large[j] + " ");
            num %= i;
        }
        while (sb.charAt(sb.length() - 1) == ' ') sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
