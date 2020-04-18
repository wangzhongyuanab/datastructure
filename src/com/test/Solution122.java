package com.test;

/**
 *  买卖股票的最佳时机 II
 */
public class Solution122 {
//    public int maxProfit(int[] prices) {
//        if (prices.length<2||prices==null) return 0;
//        int min=prices[0];
//        int pro=0;
//        int sum=0;
//        for (int j=0;j<prices.length;j++) {
//            for (int i = 1; i < prices.length; i++) {
//                if (prices[i] < min) {
//                    min = prices[i];
//                } else if (prices[i] > min) {
//                    int temp = prices[i] - min;
//                    if (temp > pro) {
//                        pro = temp;
//                        sum+=pro;
//                    }
//                }
//            }
//        }
//    return sum;
//    }

    public static int maxProfit(int[] prices) {
        int i=0;
        int valley=prices[0];
        int peak=prices[0];
        int max=0;
        while (i<prices.length-1){
            while(i<prices.length-1&&prices[i]>=prices[i+1]){
                i++;
            }
            valley = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i + 1])
                i++;
            peak = prices[i];
            max += peak - valley;
        }
        return max;
    }
    public static int maxProfit2(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
    }

    public static void main(String[] args) {
        int []prices={7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
}
