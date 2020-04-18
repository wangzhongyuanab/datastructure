package com.test;

public class Solution69 {
    public static int mySqrt(int x) {
        if(x<=0) return 0;
        int low=1,high=x;
        while (low<=high) {
            long mid = (high - low) / 2 + low;
            if (mid * mid == x) {
                return (int) mid;
            } else if (mid * mid < x) {
                low = (int) mid + 1;
            } else high = (int) mid - 1;
        }
        if (high*high<x){
            return (int)high;
        }else {
            return (int)low;
        }
    }

    public static int mySqrt2(int x){
        long res=x;
        while (res*res>x){
            res=(res+x/res)/2;
        }
        return (int)res;
    }

    public static void main(String[] args) {
        int x=8;
        System.out.println(mySqrt2(x));

    }
}
