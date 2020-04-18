package com.interview.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:MaxDirectMemorySize=5m
 * gc回收时间过长，超过98的时间用来做gc并且回收了不到2的堆内存
 * 连续多次gc都只回收了不到2的内存的情况下才会抛出。假如不抛出Gc overhead limit.就会造成死循环
 */
public class GCOverheadDemo {
    public static void main(String[] args) {
        int i=0;
        List<String> list=new ArrayList<>();
        try {
            while (true) {
                list.add(String.valueOf(++i).intern());
            }
        }catch (Throwable e){
            System.out.println("i:"+i);
            e.printStackTrace();    //java.lang.OutOfMemoryError:GC overhead limit exceeded
            throw e;
        }
    }
}
