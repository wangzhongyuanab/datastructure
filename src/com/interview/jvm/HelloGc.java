package com.interview.jvm;

public class HelloGc {
    public static void main(String[] args) throws InterruptedException {
//        long totalMemory = Runtime.getRuntime().totalMemory(); //返回java虚拟机中的内存容量
//        long maxMemory = Runtime.getRuntime().maxMemory();  //返回java虚拟机试图使用的最大内存量
//        System.out.println("TOTAL_MEMORY(-Xms)="+totalMemory+"字节,"+(totalMemory/(double)1024/1024)+"MB");
//        System.out.println("MAX_MEMORY(-Xmx)="+maxMemory+"字节,"+(maxMemory/(double)1024/1024)+"MB");
        System.out.println("Hello GC");
        //byte[] bytes=new byte[50*1024*1024];
        Thread.sleep(Integer.MAX_VALUE);
    }
}
