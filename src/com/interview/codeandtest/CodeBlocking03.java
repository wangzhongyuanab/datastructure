package com.interview.codeandtest;

/**
 * @author 王
 * @version 1.0
 * @create 2020/2/8 18:05
 */

class CodeWZY{
    public CodeWZY(){
        System.out.println("code的构造方法111");
    }

    {
        System.out.println("Code的构造方法222");
    }
    static{
        System.out.println("Code的静态方法333 ");
    }
}
public class CodeBlocking03 {
    {
        System.out.println("CodeBlocking03的构造方法444");
    }
    static{
        System.out.println("CodeBlocking03的静态代码块555");
    }
    public CodeBlocking03(){
        System.out.println("CodeBlocking03的构造方法666");
    }

    public static void main(String[] args) {
        System.out.println("==CodeBlockingo3的main方法777");
        new CodeWZY();
        System.out.println("----------------");
        new CodeWZY();
        System.out.println("----------------");
        new CodeBlocking03();
    }
}
