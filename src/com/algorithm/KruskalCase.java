package com.algorithm;


/**
 * 克鲁斯卡尔算法解决最小生成树
 */
public class KruskalCase {
    private int edgeNum;    //边的个数
    private char[] vertexs; //顶点数组
    private int [][] matrix; //邻接矩阵
    //使用INF表示2个顶点不能联通
    private static final  int INF=Integer.MAX_VALUE;
    public static void main(String[] args) {
        char[] vertexs={'A','B','C','D','E','F','G'};
        int [][]matrix={
                {0,12,INF,INF,INF,16,14},
                {12,0,10,INF,INF,4,INF},
                {INF,10,0,3,5,6,INF},
                {INF,INF,3,0,4,INF,INF},
                {INF,INF,5,4,0,2,8},
                {16,7,6,INF,2,0,9},
                {14,INF,INF,INF,8,9,0},
        };
        KruskalCase kruskalCase = new KruskalCase(vertexs, matrix);
        kruskalCase.print();
        kruskalCase.kruskal();
    }


    public KruskalCase(char[] vertexs,int [][] matrix){
        //初始化
        int vlen=vertexs.length;
        //初始化顶点。
        this.vertexs=new char[vlen];
        for (int i=0;i<vertexs.length;i++){
            this.vertexs[i]=vertexs[i];
        }
        this.matrix=new int[vlen][vlen];
        for (int i=0;i<vlen;i++){
            for (int j=0;j<vlen;j++){
                this.matrix[i][j]=matrix[i][j];
            }
        }

        //统计边
        for (int i=0;i<vlen;i++){
            for (int j=i+1 ;j<vlen;j++){
                if (this.matrix[i][j]!=INF){
                    edgeNum++;
                }
            }
        }
    }

    public void  print(){
        System.out.println("邻接矩阵为：");
        for (int i=0;i<vertexs.length;i++){
            for (int j=0;j<vertexs.length;j++){
                System.out.printf("%12d\t",matrix[i][j]);
            }
            System.out.println();
        }
    }

    //对边排序处理
    //edges:边的集合，对边进行排序,冒泡排序
    private void sortEdges(EData[] edges){
        for (int i=0;i<edges.length-1;i++){
            for (int j=0;j<edges.length-1-i;j++){
                if (edges[j].weight>edges[j+1].weight){     //交换
                    EData tmp=edges[j];
                    edges[j]=edges[j+1];
                    edges[j+1]=tmp;
                }
            }
        }
    }

    //返回顶点的下标,比如‘A’返回0
    private int getPosition(char ch){
        for (int i=0;i<vertexs.length;i++){
            if (vertexs[i]==ch){
                return i;
            }
        }
        return -1;
    }

    /*
    获取图中的边，放到数组中
    EData[] 形式 [['A','B',12],['B','F',7],...]
     * @return
     */
    private EData[] getEdges(){
        int index=0;
        EData[] edges =new EData[edgeNum];
        for (int i=0;i<vertexs.length;i++){
            for (int j=i+1;j<vertexs.length;j++){
                if (matrix[i][j]!=INF){
                    edges[index++]=new EData(vertexs[i],vertexs[j],matrix[i][j]);
                }
            }
        }
        return edges;
    }

    /**
     * 获取下标为i的顶点的终点(动态)，用于判断2个点的的终点是否相同
     * @param ends：记录各个顶点对应的终点是哪个，ends是在遍历过程中逐渐形成
     * @param i ：
     * @return
     */
    public int getEnd(int[] ends,int i){
        while (ends[i]!=0){
            i=ends[i];
        }
        return i;
    }

    public void kruskal(){

        int index=0;    //表示最后结果数组的索引
        int [] ends=new int[edgeNum];  //用于保存已有最小生成树中的每个顶点在最小生成树的终点
        //创建结果集数组，保存最后的最小生成树
        EData[] rets=new EData[edgeNum];
        //获取图中所有边的集合
        EData[] edges=getEdges();
        //按照图的权值大小进行排序
        sortEdges(edges);
        //遍历edges数组，将边添加到最小生成树中，判断加入的边是否构成了回路，啊如果没有就加入到结果数组中，否则就不加入
        for (int i=0;i<edgeNum;i++){
            int p1=getPosition(edges[i].start);
            int p2=getPosition(edges[i].end);
            //获取p1这个顶点在已有的最小生成树中的终点是哪个
            int m=getEnd(ends,p1);
            //获取p2这个顶点在已有的最小生成树中的终点是哪个
            int n=getEnd(ends,p2);
            //是否构成回路
            if (m!=n){  //不构成回路
                ends[m]=n; //设置m在已有最小生成树中的终点
                rets[index++]=edges[i];     //有一条边加入到res数组
            }
        }
        System.out.println("最小生成树为：");
        for (int i=0;i<index;i++){
            System.out.println(rets[i]);
        }
    }

}

/**
 * 表示一条边
 */
class EData{
    char start;
    char end;
    int weight;
    public EData(char start,char end,int weight){
        this.start=start;
        this.end=end;
        this.weight=weight;
    }

    @Override
    public String toString() {
        return "EData{" +
                "<" + start +
                "," + end +
                ",> =" + weight +
                '}';
    }

}
