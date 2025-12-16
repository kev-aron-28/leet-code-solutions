import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Exercices {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];

            if(map.containsKey(diff)) {
                return new int[] {  map.get(diff), i };
            }

            map.put(nums[i], i);
        }
        
        return new int[0];
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(Character c : s.toCharArray()) {
            if(c == '{' || c == '(' || c == '[') {
                stack.add(c);
            } else {
                if(stack.isEmpty()) {
                    return false;
                }

                char top = stack.peek();

                if((top == '(' && c == ')') || (top == '{' && c == '}') || (top == '[' && c == '[')) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        if(!stack.isEmpty()) {
            return false;
        }

        return true;
    }

    public ListNode mergeTwoList(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while(list1 != null && list2 != null) {
            if(list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }

            current = current.next;
        }

        if(list1 != null) current.next = list1;
        else current.next = list2;

        return dummy.next;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode first = dummy;
        ListNode second = dummy;

        for(int i = 0; i < n; i++) {
            first = first.next;
        }

        while(first.next != null) {
            second = second.next;
            first = first.next;
        }

        second.next = second.next.next;

        return dummy.next;
    }

    public static void main(String[] args) {
        
    }
}