package com.test;

/**
 *  反转字符串
 */
public class Solution344 {
    public static void reverseString(char[] s) {
    int i=0;
    int j=s.length-1;
    while(i<j){
        char temp=s[j];
        s[j]=s[i];
        s[i]=temp;
        i++;
        j--;
    }
    }

    public static void main(String[] args) {
        char []arr={'h','e','l','l','o'};
        reverseString(arr);
        for (int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }

    }
}
