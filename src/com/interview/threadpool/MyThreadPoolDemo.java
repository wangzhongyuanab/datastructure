package com.interview.threadpool;



import java.util.concurrent.*;


/**
 * 第4种使用java多线程的方式，线程池
 * 线程池做的工作主要是控制运行的线程的数量，处理过程中将任务放入队列，然后在线程创建后启动这些任务，如果线程数量超过
 * 了最大数量，超出数量的线程排队等候，等其他线程执行完毕，再从队列中取出任务来执行
 *
 * 特点：线程复用；控制最大并发数；管理线程
 *
 * 线程池的底层都是ThreadPoolExecutor
 *
 *  cpu核数:Runtime.getRuntime().availableProcessors()
 * 合理配置线程池：任务是cpu密集型还是io密集型
 * cpu密集型：需要大量的运算，而没有阻塞，cpu一直全速运行,cpu核数+1
 * io密集型：a.并不是一直在执行任务，则应配置尽可能多的线程，cpu*2
 *           b.io密集型，即使有大量的io，即大量的阻塞    cpu核数/1-阻塞系数    阻塞系数：0.8-0.9
 */
public class MyThreadPoolDemo {
    public static void main(String[] args) {
       ExecutorService threadPool=new ThreadPoolExecutor(
               2,
               5,
               1L,
               TimeUnit.SECONDS,
               new LinkedBlockingQueue<Runnable>(3),
               Executors.defaultThreadFactory(),
               new ThreadPoolExecutor.DiscardPolicy());
        try{
            //模拟10个用户来办理业务，一个用户就是一个来自外部的请求线程
            for (int i = 1; i <=10; i++) {
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"\t 办理业务");
                });
                //try{TimeUnit.MILLISECONDS.sleep(200);}catch (Exception e){e.printStackTrace();}
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }
    }

    public void threadPoolInit(){
        ExecutorService threadPool=Executors.newFixedThreadPool(5); //一池5个处理线程,可控制线程最大并发数，超出的线程会在队列中等待
        //ExecutorService threadPool=Executors.newSingleThreadExecutor(); //一池一个处理线程
        //ExecutorService threadPool=Executors.newCachedThreadPool(); //一池N个处理线程
        try{
            //模拟10个用户来办理业务，一个用户就是一个来自外部的请求线程
            for (int i = 1; i <=10; i++) {
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"\t 办理业务");
                });
                //try{TimeUnit.MILLISECONDS.sleep(200);}catch (Exception e){e.printStackTrace();}
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }
    }
}
