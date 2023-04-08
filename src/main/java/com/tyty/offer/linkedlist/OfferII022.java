package com.tyty.offer.linkedlist;

public class OfferII022 {

    public ListNode detectCycle(ListNode head) {
        ListNode h1 = head;
        ListNode h2 = head;
        while (h1 != null && h1.next != null) {
            h1 = h1.next.next;
            h2 = h2.next;
            if (h1 == h2) {
                break;
            }
        }
        if (h1 == null || h1.next == null) {
            return null;
        }
        h2 = head;
        while (h1 != h2) {
            h1 = h1.next;
            h2 = h2.next;
        }
        return h2;
    }
}
