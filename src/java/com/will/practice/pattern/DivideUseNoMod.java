package com.will.practice.pattern;

import java.util.Arrays;
import java.util.LinkedList;

public class DivideUseNoMod {
    public int divide(int dividend, int divisor) {
        if(divisor==0) return (int)(Math.pow(2,31)-1);
        long absDividend = Math.abs((long)dividend);
        long absDivisor = Math.abs((long)divisor);
        if(absDividend<absDivisor) return 0;
        boolean isNegative = (dividend>0&&divisor<0) || (dividend<0&&divisor>0)?true:false;

        long lastSum=0,currSum=absDivisor,lastCnt=0,currCnt=1;
        while(true){
            if(lastSum+currSum+currSum==absDividend){
                lastCnt=lastCnt+currCnt+currCnt;
                break;
            }else if(lastSum+currSum+currSum>absDividend){
                if(lastSum+absDivisor==absDividend){
                    lastCnt+=1;
                    break;
                }else if(lastSum+absDivisor>absDividend){
                    break;
                }
                lastCnt+=currCnt;
                lastSum+=currSum;
                currCnt=1;
                currSum=absDivisor;
            }else{
                currSum+=currSum;
                currCnt+=currCnt;
            }
        }

        if(lastCnt==Math.pow(2,31)&&isNegative){
            return (int)(0-Math.pow(2,31));
        }

        if(lastCnt>=Math.pow(2,31)-1){
            return (int)(Math.pow(2,31)-1);
        }
        if(isNegative){
            return (int)(0-lastCnt);
        }

        return (int)lastCnt;
    }

    public static void main(String[] args) {
        int dividend = -2147483648;
        int divisor = 1;
        DivideUseNoMod divideUseNoMod = new DivideUseNoMod();
        System.out.println(divideUseNoMod.divide(dividend,divisor));
    }
}
