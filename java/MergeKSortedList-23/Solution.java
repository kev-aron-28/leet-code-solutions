import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
        
        for(ListNode list : lists) {
            if(list != null) minHeap.add(list);
        }

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        while (!minHeap.isEmpty()) { 
            ListNode head = minHeap.poll();
            current.next = head;
            current = current.next;


            if(head.next != null) {
                minHeap.add(head.next);
            }
        }
        

        return dummy.next;
    }
}