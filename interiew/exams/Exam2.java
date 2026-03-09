import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import trees.TreeNode;

public class Exam2 {
    public ListNode middleOfLinkedList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) { 
            slow = slow.next;

            fast = fast.next.next;
        }

        return slow;
    }

    public ListNode removeElements(ListNode head, int val) {
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        ListNode curr = head;

        while (curr != null) { 
            if(curr.val == val) {
                prev.next = curr.next;
            } else {
                prev = curr;
            }

            curr = curr.next;
        }

        return dummy.next;
    }

    public List<Integer> binaryTreeInorderTraversal(TreeNode root) {
        
        Deque<TreeNode> stack = new ArrayDeque<>();

        List<Integer> result = new ArrayList<>();

        while (root != null || !stack.isEmpty()) { 
            while (root != null) { 
                stack.offer(root);
                root = root.left;
            }

            TreeNode node = stack.pop();

            result.add(node.val);

            root = root.right;
        }

        return result;
    }
    
    public int maximumDepthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        
        int left = maximumDepthOfBinaryTree(root.left);

        int right = maximumDepthOfBinaryTree(root.right);

        return 1 + Math.max(left, right);
    }

    public TreeNode invertBinaryTree(TreeNode root) {
        if(root == null) return null;

        TreeNode temp = root.left;

        root.left = root.right;
        root.right = temp;

        invertBinaryTree(root.left);
        invertBinaryTree(root.right);

        return root;
    }

    public int diameter(TreeNode root) {
        int sol[] = new int[] { 0 };

        depth(root, sol);

        return sol[0];
    }

    public int depth(TreeNode node, int val[]) {
        if(node == null) return 0;

        int left = depth(node.left, val);
        int right = depth(node.right, val);

        val[0] = Math.max(val[0], left + right);

        return 1 + Math.max(left, right);
    }

    public boolean pathSum(TreeNode root, int val) {
        if(root == null) return false;

        if(root.left == null && root.right == null) {
            if(root.val == val) return true;
        }

        return pathSum(root.left, val - root.val) || pathSum(root.right, val - root.val);
    }

    public List<List<Integer>> pathSumII(TreeNode ) {
        List<List<Integer>> result = new ArrayList<>();

        return result;
    }

    public void dfs()

}
