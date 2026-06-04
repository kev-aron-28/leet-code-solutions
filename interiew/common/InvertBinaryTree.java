package common;

import trees.TreeNode;

public class InvertBinaryTree {
    public TreeNode solution(TreeNode root) {
        if(root == null) return null;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        solution(root.left);
        solution(root.right);

        return root;
    }
}
