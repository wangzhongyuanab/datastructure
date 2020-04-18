package com.test;

/**
 *  将有序数组转换为二叉搜索树
 */
public class Solution108 {
    public static  TreeNode sortedArrayToBST(int[] nums) {
        if (nums==null||nums.length==0) return null;
        return helper(nums,0,nums.length);
    }

    private static  TreeNode helper(int[] nums, int left, int right) {
        if (left==right) return null;
        int mid=(left+right)>>>1;
        TreeNode root=new TreeNode(nums[mid]);
        root.left=helper(nums,left,mid);
        root.right=helper(nums,mid+1,right);
        return root;
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        int[] nums={-10,-3,0,5,9};
        System.out.println(sortedArrayToBST(nums).val);
    }
}
