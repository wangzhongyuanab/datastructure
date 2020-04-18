package com.interview.lock;

/**
 * @author 王
 * @version 1.0
 * @create 2020/3/6 10:31
 */
//自定义的信号量实现
public class WangSemaphore {
    WangAqs aqs = new WangAqs() {

        @Override
        public int tryAcquireShared() { //state-1
            for (; ; ) {
                int count = getState().get();
                int n = count - 1;
                if (count <= 0 || n < 0) {
                    return -1;
                }
                if (getState().compareAndSet(count, n)) {
                    return 1;
                }
            }
        }

        @Override
        public boolean tryReleaseShared() { //state+1
            return getState().incrementAndGet() >= 0;
        }
    };

    public WangSemaphore(int count) {    //设置资源的状态
        aqs.getState().set(count);
    }

    public void acquire() {
        //获取令牌
        aqs.acquireShared();
    }

    public void release() {
        //释放令牌
        aqs.releaseShared();
    }
}
