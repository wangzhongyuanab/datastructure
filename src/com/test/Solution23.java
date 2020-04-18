package com.test;


import java.util.PriorityQueue;

/**
 * 合并K个排序链表,
 */
public class Solution23 {
    //第一种采用分治，将链表数组中的链表分为2个链表然后再融合为一个链表
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists==null||lists.length==0) return null;
        return sort(lists,0,lists.length-1);
    }

    private ListNode sort(ListNode[] lists, int low, int high) {
        if (low>=high) return lists[low];
        int mid=(high-low)/2+low;
        ListNode l1=sort(lists,low,mid);
        ListNode l2=sort(lists,mid+1,high);
        return merge(l1,l2);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1==null) return l2;
        if (l2==null) return l1;
        if (l1.val<l2.val){
                l1.next=merge(l1.next,l2);
                return l1;
            }
        l2.next = merge(l1, l2.next);
        return l2;
    }

    public class ListNode {
     int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    /**
     * 第二种采用优先队列实现,不断的通过优先队列的poll出最小的一个。
     * @param lists
     * @return
     */
    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists==null||lists.length==0) return null;
        PriorityQueue<ListNode> queue=new PriorityQueue<>(lists.length,(a,b)->a.val-b.val);
        ListNode dummy=new ListNode(0);
        ListNode cur=dummy;

        for (ListNode list : lists) {
            if (list!=null) {
                queue.add(list);
            }
        }
        while(!queue.isEmpty()){
            cur.next=queue.poll();
            cur=cur.next;
            if (cur.next!=null){
                queue.add(cur.next);
            }
        }
        return dummy.next;
    }
}
