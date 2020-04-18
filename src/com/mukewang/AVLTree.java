package com.mukewang;


import java.util.ArrayList;

/**
 * AVLtree的实现,自平衡树，即对于任意一个节点，它的左子树的高度与右子树的高度最多只能相差1
 * AVL也是一个二分搜索树，即也满足二分搜索树的左孩子节点小于根节点，右孩子节点大于根节点
 * 采用自旋转（左旋转，右旋转）
 * @param <K>
 * @param <V>
 */
public class AVLTree<K extends Comparable<K>,V>{

    private class Node{
        public K key;
        public V value;
        public Node left,right;
        private int height;

        public Node(K key,V value) {
            this.key=key;
            this.value=value;
            this.left=null;
            this.right=null;
            height=1;
        }
    }
    private Node root;
    private int size;

    public AVLTree(){
        root=null;
        size=0;
    }

    /**
     * 判断该二叉树是不是一个二分搜索树,判断中序遍历是不是一个升序
     * @return
     */
    public boolean isBST(){
        ArrayList<K> keys=new ArrayList<>();
        inOrder(root,keys);
        for (int i=0;i<keys.size();i++){
            if (keys.get(i-1).compareTo(keys.get(i))>0){
                return false;
            }
        }
        return true;
    }


    /**
     * 判断该树是不是一个平衡树
     */
    public boolean isBalanced(){
        return isBalanced(root);
    }

    private boolean isBalanced(Node node){
        if (node==null){
            return true;
        }
        int balancedFactor=getBalanceFactor(node);
        if (Math.abs(balancedFactor)>1){
            return false;
        }
        return isBalanced(node.left)&&isBalanced(node.right);
    }

    /**
     * 中序遍历
     * @param node
     * @param keys
     */
    private void inOrder(Node node,ArrayList<K> keys){
        if (node==null){
            return ;
        }
        inOrder(node.left,keys);
        keys.add(node.key);
        inOrder(node.right,keys);
    }
    /**
     * 获得节点的高度
     * @param node
     * @return
     */
    private int getHeight(Node node){
        if (node==null){
            return 0;
        }
        return node.height;
    }


    /**
     * 获得node的平衡因子
     * @Param node
     * @return
     */
    private int getBalanceFactor(Node node){
        if (node==null){
            return 0;
        }
        return getHeight(node.left)-getHeight(node.right);
    }
    /**
     * 返回以node为根节点的二分搜索树中，key所在的节点。
     * @param node
     * @param key
     * @return
     */
    private Node getNode(Node node,K key){
        if (node==null){
            return null;
        }
        if (key.compareTo(node.key)==0){
            return node;
        }else if(key.compareTo(node.key)<0){
            return getNode(node.left,key);
        }else{  //key.compareTo(node.key)>0
            return getNode(node.right,key);
        }
    }

    /**
     * 不平衡发生在节点左侧的左侧
     * 对节点y进行向右旋转，返回旋转后新的根节点x
     * @param y
     * @return
     */
    private Node rightRotate(Node y){
        Node x=y.left;
        Node T3=x.right;

        //向右旋转过程
        x.right=y;
        y.left=T3;
        //更新height
        y.height=Math.max(getHeight(y.left),getHeight(y.right))+1;
        x.height=Math.max(getHeight(x.left),getHeight(x.right))+1;
        return x;
    }

    /**
     * 不平衡发生在节点的右侧的右侧
     * 对节点y进行向左旋转，返回旋转后新的根节点x
     * @param y
     * @return
     */
    private Node leftRotate(Node y){
        Node x=y.right;
        Node T3=x.left;

        //向左旋转过程
        x.left=y;
        y.right=T3;
        //更新height
        y.height=Math.max(getHeight(y.left),getHeight(y.right))+1;
        x.height=Math.max(getHeight(x.left),getHeight(x.right))+1;
        return x;
    }

    public void add(K key, V value) {
        root=add(root,key,value);
    }

    /**
     * 向以node为根节点的二分搜索树中添加元素，递归
     * @param node
     * @param key
     * @param value
     * @return
     */
    private Node add(Node node,K key,V value){

        if(node==null){
            size++;
            return new Node(key,value);
        }

        if(key.compareTo(node.key)<0){
            node.left=add(node.left,key,value);
        }else if(key.compareTo(node.key)>0){
            node.right=add(node.right,key,value);
        }else { //key.compareTo(node.key)==0
            node.value=value;
        }
        //更新height
        node.height=1+Math.max(getHeight(node.left),getHeight(node.right));
        //计算平衡因子
        int balanceFactor=getBalanceFactor(node);
//        if (Math.abs(balanceFactor)>1){
//            System.out.println("unbalanced:"+balanceFactor);
//        }
        //此时可能打破了平衡树的平衡，维护平衡性
        //此时节点的左侧的左侧发生了不平衡LL
        if (balanceFactor>1&&getBalanceFactor(node.left)>=0){
            // 右旋转
            return rightRotate(node);
        }
        //此时节点的右侧的右侧发生了不平衡RR
        if (balanceFactor<-1&&getBalanceFactor(node.right)<=0){
            //左旋转
            return leftRotate(node);
        }
        //LR
        if (balanceFactor>1&&getBalanceFactor(node.left)<0){
            node.left=leftRotate(node.left);
            return rightRotate(node);
        }
        //RL
        if (balanceFactor<-1&&getBalanceFactor(node.right)>0){
            node.left=rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }

    /**
     * 递归寻找最小值
     * @param node
     * @return
     */
    private Node minimum(Node node){
        if (node.left==null){
            return node;
        }
        return minimum(node.left);
    }


    /**
     * 删除以node为根节点的二分搜索树中键为key的节点
     * @param key
     * @return
     */
    public V remove(K key) {
        Node node=getNode(root,key);
        if (node!=null) {
            root = remove(root, key);
            return node.value;
        }
        return null;
    }

    /**
     * 删除以node为根节点的二分搜索树中键为key的节点，递归
     * @param node
     * @param key
     * @return
     */
    private Node remove(Node node,K key){
        if (node==null){
            return null;
        }
        Node retNode;
        if(key.compareTo(node.key)<0){
            node.left=remove(node.left,key);
            retNode=node;
        }else  if(key.compareTo(node.key)>0){
            node.right=remove(node.right,key);
            retNode=node;
        }else { //e==node.e
            //此时要删除的节点就是这个节点
            //待删除的节点左子树为空
            if (node.left==null){
                Node rightNode= node.right;
                node.right=null;
                size--;
                retNode=rightNode;
            }
            //待删除的节点右子树为空
            else if (node.right==null){
                Node leftNode=node.left;
                node.left=null;
                size--;
                retNode=leftNode;
            }else {
                //待删除的节点左右子树均不为空
                //找到比待删除节点大的最小节点，即待删除节点右子树的最小节点
                //用这个节点顶替待删除节点的位置
                //在这里也可以找待删除的节点的前驱，即待删除节点的左子树的最大节点
                Node successor = minimum(node.right);
                successor.right = remove(node.right, successor.key);
                size++;
                successor.left = node.left;
                node.left = node.right = null;
                size--;
                retNode = successor;
            }
        }
        if (retNode==null){
            return null;
        }
        //判断retNode是否需要更新
        //更新height
        retNode.height=1+Math.max(getHeight(retNode.left),getHeight(retNode.right));
        //计算平衡因子
        int balanceFactor=getBalanceFactor(retNode);
//        if (Math.abs(balanceFactor)>1){
//            System.out.println("unbalanced:"+balanceFactor);
//        }
        //此时可能打破了平衡树的平衡，维护平衡性
        //此时节点的左侧的左侧发生了不平衡LL
        if (balanceFactor>1&&getBalanceFactor(retNode.left)>=0){
            // 右旋转
            return rightRotate(retNode);
        }
        //此时节点的右侧的右侧发生了不平衡RR
        if (balanceFactor<-1&&getBalanceFactor(retNode.right)<=0){
            //左旋转
            return leftRotate(retNode);
        }
        //LR
        if (balanceFactor>1&&getBalanceFactor(retNode.left)<0){
            retNode.left=leftRotate(retNode.left);
            return rightRotate(retNode);
        }
        //RL
        if (balanceFactor<-1&&getBalanceFactor(retNode.right)>0){
            retNode.left=rightRotate(retNode.right);
            return leftRotate(retNode);
        }
        return retNode;
    }

    public boolean contains(K key) {
        return getNode(root,key)!=null;
    }


    public V get(K key) {
        Node node=getNode(root,key);
        return node==null?null:node.value;
    }


    public void set(K key, V newValue) {
        Node node=getNode(root,key);
        if (node==null){
            throw new IllegalArgumentException(key+"does not exists");
        }
        node.value=newValue;
    }


    public int getSize() {
        return size;
    }


    public boolean isEmpty() {
        return size==0;
    }
}
