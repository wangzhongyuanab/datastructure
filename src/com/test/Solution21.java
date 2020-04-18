package com.test;

/**
 *  合并两个有序链表
 */
public class Solution21 {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy=new ListNode(0);
        ListNode cur=dummy;
        while(l1.next!=null&&l2.next!=null){
            if (l1.val <l2.val){
                cur.next=new ListNode(l1.val);
                l1=l1.next;
            }else {
                cur.next=new ListNode(l2.val);
                l2=l2.next;
            }
           cur=cur.next;
        }
        if (l1!=null){
            cur.next=l1;
        }else{
            cur.next=l2;
        }
        return dummy.next;
    }

    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1==null) return l2;
        if (l2==null) return l1;
        if (l1.val<l2.val){
            l1.next=mergeTwoLists2(l1.next,l2);
            return l1;
        }else{
            l2.next=mergeTwoLists2(l1,l2.next);
            return  l2;
        }
    }

    public static  class ListNode {
      int val;
     ListNode next;
     ListNode(int x) { val = x; }
  }

    public static void main(String[] args) {
        ListNode l1=new ListNode(1);
        l1.next=new ListNode(2);
        l1.next.next=new ListNode(4);
        ListNode l2=new ListNode(1);
        l2.next=new ListNode(3);
        l2.next.next=new ListNode(4);
        System.out.println(mergeTwoLists(l1,l2).val);
    }
}
