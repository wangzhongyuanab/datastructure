package com.algorithm;


class KMPAlgorithm {

    public static void main(String[] args) {
        String str1="BBC ABCDAB ABCDABCDABDE";
        String str2="ABCDABD";
        int []next=kmpNext(str2);
        int i = kmpSearch(str1, str2, next);
        System.out.println(i);
    }

    //获取到一个字符串子串的部分匹配值的表
    public static int[] kmpNext(String dest){
        int[] next=new int[dest.length()];
        next[0]=0;  //如果字符串长度是1部分匹配值就是0
        for (int i=1,j=0;i<dest.length();i++){
            //当dest.charAt(i)！=dest.charAt(j)
            while (j>0&&dest.charAt(i)!=dest.charAt(j)){
                j=next[j-1];
            }
            if (dest.charAt(i)==dest.charAt(j)){
                j++;
            }
            next[i]=j;
        }
        return next;
    }

    //kmp搜索算法
    public static  int kmpSearch(String str1,String str2,int []next){
        for (int i=0,j=0;i<str1.length();i++){
            //需要处理str1.charAt(i)！=str2.charAt(j)
            //kmp的核心点
            while (j>0&&str1.charAt(i)!=str2.charAt(j)){
                j=next[j-1];
            }
            if (str1.charAt(i)==str2.charAt(j)){
                j++;
            }
            if (j==str2.length()){
                return i-j+1;
            }
        }
        return -1;
    }
}
