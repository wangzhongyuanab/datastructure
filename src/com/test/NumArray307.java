package com.test;

/**
 * 区域和检索 - 数组可修改，此时时间会很久采用这种算法
 */
public class NumArray307 {
    private int[] sum;  //sum[i]存储nums前i个元素和,sum[0]=0,sum[1]=nums【1】即sum【i】存储nums【0.。。i-1 】的和
    private int[] data;
    public NumArray307(int[] nums) {
        data=new int[nums.length];
        for (int i=0;i<nums.length;i++){
            data[i]=nums[i];
        }
        sum=new int[nums.length+1];
        sum[0]=0;
        for (int i=1;i<sum.length;i++){
            sum[i]=sum[i-1]+nums[i-1];
        }
    }
    public void update(int index, int val) {
        data[index]=val;
        for (int i=index+1;i<sum.length;i++){
            sum[i]=sum[i-1]+data[i-1];
        }
    }

    public int sumRange ( int i, int j){
        return sum[j+1]-sum[i];
    }
}
