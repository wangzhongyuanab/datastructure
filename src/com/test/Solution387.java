package com.test;

/**
 * 字符串中的第一个唯一字符
 */
public class Solution387 {
    public int firstUniqChar(String s) {
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return  -1;
    }

    public static  int firstUniqChar2(String s) {
        boolean equ;
        for(int i=0;i<s.length()-1;i++){
            equ=false;
            for(int j=i+1;j<s.length();j++){
               if(s.charAt(i)==s.charAt(j)&&i!=j){
                   equ=true;
                   break;
               }
            }
            if(!equ) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String a=" ";
        System.out.println(firstUniqChar2(a));
    }
}

