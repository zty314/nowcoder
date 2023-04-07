package com.example.leetcode.linkedlist;

public class LC19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode p1 = dummy;
        for (int i = 0; i < n + 1; i++) {
            p1 = p1.next;
        }
        ListNode p2 = dummy;
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        if (p2.next != null) {
            p2.next = p2.next.next;
            return dummy.next;
        }
        return null;
    }
}
