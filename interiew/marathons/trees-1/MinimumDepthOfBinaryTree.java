package marathons.trees-1;

import trees.TreeNode;


public class MinimumDepthOfBinaryTree {
    public int solution(TreeNode root) {
        if(root == null) return 0;

        if(root.left == null) {
            return 1 + solution(root.right);
        }

        if(root.right == null) {
            return 1 + solution(root.left);
        }

        int left = solution(root.left);
        int right = solution(root.right);

        return 1 + Math.min(left, right);
    }
}
