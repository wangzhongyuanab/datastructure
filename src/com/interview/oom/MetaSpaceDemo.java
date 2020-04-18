package com.interview.oom;

public class MetaSpaceDemo {

    static class OOMTest{ }

    public static void main(String[] args) {
        int i=0;    //模拟计数都少次后异常
        try{
            while (true){
                i++;
                //使用Enhancer生成OOMTest模板类
            }
        }catch (Throwable e){
            System.out.println("多少次后发生异常:"+i);
            e.printStackTrace();
        }
    }
}
