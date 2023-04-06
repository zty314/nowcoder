package com.example.offer.linkedlist;

import java.util.Comparator;
import java.util.PriorityQueue;

public class OfferII078 {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(-1);
        ListNode d = dummy;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(l1 -> l1.val));
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                queue.add(lists[i]);
            }
        }
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            d.next = node;
            if (node.next != null) {
                queue.add(node.next);
            }
            d = d.next;
        }
        return dummy.next;
    }
}
