package com.test;


/**
 * 删除链表中等于给定值 val 的所有节点。
 * 使用递归的方法
 */
public class Solution2 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
        ListNode(int[] arr){ }
    }
    public ListNode removeElements(ListNode head, int val) {
        if (head==null)
            return head;
        head.next=removeElements(head.next,val);
        return head.val==val?head.next:head;
        }
    }

