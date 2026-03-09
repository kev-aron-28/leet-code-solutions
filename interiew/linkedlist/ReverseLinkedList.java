public class ReverseLinkedList {
    public ListNode solution(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while(curr != null) {
            ListNode next = curr.next;

            curr.next = prev;

            prev = curr;

            curr = next;
        }

        return prev;
    }

    public ListNode recursive(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode node = recursive(head.next);

        head.next.next = head;

        head.next = null;
    
        return node;
    }
}