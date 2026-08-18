package Linked_List_Questions;

import java.util.PriorityQueue;

public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode node : lists) {
            if (node != null) {
                minHeap.add(node);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.remove();
            if (node.next != null) minHeap.add(node.next);
            ListNode newNode = new ListNode(node.val);
            temp.next = newNode;
            temp = newNode;
        }
        return dummy.next;
    }
}