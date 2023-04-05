package com.example.leetcode.linkedlist;

public class LC86 {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);

        ListNode p1 = dummy1;
        ListNode p2 = dummy2;
        ListNode p = head;

        while (p != null) {
            if (p.val >= x) {
                p1.next = p;
                p1 = p1.next;
            } else {
                p2.next = p;
                p2 = p2.next;
            }
            ListNode temp = p.next;
            p.next = null;
            p = temp;
        }
        p2.next = dummy1.next;
        return dummy2.next;
    }
}
