package com.test;

/**
 *  最长回文子串
 */
public class Solution5 {

    public static String longestPalindrome(String s) {
        if (s.length()==0||s==null) return s;
        String res="";
        boolean[][] dp=new boolean[s.length()][s.length()];
        int max=0;
        for (int j=0;j<s.length();j++){
            for (int i=0;i<=j;i++){
                dp[i][j]=s.charAt(i)==s.charAt(j)&&((j-i<=2)||dp[i+1][j-1]);
                if (dp[i][j]){
                    if (j-i+1>max){
                        max=j-i+1;
                        res=s.substring(i,j+1);
                    }
                }
            }
        }
        return res;
    }
    static String res="";
    public static String longestPalindrome2(String s) {
        if (s.length()==0||s==null) return s;
        for (int i=0;i<s.length();i++){
            helper(s,i,i);
            helper(s,i,i+1);
        }
        return res;
    }

    public static  void helper(String s,int left,int right){
        while(left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        String cur=s.substring(left+1,right);
        if (cur.length()>res.length()){
            res=cur;
        }
    }

    public static void main(String[] args) {
        String s="babad";
        System.out.println(longestPalindrome2(s));
    }
}
