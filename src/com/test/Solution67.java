package com.test;

/**
 *  二进制求和
 */
public class Solution67 {
    public static String addBinary(String a, String b) {
        StringBuilder builder=new StringBuilder();
        int i=a.length()-1;
        int j=b.length()-1;
        int remain=0;
        while (i>=0||j>=0){
            int sum=remain;
            if (i>=0) sum+=a.charAt(i)-'0';
            if (j>=0) sum+=b.charAt(j)-'0';
            builder.append(sum%2);
            remain=sum/2;
        }
        if (remain!=0){
            builder.append(remain);
        }
        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        String a="11";
        String b="1";
        System.out.println(addBinary(a,b));
    }
}
