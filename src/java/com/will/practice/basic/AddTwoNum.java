package com.will.practice.basic;

// 这里使用了模拟补码的方式计算
// 另外一种方式是使用与或的方式进行计算，拆成进位和不进位两部分
public class AddTwoNum {
    public int getSum(int a, int b) {
        int[] binaryA = new int[16];
        int[] binaryB = new int[16];
        setBinaryArr(a, binaryA);
        setBinaryArr(b, binaryB);

        if(a<0){
            getComplement(binaryA);
        }

        if(b<0){
            getComplement(binaryB);
        }

        getsum(binaryA,binaryB);

        return getOrigin(binaryA);
    }

    private int getOrigin(int[] binaryA) {
        if(binaryA[15]==1){
            // -1
            for(int i=0;i<15;i++){
                if(binaryA[i]==0){
                    binaryA[i]=1;
                }else{
                    binaryA[i]=0;
                    break;
                }
            }

            // 取反
            for(int i=0;i<15;i++){
                if(binaryA[i]==0){
                    binaryA[i]=1;
                }else{
                    binaryA[i]=0;
                }
            }


        }

        int sum=0;
        for(int i=0;i<15;i++){
            if(binaryA[i]==1){
                sum+=Math.pow(2,i);
            }
        }

        if(binaryA[15]==1){
            return -sum;
        }
        return sum;
    }

    private void getsum(int[] binaryA, int[] binaryB) {
        int sum=0;
        for(int i=0;i<16;i++){
            if(binaryA[i]==0&&binaryB[i]==0&&sum==0){
                binaryA[i]=0;
                sum=0;
            }else if(binaryA[i]==0&&binaryB[i]==1&&sum==0
                || binaryA[i]==1&&binaryB[i]==0&&sum==0
                || binaryA[i]==0&&binaryB[i]==0&&sum==1){
                binaryA[i]=1;
                sum=0;
            }else if(binaryA[i]==0&&binaryB[i]==1&&sum==1
                    || binaryA[i]==1&&binaryB[i]==0&&sum==1
                    || binaryA[i]==1&&binaryB[i]==1&&sum==0){
                binaryA[i]=0;
                sum=1;
            }else{
                binaryA[i]=1;
                sum=1;
            }
        }
    }

    public void setBinaryArr(int num, int[] binaryNum){
        if(num==0) return;
        int absNum = Math.abs(num);
        for(int i=0;i<16;i++){
            int div = absNum / 2;
            int left = absNum %2;
            binaryNum[i]=left;
            if(div==0){
                break;
            }
            absNum=absNum/2;
        }
        if(num<0) binaryNum[15]=1;
    }

    public void getComplement(int[] binaryNum){
        if(binaryNum[15]==0) return;

        for(int i=0;i<15;i++){
            if(binaryNum[i]==0){
                binaryNum[i]=1;
            }else{
                binaryNum[i]=0;
            }
        }

        int sum=1;
        for(int i=0;i<15;i++){
            if(sum==1&&binaryNum[i]==1){
                binaryNum[i]=0;
                sum=1;
            }else if(sum==1&&binaryNum[i]==0) {
                binaryNum[i]=1;
                break;
            }else{
                break;
            }
        }
    }

    public static void main(String[] args) {
        AddTwoNum addTwoNum = new AddTwoNum();
        int result=addTwoNum.getSum(-12,100);
        System.out.println(result);
    }
}
