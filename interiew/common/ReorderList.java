package common;

public class ReorderList {
    public void solution(ListNode head) {
        if(head == null || head.next == null) {
            return;
        }

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = null;
        ListNode current = slow.next;

        slow.next = null;

        while (current != null) { 
            ListNode next = current.next;

            current.next = prev;
            prev = current;
            current = next;
        }

        ListNode first = head;
        ListNode second = prev;

        while (second != null) { 
            ListNode tmp1 = first.next;
            ListNode tmp2 = second.next;

            first.next = second;
            second.next = tmp1;

            first = tmp1;
            second = tmp2;
        }

    }
}
