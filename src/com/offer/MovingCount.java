package com.offer;

/**
 * @program: datastructure
 * @description: 机器人的运动范围
 * @author: Mr.Wang
 * @create: 2020-04-19 10:37
 **/
public class MovingCount {
    public int movingCount(int threshold, int rows, int cols){
        int[][] flag=new int[rows][cols];
        return helper(0,0,rows,cols,flag,threshold);
    }

    private int helper(int i, int j, int rows, int cols, int[][] flag, int threshold) {
        if (i<0||i>=rows||j<0||j>=cols||flag[i][j]==1||numSum(i)+numSum(j)>threshold){
            return 0;
        }
        flag[i][j]=1;
        return helper(i-1,j,rows,cols,flag,threshold)+
                helper(i+1,j,rows,cols,flag,threshold)+
                helper(i,j-1,rows,cols,flag,threshold)+
                helper(i,j+1,rows,cols,flag,threshold)+1;
    }

    public int numSum(int num){
        int result=0;
        while(num>0){
            result+=num%10;
            num/=10;
        }
        return  result;
    }
}
