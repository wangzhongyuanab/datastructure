package com.test;

public class Solution771 {
    public static  int numJewelsInStones(String J, String S) {
        int ans=0;
        for (char s : S.toCharArray()) {
            for (char j : J.toCharArray()) {
                if(j==s){
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String a="aA";
        String b="aAAbbbb";
        System.out.println(numJewelsInStones(a, b));
    }
}
