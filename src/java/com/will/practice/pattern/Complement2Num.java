package com.will.practice.pattern;

public class Complement2Num {
    public int findComplement(int num) {
        String[] numBin = new String[33];
        // 十进制转二进制
        int i=0;
        for(;i<33;i++){
            int nMod = num % 2;
            num = num / 2;
            numBin[i]=String.valueOf(nMod);
            if(num==0){
                break;
            }
        }

        // 二进制取反
        for(int j=i;j>=0;j--){
            if(numBin[j].equals("0")){
                numBin[j]="1";
            }else{
                numBin[j]="0";
            }
        }

        // 二进制转十进制
        int out=0;
        for(int k=0;k<i;k++){
            out+=Integer.parseInt(numBin[k])*Math.pow(2,k);
        }

        return out;
    }

    public int findComplement2(int num) {
        int x = 0;
        for(int n = num;n>0;n = n - x) x = n & (-n);
        return ~num&(x-1);
    }

    public static void main(String[] args) {
        Complement2Num c = new Complement2Num();
        System.out.println(c.findComplement(2100000000));
        System.out.println(c.findComplement(1));
        System.out.println(c.findComplement(66));
        System.out.println(c.findComplement(61));
        System.out.println("===========================");
        System.out.println(c.findComplement2(2100000000));
        System.out.println(c.findComplement2(1));
        System.out.println(c.findComplement2(66));
        System.out.println(c.findComplement2(61));

        System.out.println(5>>1);
    }
}
