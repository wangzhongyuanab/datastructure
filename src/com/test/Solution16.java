package com.test;

import java.util.Arrays;

/**
 * 最接近的三数之和
 */
public class Solution16 {
    public int threeSumClosest(int[] nums, int target) {
        int res=nums[0]+nums[1]+nums[nums.length-1];
        Arrays.sort(nums);
        for (int i=0;i<nums.length-2;i++){
            int start=i+1,end=nums.length-1;
            while(start<end){
                int sum=nums[i]+nums[start]+nums[end];
                if (sum>target){
                    end--;
                }else start++;
                if (Math.abs(sum-target)<Math.abs(res-target)){
                    res=sum;
                }
            }
        }
        return res;
    }
}
