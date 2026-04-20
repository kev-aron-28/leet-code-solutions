import trees.TreeNode;

public class Exam10 {
    
    public int binaryTreeMaximumPathSum(TreeNode root) {
        int maxSum[] = { Integer.MIN_VALUE };

        depth(root, maxSum);

        return maxSum[0];
    }

    private int depth(TreeNode node, int maxSum[]) {
        if(node == null) return 0;

        int leftBranch = Math.max(depth(node.left, maxSum), 0);
        int rightBranch = Math.max(depth(node.right, maxSum),0);

        int current = node.val + leftBranch + rightBranch;

        maxSum[0] = Math.max(current, maxSum[0]);

        return node.val + Math.max(leftBranch, rightBranch);
    }

    
}
