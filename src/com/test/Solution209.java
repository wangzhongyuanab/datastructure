package com.test;

/**
 * 长度最小的子数组
 */
public class Solution209 {
    //滑动窗口
    public static int minSubArrayLen(int s, int[] nums) {
        int l=0,r=-1;    //nums[l....r]为滑动窗口
        int sum=0;
        int res=nums.length+1;      //设置当前取到的子数组的长度,初始为长度+1
        while (l< nums.length){
            if (r+1<nums.length&&sum<s){
                sum+=nums[++r];
            }else{
                sum-=nums[l++];
            }
            if (sum>=s){
                res=Math.min(res,r-l+1);
            }
        }
        if (res== nums.length+1){
            return 0;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums={2,3,1,2,4,3};
        System.out.println(minSubArrayLen(7,nums));

    }
}
