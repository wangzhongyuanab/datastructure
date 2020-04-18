package com.test;

/**
 *  验证回文串
 */
public class Solution125 {
    public static boolean isPalindrome(String s) {
        int l=0;
        int r=s.length()-1;
        while(l<r){
            while(l<r&&!Character.isLetterOrDigit(s.charAt(l))) l++;
            while(l<r&&!Character.isLetterOrDigit(s.charAt(r))) r--;
            if (Character.toLowerCase(s.charAt(l++))!=Character.toLowerCase(s.charAt(r--))) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s="race a car";
        System.out.println(isPalindrome(s));
    }
}
