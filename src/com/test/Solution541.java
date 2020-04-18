package com.test;

public class Solution541 {
    public static  String reverseStr(String s, int k) {
        int kk=k*2;
        int n=s.length();
        char[] chars=s.toCharArray();
        for(int i=0;i<n;i+=kk){
            if(i+kk<n){
                reverse(chars,i,i+k-1);
            }else if(i+k<n){
                reverse(chars,i,i+k-1);
            }else{
                reverse(chars,i,n-1);
            }
        }
        return new String(chars);
    }

    private static char[] reverse(char[] chars, int begin, int end) {
        while(begin<end){
            char c=chars[begin];
            chars[begin++]=chars[end];
            chars[end--]=c;
        }
        return chars;
    }

    public static void main(String[] args) {
        String a="abcdefg";
        System.out.println(reverseStr(a,2));
    }
}
