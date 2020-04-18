package com.offer;



import java.util.ArrayList;


public class FindPath {
    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> result= new ArrayList<>();
        if(root==null){
            return result;
        }
        ArrayList<Integer> temp=new ArrayList<>();
        temp.add(root.val);
        FindPath(result, temp, root.val, root, target);
        return result;
    }

    private static void FindPath(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> temp, int sum, TreeNode node, int target) {
        if(node.left==null&&node.right==null&&sum==target){
            result.add(new ArrayList<>(temp));
            return;
        }
        if(node.left!=null){
            temp.add(node.left.val);
            FindPath(result, temp, sum+node.left.val, node.left, target);
            temp.remove(temp.size()-1);
        }
        if(node.right!=null){
            temp.add(node.right.val);
            FindPath(result, temp, sum+node.right.val, node.right, target);
            temp.remove(temp.size()-1);
        }
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left= new TreeNode(2);
        root.right=new TreeNode(5);
        root.left.left=new TreeNode(3);
        root.left.right=new TreeNode(4);
        System.out.println(FindPath(root,6));
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
