package com.test;


/**
 * 删除排序链表中的重复元素
 */
public class Solution83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null||head.next==null) return head;
        ListNode cur=head;
        while(cur.next!=null){
            if (cur.next.val == cur.val){
                cur.next=cur.next.next;
            }else {
                cur = cur.next;
            }
        }
        return head;
    }
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}

