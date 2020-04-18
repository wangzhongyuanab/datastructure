package com.test;

/**
 * 字符串转换整数 (atoi)
 */
public class Solution8 {
    public static int myAtoi(String str) {
        str=str.trim();
        if (str==null||str.length()==0) return 0;
        char firstChar=str.charAt(0);
        int sign=1;
        int start=0;
        long res=0;
        if (firstChar=='+'){
            sign=1;
            start++;
        }else if (firstChar=='-'){
            sign=-1;
            start++;
        }
        for (int i=start;i<str.length();i++){
            if (!Character.isDigit(str.charAt(i))){
                return (int)res*sign;
            }
            res=res*10+str.charAt(i)-'0';
            if (sign==1&&res>Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (sign==-1&&res>Integer.MAX_VALUE)    return  Integer.MIN_VALUE;
        }
        return (int)res*sign;
    }

    public static void main(String[] args) {
        String s="4193 with words";
        System.out.println(myAtoi(s));
    }
}
