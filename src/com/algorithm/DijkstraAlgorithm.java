package com.algorithm;


import java.util.Arrays;

/*
解决图中最短路径，一个顶点到其他顶点的最短路径
 */
public class DijkstraAlgorithm {
    public static void main(String[] args) {
        char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int[][] matrix = new int[vertex.length][vertex.length];
        final int N = 65535;  //表示不可连接
        matrix[0]=new int[]{N,5,7,N,N,N,2};
        matrix[1]=new int[]{5,N,N,9,N,N,3};
        matrix[2]=new int[]{7,N,N,N,8,N,N};
        matrix[3]=new int[]{N,9,N,N,N,4,N};
        matrix[4]=new int[]{N,N,8,N,N,5,4};
        matrix[5]=new int[]{N,N,N,4,5,N,6};
        matrix[6]=new int[]{2,3,N,N,4,6,N};
        Graph graph = new Graph(vertex,matrix);
        graph.showGraph();
        graph.dsj(6);
        graph.showDijkstra();
    }
}

class Graph{
    private char[] vertex;  //顶点数组
    private int [][] matrix;    //邻接矩阵
    private VisitedVertex vv;       //已经访问的顶点的集合

    public Graph(char[] vertex,int [][] matrix){
        this.vertex=vertex;
        this.matrix=matrix;
    }

    public void showGraph(){
        for (int[] link:matrix){
            System.out.println(Arrays.toString(link));
        }
    }

    public void showDijkstra(){
        vv.show();
    }

    //迪杰斯特拉算法
    /**
     * @param index 出发顶点对应的下标
     */
    public void dsj(int index){
        vv = new VisitedVertex(vertex.length, index);
        update(index);      //更新index顶点到周围顶点的距离和前驱顶点
        for (int j=1;j<vertex.length;j++){
            index=vv.updateArr();       //选择并返回新的访问顶点
            update(index);
        }
    }


    //更新index下标顶点到周围顶点的距离和周围顶点的前驱顶点
    public void update(int index){
        int len=0;
        //根据遍历邻接矩阵的matrix[index]行
        for (int j=0;j<matrix[index].length;j++){
            //len表示：出发顶点到index顶点的距离加上从index这个顶点到j的顶点的距离的和
            len=vv.getDis(index)+matrix[index][j];
            //如果j没有被访问过，并且len小于出发顶点到j点的距离，就需要更新
            if (!vv.in(j)&&len<vv.getDis(j)){
                //跟新j的前驱为index这个顶点
                vv.updatePre(j,index);
                //更新出发顶点到j顶点的距离
                vv.updateDis(j,len);
            }
        }
    }
}

//以访问顶点集合
class VisitedVertex{
    //记录各个顶点是否被访问过， 1表示被访问过。0未访问过
    public int [] already_arr;
    //每个下标对应的值为前一个顶点下标
    public int [] pre_visited;
    //记录出发顶点到其他所有顶点的距离，比如G为出发顶点，就会记录G到其他顶点的距离，求的最短距离就会存放到dis
    public int []dis;

    /**
     *
     * @param lenght    顶点的个数
     * @param index     出发顶点的下标
     */
    public VisitedVertex(int lenght,int index){
        this.already_arr=new int[lenght];
        this.pre_visited=new int[lenght];
        this.dis=new int[lenght];
        Arrays.fill(dis,65535);
        this.already_arr[index]=1;  //设置出发顶点被访问过
        this.dis[index]=0;      //设置出发顶点的访问距离为0
    }

    public void show(){
        System.out.println("==============");
        for (int i:already_arr){
            System.out.println(i+" ");
        }
        System.out.println();
        for (int i:pre_visited){
            System.out.println(i+" ");
        }
        System.out.println();
        for (int i:dis){
            System.out.println(i+" ");
        }
        System.out.println();
        char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int count=0;
        for (int i:dis){
            if (i!=65535){
                System.out.println(vertex[count]+"("+i+")");
            }else {
                System.out.println("N");
            }
            count++;
        }
        System.out.println();

    }

    public int updateArr(){
        int min=65535,index=0;
        for (int i=0;i<already_arr.length;i++){
            if (already_arr[i]==0&&dis[i]<min){
                min=dis[i];
                index=i;
            }
        }
        already_arr[index]=1;
        return index;
    }
    /**
     * 判断index顶点是否被访问过
     * @param index
     * @return
     */
    public boolean in(int index){
        return already_arr[index]==1;
    }

    /**
     * 更新出发顶点到index顶点的距离
     * @param index
     * @param len
     */
    public void updateDis(int index,int len){
        dis[index]=len;
    }

    /**
     * 更新pre这个顶点的前驱为index结点
     * @param pre
     * @param index
     */
    public void updatePre(int pre,int index){
        pre_visited[pre]=index;
    }

    /**
     * 返回出发顶点到index这个顶点的距离
     * @param index
     */
    public int  getDis(int index){
        return dis[index];
    }
}
