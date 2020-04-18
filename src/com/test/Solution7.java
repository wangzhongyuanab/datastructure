package com.test;


import java.nio.charset.Charset;
import java.util.Stack;

/**
 * 整数反转
 *
 *
 *
 * 输入：123
 * 输出: 321
 *
 * 输入: -123
 * 输出: -321
 *
 * 输入: 120
 * 输出: 21
 */

public class Solution7 {
    public static int reverse(int x) {
//        Stack<Character> stack=new Stack<Character>();
//        String xString=Integer.toString(x);
//        if (x>0) {
//            for (int i = 0; i < xString.length(); i++) {
//                char c = xString.charAt(i);
//                if (Character.isDigit(c)) {
//                    stack.push(c);
//                }
//            }
//            StringBuilder stringBuilder = new StringBuilder();
//            while (!stack.isEmpty()) {
//                stringBuilder.append(stack.pop());
//            }
//            if (Long.parseLong(stringBuilder.toString())>Integer.MAX_VALUE){
//                return 0;
//            }else{
//                return Integer.parseInt(stringBuilder.toString());
//            }
//        }else if (x==0){
//            return 0;
//        }else{
//            for (int i = 1; i < xString.length(); i++) {
//                char c = xString.charAt(i);
//                if (Character.isDigit(c)) {
//                    stack.push(c);
//                }
//            }
//            StringBuilder stringBuilder = new StringBuilder();
//            stringBuilder.append("-");
//            while (!stack.isEmpty()) {
//                stringBuilder.append(stack.pop());
//            }
//            if (Long.parseLong(stringBuilder.toString())<Integer.MIN_VALUE){
//                return 0;
//            }else {
//                return Integer.parseInt(stringBuilder.toString());
//            }
//        }
        long res=0;
        while(x!=0){
            res=res*10+x%10;
            x/=10;
            if (res>Integer.MAX_VALUE||res<Integer.MIN_VALUE){
                return 0;
            }
        }
        return (int)res;
    }

    public static void main(String[] args) {
        int x=123;
        System.out.println(reverse(1534236469));
    }
}
