package com.will.practice.pattern;

public class CountAndSay {
    public String countAndSay(int n) {
        String s = "1";

        StringBuilder sb = new StringBuilder();
        for(int num=2;num<=n;num++){
            int cnt=1;
            sb = new StringBuilder();
            for(int i=0;i<s.length();i++){
                if(i+1<s.length()){
                    if(s.charAt(i)==s.charAt(i+1)){
                        cnt++;
                    }else{
                        sb.append(cnt);
                        sb.append(s.charAt(i));
                        cnt=1;
                    }
                }else{
                    sb.append(cnt);
                    sb.append(s.charAt(i));
                }
            }
            s=sb.toString();
        }

        return s;
    }

    public static void main(String[] args) {
        CountAndSay cs = new CountAndSay();
        int i=5;
        System.out.println(i+":"+cs.countAndSay(i));

    }
}
