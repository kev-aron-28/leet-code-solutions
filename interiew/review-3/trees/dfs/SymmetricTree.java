package review-3.trees.dfs;

import trees.TreeNode;


public class SymmetricTree {
    public boolean solution(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;

        if(p == null || q == null) return false;

        if(p.val != q.val) return false;
        
        return solution(p.left, q.right) && solution(p.right, q.left);
    }
}
