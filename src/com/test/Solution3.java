package com.test;

/**
 * 删除链表中等于给定值 val 的所有节点。
 * 使用虚拟头节点的方法
 */
public class Solution3 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

        ListNode(int[] arr){ }
    }
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead=new ListNode(-1);
        dummyHead.next=head;
        ListNode prev=dummyHead;
        while (prev.next!=null){
            if (prev.next.val==val){
                prev.next=prev.next.next;
            }else {
                prev=prev.next;
            }
        }
        return dummyHead.next;
    }
}
