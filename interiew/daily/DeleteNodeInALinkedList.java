package daily;

import common.ListNode;

public class DeleteNodeInALinkedList {
    public void solution(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
