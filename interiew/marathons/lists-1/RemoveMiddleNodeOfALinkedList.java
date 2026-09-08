package marathons.lists-1;

import common.ListNode;


public class RemoveMiddleNodeOfALinkedList {
    public ListNode solution(ListNode head) {
        if(head == null && head.next == null) return null;

        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;

        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = slow.next;

        return head;
    }
}
