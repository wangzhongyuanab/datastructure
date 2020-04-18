package com.test;

/**
 *  实现 strStr()
 */
public class Solution28 {
    public static  int strStr(String haystack, String needle) {
        if(needle.length()==0) return 0;
        for (int i=0;i<=haystack.length()-needle.length();i++){
            if (haystack.substring(i,i+needle.length()).equals(needle)) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        String haystack="hello";
        String needle="ll";
        System.out.println(strStr(haystack,needle));
    }
}
