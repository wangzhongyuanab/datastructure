package com.test;

/**
 * 合并两个有序数组
 */
public class Solution88 {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=m-1;
        int j=n-1;
        int k=m+n-1;
        while(i>=0&&j>=0){
            nums1[k--]=nums1[i]>nums2[j]?nums1[i--]:nums2[j--];
        }
        while(j>=0){
            nums1[k--]=nums2[j--];
        }
    }

    public static void main(String[] args) {
        int []nums1={1,2,0,0,0};
        int []nums2={2,5,6};
        merge(nums1,2,nums2,nums2.length);
        for (int i : nums1) {
            System.out.print(i);
        }
    }
}
