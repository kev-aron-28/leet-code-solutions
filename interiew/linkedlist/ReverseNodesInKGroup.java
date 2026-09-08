/**
 * ReverseNodesInKGroup
 */
public class ReverseNodesInKGroup {

    public ListNode solution(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prevNodeGroup = dummy;

        while(true) {
            // We find the kth node
            ListNode kth = getKth(prevNodeGroup, k);

            if(kth == null) break;

            // Save node after the group
            ListNode nextGroup = kth.next;

            ListNode prev = nextGroup;
            ListNode current = prevNodeGroup.next;

            while(current != nextGroup) {
                ListNode next = current.next;

                current.next = prev;
                prev = current;
                current = next;
            }

            // once you do this: 2 -> 1 -> nextGroup

            ListNode oldGroupHead = prevNodeGroup.next;

            prevNodeGroup.next = kth;

            prevNodeGroup = oldGroupHead;
        }

        return dummy.next;
    }

    private ListNode getKth(ListNode current, int k) {
        while (current != null && k > 0) { 
            current = current.next;
            k--;
        }
        

        return current;
    }
}