package com.antiguigu;

/**
 * 环形队列
 */
public class CircleArrayQueueDemo {
}

class CircleArray{
    private int maxSize;        //表示数组的最大容量
    private int front;          //队列头,指向队列中的第一个元素，也就是说arr【front】就是第一个元素
    private int rear;           //队列尾,指向队列最后一个元素的后一个位置。因为希望腾出一个空间作为约定。
    private int[]arr;           //该数据用于存放数据，模拟队列


    public CircleArray(int maxSize){
        this.maxSize=maxSize;
        arr=new int[maxSize];
    }

    //判断队列是否满
    public boolean isFull(){
        return (rear+1)%maxSize==front;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return front==rear;
    }

    public void addQueue(int n){
        //判断队列是否为空
        if (isFull()){
            System.out.println("队列满不能加入数据");
            return;
        }
        //直接将数据加入
        arr[rear]=n;
        //将rear后移,考虑取模
        rear=(rear+1)%maxSize;
    }

    //获取队列中的数据，出队列
    public int getQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列空，不能取数据");
        }
        //这里front是指向队列的第一个元素先把front对应的值保存到一个临时变量
        //把front后移,考虑取模.
        //将临时保存的变量返回
        int value= arr[front];
        front=(front+1)%maxSize;
        return value;
    }

    //显示队列中的所有数据
    public void showQueue(){
        //遍历
        if (isEmpty()){
            System.out.println("队列空,没有数据");
            return;
        }
        //从front开始遍历，遍历多少个元素

        for (int i=front;i<front+size();i++){
            System.out.printf("arr[%d]=%d\n",i%maxSize,arr[i%maxSize]);
        }
    }

    //求出当前队列有效数据的个数
    public int size(){
        return (rear+maxSize-front)%maxSize;
    }

    //显示队列的头数据,不是取出数据
    public int  headQueue(){
        //判断是否为空
        if (isEmpty()){
            throw new RuntimeException("队列空,没有数据");
        }
        return arr[front];
    }
  }
