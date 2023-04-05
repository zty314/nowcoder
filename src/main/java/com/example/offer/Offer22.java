package com.example.offer;

public class Offer22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode start = head;
        for (int i = 0; i < k; i++) {
            start = start.next;
        }
        ListNode end = head;
        while(start != null){
            start = start.next;
            end = end.next;
        }
        return end;
    }
}
