package com.test;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
   }
public class Solution144 {
    public static  List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<Integer>();
        helper(root,res);
        return res;
    }

    public static void helper(TreeNode root,List<Integer> res){
        if(root!=null){
            res.add(root.val);
            if(root.left!=null){
                helper(root.left,res);
            }
            if(root.right!=null){
                helper(root.right,res);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(5);
        root.left.left=new TreeNode(3);
        root.left.right=new TreeNode(4);
        System.out.println(preorderTraversal(root));
    }
}
