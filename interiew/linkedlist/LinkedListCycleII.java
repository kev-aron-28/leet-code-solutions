public class LinkedListCycleII {
    public ListNode solution(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                ListNode start = head;

                while(start != fast) {
                    start = start.next;

                    fast = fast.next;
                } 

                return start;
            }
        }

        return null;
    }
}
