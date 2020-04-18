package com.test;

public class Solution5two {
    public static  String longestPalindrome(String s) {
        if(s.length()==1) return s;
        int max=0;
        String ans="";
        for(int i=0;i<s.length()-1;++i){
            for(int j=i+1;j<s.length();j++){
                String test=s.substring(i,j);
                if(isValid(test)&&test.length()>max){
                    ans=s.substring(i,j);
                    max=Math.max(max,ans.length());
                }
            }
        }
        return ans;
    }

    public static  boolean isValid(String s){
        int len=s.length();
        for(int i=0;i<len/2;i++){
            if(s.charAt(i)==s.charAt(len-i-1)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s="cbbd";
        System.out.println(longestPalindrome(s));
    }
}
