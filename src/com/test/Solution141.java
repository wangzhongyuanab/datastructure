package com.test;

import java.util.HashSet;
import java.util.List;

/**
 * 环形链表
 */
public class Solution141 {
    public boolean hasCycle(ListNode head) {
        if (head==null||head.next==null) return false;
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if (slow==fast){
                return true;
            }
        }
        return false;
    }

    public boolean hasCycle2(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        while(head!=null){
            if (set.contains(head)){
                return true;
            }else{
                set.add(head);
            }
            head=head.next;
        }
        return false;
    }

    class ListNode {
      int val;
      ListNode next;
     ListNode(int x) {
          val = x;
         next = null;
      }
  }
}
