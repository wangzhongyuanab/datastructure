package com.test;

/**
 *  平衡二叉树
 */
public class Solution110 {
    public  boolean isBalanced(TreeNode root) {
        return getTreeDepth(root)!=-1;
    }

    private  int  getTreeDepth(TreeNode root) {
        if (root==null){
            return 0;
        }
        int leftdepth=getTreeDepth(root.left);
        if (leftdepth==-1){
            return -1;
        }
        int rightdepth=getTreeDepth(root.right);
        if (rightdepth==-1){
            return -1;
        }
        if (Math.abs(leftdepth-rightdepth)>1){
            return -1;
        }
        return Math.max(leftdepth,rightdepth)+1;
    }

    public static class TreeNode {
      int val;
     TreeNode left;
      TreeNode right;
    TreeNode(int x) { val = x; }
 }
}
