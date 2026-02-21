package trees;

import java.util.Stack;

public class PathSum {
    public boolean solution(TreeNode root, int targetSum) {
        if(root == null) return false;

        if(root.left == null && root.right == null) {
            return targetSum == root.val;
        }

        int remaining = targetSum - root.val;

        return solution(root.left, remaining) || solution(root.right, remaining);
    }

    public boolean solution2(TreeNode root, int targetSum) {
        if(root == null) return false;

        Stack<TreeNode> stackNode = new Stack<>();

        Stack<Integer> stackSum = new Stack<>();

        stackNode.add(root);

        stackSum.add(root.val);

        while (!stackNode.isEmpty()) { 
            TreeNode node = stackNode.pop();
            Integer currentNodeSum = stackSum.pop();

            if(node.left == null && node.right == null) {
                if(currentNodeSum == targetSum) return true;
            }

            if(node.right != null) {
                stackNode.push(node.right);
                stackSum.push(node.right.val + currentNodeSum);
            }

            if(node.left != null) {
                stackNode.push(node.left);
                stackSum.push(node.left.val + currentNodeSum);
            }
        }

        return false;
    }
}
