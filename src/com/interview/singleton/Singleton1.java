package com.interview.singleton;



/**
 * 饿汉式：直接创建对象，不管是否需要这个对象都会创建
 * 构造器私有化
 * 自行创建，并且用静态变量保存
 */
public class Singleton1 {
    public   static final Singleton1 INSTANCE=new Singleton1();
    private Singleton1(){
    }
}
