package com.interview.lock;

import java.util.concurrent.TimeUnit;

class Phone1{
    public static synchronized void sendEmail() throws Exception{
        try{TimeUnit.SECONDS.sleep(4);}catch (Exception e){e.printStackTrace();}
        System.out.println("------sendEmail");
    }

    public static synchronized void sendSMS(){
        System.out.println("------sendSMS");
    }

    public void hello(){
        System.out.println("hello");
    }
}

/**
 * 线程8锁
 * 1.正常访问，先打印邮件还是短信
 * 2.邮件方法暂停4秒钟，请问先打印邮件还是短信
 * 3.新增一个普通方法，先打印hello还是邮件
 * 4,2部手机，先打印邮件还是短信
 * 5.2个静态同步方法，同一部手机，请问先打印邮件还是短信
 * 6.2个静态同步方法，2部手机，请问先打印邮件还是短信
 * 7.一个普通同步方法，一个静态同步方法，1部手机，请问先打印邮件还是短信
 * 8.一个普通同步方法，一个静态同步方法，2部手机，请问先打印邮件还是短信
 *
 *
 * 一个对象里面如果有多个synchronized方法，某一个时刻内，只要一个线程去调用其中的一个synchronized方法了
 * 其他线程都只能等待，换句话说，某一个时刻内，只能有唯一一个线程去访问这些synchronized方法
 * 锁的是当前对象this，被锁定后，其他的线程都不能进入当前对象的其他synchronized方法
 *
 * 换个普通方法后发现和同步锁无关
 * 换成2个对象后，不是同一把锁了，情况变化
 *
 * 都换成静态方法后，情况又变化
 * 所有的非静态同步方法用的都是同一把锁-实例对象本身
 *
 * synchronized实现同步的基础：java的每一个对象都可以作为锁
 * 对于普通方法，锁是当前实例对象
 * 对于静态方法，锁的是.class文件或者说锁的是这个类，锁的是当前类的Class对象
 * 对于同步方法块，锁是synchronized括号里配置的对象
 *
 * 当一个线程试图访问同步代码块时，它首先必须得到锁，退出或抛出异常时必须释放锁
 *
 * 也就是说如果一个实例对象的普通同步方法获取锁之后，该实例对象的其他普通同步方法必须等待获取锁的方法
 * 释放锁之后才能获取锁，可是别的实例对象的普通同步方法因为跟该实例对象的普通同步方法用的是不同的锁，
 * 所以无须等待该实例对象已获取锁的普通同步方法释放锁就可以获取他们自己的锁
 *
 * 所有的静态同步方法用的也是同一把锁-类对象本身
 * 这2把锁是2个不同的对象，所以静态同步方法和非静态同步方法之间是不会又竞争条件德
 * 但是一旦一个静态同步方法获取锁之后，其他的静态同步方法都必须等待该方法释放锁之后才能获取锁
 * 而不管是同一个实例对象的静态同步方法之间，还是不同的实例对象的静态同步方法之间，只要他们同一个类的实例对象
 */
public class Lock8 {
    public static void main(String[] args) throws InterruptedException {
        Phone1 phone1 = new Phone1();
        Phone1 phone2 = new Phone1();
        new Thread(()->{
            try {
                phone1.sendEmail();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"A").start();

        Thread.sleep(100);

        new Thread(()->{
            try {
                //phone1.sendSMS();
                //phone1.hello();
                phone2.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"A").start();
    }
}
