package com.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * 图
 */
public class Graph {
    private ArrayList<String> vertexList;  //存储顶点集合
    private int [][] edges;   //存储图对应的邻接矩阵
    private int numOfEdges;   //表示边的数目
    //定义一个数组boolean【】，记录某个节点是否被访问
    private boolean[] isVisited;
    public static void main(String[] args) {
        int n=5;  //结点的个数
        String VertexValue[]={"A","B","C","D","E"};
        //创建图对象
        Graph graph = new Graph(n);
        for (String value:VertexValue){
            graph.insertVertex(value);
        }
        graph.insertEdge(0,1,1);
        graph.insertEdge(0,2,1);
        graph.insertEdge(1,2,1);
        graph.insertEdge(1,3,1);
        graph.insertEdge(1,4,1);
        graph.showGraph();
        System.out.println("深度遍历：");
        graph.dfs();
        System.out.println();
        System.out.println("广度优先");
        graph.bfs();

    }

    public Graph(int n){
        edges=new int[n][n];
        vertexList=new ArrayList<String>(n);
        numOfEdges=0;
    }

    //插入结点
    public void insertVertex(String vertex){
        vertexList.add(vertex);
    }

    //得到第一个邻接结点的下标w
    public int getFirstNeighbor(int index){
        for (int j=0;j<vertexList.size();j++){
            if (edges[index][j]>0)
                return j;
        }
        return -1;
    }

    //根据前一个邻接结点的下标来获取下一个邻接结点
    public int getNextNeighbor(int v1,int v2){
        for (int j=v2+1;j<vertexList.size();j++){
            if (edges[v1][j]>0){
                return j;
            }
        }
        return -1;
    }


    //深度优先遍历算法
    //i 第一次就是0
    private void dfs(boolean[]  isVisited,int i){
        //首先访问该节点,输出
        System.out.print(getValueByIndex(i)+"->");
        //将该结点设置为已经访问过
        isVisited[i]=true;
        //查找结点i的第一个邻接结点
        int w=getFirstNeighbor(i);
        while (w!=-1){  //说明存在w
            if (!isVisited[w]){
                dfs(isVisited, w);
            }//如果w已经被发访问过
            w=getNextNeighbor(i,w);
        }
    }



    //对dfs进行一个重载,遍历我们所有的结点，并进行dfs
    public void dfs(){
        isVisited=new boolean[5];
        //遍历所有的结点，进行dfs【回溯】
        for(int i=0;i<getNumOfEdges();i++){
            if (!isVisited[i]){
                dfs(isVisited,i);
            }
        }
    }

    //对一个结点广度优先遍历
    private void bfs(boolean[] isVisited,int i){
        int u;      //表示队列的头结点对应下标
        int w;      //邻接结点w
        //队列，记录结点访问顺序
        LinkedList queue = new LinkedList();
        //访问这个结点，输出结点信息
        System.out.println(getValueByIndex(i)+"->");
        //标记为已访问
        isVisited[i]=true;
        //将结点加入队列
        queue.addLast(i);
        while (!queue.isEmpty()){
            //取出队列的头节点的下标
            u=(Integer) queue.removeFirst();
            //得到第一个邻接结点的下标
            w=getFirstNeighbor(u);
            while (w!=-1){  //w存在
                if (!isVisited[w]){
                    System.out.println(getValueByIndex(w)+"->");
                    isVisited[w]=true;
                    queue.addLast(w);
                }
                //以u为前驱点找w后面的下一个邻接结点
                w=getNextNeighbor(u,w);     //体现出广度优先
            }
        }
    }

    public void bfs(){
        isVisited=new boolean[5];
        for (int i=0;i<getNumOfVertex();i++){
            if (!isVisited[i]){
                bfs(isVisited,i);
            }
        }
    }

    //添加边
    /**
     * @param v1    表示点的下标即是第几个顶点
     * @param v2    表示
     * @param weight
     */
    public void insertEdge(int v1,int v2,int weight){
        edges[v1][v2]=weight;
        edges[v2][v1]=weight;
        numOfEdges++;
    }

    //返回节点的个数
    public int  getNumOfVertex(){
        return vertexList.size();
    }

    //返回边的数目
    public int getNumOfEdges(){
        return numOfEdges;
    }

    //返回节点i(下标)对应的数据  0->"A"   1->"B"
    public String getValueByIndex(int index){
        return vertexList.get(index);
    }

    //返回v1和v2的权值
    public int getWeight(int v1,int v2){
        return edges[v1][v2];
    }

    public void showGraph(){
         for (int [] link:edges){
             System.out.println(Arrays.toString(link));
         }
    }
}
