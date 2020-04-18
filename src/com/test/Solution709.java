package com.test;

class Solution709 {
    public static  String toLowerCase(String str) {
        char[] chars = str.toCharArray();
        for(int i=0;i<chars.length;i++){
            if(chars[i]>='A'&&chars[i]<='Z') {
                chars[i] += 32;
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        String a="HELLO";
        System.out.println(toLowerCase(a));
    }
}
