package com.will.practice.pattern;

public class JudgeNumStr {
    public boolean isNumber(String s) {
        s = s.trim();

        // 空字符串或者都是空格返回false
        if(s.length()<1) return false;

        // 判断是有有且仅有一个e或E, 或者没有
        if(s.contains("e")&&!s.contains("E")&&s.split("e").length==2&&containsExaOne(s,"e")){ // 仅有e
            String[] splits = s.split("e");
            if((isFloat(splits[0])||isLong(splits[0]))&&isLong(splits[1])){
                return true;
            }
        }else if(s.contains("E")&&!s.contains("e")&&s.split("E").length==2&&containsExaOne(s,"E")){ // 仅有E
            String[] splits = s.split("E");
            if((isFloat(splits[0])||isLong(splits[0]))&&isLong(splits[1])){
                return true;
            }
        }else if(!s.contains("e")&&!s.contains("E")){
            if(isFloat(s)||isLong(s)){
                return true;
            }
        }

        return false;
    }

    // 小数
    public boolean isFloat(String s){
        if(s.length()<1) return false;
        if(s.startsWith("+")||s.startsWith("-")){
            if(!(containsExaOne(s,"\\+")||containsExaOne(s,"-"))){
                return false;
            }
            s = s.replace("+", "");
            s = s.replace("-", "");
        }
        if(containsExaOne(s,"\\.")){
            String[] split=s.split("\\.");
            if(split.length==0){
                return false;
            }else if(split.length==1){
                return isLong(s.split("\\.")[0]);
            }else if(split[0].length()==0&&isLongWithoutSign(split[1])){
                return true;
            }else if(isLong(split[0])&&(isLongWithoutSign(split[1])||split[1].length()==0)){
                return true;
            }
        }

        return false;
    }

    // 整数
    public boolean isLong(String s){
        return isLongWithoutSign(s)||isLongWithSign(s);
    }

    // 整数且有符号
    public boolean isLongWithSign(String s){
        if(s.length()<1) return false;
        if(s.startsWith("+")||s.startsWith("-")){
            if(isLongWithoutSign(s.substring(1))){
                return true;
            }
        }
        return false;
    }

    // 判断是整数且无符号
    public boolean isLongWithoutSign(String s){
        if(s.length()<1) return false;
        if(s.contains("+")||s.contains("-")||s.contains(".")){
            return false;
        }
        try{
            Long.parseLong(s);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }

    // 判断字符串中是否包含且仅包含一个指定字符
    public boolean containsExaOne(String s, String c){
        if(s.length()-s.replaceAll(c,"").length()==1){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String[] strT = new String[]{"005047e+6"};
//        String[] strT = new String[]{"+100", "5e2", "-123", "3.1416", "-1E-16", "0123","-100",".2","3."};
        String[] strN = new String[]{"12e", "1a3.14", "1.2.3", "+-5", "12e+5.4"};

        JudgeNumStr jn = new JudgeNumStr();
//        System.out.println(jn.isNumber(".1"));
        for(String s:strT){
            System.out.println(jn.isNumber(s));
        }
        System.out.println("========================");
        for(String s:strN){
            System.out.println(jn.isNumber(s));
        }

    }
}
