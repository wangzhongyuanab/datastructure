package com.test;

import java.util.TreeSet;

/**
 * 唯一摩尔斯密码词
 * java的TreeSet是基于红黑树实现的,平衡二叉树
 */
public class Solution804 {
    public int uniqueMorseRepresentations(String[] words) {
        String[] codes={".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        TreeSet<String> set=new TreeSet<>();
        for (String word : words) {
            StringBuilder res=new StringBuilder();
            for (int i=0;i<word.length();i++){
                res.append(codes[word.charAt(i)-'a']);
            }
            set.add(res.toString());
        }
        return set.size();
    }
}
