package com.test;

/**
 *  两两交换链表中的节点
 */
public class Solution24 {
    public ListNode swapPairs(ListNode head) {
        if (head==null||head.next==null) return head;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode l1=dummy;
        ListNode l2=head;
        while(l2!=null&&l2.next!=null){
            ListNode nextStart=l2.next.next;
            l1.next=l2.next;
            l2.next.next=l2;
            l2.next=nextStart;
            l1=l2;
            l2=l1.next;
        }
        return dummy.next;
    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
}
