package com.mukewang;

/**
 * 第五版并查集，子节点指向父节点。增加了路径压缩的能力。find方法将p节点指向它父节点的父节点.
 */
public class UnionFindFive implements UF{

    private int[] parent;
    private int[] rank;     //rank【i】表示以i为根的集合所表示的树的层数
    public UnionFindFive(int size){
        parent=new int[size];
        rank=new int[size];
        for (int i=0;i<size;i++){
            parent[i]=i;
            rank[i]=1;
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
            parent[p]=parent[parent[p]];
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
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }
        //根据2个元素所在树的rank不同判断合并方向
        //将rank低的集合合并到rank高的集合上,
        if (rank[pRoot]<rank[qRoot]){
            //此时不需要再对rank进行同步
            parent[pRoot]=qRoot;
        }else if (rank[qRoot]<rank[pRoot]){
            parent[qRoot]=pRoot;
        }else{      //rank[qRoot]=rank[pRoot]
            parent[qRoot]=pRoot;
            rank[pRoot]+=1;
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
