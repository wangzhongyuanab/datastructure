package com.test;

import java.nio.charset.Charset;

import java.util.Arrays;
import java.util.HashSet;


/**
 * 反转字符串中的元音字母
 */
public class Solution345 {
    private final static HashSet<Character> set = new HashSet<>(Arrays.asList('a','o','e','i','u','A','O','E','I','U'));
    public static String reverseVowels(String s) {
//    public static String reverseVowels(String s) {
////        int i = 0;
////        int j = s.length() - 1;
////        List arrayList = new ArrayList();
////        char temp;
////        StringBuilder strBuilder = new StringBuilder(s);
////        arrayList.add('a');
////        arrayList.add('e');
////        arrayList.add('i');
////        arrayList.add('o');
////        arrayList.add('u');
////        arrayList.add('A');
////        arrayList.add('E');
////        arrayList.add('I');
////        arrayList.add('O');
////        arrayList.add('U');
////        while(i<j){
////            if (arrayList.contains(s.charAt(i)) == true && arrayList.contains(s.charAt(j)) == true){
////                temp = s.charAt(i);
////                strBuilder.setCharAt(i, s.charAt(j));
////                strBuilder.setCharAt(j, temp);
////                i++;
//                j--;
//            }else if(arrayList.contains(s.charAt(i)) == true && arrayList.contains(s.charAt(j)) != true)
//            { j--;}
//            else if(arrayList.contains(s.charAt(i)) != true && arrayList.contains(s.charAt(j)) == true)
//            { i++;}
//            else {
//                i++;
//                j--;
//            }
//        }
//        return strBuilder.toString();\
        int i = 0,j = s.length()-1;
        char[] result = new char[s.length()];
        while(i<=j){
            char ci = s.charAt(i);
            char cj =s.charAt(j);
            if(!set.contains(ci)){
                result[i++] = ci;
            }else if(!set.contains(cj)){
                result[j--] = cj;
            }else{
                result[i++] = cj;
                result[j--] = ci;
            }
        }
        return new String(result);
    }

    public static void main(String[] args) {
        String a="hello";
        String b=reverseVowels(a);
        System.out.println(b);
    }
}
