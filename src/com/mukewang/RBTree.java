package com.mukewang;

/**
 * 红黑树保持黑平衡的二叉树,
 *          性能总结：对于完全随机的数据，普通的二分搜索树很好用    极端情况下退化成链表（高度不平衡）
 *          对于查询较多的使用情况，avl很好用
 *          红黑树牺牲了平衡性，统计性能更优（综合增删改查所有的操作）
 *            java的Treemap，TreeSet基于红黑树.
 * @param <K>
 * @param <V>
 */
public class RBTree<K extends Comparable<K>,V> {

    private static final boolean RED=true;
    private static final boolean BLACK=false;

    private class Node{
        public K key;
        public V value;
        public Node left,right;
        public boolean color;

        public Node(K key,V value) {
            this.key=key;
            this.value=value;
            this.left=null;
            this.right=null;
            color=RED;
        }
    }
    private Node root;
    private int size;

    public RBTree(){
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

    /**
     * 判断节点的颜色
     * @param node
     * @return
     */
    private boolean isRed(Node node){
        if (node == null) {
            return BLACK;
        }
        return node.color;
    }

    private Node leftRotate(Node node){
        Node x=node.right;
        //左旋转
        node.right=x.left;
        x.left=node;
        x.color=node.color;
        node.color=RED;
        return x;
    }

    /**
     * 右旋转
     * @param node
     * @return
     */
    private  Node rightRotate(Node node){
        Node x=node.left;

        //右旋转
        node.left=x.right;
        x.right=node;
        x.color=node.color;
        node.color=RED;
        return x;
    }

    /**
     *
     * 颜色翻转
     * @param node
     */
    private void fliColors(Node node){
        node.color=RED;
        node.left.color=BLACK;
        node.right.color=RED;
    }
    /**
     * 向红黑树中添加新的元素
     * @param key
     * @param value
     */
    public void add(K key, V value) {
        root=add(root,key,value);
        root.color=BLACK;
    }

    /**
     * 向以node为根节点的红黑树中添加元素，递归
     * 返回新的红黑树的根
     * @param node
     * @param key
     * @param value
     * @return
     */
    private Node add(Node node,K key,V value){

        if(node==null){
            size++;
            return new Node(key,value);     //默认插入红节点
        }

        if(key.compareTo(node.key)<0){
            node.left=add(node.left,key,value);
        }else if(key.compareTo(node.key)>0){
            node.right=add(node.right,key,value);
        }else { //key.compareTo(node.key)==0
            node.value=value;
        }


        //红黑树性质的维护
        if (isRed(node.right)&&isRed(node.left)){
            node=leftRotate(node);
        }
        if (isRed(node.left)&&isRed(node.left.left)){
            node=rightRotate(node);
        }
        if (isRed(node.left)&&isRed(node.right)){
            fliColors(node);
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
