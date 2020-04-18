package com.interview.codeandtest;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {
    public static void main(String[] args) throws Exception {
        //用于获取到本java进程，进而获取总线程数
        RuntimeMXBean runtimeBean = ManagementFactory.getRuntimeMXBean();
        String jvmName = runtimeBean.getName();
        System.out.println("JVM Name = " + jvmName);
        long pid = Long.valueOf(jvmName.split("@")[0]);
        System.out.println("JVM PID = " + pid);
        ThreadMXBean bean = ManagementFactory.getThreadMXBean();
        int n = 30000;
        for (int i = 0; i < n; i++) {
            ThreadPoolExecutor executor = new ThreadPoolExecutor(10,20,1000, TimeUnit.SECONDS,new LinkedBlockingDeque<>());
            for(int j=0;j<10;j++){
                executor.execute(()->{
                    System.out.println("当前线程总数为："+bean.getThreadCount());
                });
            }
        }
        Thread.sleep(10000);
        System.out.println("线程总数为 = " + bean.getThreadCount());
    }
}
