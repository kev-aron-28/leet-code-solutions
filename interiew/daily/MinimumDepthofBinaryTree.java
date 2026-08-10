package daily;

import trees.TreeNode;

public class MinimumDepthofBinaryTree {
    
    public int solution(TreeNode root) {
        if(root == null) return 0;

        if(root.left) {
            return 1 + solution(root.right);
        } 

        if(root.right) {
            return 1 + solution(root.left)
        }

        int left = solution(root.left);
        int right = solution(root.right);

        
        return 1 + Math.min(left, left);
    }
}
