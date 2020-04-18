package com.test;

import org.jetbrains.annotations.NotNull;

/**
 * 最大子序和
 */
public class Solution53 {
    public static int maxSubArray(int[] nums) {
        if (nums.length==0) return 0;
        int []dp=new int[nums.length];
        dp[0]=nums[0];
        int res=nums[0];
        for (int i=1;i<nums.length;i++){
            dp[i]=nums[i]+(dp[i-1]<0?0:dp[i-1]);
            res =Math.max(res,dp[i]);
        }
        return res;
    }

    public static int maxSubArray2(int[] nums) {
        int res=nums[0];
        int sum=nums[0];
        for (int i=1;i<nums.length;i++){
            sum=Math.max(nums[i],nums[i]+sum);
            res=Math.max(res,sum);
        }
        return res;
    }

    public static int maxSubArray3(int[] nums){
        int maxSum=nums[0];
        for(int i=1;i<nums.length;++i){
            if(nums[i-1]>0){
                nums[i]+=nums[i-1];
            }
            maxSum=Math.max(maxSum,nums[i]);
        }
        return maxSum;
    }

    public static int maxSubArray4(int[] nums){
        int[] dp=new int[nums.length];
        dp[0]=nums[0];
        for(int i=1;i<nums.length;++i){
            dp[i]=nums[i]+Math.max(0,dp[i-1]);
        }
        int max=dp[0];
        for(int i=1;i<dp.length;i++){
            if(dp[i]>max){
                max=dp[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int []nums={-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray3(nums));
    }
}
