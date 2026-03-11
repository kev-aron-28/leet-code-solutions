public class RemoveTheNthNodeFromEndOfList {
    public ListNode solution(ListNode head, int n) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode slow = head;
        ListNode fast = head;

        for(int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        while(fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
    }
}
