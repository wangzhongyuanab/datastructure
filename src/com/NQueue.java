package com;



/**
 * @author 王
 * @version 1.0
 * @create 2020/3/18 下午3:18
 */
class NQueue {

    private static int size;
    private static  int count;
    public static  int solveNQueens(int n) {
        count=0;
        size=(1<<n)-1;
        solve(0,0,0);
        return count;
    }

    private static void solve(int row,int ld,int rd){
        if(row==size){
            count++;
            return;
        }
        int pos=size&(~(row|ld|rd));
        while(pos!=0){
            int p=pos&(-pos);
            pos-=p;
            solve(row|p,(ld|p)<<1,(rd|p)>>1);
        }
    }

    public static void main(String[] args) {
        System.out.println(solveNQueens(8));
    }
}
