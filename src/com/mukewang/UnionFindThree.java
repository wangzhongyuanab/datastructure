package com.mukewang;

/**
 * 第三版并查集，子节点指向父节点,对第二版进行优化，基于每棵树的节点数量进行优化
 */
public class UnionFindThree implements UF{

    private int[] parent;
    private int[] sz;     //sz[i]表示以i为根的集合中元素个数
    public UnionFindThree(int size){
        parent=new int[size];
        sz=new int[size];
        for (int i=0;i<size;i++){
            parent[i]=i;
            sz[i]=1;
        }
    }

    /**
     * 查找过程，查找元素p所对应的集合编号
     * o（h）复杂度，h为树的高度
     * @param p
     * @return
     */
    private int find(int p){
        if (p<0||p>=parent.length){
            throw new IllegalArgumentException("p is out of bound");
        }
        while (p!=parent[p]) {
            p=parent[p];
        }
        return p;
    }

    /**
     * 合并元素p和元素q所属的集合
     * 0（h）复杂度，h为树的高度
     * @param p
     * @param q
     */
    @Override
    public void unionElements(int p, int q) {
        int pRoot=find(p);
        int qRoot=find(q);
        if (pRoot==qRoot){
            return;
        }
        //在合并时对2个元素的节点要先判断，将节点少的根节点连接到多的根节点上去，这样对树的高度不会有太大的变化，同时还要增加sz的值。
        if (sz[pRoot]<sz[qRoot]){
            parent[pRoot]=qRoot;
            sz[qRoot]+=sz[pRoot];
        }else {
            parent[qRoot]=pRoot;
            sz[pRoot]+=sz[qRoot];
        }
    }


    @Override
    public boolean isConnected(int p, int q) {
        return find(p)==find(q);
    }

    @Override
    public int getSize() {
        return parent.length;
    }
}
