package com.mukewang;


/**
 * 链表
 * @param <E>
 */
public class LinkedList<E> {

    private class Node{
        public E e;
        public Node next;

    public Node(E e,Node next) {
        this.e=e;
        this.next=next;
    }
    public Node(E e) {
        this(e,null);
        }
    public Node(){
        this(null,null);
        }


        @Override
        public String toString(){
            return e.toString();
        }
    }
    private Node dummyHead;
    private int size;

    public LinkedList(){
        dummyHead=new Node(null,null);
        size=0;
    }

    //获取链表中的元素个数
    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    //在链表头添加元素e
    public void addFirst(E e){
//        Node node = new Node(e);
//        node.next=head;
//        head=node;
        add(0,e);
        size++;
    }

    //在链表的中间添加元素,在链表的index（0-based）位置添加元素e
    public void add(int index,E e ){
        if (index<0||index>size){
            throw new IllegalArgumentException("add failed，index illegal");
        }
            Node prev=dummyHead;
            for(int i=0;i<index;i++){
                prev=prev.next;
            }
//            Node node = new Node(e);
//            node.next=prev.next;
//            prev.next=node;
            prev.next=new Node(e,prev.next);
            size++;

    }

    public void addLast(E e){
        add(size,e);
    }

    /**
     * 获得链表的第index个元素
     * @return
     */
    public E get(int index){
        if (index<0||index>=size) {
            throw new IllegalArgumentException("get failed ,index illegal");
        }
        Node cur=dummyHead.next;
        for (int i=0;i<index;i++){
            cur=cur.next;
        }
        return cur.e;
    }

    /**
     * 获得链表的第一个元素
     * @return
     */
    public E getFirst(){
        return get(0);
    }

    /**
     * 获得最后一个元素
     * @return
     */
    public E getLast(){
        return get(size-1);
    }


    /**
     * 更新链表的第index元素为e
     * @param index
     * @param e
     */
    public void set(int index,E e){
        if (index<0||index>=size) {
            throw new IllegalArgumentException("set failed ,index illegal");
        }
        Node cur=dummyHead.next;
        for (int i=0;i<index;i++){
            cur=cur.next;
        }
        cur.e=e;
    }

    /**
     * 查找链表中是否有元素e
     * @param e
     * @return
     */
    public boolean contains(E e){
        Node cur=dummyHead.next;
        while(cur!=null){
            if (cur.e!=e)
                return true;
            cur=cur.next;
        }
        return false;
    }

    @Override
    public String toString(){
        StringBuilder builder=new StringBuilder();
//        Node cur=dummyHead.next;
//        while(cur!=null){
//            builder.append(cur+"->");
//            cur=cur.next;
//        }
        for (Node cur=dummyHead.next;cur!=null;cur=cur.next){
            builder.append(cur+"->");
        }
        builder.append("NULL");
        return builder.toString();
    }

    /**
     * 从链表中删除index位置的元素。
     * @param index
     * @return
     */
    public E remove(int index){
        if (index<0||index>=size){
            throw new IllegalArgumentException("remove failed ,index illegal");
        }
        Node prev=dummyHead;
        for (int i=0;i<index;i++){
            prev=prev.next;
        }
        Node retNode=prev.next;
        prev.next=retNode.next;
        retNode.next=null;
        size--;
        return retNode.e;
    }

    /**
     * 从链表中删除第一个元素，返回删除的元素
     * @return
     */
    public E removeFirst(){
        return remove(0);
    }

    public E removeLast(){
        return remove(size-1);
    }


    /**
     * 从链表中删除元素e
     * @param e
     */
    public void removeElement(E e){
        Node prev=dummyHead;
        while(prev.next!=null){
            if (prev.next.e.equals(e)){
                break;
            }
            prev=prev.next;
        }
        if (prev.next!=null){
            Node delNode=prev.next;
            prev.next=delNode.next;
            delNode.next=null;
            size--;
        }
    }
}

