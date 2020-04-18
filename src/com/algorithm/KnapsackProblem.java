package com.algorithm;


/**
 * 01背包问题
 * 动态规划
 */
public class KnapsackProblem {

    public static void main(String[] args) {
        int[] w={1,4,3};        //物品的重量
        int []val={1500,3000,2000};      //物品的价值,这里val【i】就是讲的v[i]
        int m=4;    //背包的容量
        int n=val.length;    //物品的个数

        //记录放入商品的情况
        int [][] path=new int[n+1][m+1];

        //创建二维数组
        //v[][] 表示在前i个物品中能够装入容量为j的背包中的最大价值
        int [][]v=new int[n+1][m+1];

        //初始化第一行第一列
        for (int i=0;i<v.length;i++) {
            v[i][0] = 0;        //将第一列设置为0
        }
        for (int i=0;i<v[0].length;i++){
            v[0][i]=0;         //将第一行设置为0
        }

        //根据前面得到的公式进行动态规划处理
        for (int i=1;i<v.length;i++){       //不处理第一行
            for (int j=1;j<v[0].length;j++){
                //公式
                if (w[i-1]>j){        //因为i从1开始所以w【i】要变成w【i-1】
                    v[i][j]=v[i-1][j];
                }else {
                    //还是因为i是从1开始的因此公式需要调整成val【i】=val【i-1】，w【i】=w【i-1】
                    //v[i][j]=Math.max(v[i-1][j],val[i-1]+v[i-1][j-w[i-1]]);
                    //为了记录商品存放到背包的情况
                    if (v[i-1][j]<val[i-1]+v[i-1][j-w[i-1]]){
                        v[i][j]=val[i-1]+v[i-1][j-w[i-1]];
                        path[i][j]=1;
                    }else {
                        v[i][j]=v[i-1][j];
                    }
                }
            }
        }

        for (int i=0;i<v.length;i++) {
            for (int j=0;j<v[i].length;j++) {
                System.out.print(v[i][j]+" ");
            }
            System.out.println();
        }

//        //输出最终放入的哪些商品
        //这样输出会把所有遍历的情况都得到其实我们只需要最后的放入
//        for (int i=0;i<path.length;i++){
//            for (int j=0;j<path[i].length;j++){
//                if (path[i][j]==1){
//                    System.out.printf("第%d个商品放入到背包",i);
//                }
//            }
//        }
        int i=path.length-1;
        int j=path[0].length-1;
        while (i>0&&j>0){    //从path的最后开始找
            if (path[i][j]==1){
                System.out.printf("第%d个商品放入到背包\n  ",i);
                j-=w[i-1];
            }
            i--;
        }
    }
}
