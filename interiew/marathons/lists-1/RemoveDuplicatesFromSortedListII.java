package marathons.lists-1;

import common.ListNode;


public class RemoveDuplicatesFromSortedListII {
    public ListNode solution(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode curr = head;
        ListNode prev = dummy;

        while (curr != null) { 
            if(curr.next != null && curr.val == curr.next.val) {
                int repeated = curr.val;

                while (curr.val == repeated) { 
                    curr = curr.next;
                }

                prev.next = curr;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }

        return dummy.next;
    } 
}
