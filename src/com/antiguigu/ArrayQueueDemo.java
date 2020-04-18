package com.antiguigu;

/**
 * 基于数组实现的队列
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {

    }
}

class ArrayQueue{
    private int maxSize;        //表示数组的最大容量
    private int front;          //队列头
    private int rear;           //队列尾
    private int[]arr;           //该数据用于存放数据，模拟队列


    public ArrayQueue(int maxSize){
        this.maxSize=maxSize;
        arr=new int[maxSize];
        front=-1;       //指向队列头部,front是指向队列头的前一个位置
        rear=-1;        //指向队列尾部，rear是指向队列尾的数据.(即就是队列最后一个数据)
    }
    public boolean isFull(){
        return rear==maxSize-1;
    }

    public boolean isEmpty(){
        return rear==front;
    }

    public void addQueue(int n){
        //判断队列是否为空
        if (isFull()){
            System.out.println("队列满不能加入数据");
            return;
        }
        rear++; //让rear后移
        arr[rear]=n;
    }

    //获取队列中的数据，出队列
    public int getQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列空，不能取数据");
        }
        front++;   //让front后移
        return arr[front];
    }

    //显示队列中的所有数据
    public void showQueue(){
        if (isEmpty()){
            System.out.println("队列空,没有数据");
            return;
        }
        for (int i=0;i<arr.length;i++){
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }

    //显示队列的头数据,不是取出数据
    public int  headQueue(){
        //判断是否为空
        if (isEmpty()){
            throw new RuntimeException("队列空,没有数据");
        }
        return arr[front+1];
    }
}
