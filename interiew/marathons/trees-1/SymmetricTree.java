package marathons.trees-1;

import trees.TreeNode;


public class SymmetricTree {
    public boolean solution (TreeNode root) {
        return check(root.left, root.right);
    }

    public boolean check(TreeNode left, TreeNode right) {

        if(left == null && right == null) return true;

        if(left == null || right == null) return false;

        if(left.val != right.val) return true;

        return check(left.left, right.right) && check(left.right, right.left);
    }
}
