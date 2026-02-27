package trees;

public class BinaryTreeMaximumPathSum {
    
    
    public int solution(TreeNode root) {
        int maxPath[] = new int[] { Integer.MIN_VALUE };

        postOrder(root, maxPath);

        return maxPath[0];
    }
    
    public int postOrder(TreeNode node, int[] maxPath) {
        if(node == null) return 0;

        int leftMax = Math.max(postOrder(node.left, maxPath), 0);

        int rightMax = Math.max(postOrder(node.right, maxPath), 0);

        int currentPath = leftMax + rightMax + node.val;

        maxPath[0] = Math.max(currentPath, maxPath[0]);

        return node.val + Math.max(leftMax, rightMax);
    }
}
