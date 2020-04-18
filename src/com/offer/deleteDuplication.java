package com.offer;




import java.util.*;

public class deleteDuplication {
    public static  ListNode deleteDuplication(ListNode pHead){
        if (pHead==null||pHead.next==null){
            return pHead;
        }
        ListNode head=new ListNode(0);
        head.next=pHead;
        ListNode p=head;
        ListNode s=pHead;
        ListNode d=pHead.next;
        while(d!=null){
            if (s.val!=d.val){
                if (s.next==d){
                    p.next=s;
                    p=p.next;
                }
                s=d;
                d=d.next;
            }else{
                d=d.next;
            }
        }
        p.next=s.next==null? s :null;
        return head.next;
    }

    public static void main(String[] args) {
        ListNode pHead=new ListNode(1);
        pHead.next=new ListNode(2);
        pHead.next.next=new ListNode(3);
        pHead.next.next.next=new ListNode(3);
        pHead.next.next.next.next=new ListNode(4);
        pHead.next.next.next.next.next=new ListNode(4);
        pHead.next.next.next.next.next.next=new ListNode(5);
         deleteDuplication(pHead);
        while(pHead!=null){
            System.out.println(pHead.val);
            pHead=pHead.next;
        }
    }
}
