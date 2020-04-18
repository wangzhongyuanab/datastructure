package com.test;

/**
 * 买卖股票的最佳时机
 */
public class Solution121 {

    //二次循环
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > max) {
                    max = profit;
                }
            }
        }
        return max;
    }

    //一次循环
    public static int maxProfit2(int[] prices) {
            int minprice = Integer.MAX_VALUE;
            int maxprofit = 0;
            for (int i = 0; i < prices.length; i++) {
                if (prices[i] < minprice)
                    minprice = prices[i];
                else if (prices[i] - minprice > maxprofit)
                    maxprofit = prices[i] - minprice;
            }
            return maxprofit;
        }

    //一次循环
    public static int maxProfit3(int[] prices) {
        if (prices.length<2||prices==null){
            return 0;
        }
        int min=prices[0];
        int pro=0;
        for (int i=1;i<prices.length;i++){
            if (prices[i]<min){
                min=prices[i];
            }else if (prices[i]>min){
                int temp=prices[i]-min;
                if (temp>pro){
                    pro=temp;
                }
            }
        }
        return pro;
    }

    public static void main(String[] args) {
        int [] prices={7,1,5,3,6,4};
        System.out.println(maxProfit2(prices));
    }
}

