package common;

import trees.TreeNode;

public class LowestCommonAncestorOfBinaryTree {
    public TreeNode solution(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;

        TreeNode left = solution(root.left, p, q);

        TreeNode right = solution(root.right, p, q);

        if(left != null && right != null) return root;

        return left != null ? left : right;
    }
}
