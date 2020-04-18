package com.test;

/**
 * 移除元素
 */
public class Solution27 {
    public static  int removeElement(int[] nums, int val) {
        if (nums==null||nums.length==0) return 0;
        int res=0;
        for (int i=0;i<nums.length;i++){
            if (nums[i]!=val){
                nums[res++]=nums[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums={3,2,2,3};
        System.out.println(removeElement(nums,3));
    }
}
