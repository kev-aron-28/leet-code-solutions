package daily;

import trees.TreeNode;

public class BinaryTreeMaximumPathSum {
    int max = Integer.MIN_VALUE;
    public int solution(TreeNode root) {
        postorder(root);
        return max;   
    }

    private int postorder(TreeNode node) {
        if(node == null) return 0;

        int left = Math.max(postorder(node.left), 0);
        int right = Math.max(postorder(node.right), 0);

        max = Math.max(max, left + right + node.val);

        return node.val + Math.max(left, right);
    }
}
