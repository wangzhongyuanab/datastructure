package com.test;

/**
 * 两数相加
 */
public class SolutionTwo {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy=new ListNode(0);
        int sum=0;
        ListNode cur=dummy;
        ListNode p1=l1,p2=l2;
        while (p1!=null||p2!=null){
            if (p1!=null){
                sum+=p1.val;
                p1=p1.next;
            }
            if (p2!=null){
                sum+=p2.val;
                p2=p2.next;
            }
            cur.next=new ListNode(sum%10);
            sum/=10;
            cur=cur.next;
        }
        if (sum==1){
            cur.next=new ListNode(1);
        }
        return dummy.next;
    }
}
class ListNode {
      int val;
     ListNode next;
      ListNode(int x) { val = x; }
}
