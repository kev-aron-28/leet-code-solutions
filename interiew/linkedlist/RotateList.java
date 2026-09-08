public class RotateList {
    public ListNode solution(ListNode head, int k) {
        if(head == null || head.next == null) return head; 
        
        int len = 1;

        ListNode tail = head;

        while(tail.next != null) {
            len++;
            tail = tail.next;
        }

        tail.next = head;

        k = k % len;

        if(k == 0) return head;

        ListNode partition = head;


        for(int i = 0; i < len - k - 1; i++) {
            partition = partition.next;
        }


        ListNode newHead = partition.next;

        partition.next = null;

        return newHead;
    }
}
