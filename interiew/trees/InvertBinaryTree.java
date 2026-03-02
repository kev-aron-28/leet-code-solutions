package trees;

import java.util.ArrayDeque;
import java.util.Deque;

public class InvertBinaryTree {
    public TreeNode solution1(TreeNode root) {
        if(root == null) return null;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        solution1(root.left);
        solution1(root.right);

        return root;
    }

    public TreeNode solution2(TreeNode root) {

        if(root == null) return null;

        Deque<TreeNode> stack = new ArrayDeque<>();

        stack.push(root);

        while (!stack.isEmpty()) { 
            TreeNode node = stack.pollLast();

            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            if(node.right != null) stack.offer(node.right);

            if(node.left != null) stack.offer(node.left);
        }

        return root;
    }
}
