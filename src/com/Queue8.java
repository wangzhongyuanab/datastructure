package com;

/**
 * 8皇后
 */
public class Queue8 {

    //定义有多少个皇后
    int max=8;
    //arr[i]=val; val表示第i+1个皇后，放在第i+1行的第val+1列.    //定义数组保存皇后放置位置的结果,比如{0，4，7，5，2，6，1，3}
    int []arr=new int[max];
    static int count=0;
    static int judgeCount=0;
    public static void main(String[] args) {
        Queue8 queue8 = new Queue8();
        queue8.check(0);
        System.out.println("一共有解法："+count);
        System.out.println("一共判断冲突次数："+judgeCount);
    }

    //查看当我们放置第n个皇后，检测该皇后是否和以前的皇后已经冲突

    /**
     * @param n 表示第几个皇后
     * @return
     */
    private boolean judge(int n){
        judgeCount++;
        for (int i=0;i<n;i++){
            //arr[i]==arr[n]：表示判断第n个皇后是否和前面n-1个皇后在同一列
            //Math.abs(n-i)==Math.abs(arr[n]-arr[i]：表示判断第n个皇后是否和第i个皇后在同一斜线
            //当n=1时，放在第2列 即arr【1】=1；
            if (arr[i]==arr[n]||Math.abs(n-i)==Math.abs(arr[n]-arr[i])){
                return false;
            }
        }
        return true;
    }

    //放置第n个皇后
    //check是每一次递归时，进入到check中都有for (int i=0;i<max;i++)，因此会有回溯。
    private void check(int n){
        if (n==max){   //n=8，表示放第9个皇后,表示第8个皇后已经放好
            print();
            return;
        }
        //有一个循环一次放入皇后并判断是否冲突
        for (int i=0;i<max;i++){
            //先把这个皇后n放入该行的第一列
            arr[n]=i;
            //判断当放置第n个皇后到i列时是否冲突
            if (judge(n)){      //不冲突
                //接着放n+1个皇后，即开始递归
                check(n+1);
            }
            //如果冲突，就继续执行arr【n】=i；即将第n个皇后放置在本行的后移的一个位置
        }
    }


    // 将皇后排放的位置输出
    private void print(){
        count++;
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]+"");
        }
        System.out.println();
    }
}
