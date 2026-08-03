package daily;

import trees.TreeNode;

public class DiameterofBinaryTree {
    int diamter = 0;
    public int solution(TreeNode root) {
        depth(root);
        return diamter;
    }

    public int depth(TreeNode node) {
        if(node == null) return 0;

        int left = depth(node.left);

        int right = depth(node.right);

        diamter = Math.max(diamter, left + right);

        return 1 + Math.max(left, right);
    }
}
