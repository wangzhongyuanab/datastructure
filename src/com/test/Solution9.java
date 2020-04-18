package com.test;

/**
 * 回文数,正着和反着一样
 */
public class Solution9 {
    public boolean isPalindrome(int x) {
        if (x<0||x!=0&&x%10==0)  return false;
        int palind=x;
        int rev=0;
        while (x>0){
            rev=rev*10+x%10;
            x/=10;
        }
        return palind==rev;
    }
}
