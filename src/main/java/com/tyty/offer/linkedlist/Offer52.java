package com.tyty.offer.linkedlist;

public class Offer52 {
    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
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
        return ha;

    }
}
