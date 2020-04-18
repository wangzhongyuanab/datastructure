package com.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *  二叉树的层次遍历 II
 */
public class Solution107 {
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if (root==null) return res;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            List<Integer> list=new ArrayList<>();
            for (int i=0;i<size;i++){
                TreeNode cur=queue.poll();
                if (cur.left!=null)  queue.offer(cur.left);
                if (cur.right!=null)  queue.offer(cur.right);
                list.add(cur.val);
            }
            res.add(0,list);
        }
        return  res;
    }
    public static class TreeNode {
      int val;
     TreeNode left;
      TreeNode right;
     TreeNode(int x) { val = x; }
  }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(3);
        root.left=new TreeNode(9);
        root.right=new TreeNode(20);
        root.right.left=new TreeNode(15);
        root.right.right=new TreeNode(7);
        List<List<Integer>> list = levelOrderBottom(root);
        for (List<Integer> integerList : list) {
            System.out.println(integerList);
        }
    }

}
