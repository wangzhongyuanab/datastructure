package com;

public class ConstClass {
    static {
        System.out.println("ConstClass init!");
    }

    public static final String HELLOWORLD="helloworld";
}

//通过常量传播优化，常量已经存储到了NotInitialization3类的常量池中。因此以后Initialization对HELLOWORLD的引用就转化为NotInitialization3对
//自身常量池的引用
class NotInitialization3{
    public static void main(String[] args) {
        System.out.println(ConstClass.HELLOWORLD);
    }
}
