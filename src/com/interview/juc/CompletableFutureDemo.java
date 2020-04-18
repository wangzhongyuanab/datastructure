package com.interview.juc;

import java.util.concurrent.CompletableFuture;

/**
 * @author 王
 * @version 1.0
 * @create 2020/2/7 21:42
 *
 * 异步回调
 */
public class CompletableFutureDemo {
    public static void main(String[] args) throws Exception {
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "没有返回");
        });
        completableFuture.get();

        CompletableFuture<Integer> completableFuture2 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "\t completableFuture2");
            //int age=10/0;
            return 1024;
        });
        System.out.println(completableFuture2.whenComplete((t, u) -> {
            System.out.println("******t:" + t);
            System.out.println("******u:" + u);
        }).exceptionally(f -> {
            System.out.println("*******exception:" + f.getMessage());
            return 44444;
        }).get());

    }
}
