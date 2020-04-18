package com.offer;

public class cuttingRope {

    //递归
    public static int cuttingRope(int n) {
        if(n==2){
            return 1;
        }
        int res=-1;
        for(int i=1;i<=n;i++){
            res=Math.max(res,Math.max(i*(n-i),i*cuttingRope(n-i)));
        }
        return res;
    }

    //记忆化搜索
    public static int[] memo;
    public static int cuttingRope2(int n) {
        memo=new int[n+1];
        return dfs(n);
    }

    private static int dfs(int n) {
        if (n==1) return 1;
        if (n==2) return 1;
        if(memo[n]!=0) return memo[n];
        int res=-1;
        for(int i=1;i<=n;i++){
            res=Math.max(res,Math.max(i*(n-i),i*dfs(n-i)));
        }
        memo[n]=res;
        return res;
    }

    //动态规划
    public static int cuttingRope3(int n) {
        int[] dp=new int[n+1];
        dp[2]=1;
        for(int i=3;i<n+1;i++){
            for(int j=3;j<i;j++){
                dp[i]=Math.max(dp[i],Math.max((i-j)*j,j*dp[i-j]));
            }
        }
        return dp[n];
    }


    public static void main(String[] args) {
        System.out.println(cuttingRope3(8));
    }
}
