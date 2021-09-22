package com.will;

public class NimGame {


    public boolean canWinNim(int n) {
        boolean[] result=new boolean[6];
        result[0]=true;
        result[1]=true;
        result[2]=true;
        result[3]=false;
        result[4]=true;
        result[5]=true;

        for(int i=6;i<=n-1;i++){
            canWinNimInner(result,i);
        }
        return result[n%6+1];
    }

    public void canWinNimInner(boolean[] result,int n){
        result[n%6+1]=false;
        for(int i=1;i<=3;i++){
            boolean flag=true;
            for(int j=1;j<=3;j++){
                if(!result[(n-i-j)%6+1]){
                    flag=false;
                    break;
                }
            }
            if(flag){
                result[n%6+1]=true;
                break;
            }
        }
    }

    public static void main(String[] args) {
        NimGame g=new NimGame();
        for(int i=1;i<10;i++){
            System.out.println(i+":"+g.canWinNim(i));
        }
    }

}
