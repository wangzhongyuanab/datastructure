package com.test;

/**
 *  对称二叉树
 */
public class Solution101 {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    private boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1==null&&t2==null) return true;
        if (t1==null||t2==null) return false;
        return (t1.val==t2.val)&&isMirror(t1.right,t2.left)&&isMirror(t1.left,t2.right);
    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
