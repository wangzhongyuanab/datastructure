package com.test;


import java.util.LinkedList;


public class Solution112 {
    //递归判断
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left==null&&root.right==null){
            return sum==root.val;
        }
        return hasPathSum(root.left,sum-root.val)||hasPathSum(root.right,sum-root.val);
    }

    //栈迭代调用
    public  static boolean hasPathSum2(TreeNode root, int sum) {
        if (root==null) return false;
        LinkedList<TreeNode> stack=new LinkedList<>();
        LinkedList<Integer> sum_stack=new LinkedList<>();
        stack.push(root);
        sum_stack.add(sum-root.val);
        TreeNode node;
        int curr_sum;
        if (!stack.isEmpty()){
            node=stack.pollLast();
            curr_sum=sum_stack.pollLast();
            if ((node.right==null)&&(node.left==null)&&(curr_sum==0)){
                return true;
            }
            if (node.right!=null){
                stack.add(node.right);
                sum_stack.add(curr_sum-node.right.val);
            }
            if (node.left!=null){
                stack.add(node.left);
                sum_stack.add(curr_sum-node.left.val);
            }
        }
        return false;
    }

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
     TreeNode(int x) { val = x; }
 }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(5);
        root.left=new TreeNode(4);
        root.right=new TreeNode(8);
        root.left.left=new TreeNode(11);
        root.left.left.left=new TreeNode(7);
        root.left.left.right=new TreeNode(2);
        root.right.left=new TreeNode(13);
        root.right.right=new TreeNode(4);
        root.right.right.right=new TreeNode(1);
        System.out.println(hasPathSum2(root,22));
    }
}
