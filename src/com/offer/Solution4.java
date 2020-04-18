package com.offer;



import java.util.Arrays;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }

public class Solution4 {
    public static TreeNode reConstructBinaryTree2(int[] pre, int[] in) {
        if (pre.length == 0 || in.length == 0) {
            return null;
        }
        TreeNode treeNode = new TreeNode(pre[0]);
        for (int i = 0; i < in.length; i++) {
            if (pre[0] == in[i]) {
                treeNode.left = reConstructBinaryTree2(Arrays.copyOfRange(pre, 1, i + 1),
                        Arrays.copyOfRange(in, 0, i));
                treeNode.right = reConstructBinaryTree2(Arrays.copyOfRange(pre, i + 1, pre.length),
                        Arrays.copyOfRange(in, i + 1, in.length));
                break;
            }
        }
        return treeNode;
    }


    //识别前序数组中的位置
    static int index;
    public static TreeNode reConstructBinaryTree1(int[] pre, int[] in) {
        index=0;
        int length=pre.length;
        return reConstructBinaryTree(pre,in,0,length-1);
    }

    /**
     * 递归重建二叉树
     * @param pre
     * @param in
     * @param s 重建区间的开始位置
     * @param e 重建区间的结束位置
     * @return
     */
    private static TreeNode reConstructBinaryTree(int[] pre, int[] in, int s, int e) {
        TreeNode treeNode=null;
        if (s<=e){
            treeNode=new TreeNode(pre[index]);
            //看看当前的子树的根节点在中序的哪个位置
            int i=getiByVal(pre[index],in,s,e);
            //递归子树根节点的左子树
            treeNode.left=reConstructBinaryTree(pre, in, s, i-1);
            //递归子树根节点的右子树
            treeNode.right=reConstructBinaryTree(pre, in, i+1, e);
        }
        return treeNode;
    }

    /**
     * 获得根节点在中序遍历的位置
     * 复杂度为线性，当然你可以利用哈希
     * @param target
     * @param in
     * @return
     */
    private static int getiByVal(int target, int[] in, int s, int e) {
        for (int i=s;i<=e;i++){
            if (target==in[i]){
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
//        int []pre=new int[]{1,2,4,7,3,5,6,8};
//        int []in=new int[]{4,7,2,1,5,3,8,6};
//        System.out.println(reConstructBinaryTree2(pre, in));
            int[]dp=new int[39];
            dp[0]=0;
            dp[1]=1;
            for(int i=2;i<=2;i++){
                dp[i]=dp[i-1]+dp[i-2];
            }
        System.out.println(dp[2]);
    }
}
