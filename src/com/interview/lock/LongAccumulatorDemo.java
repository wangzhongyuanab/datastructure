package com.interview.lock;

import java.util.concurrent.atomic.LongAccumulator;
import java.util.function.LongBinaryOperator;

/**
 * @author 王
 * @version 1.0
 * @create 2020/3/5 23:03
 */
public class LongAccumulatorDemo {
    public static void main(String[] args) throws InterruptedException {
        LongAccumulator accumulator=new LongAccumulator(new LongBinaryOperator() {
            @Override
            public long applyAsLong(long left, long right) {
                //返回最大值，这就是自定义的计算
                return left>right?left:right;
            }
        },0);

        for (int i=0;i<1000;i++){
            int finall=i;
            new Thread(()->{
                accumulator.accumulate(finall); //此处就是执行上面定义的操作
            }).start();
        }
        Thread.sleep(2000L);
        System.out.println(accumulator.longValue());
    }
}
