package com.example.leetcode.array;


public class LC83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (null == head) {
            return null;
        }
        ListNode slow = head;
        ListNode dummy = slow;
        ListNode fast = head;

        while (fast != null) {
            if (slow.val == fast.val) {
                fast = fast.next;
            } else {
                slow.next = fast;
                slow = slow.next;
                fast = fast.next;
            }
        }
        slow.next = null;

        return dummy;
    }
}
