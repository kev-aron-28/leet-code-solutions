package trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreOrderTraversal {
    public void preOrder(TreeNode node, List<Integer> result) {
        if(node == null) return;

        result.add(node.val);
        preOrder(node.left, result);
        preOrder(node.right, result);
    }

    public List<Integer> preOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();

            result.add(node.val);

            if(node.right != null) {
                stack.push(node.right);
            }

            if(node.left != null) {
                stack.push(node.left);
            }
        }
        
        return result;
    }
}
