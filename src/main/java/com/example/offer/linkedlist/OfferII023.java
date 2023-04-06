package com.example.offer.linkedlist;

public class OfferII023 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode ha = headA;
        ListNode hb = headB;
        while (ha != hb) {
            if (ha == null) {
                ha = headB;
            } else {
                ha = ha.next;
            }
            if (hb == null) {
                hb = headA;
            } else {
                hb = hb.next;
            }
        }
        return hb;
    }
}
