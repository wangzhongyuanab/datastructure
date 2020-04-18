package com.test;

public class NumArray303two {

    private int[] sum;  //sum[i]存储nums前i个元素和,sum[0]=0,sum[1]=nums【1】即sum【i】存储nums【0.。。i-1 】的和

    public NumArray303two(int[] nums) {
        sum=new int[nums.length+1];
        sum[0]=0;
        for (int i=1;i<sum.length;i++){
            sum[i]=sum[i-1]+nums[i-1];
        }
    }

    public int sumRange ( int i, int j){
        return sum[j+1]-sum[i];
    }
}
