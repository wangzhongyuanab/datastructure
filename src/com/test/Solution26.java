package com.test;

/**
 *  删除排序数组中的重复项
 */
public class Solution26 {
    public static int removeDuplicates(int[] nums) {
        if (nums==null||nums.length==0) return 0;
        int count=1;
        for (int i=1;i<nums.length;i++) {
            if (nums[i-1]!=nums[i]){
                nums[count++]=nums[i];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int []nums={1,1,2};
        System.out.println(removeDuplicates(nums));
    }
}
