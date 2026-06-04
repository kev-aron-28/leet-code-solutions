package common;

import trees.TreeNode;

public class MaximumDepthOfABinaryTree {
    public int solution(TreeNode node) {
        if(node == null) return 0;
        int leftSubtree = solution(node.left);
        int rightSubtree = solution(node.right);

        return 1 + Math.max(leftSubtree, rightSubtree);
    }
}
