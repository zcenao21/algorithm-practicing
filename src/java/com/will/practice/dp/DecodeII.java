package com.will.practice.dp;

public class DecodeII {
    public int numDecodings(String s) {
        if(s.length()<1) return 0;
        Long[] results = new Long[s.length()+1];
        results[0]=1L;

        // 计算result[1]
        if(s.charAt(0)=='*'){
            results[1]=9L;
        }else if(s.charAt(0)=='0'){
            results[1]=0L;
        }else{
            results[1]=1L;
        }
        for(int curr=2;curr<=s.length();curr++){
            results[curr]=(results[curr-2]*calTwoCohesiveChars(s.substring(curr-2,curr))
                    +results[curr-1]*calOneChar(s.charAt(curr-1)))%(int)(Math.pow(10,9)+7);
        }

        return (int)(results[s.length()]%(int)(Math.pow(10,9)+7));
    }

    public int calOneChar(char c){
        if(c=='0'){
            return 0;
        }else if(c=='*'){
            return 9;
        }else{
            return 1;
        }
    }

    public int calTwoCohesiveChars(String twoChars){
        if(twoChars.contains("*")){
            if(twoChars.equals("**")){
                return 15;
            }else if(twoChars.startsWith("*")){
                int value2 =Integer.parseInt(twoChars.charAt(1)+"");
                if(value2<=6){
                    return 2;
                }else{
                    return 1;
                }
            }else{
                int value1 =Integer.parseInt(twoChars.charAt(0)+"");
                if(value1==0||value1>=3){
                    return 0;
                }else if(value1==1){
                    return 9;
                }else{
                    return 6;
                }
            }
        }else{
            int value = Integer.parseInt(twoChars);
            if(value>=10&&value<=26){
                return 1;
            }else{
                return 0;
            }
        }
    }

    public static void main(String[] args) {
        DecodeII decodeII = new DecodeII();
        System.out.println(decodeII.numDecodings("*"));
    }
}
