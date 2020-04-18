package com.test;

/**
 * 爬楼梯
 */
public class Solution70 {
    public static int climbStairs(int n) {
        if (n<=2){
            return n;
        }else
            return climbStairs(n-1)+climbStairs(n-2);
    }

    public static int climbStairs2(int n) {
        if (n<=1) return  1;
        int oneStep=1,twoStep=1,res=0;
        for (int i=2;i<=n;i++){
            res=oneStep+twoStep;
            twoStep=oneStep;
            oneStep=res;
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(climbStairs2(3));
    }
}
