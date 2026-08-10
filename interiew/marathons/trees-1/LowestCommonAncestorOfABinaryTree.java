package marathons.trees-1;

import trees.TreeNode;


public class LowestCommonAncestorOfABinaryTree {
    public TreeNode LCA(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;

        if(root == p || root == q) {
            return root;
        }

        TreeNode left = LCA(root.left, p, q);
        TreeNode right = LCA(root.right, p, q);

        if(left != null && right != null) {
            return root;
        }

        if(left != null) {
            return left;
        }

        return right;
    }
}
