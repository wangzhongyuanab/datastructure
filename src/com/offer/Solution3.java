package com.offer;

import java.util.ArrayList;
import java.util.Stack;

class ListNode {
       int val;
        ListNode next = null;
            ListNode(int val) {
           this.val = val;
       }
    }
public class Solution3 {
    public static  ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> integers = new ArrayList<>();
        if (listNode==null){
            return integers;
        }
        while(listNode!=null){
            integers.add(listNode.val);
            listNode=listNode.next;

        }
        int i=0;
        int j=integers.size()-1;
        while(i<=j){
            int tmp=integers.get(i);
            integers.set(i,integers.get(j));
            integers.set(j,tmp);
            i++;
            j--;
        }
        return integers;
    }
    public static  ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        ArrayList<Integer> integers = new ArrayList<>();
        Stack<ListNode> stack = new Stack<>();
        while(listNode!=null){
            stack.push(listNode);
            listNode=listNode.next;
        }
        while(!stack.isEmpty()){
            integers.add(stack.pop().val);
        }
        return integers;
    }
    static ArrayList<Integer> result=new ArrayList();

    public static  ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        if (listNode!=null){
            printListFromTailToHead2(listNode.next);
            result.add(listNode.val);
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode listNode1=new ListNode(5);
        ListNode listNode2=new ListNode(81);
        ListNode listNode3=new ListNode(61);
        ListNode listNode4=new ListNode(95);
        listNode1.next=listNode2;
        listNode2.next=listNode3;
        listNode3.next=listNode4;
        System.out.println(printListFromTailToHead2(listNode1));
    }
}
