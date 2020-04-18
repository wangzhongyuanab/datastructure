package com.mukewang;

/**
 * 第二版并查集，子节点指向父节点
 */
public class UnionFindTwo implements UF{

    private int[] parent;

    public UnionFindTwo(int size){
        parent=new int[size];
        for (int i=0;i<size;i++){
            parent[i]=i;
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
        parent[pRoot]=qRoot;
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
