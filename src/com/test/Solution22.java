package com.test;

import java.util.ArrayList;
import java.util.List;

/**
 *  括号生成，回溯
 */
public class Solution22 {
    public static List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();
        if (n==0) return res;
        helper(res,"",n,n);
        return res;
    }

    private static void helper(List<String> res, String s, int left, int right) {
        if (left>right){
            return;
        }
        if (left==0&&right==0){
            res.add(s);
            return;
        }
        if (left>0){
            helper(res,s+"(",left-1,right);
        }
        if (right>0){
            helper(res,s+")",left,right-1);
        }
    }

    public static void main(String[] args) {
        List<String> strings = generateParenthesis2(3);
        for (String string : strings) {
            System.out.println(string);
        }
    }


    public static List<String> generateParenthesis2(int n) {
        List<String> res=new ArrayList<>();
        //这里的left和right表示左括号和右括号用了几次
        generate(0,0,n,"",res);
        return res;
    }

    private static void generate(int left, int right,int n, String s,List<String> res) {
        //terminator
        if (left==n&&right==n){
            res.add(s);
            return;
        }
        //process
        //drill down
        if (left<n) {
            generate(left + 1,right, n, s + "(",res);
        }
        if (left>right) {
            generate(left, right+1,n, s + ")",res);
        }
        //reverse staets
    }


}
