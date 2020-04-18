package com.algorithm;

import java.util.Arrays;

/**
 * 普里姆算法求修路问题，权值最小,求最小生成树
 */
public class Prim {
    public static void main(String[] args) {
        char[] data=new char[]{'A','B','C','D','E','F','G'};
        int verxs=data.length;
        //10000表示这2个点不连通
        int [][]weight=new int[][]{
                {10000,5,7,10000,10000,10000,2},
                {5,10000,10000,9,10000,10000,3},
                {7,10000,10000,10000,8,10000,10000},
                {10000,9,10000,10000,10000,4,10000},
                {10000,10000,8,10000,10000,5,4},
                {10000,10000,10000,4,5,10000,6},
                {2,3,10000,10000,4,6,10000},
        };
        MGraph graph = new MGraph(verxs);
        MinTree minTree = new MinTree();
        minTree.createGraph(graph,verxs,data,weight);
        minTree.showGraph(graph);

        //普里姆算法
        minTree.prim(graph,1);
    }
}


//创建生成最小生成树
class MinTree{

    //创建图的邻接矩阵
    /**
     *
     * @param graph 图对象
     * @param verxs     顶点个数
     * @param data      图的各个顶点的值
     * @param weight    图的邻接矩阵
     */
    public void createGraph(MGraph graph,int verxs,char data[],int [][]weight){
        int i,j;
        for ( i=0;i<verxs;i++){
            graph.data[i]=data[i];
            for (j=0;j<verxs;j++){
                graph.weight[i][j]=weight[i][j];
            }
        }
    }

    //显示图
    public void showGraph(MGraph graph){
        for (int[] link:graph.weight){
            System.out.println(Arrays.toString(link));
        }
    }


    //编写Prim算法
    /**
     * @param graph
     * @param v 从第几个顶点开始生成
     */
    public void prim(MGraph graph,int v){
        //标记顶点是否被访问过
        int[] visited = new int[graph.verxs];
        for (int i=0;i<graph.verxs;i++){
            visited[i]=0;
        }
        //把当前这个结点标记为已访问
        visited[v]=1;
        //用h1和h2记录2个顶点的下标
        int h1=-1;
        int h2=-1;
        int minWeight=10000;
        for (int k=1;k<graph.verxs;k++){    //因为有verxs个顶点,算法结束后，有verxs-1个边

            //这个是确定每一次生成的子图和哪个结点的距离最近
            for (int i=0;i<graph.verxs;i++){    //i结点表示被访问过的结点
                for (int j=0;j<graph.verxs;j++){    //j结点表示还没有访问过的结点
                    if (visited[i]==1&&visited[j]==0&&graph.weight[i][j]<minWeight){
                        //替换minweight(),寻找已经访问过的结点和未访问过的结点间权值最小边
                       minWeight=graph.weight[i][j];
                       h1=i;
                       h2=j;
                    }
                }
            }
            //已经找到一条边是最小权值的
            System.out.println("边<"+graph.data[h1]+","+graph.data[h2]+"> 权值："+minWeight);
            //将当前结点标记为已经访问过
            visited[h2]=1;
            //重新设置为最大值10000
            minWeight=10000;
        }
    }
 }
class MGraph{
    int verxs;   //表示图的结点个数
    char [] data;   //存放结点数据
    int [][] weight;  //存放边，就是邻接矩阵

    public MGraph(int verxs){
        this.verxs=verxs;
        data=new char[verxs];
        weight=new int[verxs][verxs];
    }
}

