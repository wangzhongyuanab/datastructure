package com.interview;

public class Singleton {
    private  static volatile Singleton instance=null;

    private Singleton(){
        System.out.println(Thread.currentThread().getName()+"\t 我是构造方法singletonDemom()");
    }

    //DCL模式：双重检查锁机制
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
//    public static Singleton getInstance(){
//        if (instance==null){
//            synchronized (Singleton.class){
//                if (instance==null){
//                    instance=new Singleton();
//                }
//            }
//        }
//        return instance;
//    }

        public static void main (String[]args){
            for (int i = 1; i <= 10; i++) {
                new Thread(() -> {
                    Singleton.getInstance();
                }, String.valueOf(i)).start();
            }
        }

    }