package com.interview.singleton;

/**
 * 懒汉式:线程不安全
 */
public class Singleton4 {
    private static Singleton4 instance;
    private Singleton4(){

    }
    public static Singleton4 getInstance(){
        if (instance==null){
            instance=new Singleton4();
        }
        return instance;
    }
}
