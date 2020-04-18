package com.interview.oom;

import java.nio.ByteBuffer;

//jvm配置：-Xms10m -Xmx10m -XX:+PrintGCDetails -XX:MaxDirectMemorySize=5m
//Netty启用了堆外内存DirectByteBuffer实现了零拷贝，堆外内存对young gc免疫，只有在full gc的时候才被收回。
public class DirectBufferMemoryDemo {
    public static void main(String[] args) {
        System.out.println("配置的maxDirectMemory:"+(sun.misc.VM.maxDirectMemory()/(double)1024/1024)+"MB");
        try{Thread.sleep(3000);}catch (InterruptedException e){e.printStackTrace();}
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(6 * 1024 * 1024); //java.lang.OutOfMemoryError: Direct buffer memory
    }
}
