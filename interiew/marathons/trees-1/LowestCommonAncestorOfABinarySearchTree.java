import trees.TreeNode;

/**
 * LowestCommonAncestorOfABinarySearchTree
 */
public class LowestCommonAncestorOfABinarySearchTree {
    public TreeNode LCA(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < root.val && q.val < root.val) {
            return LCA(root.left, p, q);
        }

        if(p.val > root.val && q.val > root.val) {
            return LCA(root.right, p, q);
        }

        return root;
    }
}