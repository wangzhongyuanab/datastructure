package com.test;

/**
 *  最后一个单词的长度
 */
public class Solution58 {
    public static  int lengthOfLastWord(String s) {
        return s.trim().length()-s.trim().lastIndexOf(" ")-1;
    }

    public  static int lengthOfLastWord2(String s) {
        int end = s.length() - 1;
        while(end >= 0 && s.charAt(end) == ' ') end--;
        if(end < 0) return 0;
        int start = end;
        while(start >= 0 && s.charAt(start) != ' ') start--;
        return end - start;
    }

    public static void main(String[] args) {
        String s="Hello world";
        System.out.println(lengthOfLastWord2(s));
    }
}
