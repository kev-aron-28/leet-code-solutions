package trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostOrderTraversal {
    public void postOrder(TreeNode node, List<Integer> result) {
        if(node == null) return;

        postOrder(node.left, result);
        postOrder(node.right, result);
        result.add(node.val);
    }   

    public List<Integer> postOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode prev = null;

        while (root != null || !stack.isEmpty()) { 
            while(root != null) {
                stack.push(root);
                root = root.left;
            }

            TreeNode node = stack.peek();

            if(node.right == null || node.right == prev) {
                stack.pop();
                result.add(node.val);
                prev = node;
            } else {
                root = node.right;
            }
        }

        return result;
    }
}
