package com.mukewang;

/**
 * 基于二分搜索树的映射实现
*  时间复杂度：增add：    o（h）     o(logn)
 *              删remove：  o（h）   o(logn)
 *              改set：  o（h）     o(logn)
 *               查get:  o（h）     o(logn)
 *               查contains：  o（h）   o(logn)
 *             当树变成一个链表后时间复杂度也全都会变成o(n)
 *
 */
public class BSTMap<K extends Comparable<K>,V> implements Map<K,V> {

    private class Node{
        public K key;
        public V value;
        public Node left,right;

        public Node(K key,V value) {
            this.key=key;
            this.value=value;
            this.left=null;
            this.right=null;
        }
    }
    private Node root;
    private int size;

    public BSTMap(){
        root=null;
        size=0;
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

    @Override
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
     * 删除以node为根的二分搜索树的最小值
     * 返回删除节点后新的二分搜索树的根
     * @param node
     * @return
     */
    private  Node removeMin(Node node){
        if (node.left==null){
            Node rightNode=node.right;
            node.right=null;
            size--;
            return rightNode;
        }
        node.left=removeMin(node.left);
        return node;
    }

    /**
     * 删除以node为根节点的二分搜索树中键为key的节点
     * @param key
     * @return
     */
    @Override
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
        if(key.compareTo(node.key)<0){
            node.left=remove(node.left,key);
            return node;
        }else  if(key.compareTo(node.key)>0){
            node.right=remove(node.right,key);
            return node;
        }else { //e==node.e
            //此时要删除的节点就是这个节点
            //待删除的节点左子树为空
            if (node.left==null){
                Node rightNode= node.right;
                node.right=null;
                size--;
                return rightNode;
            }
            //待删除的节点右子树为空
            if (node.right==null){
                Node leftNode=node.left;
                node.left=null;
                size--;
                return leftNode;
            }
            //待删除的节点左右子树均不为空
            //找到比待删除节点大的最小节点，即待删除节点右子树的最小节点
            //用这个节点顶替待删除节点的位置
            //在这里也可以找待删除的节点的前驱，即待删除节点的左子树的最大节点
            Node successor=minimum(node.right);
            successor.right=removeMin(node.right);
            size++;
            successor.left=node.left;
            node.left=node.right=null;
            size--;
            return successor;
        }
    }
    @Override
    public boolean contains(K key) {
        return getNode(root,key)!=null;
    }

    @Override
    public V get(K key) {
        Node node=getNode(root,key);
        return node==null?null:node.value;
    }

    @Override
    public void set(K key, V newValue) {
        Node node=getNode(root,key);
        if (node==null){
            throw new IllegalArgumentException(key+"does not exists");
        }
        node.value=newValue;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }
}
