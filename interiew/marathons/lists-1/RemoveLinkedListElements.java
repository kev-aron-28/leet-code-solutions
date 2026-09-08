package marathons.lists-1;

import common.ListNode;


public class RemoveLinkedListElements {
    public ListNode solution(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode curr = head;
        ListNode prev = dummy;

        while (curr != null) { 
            if(curr.val == val) {
                prev.next = curr.next;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }

        return dummy.next;
    }
}
