package com.will.practice.pattern;

public class IsSqrt {
    public boolean isPerfectSquare(int num) {
        int low = 1;
        int high = (int) Math.sqrt((double)Integer.MAX_VALUE);
        if(num==low) return true;
        if(num==high*high) return true;
        if(num>high*high) return false;

        while(low<=high){
            int mid = (low+high)/2;
            if(mid*mid>num){
                high = mid-1;
            }else if(mid*mid<num){
                low = mid+1;
            }else{
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        IsSqrt isSqrt = new IsSqrt();
        System.out.println(Math.sqrt(2147395600));
        System.out.println(isSqrt.isPerfectSquare(15));
    }

}
