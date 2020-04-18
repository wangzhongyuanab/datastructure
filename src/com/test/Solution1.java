package com.test;


/**
 * 删除链表中等于给定值 val 的所有节点。
 */
public class Solution1 {
    public class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }

     ListNode(int[] arr){ }
  }
    public ListNode removeElements(ListNode head, int val) {
        while (head!=null&&head.val==val){
//            ListNode delNode=head;
//            head=head.next;
//            delNode.next=null;
            head=head.next;
        }
        if (head==null){
            return head;
        }
        ListNode prev=head;
        while(prev.next!=null){
            if (prev.next.val==val){
//                ListNode delNode=prev.next;
//                prev.next=delNode.next;
//                delNode.next=null;

            }else {
                prev=prev.next;
            }
        }
        return head;
    }
}
