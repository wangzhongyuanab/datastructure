package com.interview.lock;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 王
 * @version 1.0
 * @create 2020/3/6 11:34
 */
//自己实现CountDownLatch
public class WangCDL {
    WangAqs aqs=new WangAqs(){
        @Override
        public int tryAcquireShared() {
            //如果不等于0，代表当前还有线程没有准备好，则认为就需要等待
            return this.getState().get()==0?1:-1;
        }

        @Override
        public boolean tryReleaseShared() {
            //如果不等于0，代表当前还有线程没有准备好，则不会通知继续执行
            return this.getState().decrementAndGet()==0;
        }
    };

    public WangCDL(int count){
        aqs.setState(new AtomicInteger(count));
    }

    public void await(){
        aqs.acquireShared();
    }

    public void countDown(){
        aqs.releaseShared();
    }
}
