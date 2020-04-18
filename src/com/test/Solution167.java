package com.test;

/**
 *  输入有序数组
 */
public class Solution167 {
    public int[] twoSum(int[] numbers, int target) {
        //碰撞指针
        int l=0;
        int r=numbers.length-1;
        while (l<r){
            if (numbers[l]+numbers[r]==target){
                int res[]=new int[]{l+1,r+1};
                return res;
            }else if (numbers[l]+numbers[r]>target){
                r--;
            }else{
                l++;
            }
        }
        throw  new IllegalArgumentException("the input has no solution");
    }
}
