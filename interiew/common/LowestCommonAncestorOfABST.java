package common;

import trees.TreeNode;

public class LowestCommonAncestorOfABST {
    public TreeNode solution(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val < root.val && q.val < root.val) {
            return solution(root.left, p,q);
        }

        if (p.val > root.val && q.val > root.val) {
            return solution(root.right, p, q);
        }

        return root;
    }
}
