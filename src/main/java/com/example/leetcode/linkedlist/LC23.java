package com.example.leetcode.linkedlist;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LC23 {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummuy = new ListNode(-1);
        ListNode p = dummuy;

        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, (a, b)->(a.val - b.val));

        // 将 k 个链表的头结点加入最小堆
        for (ListNode head : lists) {
            if (head != null) {
                queue.add(head);
            }
        }

        while (!queue.isEmpty()) {
            // 获取最小节点，接到结果链表中
            ListNode node = queue.poll();
            p.next = node;
            if (node.next != null) {
                queue.add(node.next);
            }
            // p 指针不断前进
            p = p.next;
        }
        return dummuy.next;
    }
}
