package com.test;

/**
 *  删除链表的倒数第N个节点
 */
public class Solution19 {
    public class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
  }
    //先找到链表的倒数第n个节点
    //先得到链表的总长度
    //得到size后，从链表的第一个开始遍历size-index个，就可以得到倒数第n个节点.
    public ListNode removeNthFromEnd(ListNode head, int n) {
//        //第一个遍历得到链表的长度（节点个数）
//        ListNode cur=head;
//        int size=0;
//        while(cur!=null){
//            size++;
//            cur=cur.next;
//        }
//        if (n==size){
//            return head.next;
//        }else if(n <= 0 || n > size) {
//            return null;
//        }else{
//            //第二次遍历size-index位置，
//            //定义辅助变量，循环定位到倒数的index-1
//            ListNode prev = head;
//            while（length>0）{//
//                prev = prev.next;
//            }
//            //此时prev就是要删除的节点的前驱
//            ListNode current = prev.next;
//            prev.next = current.next;
//            current.next = null;
//            return head;
//        }
        //双指针进行遍历，第一个指针一直遍历到链表的末尾。
            ListNode pre = new ListNode(0);
            pre.next = head;
            ListNode start = pre, end = pre;
            while(n != 0) {
                start = start.next;
                n--;
            }
            while(start.next != null) {
                start = start.next;
                end = end.next;
            }
            end.next = end.next.next;
            return pre.next;

    }

    public static void main(String[] args) {

    }
}
